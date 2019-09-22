package ar.strellis.com.bgpsec.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.commons.cli.ParseException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.statemachine.StateMachine;
import org.apache.mina.statemachine.StateMachineFactory;
import org.apache.mina.statemachine.StateMachineProxyBuilder;
import org.apache.mina.statemachine.annotation.IoHandlerTransition;
import org.apache.mina.statemachine.context.IoSessionStateContextLookup;
import org.apache.mina.statemachine.context.StateContext;
import org.apache.mina.statemachine.context.StateContextFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import ar.strellis.com.bgpsec.codec.BgpCoder;
import ar.strellis.com.bgpsec.codec.BgpDecoder;
import ar.strellis.com.bgpsec.configparser.RouterConfigurationReader;
import ar.strellis.com.bgpsec.event.EventTransitionListener;
import ar.strellis.com.bgpsec.handler.BgpHandler;
import ar.strellis.com.bgpsec.model.BgpSession;
import ar.strellis.com.bgpsec.model.MyConfiguration;
import ar.strellis.com.bgpsec.zebra.ZebraSocketMessenger;

/**
 * Launcher class for the BGP server
 * @author daxcurson
 *
 */
public class BgpServer 
{
	private static Logger log=LogManager.getLogger(BgpServer.class); 
	private String configurationFilename="/etc/bgpsec/bgpsec.conf";
	private SocketAcceptor acceptor;
	private List<EventTransitionListener> listeners;
	private MyConfiguration configuration;
	private RouterConfigurationReader configurationReader;
	private BgpCommandLineProcessor commandLineProcessor;
	private String[] commandLineArgs;
	private ZebraSocketMessenger zebra;
	private Channel channelToZebra;
	private Channel channelToBgpsec;
	
	public BgpServer(String[] commandLineArgs)
	{
		listeners=new LinkedList<EventTransitionListener>();
		this.commandLineArgs=commandLineArgs;
	}
	private IoHandler createIoHandler() throws IOException 
	{
		BgpHandler b=new BgpHandler(this.configuration,this.channelToBgpsec,this.channelToZebra);
		addTransitionListener(b);
		StateMachine sm = StateMachineFactory.getInstance(IoHandlerTransition.class).create(BgpHandler.IDLE, b);

		return new StateMachineProxyBuilder().setStateContextLookup(
				new IoSessionStateContextLookup(new StateContextFactory() {
					public StateContext create() {
						return new BgpSession();
					}
				})).create(IoHandler.class, sm);
	}
	public void addTransitionListener(EventTransitionListener candidate)
	{
		listeners.add(candidate);
	}
	public void fireStartEvent()
	{
		for(EventTransitionListener l:listeners)
		{
			l.start();
		}
	}
	public static void main(String[] args) 
	{
		BgpServer s=new BgpServer(args);
		s.run();
	}
	private void welcomeMessage()
	{
		log.info("The BgpSec server is Starting");
	}
	/**
	 * Effectively starts the BGP server. It starts with the IDLE status and proceeds
	 * according to the RFC, to create the listening socket and attempting
	 * a connection with the BGP peer.
	 */
	private void run()
	{
		try
		{
			welcomeMessage();
			readConfiguration();
			openChannelToRabbitMQ();
			openZebraSocket();
			openListener();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void readConfiguration() throws FileNotFoundException, IOException
	{
		log.info("Reading configuration");
		this.configurationReader=RouterConfigurationReader.getInstance();
		// Let's read the command-line options, if any.
		commandLineProcessor=BgpCommandLineProcessor.getInstance();
		String filename=configurationFilename;
		try {
			filename=commandLineProcessor.applyCommandLineOptions(commandLineArgs);
		} catch (ParseException e) {
			// If no command line is present to override the configuration file,
			// use the default value.
		}
		configurationReader.setConfigurationFilename(filename);
		this.configuration=configurationReader.loadConfiguration();
	}
	private void openListener() throws IOException
	{
		log.info("Opening listener");
		acceptor=new NioSocketAcceptor();
		acceptor.setReuseAddress(true);
		ProtocolCodecFilter pcf=new ProtocolCodecFilter(new BgpCoder(),new BgpDecoder());
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", pcf);
		acceptor.setHandler(createIoHandler());
		acceptor.setDefaultLocalAddress(new InetSocketAddress(179));
		acceptor.bind();
	}
	/**
	 * Opens a connection to RabbitMQ, which is assumed to be already running, and declares
	 * a new queue for use with Zebra.
	 * @throws IOException
	 * @throws TimeoutException
	 */
	private void openChannelToRabbitMQ() throws IOException, TimeoutException
	{
		log.info("Opening RabbitMQ queue. It is assumed that RabbitMQ is already running");
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection(); 
		Channel channelToZebra = connection.createChannel();
		this.channelToZebra=channelToZebra;
		channelToZebra.queueDeclare("ZebraQueue", false, false, false, null);
		log.info("Queue to Zebra opened. Ready for sending messages");
		
		// Now we open another queue, so that Zebra talks to us.
		Channel channelToBgpsec=connection.createChannel();
		this.channelToBgpsec=channelToBgpsec;
		channelToBgpsec.queueDeclare("BgpsecQueue",false,false,false,null);
		log.info("Queue to Bgpsec opened");
	}
	/**
	 * Opens a socket to the Zebra daemon. It is assumed that Zebra is already running. 
	 * @throws IOException
	 */
	private void openZebraSocket() throws IOException
	{
		log.info("Opening Zebra socket. It is assumed that Zebra is already running");
		zebra=new ZebraSocketMessenger(channelToZebra,channelToBgpsec,configuration.getZebraSocket());
		zebra.openZebraSocket();
		channelToZebra.basicConsume("ZebraQueue", false,"ConsumerTag",zebra);
		Thread t=new Thread(zebra);
		t.start();
	}
	public List<IoSession> getSessions()
	{
		List<IoSession> sessions=new LinkedList<IoSession>();
		for(IoSession session:acceptor.getManagedSessions().values())
		{
			sessions.add(session);
		}
		return sessions;
	}
}
