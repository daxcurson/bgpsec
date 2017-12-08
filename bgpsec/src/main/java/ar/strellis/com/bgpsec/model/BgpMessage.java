package ar.strellis.com.bgpsec.model;

import java.nio.ByteBuffer;

/**
 * A BGP message. 
 *
 */
public abstract class BgpMessage 
{
	protected ByteBuffer marker;
	protected int length;
	protected int type;
	
	public BgpMessage()
	{
		marker=ByteBuffer.allocate(16);
		length=0;
	}
	public void setMarker(byte[] newmarker)
	{
		marker.put(newmarker);
	}
	public void setLength(int l)
	{
		length=l;
	}
	public int getLength()
	{
		return length;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
