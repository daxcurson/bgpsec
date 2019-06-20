package ar.strellis.com.bgp.messages;

public enum AFI 
{
	AFI_IP(0),
	AFI_IP6(1),
	AFI_MAX(2);
	
	private final int code;
	
	private AFI(int code)
	{
		this.code=code;
	}
	public int getCode()
	{
		return this.code;
	}
}
