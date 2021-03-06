package ar.strellis.com.bgpsec.routingconfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import ar.strellis.com.bgpsec.exceptions.BgpException;
import ar.strellis.com.bgpsec.model.BgpInterface;

public class RoutingConfigurerIproute2 extends RoutingConfigurer
{
	@Override
	public void add_network(String iface, String network, String cidr, String gateway) throws BgpException 
	{
		add_network_via_iproute2(iface,network,cidr,gateway);
	}
	private void add_network_via_iproute2(String iface, String network, String cidr,String gateway) throws BgpException
	{
		// To add a route , I invoke the command:
		String command="/usr/sbin/ip route add "+network+"/"+cidr+" via "+gateway+" dev "+iface;
		List<String> output=this.execute(command);
		// Now I process the output. If it gives an error, I should fire an exception.
		if(!output.isEmpty())
			throw new BgpException("Error adding routes");
	}
	
	private List<String> execute(String command)
	{
		List<String> output = new LinkedList<String>();

		Process p;
		try {
			System.out.println("Executing command: "+command);
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine())!= null) {
				System.out.println("Output: "+line);
				output.add(line);
			}

		} 
		catch (Exception e) 
		{
			System.out.println("Exception while executing command");
			e.printStackTrace();
		}
		return output;
	}
	/**
	 * Parses the output of ip link show to obtain the list of interfaces in the system.
	 * @return
	 */
	public List<BgpInterface> list_interfaces()
	{
		System.out.println("Getting ip link information");
		String command="/usr/sbin/ip link|grep ^[0-9]";
		List<String> output=this.execute(command);
		// Now, separate the string members.
		// The output format is:
		List<BgpInterface> l=new LinkedList<BgpInterface>();
		// 2: enp0s3: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc pfifo_fast state UP mode DEFAULT qlen 1000
		for(String iff:output)
		{
			System.out.println("Interface: "+iff);
			BgpInterface i=new BgpInterface();
			StringTokenizer t=new StringTokenizer(iff);
			i.setIndex(Integer.parseInt(t.nextToken(":").trim()));
			i.setName(t.nextToken(":").trim());
			l.add(i);
		}
		return l;
	}
}
