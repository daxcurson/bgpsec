package ar.strellis.com.bgpsec.routingconfig;

import java.util.List;

import ar.strellis.com.bgpsec.exceptions.BgpException;
import ar.strellis.com.bgpsec.model.*;

public abstract class RoutingConfigurer 
{
	public abstract void add_network(String iface, String network, String cidr, String gateway) throws BgpException;
	public abstract List<BgpInterface> list_interfaces();
}
