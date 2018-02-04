package ar.strellis.com.bgpsec.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

/**
 * Stores the configuration values read from a properties file.
 * @author Agustín Villafañe
 *
 */
public class MyConfiguration 
{
	private final String filename="configuration/config.properties";
	private Properties properties;
	
	private String myIP;
	private String myAS;
	private int myHoldTime;
	private int myKeepAliveTimer;
	
	public MyConfiguration() throws FileNotFoundException,IOException
	{
		// Read the configuration file.
		properties=new Properties();
		readConfiguration();
	}
	public void readConfiguration() throws FileNotFoundException,IOException
	{
		// Invoking the class loader to ask the OS for the configuration file
		ClassLoader classLoader=getClass().getClassLoader();
		
		InputStream is= classLoader.getResourceAsStream(this.filename);
		// Now, load the properties from the file.
		properties.load(is);
		myIP=properties.getProperty("my_IP");
		myAS=properties.getProperty("my_AS", "0");
		myHoldTime=Integer.parseInt(properties.getProperty("my_hold_time","180"));
		myKeepAliveTimer=Integer.parseInt(properties.getProperty("my_keepalive_timer","60"));
	}
	public String getMyIP() {
		return myIP;
	}
	public void setMyIP(String myIP) {
		this.myIP = myIP;
	}
	public String getMyAS() {
		return myAS;
	}
	public void setMyAS(String myAS) {
		this.myAS = myAS;
	}
	public int getMyHoldTime() {
		return myHoldTime;
	}
	public void setMyHoldTime(int myHoldTime) {
		this.myHoldTime = myHoldTime;
	}
	public int getMyKeepAliveTimer() {
		return myKeepAliveTimer;
	}
	public void setMyKeepAliveTimer(int myKeepAliveTimer) {
		this.myKeepAliveTimer = myKeepAliveTimer;
	}
}
