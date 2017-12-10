package ar.strellis.com.bgpsec.routingconfig;

public class RoutingConfigurer 
{
	static
	{
		System.loadLibrary("mnl_communicator");
	}
	
	private native void add_network_via_nml(String network);
}
