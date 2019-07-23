package ar.strellis.com.bgpsec.routingconfig;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
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
	private DataOutputStream out;
	private DataInputStream in;
	public void openSocketZebra() throws IOException
	{
		RouterConfigurationReader routerConfiguration=RouterConfigurationReader.getInstance();
		routerConfiguration.setConfigurationFilename(configurationFilename);
		File zebraSocketFile=new File(routerConfiguration.loadConfiguration().getZebraSocket());
		UnixSocketAddress address = new UnixSocketAddress(zebraSocketFile);
        UnixSocketChannel channel = UnixSocketChannel.open(address);
        System.out.println("connected to " + channel.getRemoteSocketAddress());
        out = new DataOutputStream(Channels.newOutputStream(channel));
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
	public DataOutputStream getOut()
	{
		return this.out;
	}
}
