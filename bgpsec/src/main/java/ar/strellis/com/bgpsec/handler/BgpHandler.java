package ar.strellis.com.bgpsec.handler;

import org.apache.mina.statemachine.StateControl;
import org.apache.mina.statemachine.annotation.IoHandlerTransition;
import org.apache.mina.statemachine.annotation.State;
import static org.apache.mina.statemachine.event.IoHandlerEvents.*;

import org.apache.mina.core.session.IoSession;

import ar.strellis.com.bgpsec.event.EventTransitionListener;
import ar.strellis.com.bgpsec.model.BgpKeepAlive;
import ar.strellis.com.bgpsec.model.BgpMessage;
import ar.strellis.com.bgpsec.model.BgpNotification;
import ar.strellis.com.bgpsec.model.BgpOpen;
import ar.strellis.com.bgpsec.model.BgpSession;
import ar.strellis.com.bgpsec.model.BgpUpdate;
import ar.strellis.com.bgpsec.routingconfig.RoutingConfigurer;

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
			openMessage.setBgp_identifier(0xa3c3c01);
			openMessage.setHold_time(180);
			openMessage.setSender_AS(2000);
			ioSession.write(openMessage);
			BgpKeepAlive keepAlive=new BgpKeepAlive();
			ioSession.write(keepAlive);
			StateControl.breakAndGotoNext(OPEN_CONFIRM);
		}
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
