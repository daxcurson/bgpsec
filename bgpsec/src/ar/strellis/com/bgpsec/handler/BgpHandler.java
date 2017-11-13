package ar.strellis.com.bgpsec.handler;

import org.apache.mina.statemachine.annotation.IoHandlerTransition;
import org.apache.mina.statemachine.annotation.State;
import static org.apache.mina.statemachine.event.IoHandlerEvents.*;

import org.apache.mina.core.session.IoSession;

import ar.strellis.com.bgpsec.model.BgpSession;

/**
 * MINA BGP handler
 * @author daxcurson
 *
 */
public class BgpHandler 
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
		
	}
}
