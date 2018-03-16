package bgpsec;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import ar.strellis.com.bgpsec.configparser.RouterConfigurationReader;
import ar.strellis.com.bgpsec.model.MyConfiguration;

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
