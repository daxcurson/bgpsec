package ar.strellis.com.bgpsec.routingconfig;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.util.List;

import ar.strellis.com.bgpsec.configparser.RouterConfigurationReader;
import ar.strellis.com.bgpsec.exceptions.BgpException;
import ar.strellis.com.bgpsec.model.BgpInterface;
import jnr.unixsocket.UnixSocketAddress;
import jnr.unixsocket.UnixSocketChannel;

public class RoutingConfigurerZebra extends RoutingConfigurer
{
	private String configurationFilename="/etc/bgpsec/bgpsec.conf";
	private OutputStreamWriter out;
	private DataInputStream in;
	public void openSocketZebra() throws IOException
	{
		RouterConfigurationReader routerConfiguration=RouterConfigurationReader.getInstance();
		
		File zebraSocketFile=new File(routerConfiguration.loadConfiguration(configurationFilename).getZebraSocket());
		UnixSocketAddress address = new UnixSocketAddress(zebraSocketFile);
        UnixSocketChannel channel = UnixSocketChannel.open(address);
        System.out.println("connected to " + channel.getRemoteSocketAddress());
        out = new OutputStreamWriter(Channels.newOutputStream(channel));
        in=new DataInputStream(Channels.newInputStream(channel));
	}
	@Override
	public void add_network(String iface, String network, String cidr, String gateway) throws BgpException 
	{
	}

	@Override
	public List<BgpInterface> list_interfaces() 
	{
		return null;
	}
	public DataInputStream getIn()
	{
		return this.in;
	}
}
