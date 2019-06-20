package ar.strellis.com.bgp.messages;

import java.util.List;

public class InterfaceUpdate extends RoutingMessage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7597307218986209537L;
	private int index;
	private int flags;
	private int mtu;
	private int metric;
	private HwAddr  hw_addr;
	private List<Address> addr_ipv4;
	private List<Address> addr_ipv6;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public int getMtu() {
		return mtu;
	}
	public void setMtu(int mtu) {
		this.mtu = mtu;
	}
	public int getMetric() {
		return metric;
	}
	public void setMetric(int metric) {
		this.metric = metric;
	}
	public HwAddr getHw_addr() {
		return hw_addr;
	}
	public void setHw_addr(HwAddr hw_addr) {
		this.hw_addr = hw_addr;
	}
	public List<Address> getAddr_ipv4() {
		return addr_ipv4;
	}
	public void setAddr_ipv4(List<Address> addr_ipv4) {
		this.addr_ipv4 = addr_ipv4;
	}
	public List<Address> getAddr_ipv6() {
		return addr_ipv6;
	}
	public void setAddr_ipv6(List<Address> addr_ipv6) {
		this.addr_ipv6 = addr_ipv6;
	}
}