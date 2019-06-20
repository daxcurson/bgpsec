package ar.strellis.com.bgp.messages;

public class RouterIdUpdate extends RoutingMessage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8902862633247679058L;
	private int vrf_id;
	private byte[] router_id;
}