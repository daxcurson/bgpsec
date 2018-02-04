package ar.strellis.com.bgpsec.handler;

import org.apache.mina.statemachine.StateControl;
import org.apache.mina.statemachine.annotation.IoHandlerTransition;
import org.apache.mina.statemachine.annotation.State;
import static org.apache.mina.statemachine.event.IoHandlerEvents.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.session.IoSession;

import ar.strellis.com.bgpsec.event.EventTransitionListener;
import ar.strellis.com.bgpsec.model.BgpKeepAlive;
import ar.strellis.com.bgpsec.model.BgpMessage;
import ar.strellis.com.bgpsec.model.BgpNotification;
import ar.strellis.com.bgpsec.model.BgpOpen;
import ar.strellis.com.bgpsec.model.BgpSession;
import ar.strellis.com.bgpsec.model.BgpUpdate;
import ar.strellis.com.bgpsec.model.MyConfiguration;
//import ar.strellis.com.bgpsec.routingconfig.RoutingConfigurer;

/**
 * MINA BGP handler
 * @author daxcurson
 *
 */
public class BgpHandler implements EventTransitionListener
{
	@State public static final String ROOT="Root";
	@State(ROOT) public static final String IDLE="Idle";
	@State(ROOT) public static final String CONNECT="Connect";
	@State(ROOT) public static final String ACTIVE="Active";
	@State(ROOT) public static final String OPEN_SENT="Open Sent";
	@State(ROOT) public static final String OPEN_CONFIRM="Open Confirm";
	@State(ROOT) public static final String ESTABLISHED="Established";
	
	private MyConfiguration configuration;
	private ScheduledExecutorService keepAliveScheduler;
	private ScheduledExecutorService holdScheduler;
	private ScheduledFuture<Void> holdTimerRunning;
	
	/**
	 * Sends a KeepAlive message when the time expires. It contains the session
	 * for which this message must be sent.
	 * @author Agustín Villafañe
	 *
	 */
	class BgpKeepAliveTimerExpired implements Runnable
	{
		private IoSession ioSession;
		private BgpSession bgpSession;
		
		public BgpKeepAliveTimerExpired(BgpSession bgpSession,IoSession ioSession)
		{
			this.ioSession=ioSession;
			this.bgpSession=bgpSession;
		}
		@Override
		public void run() 
		{
			// When the timer expires, generate a new BgpKeepAlive message.
			BgpMessage m=new BgpKeepAlive();
			ioSession.write(m);
			// Restart the timer
			startKeepAliveTimer(bgpSession,ioSession);
		}
	}
	
