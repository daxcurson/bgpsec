package ar.strellis.com.bgpsec.codec;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import ar.strellis.com.bgpsec.model.BgpPathAttributeTypeCode;
import ar.strellis.com.bgpsec.model.BgpCapability;
import ar.strellis.com.bgpsec.model.BgpKeepAlive;
import ar.strellis.com.bgpsec.model.BgpMessage;
import ar.strellis.com.bgpsec.model.BgpNeighbor;
import ar.strellis.com.bgpsec.model.BgpNotification;
import ar.strellis.com.bgpsec.model.BgpOpen;
import ar.strellis.com.bgpsec.model.BgpPathAttribute;
import ar.strellis.com.bgpsec.model.BgpPathAttributeFactory;
import ar.strellis.com.bgpsec.model.BgpUpdate;
import ar.strellis.com.bgpsec.model.Route;

public class BgpDecoder extends CumulativeProtocolDecoder
{
	/**
	 * Decodes the BGP OPEN message
	 * @param session
	 * @param in
	 * @param length
	 * @return
	 */
	private BgpOpen decodeOpen(IoSession session,IoBuffer in, int length)
	{
		// OPEN
		BgpOpen message=new BgpOpen();
		message.setLength(length);
		// Version: 1 octet.
		message.setVersion(in.getUnsigned());
		// My AS: 2 octet unsigned
		message.setSender_AS(in.getUnsignedShort());
		// Proposed hold time: 2 octet unsigned
		message.setHold_time(in.getUnsignedShort());
		// BGP identifier: 4 octet unsigned
		message.setBgp_identifier(in.getUnsignedInt());
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
			message.setOptional_parameters(parameters);
		}
		return message;
	}
	private BgpUpdate decodeUpdate(IoSession session,IoBuffer in, int length)
	{
		// UPDATE
		BgpUpdate message=new BgpUpdate();
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
			// I must do this if route_prefix_length >0!!!
			if(route_prefix_length>0)
			{
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
		}
		((BgpUpdate)message).setWithdrawn_routes(withdrawn_routes);
		// Done with the list of withdrawn routes.
		// Now comes the list of new or updated routes.
		// First, total path attribute length, 2 octets.
		int path_attribute_length=in.getUnsignedShort();
		count=path_attribute_length;
		// Now, identify the path attributes.
		// I need these attributes in a Map so they are easier to look up later.
		Map<String,BgpPathAttribute> path_attributes=new HashMap<String,BgpPathAttribute>();
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
			int optional=(attr_flags & 128) == 128 ? 1:0;
			// The second high-order bit is the transitive bit. It defines whether
			// an optional attribute is transitive (if set to 1) or non-transitive
			// (if set to 0). For well-known attributes, the transitive bit must be 1.
			int transitive=(attr_flags & 64) == 64 ? 1:0;
			// The third high-order bit is the partial bit. It defines whether the
			// information contained in the optional transitive attribute is partial
			// (if set to 1) or complete (if set to 0). For well-known attributes
			// and for optional non-transitive attributes, the Partial bit must be 0.
			int partial=(attr_flags & 32) == 32 ? 1:0;
			// The fourth high-order bit is the extended length bit. It defines
			// whether the Attribute Length is one octet (if set to 0) or two octets
			// (if set to 1). The lower-order four bits of the Attribute flags octet
			// are unused. They must be zero when sent and must be ignored when received.
			int extended_length=(attr_flags & 16) == 16 ? 1:0;
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
			// I use a factory method to create the type of attribute, then the loadValue method of each
			// attribute type takes responsibility of reading the contents and form an actual value from the
			// bytes read from the stream.
			if(path_attribute_value_length>0)
			{
				// I read the value of the attribute directly into an array of bytes
				// so that it can be consumed by the BgpPathAttribute.
				byte[] value=new byte[path_attribute_value_length];
				in.get(value);
				// Now I decrease the count by the number of bytes read.
				count-=path_attribute_value_length;
				BgpPathAttribute p=BgpPathAttributeFactory.returnPathAttribute(BgpPathAttributeTypeCode.valueOf(attr_type_code));
				p.setAttribute_type_code(BgpPathAttributeTypeCode.valueOf(attr_type_code));
				p.loadValue(value);
				p.setOptional(optional);
				p.setTransitive(transitive);
				p.setPartial(partial);
				path_attributes.put(BgpPathAttributeTypeCode.valueOf(attr_type_code).toString(), p);
			}
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
					route_length_count-=8;
					// If after decreasing the route_length_count, something remains, 
					// read it; otherwise, skip, because if the route_length_count reaches 0
					// and we read this byte, we'll actually lose it because the count
					// below will reach -1 and terminate the loop, and there will be a read
					// of a byte that is never processed, disrupting the flow of the following
					// messages in the byte stream.
					if(route_length_count>0)
					{
						byte_route=in.getUnsigned();
						count--;
					}
				}
			}
			Route r=new Route();
			r.setNetwork_address(route);
			r.setPrefix(route_prefix_length);
			reachability_routes.add(r);
		}
		((BgpUpdate)message).setReachability_information(reachability_routes);
		return message;
	}
	private BgpKeepAlive decodeKeepalive(IoSession session, IoBuffer in,int length)
	{
		// KEEPALIVE
		BgpKeepAlive message=new BgpKeepAlive();
		// No data is expected after the marker, length and type.
		message.setLength(length);
		return message;
	}
	private BgpNotification decodeNotification(IoSession session, IoBuffer in,int length)
	{
		// NOTIFICATION
		BgpNotification message=new BgpNotification();
		message.setLength(length);
		// Error code: 1 octet unsigned
		// Error subcode: 1 octet unsigned
		// Data: length-21 octets.
		((BgpNotification)message).setError_code(in.getUnsigned());
		((BgpNotification)message).setError_subcode(in.getUnsigned());
		byte[] data=new byte[length-21];
		in.get(data);
		((BgpNotification)message).setData(new String(data));
		return message;
	}
	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception 
	{
		// First of all I have to configure who sent it to me. I made sure that when the session
		// is created, the neighbor is set. 
		BgpNeighbor neighbor=(BgpNeighbor) session.getAttribute("neighbor");
		// There may be more than one message in this buffer. Use a while to read them,
		// as long as the message is longer than the minimum size.
		// Section 4. The smallest message that may be sent consists of a BGP header
		// without a data portion.
		if(in.remaining()>=19)
		{
			while(in.remaining()>=19)
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
					message=this.decodeOpen(session, in, length);
					break;
				case 2:
					message=this.decodeUpdate(session, in, length);
					break;
				case 3:
					message=this.decodeNotification(session, in, length);
					break;
				case 4:
					message=this.decodeKeepalive(session, in, length);
					break;
				}
				// Place the decoded message in the output
				message.setNeighbor(neighbor);
				out.write(message);
			}
			return true;
		}
		else
			return false;
	}
}
