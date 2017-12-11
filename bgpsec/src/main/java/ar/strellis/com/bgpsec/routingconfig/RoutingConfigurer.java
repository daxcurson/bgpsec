package ar.strellis.com.bgpsec.routingconfig;

public class RoutingConfigurer 
{
	static
	{
		System.loadLibrary("routing_configurer");
	}
	
	private native void add_network_via_nml(String iface, String network, String cidr, String gateway);
	
	public void add_network(String iface, String network, String cidr, String gateway)
	{
		// According to a selected implementation for message-passing,
		// we'll choose the native method to execute.
		add_network_via_nml(iface, network, cidr, gateway);
	}
}
