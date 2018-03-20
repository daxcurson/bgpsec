package ar.strellis.com.bgpsec.model;

/**
 * Represents a route within a BGP message. Can be interpreted by the routing
 * configurer as a route to add or delete.
 * @author Agustín Villafañe
 *
 */
public class Route 
{
	/**
	 * This is the network address, e.g. 192.168.1
	 */
	private int network_address;
	/**
	 * This is the prefix length, e.g. in 192.168.1.0/24, this is 24.
	 */
	private int prefix;
	
	public int getNetwork_address() {
		return network_address;
	}
	public void setNetwork_address(int network_address) {
		this.network_address = network_address;
	}
	public int getPrefix() {
		return prefix;
	}
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
}
