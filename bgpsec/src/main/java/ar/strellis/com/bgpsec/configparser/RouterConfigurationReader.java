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
import ar.strellis.com.bgpsec.model.BgpNeighbor;
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
		// The BGP peers too.
		List<BgpNeighbor> neighbors=new LinkedList<BgpNeighbor>();
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
		// Now, read the BGP peers. I'll assume, for now, that all the router statements
		// that I will have will be BGP and that I'll have configuration for their BGP
		// neighbors, so looking into any other kind of statement except neighbor statements
		// is useless for now.
		parser.addParseListener(new ConfigurationBaseListener()
				{
			private String neighbor_description;
			private String neighbor_ip;
			private int remote_as;
			private String router_kind;
			private String my_as;
			public void exitNeighbor_description_string(ConfigurationParser.Neighbor_description_stringContext ctx)
			{
				neighbor_description=ctx.STRING().getText();
			}
			public void exitNeighbor_ip(ConfigurationParser.Neighbor_ipContext ctx)
			{
				neighbor_ip=ctx.IPV4().getText();
			}
			public void exitRemote_as(ConfigurationParser.Remote_asContext ctx)
			{
				remote_as=Integer.parseInt(ctx.INT().getText());
			}
			public void exitNeighbor(ConfigurationParser.NeighborContext ctx)
			{
				BgpNeighbor n=new BgpNeighbor();
				n.setAsNumber(this.remote_as);
				n.setDescription(this.neighbor_description);
				n.setPeerIp(neighbor_ip);
				neighbors.add(n);
			}
			public void exitKind(ConfigurationParser.KindContext ctx)
			{
				this.router_kind=ctx.STRING().getText();
			}
			public void exitAsnumber(ConfigurationParser.AsnumberContext ctx)
			{
				System.out.println("The AS number is:"+ctx.INT().getText());
				this.my_as=ctx.INT().getText();
			}
			public void exitRouter(ConfigurationParser.RouterContext ctx)
			{
				// Leaving the router configuration section, I require to read
				// what kind of router I am, and what is my AS number.
				System.out.println("My AS is: "+this.my_as);
				configuration.setMyAS(this.my_as);
				configuration.setMyRouterKind(router_kind);
			}
				}
		);
		parser.prog();
		configuration.setInterfaces(interfaces);
		configuration.setNeighbors(neighbors);
		return configuration;
	}
}
