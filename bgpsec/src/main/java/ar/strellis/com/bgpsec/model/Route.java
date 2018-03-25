package ar.strellis.com.bgpsec.model;

/**
 * Represents a route within a BGP message. Can be interpreted by the routing
 * configurer as a route to add or delete.
 * @author Agust�n Villafa�e
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
	private int gateway;
	private int metric;
	private int origin_as;
	
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
	public int getGateway() {
		return gateway;
	}
	public void setGateway(int gateway) {
		this.gateway = gateway;
	}
	public int getMetric() {
		return metric;
	}
	public void setMetric(int metric) {
		this.metric = metric;
	}
	public int getOrigin_as() {
		return origin_as;
	}
	public void setOrigin_as(int origin_as) {
		this.origin_as = origin_as;
	}
}
