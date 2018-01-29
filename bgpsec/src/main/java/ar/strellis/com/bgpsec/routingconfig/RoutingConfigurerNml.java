package ar.strellis.com.bgpsec.routingconfig;

import java.util.List;

import ar.strellis.com.bgpsec.exceptions.BgpException;
import ar.strellis.com.bgpsec.model.BgpInterface;

public class RoutingConfigurerNml extends RoutingConfigurer
{
	private native void add_network_via_nml(String iface, String network, String cidr, String gateway);
	private native void list_interfaces_via_nml();
	static
	{
		System.loadLibrary("routing_configurer");
	}
	@Override
	public void add_network(String iface, String network, String cidr, String gateway) throws BgpException {
		add_network_via_nml(iface, network, cidr, gateway);
	}
	@Override
	public List<BgpInterface> list_interfaces() {
		// TODO Auto-generated method stub
		return null;
	}
}
