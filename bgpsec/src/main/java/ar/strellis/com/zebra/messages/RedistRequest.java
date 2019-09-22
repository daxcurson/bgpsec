package ar.strellis.com.zebra.messages;

import ar.strellis.com.bgpsec.messages.Op;
import ar.strellis.com.bgpsec.messages.RoutingMessage;

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
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}