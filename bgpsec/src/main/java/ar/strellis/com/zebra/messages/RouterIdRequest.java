package ar.strellis.com.zebra.messages;

import ar.strellis.com.bgpsec.messages.Op;
import ar.strellis.com.bgpsec.messages.RoutingMessage;

public class RouterIdRequest extends RoutingMessage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2605797606666730473L;
	private Op op;
	private int vrf_id;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}