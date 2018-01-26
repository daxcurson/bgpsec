package ar.strellis.com.bgpsec.codec;

import java.util.LinkedList;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import ar.strellis.com.bgpsec.model.BgpAttributeTypeCode;
import ar.strellis.com.bgpsec.model.BgpCapability;
import ar.strellis.com.bgpsec.model.BgpKeepAlive;
import ar.strellis.com.bgpsec.model.BgpMessage;
import ar.strellis.com.bgpsec.model.BgpNotification;
import ar.strellis.com.bgpsec.model.BgpOpen;
import ar.strellis.com.bgpsec.model.BgpPathAttribute;
import ar.strellis.com.bgpsec.model.BgpUpdate;
import ar.strellis.com.bgpsec.model.Route;

public class BgpDecoder extends CumulativeProtocolDecoder
{

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception 
	{
		// Section 4. The smallest message that may be sent consists of a BGP header
		// without a data portion.
		if(in.remaining()>=19)
		{
			BgpMessage message=null;
			// RFC 4271 section 4.2. Open message format.
			// All messages start with a 16-octet Marker which is all 1s, followed
			// by a message length (unsigned int, 2 octets) and a message type (unsigned int, 1 octet)
			byte[] marker=new byte[16];
			in.get(marker);
			int length=in.getUnsignedShort();
			int message_type=in.getUnsigned();
			switch(message_type)
			{
			case 1:
				// OPEN
				message=new BgpOpen();
				message.setLength(length);
				// Version: 1 octet.
				((BgpOpen)message).setVersion(in.getUnsigned());
				// My AS: 2 octet unsigned
				((BgpOpen)message).setSender_AS(in.getUnsignedShort());
				// Proposed hold time: 2 octet unsigned
				((BgpOpen)message).setHold_time(in.getUnsignedShort());
				// BGP identifier: 4 octet unsigned
				((BgpOpen)message).setBgp_identifier(in.getUnsignedInt());
				// BGP optional parameters: 1 octet unsigned
				int optional_parameters_length=in.getUnsigned();
				if(optional_parameters_length>0)
				{
					List<BgpCapability> parameters=new LinkedList<BgpCapability>();
					// Now I consume the parameters, one by one, until I run out of optional_parameters_length.
					while(optional_parameters_length>0)
					{
						int type=in.getUnsigned();
						optional_parameters_length--;
						int capability_length=in.getUnsigned();
						optional_parameters_length--;
						byte[] capability_value=new byte[capability_length];
						in.get(capability_value);
						optional_parameters_length-=capability_length;
						
						BgpCapability b=new BgpCapability();
						b.setCapability_code(type);
						b.setCapability_length(capability_length);
						b.setCapability_value(new String(capability_value));
						parameters.add(b);
					}
					((BgpOpen)message).setOptional_parameters(parameters);
				}
				break;
			case 2:
				// UPDATE
				message=new BgpUpdate();
				message.setLength(length);
				// Withdrawn routes length - 2 octets
				int withdrawn_routes_length=in.getUnsignedShort();
				// Read the withdrawn routes
				int count=withdrawn_routes_length;
				List<Route> withdrawn_routes=new LinkedList<Route>();
				while(count>0)
				{
					// Prefix length. The length is in BITS of the network prefix.
					// Could be 0-32.
					int route_prefix_length=in.getUnsigned();
					count--;
					// Prefix
					// According to RFC 4271, "the prefix field contains an IP address prefix,
					// followed by the minimum number of trailing bits needed to make the end
					// of the field fall on an octet boundary. Note that the value of trailing bits
					// is irrelevant".
					// So this is a number of bytes, where 32 bits of route_length means 4 bytes.
					int route=0;
					int byte_route=in.getUnsigned();
					count--;
					int route_length_count=route_prefix_length;
					while(route_length_count>0)
					{
						if(route_length_count<8)
						{
							// No more bytes in the route.
							route=(route << route_length_count)+byte_route;
							route_length_count=0;
						}
						else
						{
							// Add the byte to the route and read one byte from the message
							route=(route << 8)+byte_route;
							byte_route=in.getUnsigned();
							count--;
							route_length_count=-8;
						}
					}
					Route r=new Route();
					r.setNetwork_address(route);
					r.setPrefix(route_prefix_length);
					withdrawn_routes.add(r);
				}
				((BgpUpdate)message).setWithdrawn_routes(withdrawn_routes);
				// Done with the list of withdrawn routes.
				// Now comes the list of new or updated routes.
				// First, total path attribute length, 2 octets.
				int path_attribute_length=in.getUnsignedShort();
				count=path_attribute_length;
				// Now, identify the path attributes.
				List<BgpPathAttribute> path_attributes=new LinkedList<BgpPathAttribute>();
				while(count>0)
				{
					// Path attributes: attr. flag + attr. type code.
					int attr_flags=in.getUnsigned();
					count--;
					int attr_type_code=in.getUnsigned();
					count--;
					// Now let's interpret the meaning of these values.
					// The high-order bit of the attribute flags octet is the optional bit.
					// It defines whether the attribute is optional (if set to 1) or well-known
					// (if set to 0).
					int optional=attr_flags & 128;
					// The second high-order bit is the transitive bit. It defines whether
					// an optional attribute is transitive (if set to 1) or non-transitive
					// (if set to 0). For well-known attributes, the transitive bit must be 1.
					int transitive=attr_flags & 64;
					// The third high-order bit is the partial bit. It defines whether the
					// information contained in the optional transitive attribute is partial
					// (if set to 1) or complete (if set to 0). For well-known attributes
					// and for optional non-transitive attributes, the Partial bit must be 0.
					int partial=attr_flags & 32;
					// The fourth high-order bit is the extended length bit. It defines
					// whether the Attribute Length is one octet (if set to 0) or two octets
					// (if set to 1). The lower-order four bits of the Attribute flags octet
					// are unused. They must be zero when sent and must be ignored when received.
					int extended_length=attr_flags & 16;
					// The attribute type code octet contains the attribute type code.
					// If the extended length bit of the attribute flags octet is set to 0,
					// the third octet of the path attribute contains the length of the
					// attribute data in octets.
					// If the extended length bit of the attribute flags octet is set to 1,
					// the third and fourth octets of the path attribute contain the length of the
					// attribute data in octets.
					// The remaining octets of the path attribute represent the attribute
					// value and are interpreted according to the attribute flags
					// and the attribute type code.
					
					// ------ And now, finally, read the path attribute value. First,
					// interpret the next bytes as length of the value, according to the
					// extended_length field.
					int path_attribute_value_length=0;
					if(extended_length==0) // just one octet
					{
						path_attribute_value_length=in.getUnsigned();
						count--;
					}
					else // two bytes
					{
						path_attribute_value_length=in.getUnsignedShort();
						count-=2;
					}
					// Now comes the attribute value.
					long attribute_value=0;
					// Read a byte now, reduce the number of path_attribute_length
					// and shift left whatever I read, if there is more.
					if(path_attribute_value_length>0)
					{
						attribute_value=in.getUnsigned();
						count--;
						path_attribute_value_length--;
						while(path_attribute_value_length>0)
						{
							int byte_read=in.getUnsigned();
							count--;
							attribute_value=(attribute_value << 8)+byte_read;
							path_attribute_value_length--;
						}
					}
					BgpPathAttribute p=new BgpPathAttribute();
					p.setAttribute_type_code(BgpAttributeTypeCode.valueOf(attr_type_code));
					p.setAttribute_value(attribute_value);
					path_attributes.add(p);
				}
				((BgpUpdate)message).setPath_attributes(path_attributes);
				// Finally, now comes the Network Layer Reachability Information,
				// consisting of IP prefixes, that share these attributes.
				
				// The length of this field is not explicitly defined, it must be inferred
				// with the length of the previous fields.
				int network_reachability_length=length-23-path_attribute_length-withdrawn_routes_length;
				count=network_reachability_length;
				List<Route> reachability_routes=new LinkedList<Route>();
				while(count>0)
				{
					// Prefix length. The length is in BITS of the network prefix.
					// Could be 0-32.
					int route_prefix_length=in.getUnsigned();
					count--;
					// Prefix
					// According to RFC 4271, "the prefix field contains an IP address prefix,
					// followed by the minimum number of trailing bits needed to make the end
					// of the field fall on an octet boundary. Note that the value of trailing bits
					// is irrelevant".
					// So this is a number of bytes, where 32 bits of route_length means 4 bytes.
					int route=0;
					int byte_route=in.getUnsigned();
					count--;
					int route_length_count=route_prefix_length;
					while(route_length_count>0)
					{
						if(route_length_count<8)
						{
							// No more bytes in the route.
							route=(route << route_length_count)+byte_route;
							route_length_count=0;
						}
						else
						{
							// Add the byte to the route and read one byte from the message
							route=(route << 8)+byte_route;
							byte_route=in.getUnsigned();
							count--;
							route_length_count-=8;
						}
					}
					Route r=new Route();
					r.setNetwork_address(route);
					r.setPrefix(route_prefix_length);
					reachability_routes.add(r);
				}
				((BgpUpdate)message).setReachability_information(reachability_routes);
				break;
			case 3:
				// NOTIFICATION
				message=new BgpNotification();
				message.setMarker(marker);
				message.setLength(length);
				// Error code: 1 octet unsigned
				// Error subcode: 1 octet unsigned
				// Data: length-21 octets.
				((BgpNotification)message).setError_code(in.getUnsigned());
				((BgpNotification)message).setError_subcode(in.getUnsigned());
				byte[] data=new byte[length-21];
				in.get(data);
				((BgpNotification)message).setData(new String(data));
				break;
			case 4:
				// KEEPALIVE
				message=new BgpKeepAlive();
				// No data is expected after the marker, length and type.
				message.setMarker(marker);
				message.setLength(length);
				break;
			}
			// Place the decoded message in the output
			out.write(message);
			return true;
		}
		else
			return false;
	}
}
