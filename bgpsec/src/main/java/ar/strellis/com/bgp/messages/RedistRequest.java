package ar.strellis.com.bgp.messages;

public class RedistRequest extends RoutingMessage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1554392184829383724L;
	private Op op;
	private AFI afi;
	private boolean all_vrf;
	private int vrf_id;
    private RouteType type;
}