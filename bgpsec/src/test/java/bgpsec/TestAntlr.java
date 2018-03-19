package bgpsec;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import ar.strellis.com.bgpsec.configparser.RouterConfigurationReader;
import ar.strellis.com.bgpsec.model.BgpInterface;
import ar.strellis.com.bgpsec.model.MyConfiguration;
import ar.strellis.com.bgpsec.util.NetworkConverter;

public class TestAntlr 
{
	@Test
	public void readConfiguration()
	{
		// Let's consume the configuration file
		String filename="/etc/bgpsec/bgpsec.conf";
		try {
			RouterConfigurationReader r=new RouterConfigurationReader(filename);
			MyConfiguration c=r.getConfiguration();
			// Now I list the interfaces.
			for(BgpInterface i:c.getInterfaces())
			{
				System.out.println("Parsed interface: "+i.getIp()+"/"+i.getNetmask());
			}
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
	public void compareIP()
	{
		// I will compare the IP with those of the interfaces and decide
		// if they are in the same network.
		// Let's consume the configuration file
		String anotherIP="10.70.60.2";
		String filename="/etc/bgpsec/bgpsec.conf";
		try {
			RouterConfigurationReader r=new RouterConfigurationReader(filename);
			MyConfiguration c=r.getConfiguration();
			// Now I list the interfaces.
			for(BgpInterface i:c.getInterfaces())
			{
				System.out.println("Parsed interface: "+i.getIp()+"/"+i.getNetmask());
				System.out.print("Is the IP "+anotherIP+" in the same network? ");
				if(i.inMyNetwork(NetworkConverter.convertStringIPtoLong(anotherIP)))
					System.out.println("Yes");
				else
					System.out.println("No");
			}
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
}
