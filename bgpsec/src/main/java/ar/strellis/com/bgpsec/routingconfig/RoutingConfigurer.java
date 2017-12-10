package ar.strellis.com.bgpsec.routingconfig;

public class RoutingConfigurer 
{
	static
	{
		System.loadLibrary("routing_configurer");
	}
	
	private native void add_network_via_nml(String network);
}
