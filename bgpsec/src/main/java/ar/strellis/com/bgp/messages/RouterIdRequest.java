package ar.strellis.com.bgp.messages;

public class RouterIdRequest extends RoutingMessage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2605797606666730473L;
	private Op op;
	private int vrf_id;
}