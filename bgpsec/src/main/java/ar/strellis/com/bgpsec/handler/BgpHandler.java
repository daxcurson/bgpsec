package ar.strellis.com.bgpsec.handler;

import org.apache.mina.statemachine.StateControl;
import org.apache.mina.statemachine.annotation.IoHandlerTransition;
import org.apache.mina.statemachine.annotation.State;
import static org.apache.mina.statemachine.event.IoHandlerEvents.*;

import org.apache.mina.core.session.IoSession;

import ar.strellis.com.bgpsec.event.EventTransitionListener;
import ar.strellis.com.bgpsec.model.BgpMessage;
import ar.strellis.com.bgpsec.model.BgpSession;
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
		StateControl.breakAndCallNext(CONNECT);
	}
	@IoHandlerTransition(on=SESSION_OPENED,in=IDLE)
	public void forced_start(BgpSession context,IoSession session)
	{
		StateControl.breakAndGotoNext(CONNECT);
	}
	@IoHandlerTransition(on=SESSION_OPENED,in=CONNECT)
	public void openSession(BgpSession bgpSession,IoSession ioSession)
	{
	}
	@IoHandlerTransition(on=MESSAGE_RECEIVED,in=CONNECT)
	public void dispatchMessage(BgpSession bgpSession,IoSession ioSession,BgpMessage message)
	{
	}
	@Override
	public void start() 
	{
		System.out.println("Changing to connect");
		StateControl.breakAndGotoNext(CONNECT);
	}
}
