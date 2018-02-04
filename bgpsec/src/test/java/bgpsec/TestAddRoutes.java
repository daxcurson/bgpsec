package bgpsec;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.strellis.com.bgpsec.exceptions.BgpException;
import ar.strellis.com.bgpsec.routingconfig.RoutingConfigurer;
import ar.strellis.com.bgpsec.routingconfig.RoutingConfigurerFactory;

public class TestAddRoutes 
{
	private RoutingConfigurer routingConfigurer;
	@Before
	public void createRoutingConfigurer()
	{
		routingConfigurer=RoutingConfigurerFactory.getRoutingConfigurer("mnl");
	}/*
	@Test
	public void testAddRouteNml() 
	{
		// Test if we can add a route using libmnl.
		
		try {
			routingConfigurer.add_network("enp0s8", "10.60.70.0", "24", "10.60.60.1");
		} catch (BgpException e) 
		{
			e.printStackTrace();
			fail("Failed to add the route");
		}
	}*/
	@Test
	public void testListInterfaces()
	{
		routingConfigurer.list_interfaces();
	}
}
