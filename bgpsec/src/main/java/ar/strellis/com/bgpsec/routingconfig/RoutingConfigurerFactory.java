package ar.strellis.com.bgpsec.routingconfig;

public class RoutingConfigurerFactory 
{
	public static RoutingConfigurer getRoutingConfigurer(String type)
	{
		if(type.equals("iproute2"))
			return new RoutingConfigurerIproute2();
		if(type.equals("mnl"))
			return new RoutingConfigurerNml();
		return null;
	}
}
