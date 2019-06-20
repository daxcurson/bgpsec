package ar.strellis.com.bgp.messages;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RoutingMessageFactory 
{
	private static RoutingMessageFactory me;
	private MessageDecoder decoder;
	
	private RoutingMessageFactory()
	{
		decoder=new MessageDecoder();
	}
	public static RoutingMessageFactory getInstance()
	{
		if(me==null)
			me=new RoutingMessageFactory();
		return me;
	}
	
	public RoutingMessage getMessage(DataInputStream in) throws IOException
	{
		RoutingMessage result=null;
		// Zebra protocol: length(2 bytes), Marker (1 byte, always 255 if version 1), Version (1 byte, 1 or above)
		int length=in.readUnsignedShort();
		int count=length;
		count-=2;
		int marker=in.readUnsignedByte();
		count--;
		int version=0;
		if(marker==255) // We're dealing with Quagga's zebra daemon
		{
			version=in.readUnsignedByte();
			count--;
		}
		if(marker==254) // We're dealing with FRR's zebra daemon!!!
		{
			version=in.readUnsignedByte();
			count--;
		}
		if(version>=5)
		{
			System.out.println("Zebra protocol Version "+version);
			// Next comes the VRF ID - 4 bytes.
			int vrf_id=in.readInt();
			count-=4;
			// Now, the all-powerful Op
			int command=in.readUnsignedShort();
			count-=2;
			// I know the command now. Let's decode it.
			Op op=Op.values()[command];
			System.out.println("The command value is "+command);
			switch(op)
			{
			case ZEBRA_INTERFACE_ADD:
			case ZEBRA_INTERFACE_DELETE:
			case ZEBRA_INTERFACE_ADDRESS_ADD:
				System.out.println("InterfaceRequest, of type "+op.name());
				result=new InterfaceRequest();
				((InterfaceRequest)result).setOp(op);
				break;
			case ZEBRA_INTERFACE_ADDRESS_DELETE:
				System.out.println("AddressDelete, of type "+op.name());
				result=new AddressDelete();
				((AddressDelete)result).setOp(op);
				((AddressDelete)result).setVrf_id(vrf_id);
				((AddressDelete)result).setIndex(in.readInt()); count=-4;
				// Now comes the data specific to the address.
				Address a=new Address();
				a.setFlags(in.readUnsignedByte());count--;
				Prefix p=new Prefix();
				// According to the family the IP will be IPv4 or 6
				int addressFamily=in.readUnsignedByte(); count--;
				System.out.println("The address family is: "+addressFamily+", "+Address.Type.values()[addressFamily]);
				// With the address family, which can be AF_INET (IPv4), AF_INET6 (IPv6) or AF_ETHERNET (Ethernet)
				// I can deduce how long the prefix will be. 
				int prefix=0;
				if(addressFamily==Address.Type.AF_INET.getCode())
					prefix=4;
				if(addressFamily==Address.Type.AF_INET6.getCode())
					prefix=16;
				if(addressFamily==Address.Type.AF_ETHERNET.getCode())
					prefix=6;
				byte[] prefixToRead=new byte[prefix];
				in.read(prefixToRead,0,prefix); count-=prefix;
				// Prefix length, 1 byte
				int prefixLength=in.readUnsignedByte(); count--;
				System.out.println("The prefix for this address is "+prefixLength);
				p.setAddr(prefixToRead);
				p.setLength(prefixLength);
				a.setPrefix(p);
				// Destination address. Same lenght as the prefix that we have.
				byte[] addressToRead=new byte[prefix];
				in.read(addressToRead,0,prefix); count-=prefix;
				a.setAddress(addressToRead);
				a.setAddressFamily(addressFamily);
				StringBuilder b=new StringBuilder();
				StringBuilder c=new StringBuilder();
				for(int i=0;i<prefix;i++)
				{
					b.append(p.getAddr()[i]+".");
					c.append(a.getAddress()[i]+".");
				}
				System.out.println("Prefix: "+b.toString());
				System.out.println("Destination: "+c.toString());
				break;
			case ZEBRA_INTERFACE_UP:
				System.out.println("InterfaceRequest, of type "+op.name());
				result=new InterfaceRequest();
				((InterfaceRequest)result).setOp(op);
				break;
			case ZEBRA_INTERFACE_DOWN:
				System.out.println("InterfaceRequest, of type "+op.name());
				result=new InterfaceRequest();
				((InterfaceRequest)result).setOp(op);
				// vrf_id
				((InterfaceRequest)result).setVrf_id(vrf_id);
				// the interface name has a FIXED SIZE of 20
				byte[] interfaceNameBuffer=new byte[20];
				in.read(interfaceNameBuffer,0,20);
				String iff=new String(interfaceNameBuffer);
				System.out.println("String read: "+iff);
				((InterfaceRequest)result).setInterfaceName(iff);
				count-=20;
				/*
				 * Fields of the "interface" message:
				 * 
				 * null-terminated string - interface name
				 * integer 4 bytes - index
				 * char 1 byte - status
				 * long 8 bytes - flags
				 * char 1 byte - ptm_enable
				 * char 1 byte - ptm_status
				 * integer 4 bytes - metric
				 * integer 4 bytes - speed
				 * integer 4 bytes - mtu
				 * integer 4 bytes - mtu6
				 * integer 4 bytes - bandwidth
				 * integer 4 bytes - link_ifindex
				 * integer 4 bytes - ll_type
				 * integer 4 bytes - hadware address length
				 * set of bytes - hardware address
				 * char 1 byte - traffic engineering parameters present, 1 or 0
				 * variable parameters - if traffic engineering parameters==1
				 */
				((InterfaceRequest)result).setIndex(in.readInt()); count-=4;
				System.out.println("Index: "+((InterfaceRequest)result).getIndex());
				((InterfaceRequest)result).setStatus(in.readUnsignedByte()); count--;
				System.out.println("Status: "+((InterfaceRequest)result).getStatus());
				((InterfaceRequest)result).setFlags(in.readLong());count-=8;
				System.out.println("Flags: "+((InterfaceRequest)result).getFlags());
				((InterfaceRequest)result).setPtm_enable(in.readUnsignedByte()); count--;
				System.out.println("PTM Enable: "+((InterfaceRequest)result).getPtm_enable());
				((InterfaceRequest)result).setPtm_status(in.readUnsignedByte()); count--;
				System.out.println("PTM Status: "+((InterfaceRequest)result).getPtm_status());
				((InterfaceRequest)result).setMetric(in.readInt()); count-=4;
				System.out.println("Metric: "+((InterfaceRequest)result).getMetric());
				((InterfaceRequest)result).setSpeed(in.readInt()); count-=4;
				System.out.println("Speed: "+((InterfaceRequest)result).getSpeed());
				((InterfaceRequest)result).setMtu(in.readInt()); count-=4;
				System.out.println("MTU: "+((InterfaceRequest)result).getMtu());
				((InterfaceRequest)result).setMtu6(in.readInt()); count-=4;
				System.out.println("MTU6: "+((InterfaceRequest)result).getMtu6());
				((InterfaceRequest)result).setBandwidth(in.readInt()); count-=4;
				System.out.println("Bandwidth: "+((InterfaceRequest)result).getBandwidth());
				((InterfaceRequest)result).setLink_ifindex(in.readInt()); count-=4;
				System.out.println("Link: "+((InterfaceRequest)result).getLink_ifindex());
				((InterfaceRequest)result).setLl_type(in.readInt()); count-=4;
				System.out.println("Ll type: "+((InterfaceRequest)result).getLl_type());
				int hwaddr_length=in.readInt(); count-=4;
				System.out.println("Hw addr length: "+hwaddr_length+", count:"+count);
				((InterfaceRequest)result).setHwaddr_length(hwaddr_length);
				byte[] hwaddr=new byte[hwaddr_length];
				in.read(hwaddr, 0, hwaddr_length);count-=hwaddr_length;
				((InterfaceRequest)result).setTraffic_eng_params(in.readUnsignedByte()); count--;
				System.out.println("Traffic eng params: "+((InterfaceRequest)result).getTraffic_eng_params());
				break;
			case ZEBRA_INTERFACE_SET_MASTER:
			case ZEBRA_ROUTE_ADD:
			case ZEBRA_ROUTE_DELETE:
			case ZEBRA_ROUTE_NOTIFY_OWNER:
			case ZEBRA_REDISTRIBUTE_ADD:
			case ZEBRA_REDISTRIBUTE_DELETE:
			case ZEBRA_REDISTRIBUTE_DEFAULT_ADD:
			case ZEBRA_REDISTRIBUTE_DEFAULT_DELETE:
			case ZEBRA_ROUTER_ID_ADD:
			case ZEBRA_ROUTER_ID_DELETE:
			case ZEBRA_ROUTER_ID_UPDATE:
			case ZEBRA_HELLO:
			case ZEBRA_CAPABILITIES:
			case ZEBRA_NEXTHOP_REGISTER:
			case ZEBRA_NEXTHOP_UNREGISTER:
			case ZEBRA_NEXTHOP_UPDATE:
			case ZEBRA_INTERFACE_NBR_ADDRESS_ADD:
			case ZEBRA_INTERFACE_NBR_ADDRESS_DELETE:
			case ZEBRA_INTERFACE_BFD_DEST_UPDATE:
			case ZEBRA_IMPORT_ROUTE_REGISTER:
			case ZEBRA_IMPORT_ROUTE_UNREGISTER:
			case ZEBRA_IMPORT_CHECK_UPDATE:
			case ZEBRA_BFD_DEST_REGISTER:
			case ZEBRA_BFD_DEST_DEREGISTER:
			case ZEBRA_BFD_DEST_UPDATE:
			case ZEBRA_BFD_DEST_REPLAY:
			case ZEBRA_REDISTRIBUTE_ROUTE_ADD:
			case ZEBRA_REDISTRIBUTE_ROUTE_DEL:
			case ZEBRA_VRF_UNREGISTER:
			case ZEBRA_VRF_ADD:
			case ZEBRA_VRF_DELETE:
			case ZEBRA_VRF_LABEL:
			case ZEBRA_INTERFACE_VRF_UPDATE:
			case ZEBRA_BFD_CLIENT_REGISTER:
			case ZEBRA_BFD_CLIENT_DEREGISTER:
			case ZEBRA_INTERFACE_ENABLE_RADV:
			case ZEBRA_INTERFACE_DISABLE_RADV:
			case ZEBRA_IPV3_NEXTHOP_LOOKUP_MRIB:
			case ZEBRA_INTERFACE_LINK_PARAMS:
			case ZEBRA_MPLS_LABELS_ADD:
			case ZEBRA_MPLS_LABELS_DELETE:
			case ZEBRA_IPMR_ROUTE_STATS:
			case ZEBRA_LABEL_MANAGER_CONNECT:
			case ZEBRA_LABEL_MANAGER_CONNECT_ASYNC:
			case ZEBRA_GET_LABEL_CHUNK:
			case ZEBRA_RELEASE_LABEL_CHUNK:
			case ZEBRA_FEC_REGISTER:
			case ZEBRA_FEC_UNREGISTER:
			case ZEBRA_FEC_UPDATE:
			case ZEBRA_ADVERTISE_DEFAULT_GW:
			case ZEBRA_ADVERTISE_SUBNET:
			case ZEBRA_ADVERTISE_ALL_VNI:
			case ZEBRA_LOCAL_ES_ADD:
			case ZEBRA_LOCAL_ES_DEL:
			case ZEBRA_VNI_ADD:
			case ZEBRA_VNI_DEL:
			case ZEBRA_L3VNI_ADD:
			case ZEBRA_L3VNI_DEL:
			case ZEBRA_REMOTE_VTEP_ADD:
			case ZEBRA_REMOTE_VTEP_DEL:
			case ZEBRA_MACIP_ADD:
			case ZEBRA_MACIP_DEL:
			case ZEBRA_IP_PREFIX_ROUTE_ADD:
			case ZEBRA_IP_PREFIX_ROUTE_DEL:
			case ZEBRA_REMOTE_MACIP_ADD:
			case ZEBRA_REMOTE_MACIP_DEL:
			case ZEBRA_PW_ADD:
			case ZEBRA_PW_DELETE:
			case ZEBRA_PW_SET:
			case ZEBRA_PW_UNSET:
			case ZEBRA_PW_STATUS_UPDATE:
			case ZEBRA_RULE_ADD:
			case ZEBRA_RULE_DELETE:
			case ZEBRA_RULE_NOTIFY_OWNER:
			case ZEBRA_TABLE_MANAGER_CONNECT:
			case ZEBRA_GET_TABLE_CHUNK:
			case ZEBRA_RELEASE_TABLE_CHUNK:
			case ZEBRA_IPSET_CREATE:
			case ZEBRA_IPSET_DESTROY:
			case ZEBRA_IPSET_ENTRY_ADD:
			case ZEBRA_IPSET_ENTRY_DELETE:
			case ZEBRA_IPSET_NOTIFY_OWNER:
			case ZEBRA_IPSET_ENTRY_NOTIFY_OWNER:
			case ZEBRA_IPTABLE_ADD:
			case ZEBRA_IPTABLE_DELETE:
			case ZEBRA_IPTABLE_NOTIFY_OWNER:
			case ZEBRA_VXLAN_FLOOD_CONTROL:
			default:
				System.out.println("Unhandled op of type "+op.name());
				break;
			}
		}
		if(version==1)
		{
			System.out.println("Zebra protocol Version "+version);
			// Decoding messages of Zebra protocol version 1 or above.
			int command=in.readUnsignedShort();
			count-=2;
			// I know the command now. Let's decode it.
			Op op=Op.values()[command];
			System.out.println("The command value is "+command);
			switch(op)
			{
			case ZEBRA_INTERFACE_ADD:
			case ZEBRA_INTERFACE_DELETE:
			case ZEBRA_INTERFACE_ADDRESS_ADD:
			case ZEBRA_INTERFACE_ADDRESS_DELETE:
			case ZEBRA_INTERFACE_UP:
			case ZEBRA_INTERFACE_DOWN:
			case ZEBRA_INTERFACE_SET_MASTER:
			case ZEBRA_ROUTE_ADD:
			case ZEBRA_ROUTE_DELETE:
			case ZEBRA_ROUTE_NOTIFY_OWNER:
			case ZEBRA_REDISTRIBUTE_ADD:
			case ZEBRA_REDISTRIBUTE_DELETE:
			case ZEBRA_REDISTRIBUTE_DEFAULT_ADD:
			case ZEBRA_REDISTRIBUTE_DEFAULT_DELETE:
			case ZEBRA_ROUTER_ID_ADD:
			case ZEBRA_ROUTER_ID_DELETE:
			case ZEBRA_ROUTER_ID_UPDATE:
			case ZEBRA_HELLO:
			case ZEBRA_CAPABILITIES:
			case ZEBRA_NEXTHOP_REGISTER:
			case ZEBRA_NEXTHOP_UNREGISTER:
			case ZEBRA_NEXTHOP_UPDATE:
			case ZEBRA_INTERFACE_NBR_ADDRESS_ADD:
			case ZEBRA_INTERFACE_NBR_ADDRESS_DELETE:
			case ZEBRA_INTERFACE_BFD_DEST_UPDATE:
			case ZEBRA_IMPORT_ROUTE_REGISTER:
			case ZEBRA_IMPORT_ROUTE_UNREGISTER:
			case ZEBRA_IMPORT_CHECK_UPDATE:
			case ZEBRA_BFD_DEST_REGISTER:
			case ZEBRA_BFD_DEST_DEREGISTER:
			case ZEBRA_BFD_DEST_UPDATE:
			case ZEBRA_BFD_DEST_REPLAY:
			case ZEBRA_REDISTRIBUTE_ROUTE_ADD:
			case ZEBRA_REDISTRIBUTE_ROUTE_DEL:
			case ZEBRA_VRF_UNREGISTER:
			case ZEBRA_VRF_ADD:
			case ZEBRA_VRF_DELETE:
			case ZEBRA_VRF_LABEL:
			case ZEBRA_INTERFACE_VRF_UPDATE:
			case ZEBRA_BFD_CLIENT_REGISTER:
			case ZEBRA_BFD_CLIENT_DEREGISTER:
			case ZEBRA_INTERFACE_ENABLE_RADV:
			case ZEBRA_INTERFACE_DISABLE_RADV:
			case ZEBRA_IPV3_NEXTHOP_LOOKUP_MRIB:
			case ZEBRA_INTERFACE_LINK_PARAMS:
			case ZEBRA_MPLS_LABELS_ADD:
			case ZEBRA_MPLS_LABELS_DELETE:
			case ZEBRA_IPMR_ROUTE_STATS:
			case ZEBRA_LABEL_MANAGER_CONNECT:
			case ZEBRA_LABEL_MANAGER_CONNECT_ASYNC:
			case ZEBRA_GET_LABEL_CHUNK:
			case ZEBRA_RELEASE_LABEL_CHUNK:
			case ZEBRA_FEC_REGISTER:
			case ZEBRA_FEC_UNREGISTER:
			case ZEBRA_FEC_UPDATE:
			case ZEBRA_ADVERTISE_DEFAULT_GW:
			case ZEBRA_ADVERTISE_SUBNET:
			case ZEBRA_ADVERTISE_ALL_VNI:
			case ZEBRA_LOCAL_ES_ADD:
			case ZEBRA_LOCAL_ES_DEL:
			case ZEBRA_VNI_ADD:
			case ZEBRA_VNI_DEL:
			case ZEBRA_L3VNI_ADD:
			case ZEBRA_L3VNI_DEL:
			case ZEBRA_REMOTE_VTEP_ADD:
			case ZEBRA_REMOTE_VTEP_DEL:
			case ZEBRA_MACIP_ADD:
			case ZEBRA_MACIP_DEL:
			case ZEBRA_IP_PREFIX_ROUTE_ADD:
			case ZEBRA_IP_PREFIX_ROUTE_DEL:
			case ZEBRA_REMOTE_MACIP_ADD:
			case ZEBRA_REMOTE_MACIP_DEL:
			case ZEBRA_PW_ADD:
			case ZEBRA_PW_DELETE:
			case ZEBRA_PW_SET:
			case ZEBRA_PW_UNSET:
			case ZEBRA_PW_STATUS_UPDATE:
			case ZEBRA_RULE_ADD:
			case ZEBRA_RULE_DELETE:
			case ZEBRA_RULE_NOTIFY_OWNER:
			case ZEBRA_TABLE_MANAGER_CONNECT:
			case ZEBRA_GET_TABLE_CHUNK:
			case ZEBRA_RELEASE_TABLE_CHUNK:
			case ZEBRA_IPSET_CREATE:
			case ZEBRA_IPSET_DESTROY:
			case ZEBRA_IPSET_ENTRY_ADD:
			case ZEBRA_IPSET_ENTRY_DELETE:
			case ZEBRA_IPSET_NOTIFY_OWNER:
			case ZEBRA_IPSET_ENTRY_NOTIFY_OWNER:
			case ZEBRA_IPTABLE_ADD:
			case ZEBRA_IPTABLE_DELETE:
			case ZEBRA_IPTABLE_NOTIFY_OWNER:
			case ZEBRA_VXLAN_FLOOD_CONTROL:
			default:
				System.out.println("Unhandled op of type "+op.name());
				break;
			}
		}
		if(version==0)
		{
			// We're decoding version 0 messages!!!!!
			System.out.println("Zebra protocol Version "+version);
			// Decoding messages of Zebra protocol version 0.
			int command=in.readByte();
			count--;
			// I know the command now. Let's decode it.
			Op op=Op.values()[command];
			System.out.println("The command value is "+command);
			switch(op)
			{
			case ZEBRA_INTERFACE_ADD:
			case ZEBRA_INTERFACE_DELETE:
			case ZEBRA_INTERFACE_ADDRESS_ADD:
			case ZEBRA_INTERFACE_ADDRESS_DELETE:
			case ZEBRA_INTERFACE_UP:
			case ZEBRA_INTERFACE_DOWN:
			case ZEBRA_INTERFACE_SET_MASTER:
			case ZEBRA_ROUTE_ADD:
			case ZEBRA_ROUTE_DELETE:
			case ZEBRA_ROUTE_NOTIFY_OWNER:
			case ZEBRA_REDISTRIBUTE_ADD:
			case ZEBRA_REDISTRIBUTE_DELETE:
			case ZEBRA_REDISTRIBUTE_DEFAULT_ADD:
			case ZEBRA_REDISTRIBUTE_DEFAULT_DELETE:
			case ZEBRA_ROUTER_ID_ADD:
			case ZEBRA_ROUTER_ID_DELETE:
			case ZEBRA_ROUTER_ID_UPDATE:
			case ZEBRA_HELLO:
			case ZEBRA_CAPABILITIES:
			case ZEBRA_NEXTHOP_REGISTER:
			case ZEBRA_NEXTHOP_UNREGISTER:
			case ZEBRA_NEXTHOP_UPDATE:
			case ZEBRA_INTERFACE_NBR_ADDRESS_ADD:
			case ZEBRA_INTERFACE_NBR_ADDRESS_DELETE:
			case ZEBRA_INTERFACE_BFD_DEST_UPDATE:
			case ZEBRA_IMPORT_ROUTE_REGISTER:
			case ZEBRA_IMPORT_ROUTE_UNREGISTER:
			case ZEBRA_IMPORT_CHECK_UPDATE:
			case ZEBRA_BFD_DEST_REGISTER:
			case ZEBRA_BFD_DEST_DEREGISTER:
			case ZEBRA_BFD_DEST_UPDATE:
			case ZEBRA_BFD_DEST_REPLAY:
			case ZEBRA_REDISTRIBUTE_ROUTE_ADD:
			case ZEBRA_REDISTRIBUTE_ROUTE_DEL:
			case ZEBRA_VRF_UNREGISTER:
			case ZEBRA_VRF_ADD:
			case ZEBRA_VRF_DELETE:
			case ZEBRA_VRF_LABEL:
			case ZEBRA_INTERFACE_VRF_UPDATE:
			case ZEBRA_BFD_CLIENT_REGISTER:
			case ZEBRA_BFD_CLIENT_DEREGISTER:
			case ZEBRA_INTERFACE_ENABLE_RADV:
			case ZEBRA_INTERFACE_DISABLE_RADV:
			case ZEBRA_IPV3_NEXTHOP_LOOKUP_MRIB:
			case ZEBRA_INTERFACE_LINK_PARAMS:
			case ZEBRA_MPLS_LABELS_ADD:
			case ZEBRA_MPLS_LABELS_DELETE:
			case ZEBRA_IPMR_ROUTE_STATS:
			case ZEBRA_LABEL_MANAGER_CONNECT:
			case ZEBRA_LABEL_MANAGER_CONNECT_ASYNC:
			case ZEBRA_GET_LABEL_CHUNK:
			case ZEBRA_RELEASE_LABEL_CHUNK:
			case ZEBRA_FEC_REGISTER:
			case ZEBRA_FEC_UNREGISTER:
			case ZEBRA_FEC_UPDATE:
			case ZEBRA_ADVERTISE_DEFAULT_GW:
			case ZEBRA_ADVERTISE_SUBNET:
			case ZEBRA_ADVERTISE_ALL_VNI:
			case ZEBRA_LOCAL_ES_ADD:
			case ZEBRA_LOCAL_ES_DEL:
			case ZEBRA_VNI_ADD:
			case ZEBRA_VNI_DEL:
			case ZEBRA_L3VNI_ADD:
			case ZEBRA_L3VNI_DEL:
			case ZEBRA_REMOTE_VTEP_ADD:
			case ZEBRA_REMOTE_VTEP_DEL:
			case ZEBRA_MACIP_ADD:
			case ZEBRA_MACIP_DEL:
			case ZEBRA_IP_PREFIX_ROUTE_ADD:
			case ZEBRA_IP_PREFIX_ROUTE_DEL:
			case ZEBRA_REMOTE_MACIP_ADD:
			case ZEBRA_REMOTE_MACIP_DEL:
			case ZEBRA_PW_ADD:
			case ZEBRA_PW_DELETE:
			case ZEBRA_PW_SET:
			case ZEBRA_PW_UNSET:
			case ZEBRA_PW_STATUS_UPDATE:
			case ZEBRA_RULE_ADD:
			case ZEBRA_RULE_DELETE:
			case ZEBRA_RULE_NOTIFY_OWNER:
			case ZEBRA_TABLE_MANAGER_CONNECT:
			case ZEBRA_GET_TABLE_CHUNK:
			case ZEBRA_RELEASE_TABLE_CHUNK:
			case ZEBRA_IPSET_CREATE:
			case ZEBRA_IPSET_DESTROY:
			case ZEBRA_IPSET_ENTRY_ADD:
			case ZEBRA_IPSET_ENTRY_DELETE:
			case ZEBRA_IPSET_NOTIFY_OWNER:
			case ZEBRA_IPSET_ENTRY_NOTIFY_OWNER:
			case ZEBRA_IPTABLE_ADD:
			case ZEBRA_IPTABLE_DELETE:
			case ZEBRA_IPTABLE_NOTIFY_OWNER:
			case ZEBRA_VXLAN_FLOOD_CONTROL:
			default:
				System.out.println("Unhandled op of type "+op.name());
				break;
			}
		}
		System.out.println("The message was "+length+" bytes long. Still "+count+" bytes unread remain");
		in.skip(count);
		return result;
	}
}
