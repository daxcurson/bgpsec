package ar.strellis.com.bgp.messages;

public enum RouteSubType 
{
	RIB_SUB_OSPF_IA(0),
	RIB_SUB_OSPF_NSSA_1(1),
	RIB_SUB_OSPF_NSSA_2(2),
	RIB_SUB_OSPF_EXTERNAL_1(3),
	RIB_SUB_OSPF_EXTERNAL_2(4),
	RIB_SUB_BGP_IBGP(5),
	RIB_SUB_BGP_EBGP(6),
	RIB_SUB_BGP_CONFED(7),
	RIB_SUB_ISIS_L1(8),
	RIB_SUB_ISIS_L2(9),
	RIB_SUB_ISIS_IA(10);
	
	private final int code;
	private RouteSubType(int code)
	{
		this.code=code;
	}
	public int getCode()
	{
		return this.code;
	}
}
