package ar.strellis.com.zebra.messages;

public enum RouteType 
{
	RIB_UNKNOWN(0),
	RIB_KERNEL(1),
	RIB_CONNECTED(2),
	RIB_STATIC(3),
	RIB_RIP(4),
	RIB_OSPF(5),
	RIB_ISIS(6),
	RIB_BGP(7);
	
	private final int code;
	private RouteType(int code)
	{
		this.code=code;
	}
	public int getCode()
	{
		return this.code;
	}
}
