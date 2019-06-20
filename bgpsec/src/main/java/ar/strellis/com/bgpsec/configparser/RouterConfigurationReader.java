package ar.strellis.com.bgpsec.configparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ar.strellis.com.bgpsec.model.BgpInterface;
import ar.strellis.com.bgpsec.model.BgpNeighbor;
import ar.strellis.com.bgpsec.model.BgpNeighborType;
import ar.strellis.com.bgpsec.model.MyConfiguration;

/**
 * Uses ANTLR to parse the configuration file and read it into an object. It's a singleton.
 * @author Agustín Villafañe
 *
 */
public class RouterConfigurationReader
{
	private static RouterConfigurationReader me;
	private MyConfiguration configuration;
	private String configurationFilename;
	
	public static RouterConfigurationReader getInstance()
	{
		if(me==null)
			me=new RouterConfigurationReader();
		return me;
	}
	private RouterConfigurationReader()
	{
		this.configuration=new MyConfiguration();
	}
	public MyConfiguration getConfiguration()
	{
		return configuration;
	}
	public MyConfiguration loadConfiguration(String configurationFilename) throws FileNotFoundException,IOException
	{
		this.configurationFilename=configurationFilename;
		// I'll create the parser that I'll use to consume the configuration.
		File f=new File(this.configurationFilename);
		InputStream inputStream=new FileInputStream(f);
		CharStream stream=CharStreams.fromStream(inputStream);
		ConfigurationLexer lexer=new ConfigurationLexer(stream);
		CommonTokenStream tokens=new CommonTokenStream(lexer);
		ConfigurationParser parser=new ConfigurationParser(tokens);
		// I get the interfaces present with a list.
		List<BgpInterface> interfaces=new LinkedList<BgpInterface>();
		// For the BGP peers, I need a map, because I need to retrieve them using the configured IP.
		Map<String,BgpNeighbor> neighbors=new HashMap<String,BgpNeighbor>();
		parser.addParseListener(new ConfigurationBaseListener()
				{
			private String ip;
			private String netmask;
			private String neighbor_description;
			private String neighbor_ip;
			private int remote_as;
			private String router_kind;
			private String my_as;
			private BgpNeighborType neighbor_type;
			private String zebra_socket;
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
			public void exitNeighbor_description_string(ConfigurationParser.Neighbor_description_stringContext ctx)
			{
				neighbor_description=ctx.STRING().getText();
			}
			public void exitNeighbor_ip(ConfigurationParser.Neighbor_ipContext ctx)
			{
				neighbor_ip=ctx.IPV4().getText();
			}
			public void exitNeighbor_type(ConfigurationParser.Neighbor_typeContext ctx)
			{
				if(ctx.INTERNAL()!=null)
					neighbor_type=BgpNeighborType.INTERNAL;
				if(ctx.EXTERNAL()!=null)
					neighbor_type=BgpNeighborType.EXTERNAL;
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
				// If the neighbor type is null or empty, I have to assume that it is external.
				if(neighbor_type!=null)
					n.setType(neighbor_type);
				else
					n.setType(BgpNeighborType.EXTERNAL);
				neighbors.put(neighbor_ip, n);
			}
			public void exitOption_router_kind(ConfigurationParser.Option_router_kindContext ctx)
			{
				this.router_kind=ctx.STRING().getText();
			}
			public void exitOption_router_asnumber(ConfigurationParser.Option_router_asnumberContext ctx)
			{
				this.my_as=ctx.INT().getText();
			}
			public void exitStatement_router(ConfigurationParser.Statement_routerContext ctx)
			{
				configuration.setMyAS(this.my_as);
				configuration.setMyRouterKind(this.router_kind);
			}
			public void exitZebra_socket_desc(ConfigurationParser.Zebra_socket_descContext ctx)
			{
				this.zebra_socket=ctx.FILEPATH().getText();
			}
			public void exitStatement_options(ConfigurationParser.Statement_optionsContext ctx)
			{
				configuration.setZebraSocket(this.zebra_socket);
			}
				}
		);
		parser.prog();
		configuration.setInterfaces(interfaces);
		configuration.setNeighbors(neighbors);
		return configuration;
	}
}
