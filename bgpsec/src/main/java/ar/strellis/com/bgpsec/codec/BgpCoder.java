package ar.strellis.com.bgpsec.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import ar.strellis.com.bgpsec.model.BgpKeepAlive;
import ar.strellis.com.bgpsec.model.BgpMessage;
import ar.strellis.com.bgpsec.model.BgpOpen;

public class BgpCoder implements ProtocolEncoder
{

	@Override
	public void dispose(IoSession session) throws Exception 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encode(IoSession ioSession, Object message, ProtocolEncoderOutput output) throws Exception 
	{
		IoBuffer buffer=IoBuffer.allocate(2048);
		buffer.put(((BgpMessage)message).getMarker());
		// Now comes the size of the buffer, and then the message type.
		// The problem is that the size of the message is not known until I encode
		// the message completely. 
		// To solve this, I'll allocate a second buffer and write to it, then obtain the written
		// length and add 19 (marker 16, size 2, type 1)
		int type=0;
		IoBuffer outputBuffer=IoBuffer.allocate(2048);
		if(message instanceof BgpKeepAlive)
		{
			// The keepalive message consists only of the marker, length and type.
			type=4;
			// That's why I don't write anything to the output buffer
		}
		if(message instanceof BgpOpen)
		{
			type=1;
			// BGP Open.
			// Version
			outputBuffer.putUnsigned(((BgpOpen)message).getVersion());
			// My AS
			outputBuffer.putUnsignedShort(((BgpOpen) message).getSender_AS());
			// Hold time.
			outputBuffer.putUnsignedShort(((BgpOpen) message).getHold_time());
			// BGP Identifier.
			outputBuffer.putUnsignedInt(((BgpOpen) message).getBgp_identifier());
			// Optional parameters. None for now.
			outputBuffer.putUnsigned(0);
		}
		buffer.putUnsignedShort(outputBuffer.position()+19); // that's the amount of bytes written in the output buffer plus the default header of 19
		// Type
		buffer.putUnsigned(type);
		outputBuffer.flip();
		buffer.put(outputBuffer);
		buffer.flip();
		output.write(buffer);
	}
}
