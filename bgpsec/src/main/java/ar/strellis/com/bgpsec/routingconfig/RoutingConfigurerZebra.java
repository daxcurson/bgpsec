package ar.strellis.com.bgpsec.routingconfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import ar.strellis.com.bgpsec.exceptions.BgpException;
import ar.strellis.com.bgpsec.model.BgpInterface;

public class RoutingConfigurerZebra extends RoutingConfigurer
{
	private Socket echoSocket;
	private final int PORT=2699;
	private PrintWriter out;
	private BufferedReader in;
	public void openSocketZebra()
	{
		try {
			echoSocket = new Socket("127.0.0.1", 2601);
			out =
					new PrintWriter(echoSocket.getOutputStream(), true);
			in =
					new BufferedReader(
							new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public BufferedReader getIn()
	{
		return this.in;
	}
}