	public BgpHandler(MyConfiguration configuration)
	{
		this.configuration=configuration;
		// Start the keepalive timer.
		keepAliveScheduler=Executors.newScheduledThreadPool(3);
	}
	/*
	 * State changes
	 */
	@IoHandlerTransition(on=MESSAGE_RECEIVED,in=IDLE)
	public void refuse_connection(BgpSession context,IoSession session)
	{
		// Nothing to do here.
	}
	@IoHandlerTransition(on=SESSION_CREATED,in=IDLE)
	public void session_created(BgpSession context,IoSession session)
	{
		StateControl.breakAndGotoNext(CONNECT);
	}
	@IoHandlerTransition(on=SESSION_OPENED,in=IDLE)
	public void forced_start(BgpSession context,IoSession session)
	{
		StateControl.breakAndGotoNext(CONNECT);
	}
	@IoHandlerTransition(on=SESSION_CLOSED,in=IDLE)
	public void closeIdleSession(BgpSession bgpSession,IoSession ioSession)
	{
		// Close the session!!!
		System.out.println("Close session received, but I'm idle!!");
	}
	@IoHandlerTransition(on=SESSION_OPENED,in=CONNECT)
	public void openSession(BgpSession bgpSession,IoSession ioSession)
	{
		// Create a new BgpSession.
		bgpSession.setState(CONNECT);
	}
	@IoHandlerTransition(on=SESSION_CLOSED,in=CONNECT)
	public void closeRunningSession(BgpSession bgpSession,IoSession ioSession)
	{
		System.out.println("Close session received");
	}
	@IoHandlerTransition(on=EXCEPTION_CAUGHT,in=CONNECT)
	public void exceptionCaught(BgpSession bgpSession,IoSession ioSession)
	{
		System.out.println("Exception caught!!!!");
	}
	@IoHandlerTransition(on=MESSAGE_RECEIVED,in=CONNECT)
	public void bgpOpenReceived(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
		if(message instanceof BgpOpen)
		{
			// Starts a new conversation with a remote router.
			// In this state, we send an open and then a keepalive message.
			// The state changes from Connect to OpenSent. If I'm in the OpenSent state,
			// I don't send a new Open message. If I receive a keepalive message,
			// I change to the OpenConfirm state.
			BgpOpen openMessage=new BgpOpen();
			openMessage.setBgp_identifier(ipToLong(configuration.getMyIP()));
			openMessage.setHold_time(configuration.getMyHoldTime());
			openMessage.setSender_AS(Integer.parseInt(configuration.getMyAS()));
			ioSession.write(openMessage);
			BgpKeepAlive keepAlive=new BgpKeepAlive();
			ioSession.write(keepAlive);
			// Prepare a timer for sending a KeepAlive message.
			if(configuration.getMyHoldTime()>0)
			{
				this.startKeepAliveTimer(bgpSession, ioSession);
			}
			else
			{
				// The keepAlive timer is there for each bgp Session created. 
				// I must retrieve the current keepalive timer, if any, to cancel it.
				cancelKeepAliveTimer(bgpSession);
			}
			StateControl.breakAndGotoNext(OPEN_CONFIRM);
		}
	}
	private void cancelKeepAliveTimer(BgpSession bgpSession)
	{
		@SuppressWarnings("unchecked")
		ScheduledFuture<Void> keepAliveTimerRunning=(ScheduledFuture<Void>) bgpSession.getAttribute("keepAliveTimer");
		// If I couldn't retrieve this object, don't bother checking.
		if(keepAliveTimerRunning!=null)
			if(!keepAliveTimerRunning.isDone())
			{
				// The timer is still running.
				keepAliveTimerRunning.cancel(false);
			}
	}
	private void startKeepAliveTimer(BgpSession bgpSession,IoSession ioSession)
	{
		Runnable keepAliveTimer=new BgpKeepAliveTimerExpired(bgpSession,ioSession);
		keepAliveScheduler.schedule(keepAliveTimer, configuration.getMyKeepAliveTimer(),TimeUnit.SECONDS);
		// Store the created keepalive timer in the BgpSession.
		bgpSession.setAttribute("keepAliveTimer", keepAliveTimer);
	}
	/**
	 * Extracted from https://www.mkyong.com/java/java-convert-ip-address-to-decimal-number/
	 * @param IP
	 * @return
	 */
	private long ipToLong(String IP)
	{
		String[] ipAddressInArray = IP.split("\\.");

		long result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {

			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			result += ip * Math.pow(256, power);

		}

		return result;
	}
	@IoHandlerTransition(on=MESSAGE_SENT,in=CONNECT)
	public void messageSentConnect(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
		// When a message is sent, I get here.
	}
	@IoHandlerTransition(on=MESSAGE_RECEIVED,in=OPEN_SENT)
	public void bgpOpenSent(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
		if(message instanceof BgpOpen)
		{
			// I already sent an Open and I receive an open from the other side. Ignore this.
		}
		if(message instanceof BgpKeepAlive)
		{
			// I received an ack from the other side. Confirm this by sending a Keepalive.
			BgpKeepAlive k=new BgpKeepAlive();
			ioSession.write(k);
			StateControl.breakAndGotoNext(OPEN_CONFIRM);
		}
	}
	@IoHandlerTransition(on=SESSION_CLOSED,in=OPEN_SENT)
	public void closeRunningSessionHalfOpen(BgpSession bgpSession,IoSession ioSession)
	{
		System.out.println("Close session received");
	}
	@IoHandlerTransition(on=EXCEPTION_CAUGHT,in=OPEN_SENT)
	public void exceptionCaughtHalfOpen(BgpSession bgpSession,IoSession ioSession)
	{
		System.out.println("Exception caught!!!!");
	}
	@IoHandlerTransition(on=MESSAGE_SENT,in=OPEN_SENT)
	public void messageSentHalfOpen(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
		// When a message is sent, I get here.
	}
	@IoHandlerTransition(on=MESSAGE_RECEIVED,in=OPEN_CONFIRM)
	public void bgpOpenConfirm(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
		if(message instanceof BgpKeepAlive)
		{
			// Keepalive received. Moving to the Established mode.
			StateControl.breakAndGotoNext(ESTABLISHED);
		}
		if(message instanceof BgpNotification)
		{
			// Notification received.
		}
	}
	@IoHandlerTransition(on=SESSION_CLOSED,in=OPEN_CONFIRM)
	public void closeRunningSessionConfirmed(BgpSession bgpSession,IoSession ioSession)
	{
		System.out.println("Close session received");
	}
	@IoHandlerTransition(on=EXCEPTION_CAUGHT,in=OPEN_CONFIRM)
	public void exceptionCaughtConfirmed(BgpSession bgpSession,IoSession ioSession)
	{
		System.out.println("Exception caught!!!!");
	}
	@Override
	public void start() 
	{
		System.out.println("Changing to connect");
		StateControl.breakAndGotoNext(CONNECT);
	}
	@IoHandlerTransition(on=MESSAGE_SENT,in=OPEN_CONFIRM)
	public void messageSentConfirmed(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
		// When a message is sent, I get here.
	}
	@IoHandlerTransition(on=MESSAGE_RECEIVED,in=ESTABLISHED)
	public void messageReceivedEstablished(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
		if(message instanceof BgpUpdate)
		{
			// Do something with the update.
		}
		if(message instanceof BgpKeepAlive)
		{
			// Do something with the keepalive
		}
	}
	@IoHandlerTransition(on=SESSION_CLOSED,in=ESTABLISHED)
	public void sessionClosedEstablished(BgpSession bgpSession,IoSession ioSession)
	{
		
	}
	@IoHandlerTransition(on=EXCEPTION_CAUGHT,in=ESTABLISHED)
	public void exceptionCaughtEstablished(BgpSession bgpSession,IoSession ioSession)
	{
		
	}
	@IoHandlerTransition(on=MESSAGE_SENT,in=ESTABLISHED)
	public void messageSentEstablished(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
		
	}
}
