package ar.strellis.com.bgpsec.model;

import ar.strellis.com.bgpsec.util.NetworkConverter;

public class BgpInterface 
{
	private String name;
	private int index;
	private String hwaddr;
	private String ip;
	private String netmask;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getHwaddr() {
		return hwaddr;
	}

	public void setHwaddr(String hwaddr) {
		this.hwaddr = hwaddr;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * Determines if the IP I'm given as an argument is in the same network as my own IP
	 * @param anotherIP
	 * @return
	 */
	public boolean inMyNetwork(long anotherIP)
	{
		// Convert text IP to Long.
		boolean result=false;
		
		long ipAsLong=NetworkConverter.convertStringIPtoLong(this.ip);
		// I do the same for the netmask value.
		long netmaskAsLong=NetworkConverter.convertStringIPtoLong(this.netmask);
		// Now, the crucial statement. If I AND the IPs with the Netmask, and are the same value,
		// then the IP is in my network.
		result = (ipAsLong & netmaskAsLong) == (anotherIP & netmaskAsLong);
		return result;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}
}
