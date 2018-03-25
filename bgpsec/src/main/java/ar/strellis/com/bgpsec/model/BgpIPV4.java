package ar.strellis.com.bgpsec.model;

public class BgpIPV4 
{
	private long ip;

	public long getIp() {
		return ip;
	}

	public void setIp(long ip) {
		this.ip = ip;
	}
	
	/**
	 * Converts the IPv4 to String
	 */
	public String toString()
	{
		long ipv4=ip;
		// The 4th byte
		int byte4=(int) (ipv4 & 0xFF);
		ipv4=ipv4 >> 8; // bite the least-significant 8 bits to get the 3rd byte, and so on
		int byte3=(int)(ipv4 & 0xFF);
		ipv4=ipv4 >> 8;
		int byte2=(int)(ipv4 & 0xFF);
		ipv4=ipv4 >> 8;
		int byte1=(int)(ipv4 & 0xFF);
		return String.valueOf(byte1)+"."+String.valueOf(byte2)+"."+String.valueOf(byte3)+"."+String.valueOf(byte4);
	}
}
