package ar.strellis.com.bgpsec.model;

import java.util.HashMap;
import java.util.Map;

public enum BgpAttributeTypeCode 
{
	ORIGIN(1),
	AS_PATH(2),
	NEXT_HOP(3),
	MULTI_EXIT_DISC(4),
	LOCAL_PREF(5),
	ATOMIC_AGGREGATE(6),
	AGGREGATOR(7);
	private final int type_code;
	private static Map<Integer,BgpAttributeTypeCode> map = new HashMap<>();
	BgpAttributeTypeCode(int type_code)
	{
		this.type_code=type_code;
	}
	public int code()
	{
		return this.type_code;
	}
	static {
		for (BgpAttributeTypeCode pageType : BgpAttributeTypeCode.values()) 
		{
			map.put(pageType.type_code, pageType);
		}
	}

	public static BgpAttributeTypeCode valueOf(int pageType) 
	{
		return (BgpAttributeTypeCode) map.get(pageType);
	}
}
