package ar.strellis.com.bgpsec.controller;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandler;
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
import ar.strellis.com.bgpsec.handler.BgpHandler;
import ar.strellis.com.bgpsec.model.BgpSession;

/**
 * Launcher class for the BGP server
 * @author daxcurson
 *
 */
public class BgpServer 
{
	private SocketAcceptor acceptor;
	private IoHandler createIoHandler() 
	{
		StateMachine sm = StateMachineFactory.getInstance(IoHandlerTransition.class).create(BgpHandler.IDLE, new BgpHandler());

		return new StateMachineProxyBuilder().setStateContextLookup(
				new IoSessionStateContextLookup(new StateContextFactory() {
					public StateContext create() {
						return new BgpSession();
					}
				})).create(IoHandler.class, sm);
	}
	public static void main(String[] args) 
	{
		BgpServer s=new BgpServer();
		s.run();
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
			openListener();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void openListener() throws IOException
	{
		acceptor=new NioSocketAcceptor();
		acceptor.setReuseAddress(true);
		ProtocolCodecFilter pcf=new ProtocolCodecFilter(new BgpCoder(),new BgpDecoder());
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", pcf);
		acceptor.setHandler(createIoHandler());
		acceptor.setDefaultLocalAddress(new InetSocketAddress(179));
		acceptor.bind();
	}
}
