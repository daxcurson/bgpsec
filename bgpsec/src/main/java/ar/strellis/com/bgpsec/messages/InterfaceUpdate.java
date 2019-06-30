package ar.strellis.com.bgpsec.messages;

public abstract class InterfaceUpdate extends RoutingMessage
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5410801938960868405L;
	private String interfaceName;
	 /* integer 4 bytes - index
	 * char 1 byte - status
	 * long 8 bytes - flags
	 * char 1 byte - ptm_enable
	 * char 1 byte - ptm_status
	 * integer 4 bytes - metric
	 * integer 4 bytes - speed
	 * integer 4 bytes - mtu
	 * integer 4 bytes - mtu6
	 * integer 4 bytes - bandwidth
	 * integer 4 bytes - link_ifindex
	 * integer 4 bytes - ll_type
	 * integer 4 bytes - hadware address length
	 * set of bytes - hardware address
	 * char 1 byte - traffic engineering parameters present, 1 or 0
*/
	private int index;
	private int status;
	private long flags;
	private int ptm_enable;
	private int ptm_status;
	private int metric;
	private int speed;
	private int mtu;
	private int mtu6;
	private int bandwidth;
	private int link_ifindex;
	private int ll_type;
	private int hwaddr_length;
	private byte[] hwaddr;
	private int traffic_eng_params;
	
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getFlags() {
		return flags;
	}
	public void setFlags(long flags) {
		this.flags = flags;
	}
	public int getPtm_enable() {
		return ptm_enable;
	}
	public void setPtm_enable(int ptm_enable) {
		this.ptm_enable = ptm_enable;
	}
	public int getPtm_status() {
		return ptm_status;
	}
	public void setPtm_status(int ptm_status) {
		this.ptm_status = ptm_status;
	}
	public int getMetric() {
		return metric;
	}
	public void setMetric(int metric) {
		this.metric = metric;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMtu() {
		return mtu;
	}
	public void setMtu(int mtu) {
		this.mtu = mtu;
	}
	public int getMtu6() {
		return mtu6;
	}
	public void setMtu6(int mtu6) {
		this.mtu6 = mtu6;
	}
	public int getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}
	public int getLink_ifindex() {
		return link_ifindex;
	}
	public void setLink_ifindex(int link_ifindex) {
		this.link_ifindex = link_ifindex;
	}
	public int getLl_type() {
		return ll_type;
	}
	public void setLl_type(int ll_type) {
		this.ll_type = ll_type;
	}
	public int getHwaddr_length() {
		return hwaddr_length;
	}
	public void setHwaddr_length(int hwaddr_length) {
		this.hwaddr_length = hwaddr_length;
	}
	public byte[] getHwaddr() {
		return hwaddr;
	}
	public void setHwaddr(byte[] hwaddr) {
		this.hwaddr = hwaddr;
	}
	public int getTraffic_eng_params() {
		return traffic_eng_params;
	}
	public void setTraffic_eng_params(int traffic_eng_params) {
		this.traffic_eng_params = traffic_eng_params;
	}
}
