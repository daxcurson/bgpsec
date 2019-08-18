package ar.strellis.com.bgpsec.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.LinkedList;
import java.util.List;

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

import ar.strellis.com.bgpsec.codec.BgpCoder;
import ar.strellis.com.bgpsec.codec.BgpDecoder;
import ar.strellis.com.bgpsec.configparser.RouterConfigurationReader;
import ar.strellis.com.bgpsec.event.EventTransitionListener;
import ar.strellis.com.bgpsec.handler.BgpHandler;
import ar.strellis.com.bgpsec.model.BgpSession;
import ar.strellis.com.bgpsec.model.MyConfiguration;

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
	
	public BgpServer(String[] commandLineArgs)
	{
		listeners=new LinkedList<EventTransitionListener>();
		this.commandLineArgs=commandLineArgs;
	}
	private IoHandler createIoHandler() 
	{
		BgpHandler b=new BgpHandler(this.configuration);
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
			openListener();
			openZebraSocket();
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
	private void openZebraSocket()
	{
		log.info("Opening socket with the Zebra daemon. It is assumed that it is already running");
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
