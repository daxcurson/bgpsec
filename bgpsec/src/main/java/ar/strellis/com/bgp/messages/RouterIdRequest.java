package ar.strellis.com.bgp.messages;

import java.io.DataOutputStream;

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
	public void encode(DataOutputStream out) {
		// TODO Auto-generated method stub
		
	}
}