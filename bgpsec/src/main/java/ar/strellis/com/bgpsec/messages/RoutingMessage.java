package ar.strellis.com.bgpsec.messages;

import java.io.DataOutputStream;
import java.io.Serializable;

public abstract class RoutingMessage implements Serializable
{
	protected Op op;
	protected int vrf_id;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1946895660393844492L;
	public Op getOp() {
		return op;
	}
	public void setOp(Op op) {
		this.op = op;
	}
	public int getVrf_id() {
		return vrf_id;
	}
	public void setVrf_id(int vrf_id) {
		this.vrf_id = vrf_id;
	}
	public abstract void encode(DataOutputStream out);
}
