package ar.strellis.com.bgpsec.codec;

import java.util.LinkedList;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import ar.strellis.com.bgpsec.model.BgpCapability;
import ar.strellis.com.bgpsec.model.BgpKeepAlive;
import ar.strellis.com.bgpsec.model.BgpMessage;
import ar.strellis.com.bgpsec.model.BgpNotification;
import ar.strellis.com.bgpsec.model.BgpOpen;
import ar.strellis.com.bgpsec.model.BgpUpdate;

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
