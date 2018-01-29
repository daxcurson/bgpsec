package bgpsec;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.strellis.com.bgpsec.exceptions.BgpException;
import ar.strellis.com.bgpsec.routingconfig.RoutingConfigurer;
import ar.strellis.com.bgpsec.routingconfig.RoutingConfigurerFactory;

public class TestAddRoutes 
{
	private RoutingConfigurer routingConfigurer;
	
	@Test
	public void testAddRouteNml() 
	{
		// Test if we can add a route using libmnl.
		routingConfigurer=RoutingConfigurerFactory.getRoutingConfigurer("mnl");
		try {
			routingConfigurer.add_network("enp0s8", "10.60.70.0", "24", "10.60.60.1");
		} catch (BgpException e) 
		{
			e.printStackTrace();
			fail("Failed to add the route");
		}
	}

}
