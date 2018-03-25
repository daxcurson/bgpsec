package ar.strellis.com.bgpsec.model;

/**
 * A BGP message. 
 *
 */
public abstract class BgpMessage 
{
	protected byte[] marker;
	protected int length;
	protected int type;
	
	public BgpMessage()
	{
		marker=new byte[16];
		length=0;
		// Initialize the marker
		for(int i=0;i<16;i++)
			marker[i]=(byte) 0xff;
	}
	public byte[] getMarker()
	{
		return marker;
	}
	public void setMarker(byte[] newmarker)
	{
		if(marker!=null)
			for(int i=0;i<16;i++)
				marker[i]=newmarker[i];
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
