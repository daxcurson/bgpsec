package ar.strellis.com.bgpsec.messages;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class RoutingMessageFactory 
{
	private static RoutingMessageFactory me;
	
	private RoutingMessageFactory()
	{
	}
	public static RoutingMessageFactory getInstance()
	{
		if(me==null)
			me=new RoutingMessageFactory();
		return me;
	}
	private InterfaceUpdate getInterfaceUpdateMessage(DataInputStream in,InterfaceUpdate interfaceUpdate) throws IOException
	{				// the interface name has a FIXED SIZE of 20
		byte[] interfaceNameBuffer=new byte[20];
		in.read(interfaceNameBuffer,0,20);
		String iff=new String(interfaceNameBuffer);
		interfaceUpdate.setInterfaceName(iff);
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
		interfaceUpdate.setIndex(in.readInt());
		interfaceUpdate.setStatus(in.readUnsignedByte());
		interfaceUpdate.setFlags(in.readLong());
		interfaceUpdate.setPtm_enable(in.readUnsignedByte());
		interfaceUpdate.setPtm_status(in.readUnsignedByte());
		interfaceUpdate.setMetric(in.readInt());
		interfaceUpdate.setSpeed(in.readInt());
		interfaceUpdate.setMtu(in.readInt());
		interfaceUpdate.setMtu6(in.readInt());
		interfaceUpdate.setBandwidth(in.readInt());
		interfaceUpdate.setLink_ifindex(in.readInt());
		interfaceUpdate.setLl_type(in.readInt());
		int hwaddr_length=in.readInt();
		interfaceUpdate.setHwaddr_length(hwaddr_length);
		byte[] hwaddr=new byte[hwaddr_length];
		in.read(hwaddr, 0, hwaddr_length);
		interfaceUpdate.setTraffic_eng_params(in.readUnsignedByte());
		return interfaceUpdate;
	}
	private AddressUpdate getAddressUpdateMessage(DataInputStream in,AddressUpdate address) throws IOException
	{
		// Now comes the data specific to the address.
		Address a=new Address();
		a.setFlags(in.readUnsignedByte());
		// According to the family the IP will be IPv4 or 6
		int addressFamily=in.readUnsignedByte(); 
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
		in.read(prefixToRead,0,prefix);
		// Prefix length, 1 byte
		int prefixLength=in.readUnsignedByte();
		a.setPrefix(prefixToRead);
		a.setPrefixLength(prefixLength);
		// Destination address. Same lenght as the prefix that we have.
		byte[] addressToRead=new byte[prefix];
		in.read(addressToRead,0,prefix);
		a.setAddress(addressToRead);
		a.setAddressFamily(addressFamily);
		StringBuilder b=new StringBuilder();
		StringBuilder c=new StringBuilder();
		for(int i=0;i<prefix;i++)
		{
			b.append(a.getPrefix()[i]+".");
			c.append(a.getAddress()[i]+".");
		}
		System.out.println("Prefix: "+b.toString());
		System.out.println("Destination: "+c.toString());
		address.setAddress(a);
		return address;
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
			// Next comes the VRF ID - 4 bytes.
			int vrf_id=in.readInt();
			count-=4;
			// Now, the all-powerful Op
			int command=in.readUnsignedShort();
			count-=2;
			// I know the command now. Let's decode it.
			Op op=Op.values()[command];
			switch(op)
			{
			case ZEBRA_INTERFACE_ADD:
			case ZEBRA_INTERFACE_DELETE:
			case ZEBRA_INTERFACE_ADDRESS_ADD:
				result=new AddressAdd();
				result.setOp(op);
				result.setVrf_id(vrf_id);
				((AddressAdd)result).setIndex(in.readInt());
				result=this.getAddressUpdateMessage(in,((AddressAdd)result));
				break;
			case ZEBRA_INTERFACE_ADDRESS_DELETE:
				result=new AddressDelete();
				result.setOp(op);
				result.setVrf_id(vrf_id);
				((AddressDelete)result).setIndex(in.readInt());
				result=this.getAddressUpdateMessage(in,((AddressDelete)result));
				break;
			case ZEBRA_INTERFACE_UP:
				result=new InterfaceUp();
				result.setOp(op);
				result.setVrf_id(vrf_id);
				result=this.getInterfaceUpdateMessage(in, (InterfaceUp)result);
				break;
			case ZEBRA_INTERFACE_DOWN:
				result=new InterfaceDown();
				result.setOp(op);
				// vrf_id
				result.setVrf_id(vrf_id);
				result=this.getInterfaceUpdateMessage(in, (InterfaceDown)result);
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
				System.out.println("The message was "+length+" bytes long. Still "+count+" bytes unread remain");
				in.skip(count);
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
				System.out.println("The message was "+length+" bytes long. Still "+count+" bytes unread remain");
				in.skip(count);
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
		return result;
	}
	public void sendMessage(DataOutputStream out,RoutingMessage message)
	{
		// Send a message to the output stream.
		message.encode(out);
	}
}
