package ar.strellis.com.bgpsec.model;

/**
 * A BGP neighbor system. It listens to BGP and I will communicate with it to send
 * and receive routing information.
 * @author Agustín Villafañe
 *
 */
public class BgpNeighbor 
{
	private int asNumber;
	private String description;
	private String peerIp;
	public int getAsNumber() {
		return asNumber;
	}
	public void setAsNumber(int asNumber) {
		this.asNumber = asNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPeerIp() {
		return peerIp;
	}
	public void setPeerIp(String peerIp) {
		this.peerIp = peerIp;
	}
}
