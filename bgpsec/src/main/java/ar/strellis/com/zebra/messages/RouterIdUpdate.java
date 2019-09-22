package ar.strellis.com.zebra.messages;

import ar.strellis.com.bgpsec.messages.RoutingMessage;

public class RouterIdUpdate extends RoutingMessage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8902862633247679058L;
	private int vrf_id;
	private byte[] router_id;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}