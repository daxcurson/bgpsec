package ar.strellis.com.bgpsec.model;

import java.util.List;

/**
 * BGP OPEN message
 * - version: protocol version number of the message. Expected to be 4.
 * - sender_AS: the autonomous system number of the sender
 * - hold_time: the proposed number of seconds for the hold timer proposed by this sender.
 * - bgp_identifier: BGP identifier of the sender
 * - optional_parameters: BGP capabilities per RFC 3392
 * @author Agustín Villafañe
 *
 */
public class BgpOpen extends BgpMessage
{
	private int version;
	private int sender_AS;
	private int hold_time;
	private long bgp_identifier;
	private List<BgpCapability> optional_parameters;
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getSender_AS() {
		return sender_AS;
	}
	public void setSender_AS(int sender_AS) {
		this.sender_AS = sender_AS;
	}
	public int getHold_time() {
		return hold_time;
	}
	public void setHold_time(int hold_time) {
		this.hold_time = hold_time;
	}
	public long getBgp_identifier() {
		return bgp_identifier;
	}
	public void setBgp_identifier(long bgp_identifier) {
		this.bgp_identifier = bgp_identifier;
	}
	public List<BgpCapability> getOptional_parameters() {
		return optional_parameters;
	}
	public void setOptional_parameters(List<BgpCapability> optional_parameters) {
		this.optional_parameters = optional_parameters;
	}
}
