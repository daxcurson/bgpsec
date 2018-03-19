package ar.strellis.com.bgpsec.configparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ar.strellis.com.bgpsec.model.BgpInterface;
import ar.strellis.com.bgpsec.model.MyConfiguration;

public class RouterConfigurationReader
{
	private MyConfiguration configuration;
	private String configurationFilename;
	public RouterConfigurationReader(String configurationFilename) 
	{
		this.configurationFilename=configurationFilename;
		configuration=new MyConfiguration();
	}
	public MyConfiguration getConfiguration() throws FileNotFoundException,IOException
	{
		// I'll create the parser that I'll use to consume the configuration.
		File f=new File(this.configurationFilename);
		InputStream inputStream=new FileInputStream(f);
		CharStream stream=CharStreams.fromStream(inputStream);
		ConfigurationLexer lexer=new ConfigurationLexer(stream);
		CommonTokenStream tokens=new CommonTokenStream(lexer);
		ConfigurationParser parser=new ConfigurationParser(tokens);
		// I get the interfaces present with a list.
		List<BgpInterface> interfaces=new LinkedList<BgpInterface>();
		parser.addParseListener(new ConfigurationBaseListener()
				{
			private String ip;
			private String netmask;
			@Override
			public void exitStatement_interface(ConfigurationParser.Statement_interfaceContext ctx)
			{
				BgpInterface iface=new BgpInterface();
				iface.setIp(ip);
				iface.setNetmask(netmask);
				interfaces.add(iface);
			}
			public void exitOption_interface_ip(ConfigurationParser.Option_interface_ipContext ctx)
			{
				ip=ctx.IPV4().getText();
			}
			public void exitOption_interface_netmask(ConfigurationParser.Option_interface_netmaskContext ctx)
			{
				netmask=ctx.IPV4().getText();
			}
				}
		);
		parser.prog();
		configuration.setInterfaces(interfaces);
		return configuration;
	}
}
