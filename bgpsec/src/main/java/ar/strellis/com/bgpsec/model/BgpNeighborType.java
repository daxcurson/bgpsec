package ar.strellis.com.bgpsec.model;

import java.util.HashMap;
import java.util.Map;

public enum BgpNeighborType 
{
	INTERNAL(1),
	EXTERNAL(2);
	private final int type_code;
	private static Map<Integer,BgpNeighborType> map = new HashMap<>();
	BgpNeighborType(int type_code)
	{
		this.type_code=type_code;
	}
	public int code()
	{
		return this.type_code;
	}
	static {
		for (BgpNeighborType pageType : BgpNeighborType.values()) 
		{
			map.put(pageType.type_code, pageType);
		}
	}

	public static BgpNeighborType valueOf(int pageType) 
	{
		return (BgpNeighborType) map.get(pageType);
	}
}
