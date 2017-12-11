package ar.strellis.com.bgpsec.routingconfig;

public class RoutingConfigurer 
{
	static
	{
		System.loadLibrary("routing_configurer");
	}
	
	private native void add_network_via_nml(String network);
	
	public void add_network(String network)
	{
		// According to a selected implementation for message-passing,
		// we'll choose the native method to execute.
		add_network_via_nml(network);
	}
}
