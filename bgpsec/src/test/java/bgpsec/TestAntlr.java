package bgpsec;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ar.strellis.com.bgpsec.configparser.RouterConfigurationReader;
import ar.strellis.com.bgpsec.model.BgpInterface;
import ar.strellis.com.bgpsec.model.BgpNeighbor;
import ar.strellis.com.bgpsec.model.MyConfiguration;
import ar.strellis.com.bgpsec.util.NetworkConverter;

public class TestAntlr 
{
	private MyConfiguration configuration;
	@Before
	public void readConfiguration()
	{
		// Let's consume the configuration file
		String filename="/etc/bgpsec/bgpsec.conf";
		try {
			RouterConfigurationReader r=RouterConfigurationReader.getInstance();
			r.setConfigurationFilename(filename);
			this.configuration=r.loadConfiguration();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Configuration file not found");
			fail();
		}
		catch(IOException e)
		{
			System.out.println("Error reading the configuration file");
			fail();
		}
	}
	@Test
	public void testInterfaces()
	{
		System.out.println("INTERFACES------------------------------------------------");
		// Now I list the interfaces.
		for(BgpInterface i:configuration.getInterfaces())
		{
			System.out.println("Parsed interface: "+i.getIp()+"/"+i.getNetmask());
		}
	}
	@Test
	public void compareIP()
	{
		System.out.println("COMPARING IPs----------------------------------------------");
		// I will compare the IP with those of the interfaces and decide
		// if they are in the same network.
		// Let's consume the configuration file
		String anotherIP="10.70.60.2";
		for(BgpInterface i:configuration.getInterfaces())
		{
			System.out.println("Parsed interface: "+i.getIp()+"/"+i.getNetmask());
			System.out.print("Is the IP "+anotherIP+" in the same network? ");
			if(i.inMyNetwork(NetworkConverter.convertStringIPtoLong(anotherIP)))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
	@Test
	public void findPeers()
	{
		System.out.println("FIND PEERS----------------------------------------------");
		// Find the BGP peers read from the configuration file.
		for(BgpNeighbor n:configuration.getNeighbors().values())
		{
			System.out.println("Parsed neighbor: "+n.getAsNumber()+", at "+n.getPeerIp());
		}
	}
	@Test
	public void getASNumber()
	{
		System.out.println("GETTING AS NUMBER----------------------------------------------");
		assertNotNull(configuration.getMyAS());
		System.out.println("My AS is "+configuration.getMyAS());
	}
	@Test
	public void getZebraSocket()
	{
		System.out.println("GETTING ZEBRA SOCKET-------------------------------------------");
		assertNotNull(configuration.getZebraSocket());
		System.out.println("The Zebra socket is "+configuration.getZebraSocket());
	}
}
