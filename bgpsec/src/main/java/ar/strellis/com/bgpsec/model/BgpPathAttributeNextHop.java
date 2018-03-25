package ar.strellis.com.bgpsec.model;

/**
 * This is a well-known mandatory attribute that defines the unicast IP address of the router
 * that SHOULD be used as the next hop to the destinations listed in the Network Layer Reachability
 * Information field of the UPDATE message.
 * @author Agustín Villafañe
 *
 */
public class BgpPathAttributeNextHop extends BgpPathAttribute 
{
	private BgpIPV4 ipv4;
	@Override
	public void loadValue(byte[] value) 
	{
		// I receive some kind of value!!!
		this.setAttribute_value(value);
		// Convert to long.
		long ip=0;
		for(int i=0;i<4;i++)
		{
			ip=ip << 8;
			ip=ip+value[i];
		}
		ipv4=new BgpIPV4();
		ipv4.setIp(ip);
	}
	public BgpIPV4 getIpv4() {
		return ipv4;
	}
	public void setIpv4(BgpIPV4 ipv4) {
		this.ipv4 = ipv4;
	}
}
