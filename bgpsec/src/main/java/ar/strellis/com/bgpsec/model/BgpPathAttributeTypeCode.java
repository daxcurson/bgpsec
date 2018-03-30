package ar.strellis.com.bgpsec.model;

import java.util.HashMap;
import java.util.Map;

public enum BgpPathAttributeTypeCode 
{
	ORIGIN(1),
	AS_PATH(2),
	NEXT_HOP(3),
	MULTI_EXIT_DISC(4),
	LOCAL_PREF(5),
	ATOMIC_AGGREGATE(6),
	AGGREGATOR(7);
	private final int type_code;
	private static Map<Integer,BgpPathAttributeTypeCode> map = new HashMap<>();
	BgpPathAttributeTypeCode(int type_code)
	{
		this.type_code=type_code;
	}
	public int code()
	{
		return this.type_code;
	}
	static {
		for (BgpPathAttributeTypeCode pageType : BgpPathAttributeTypeCode.values()) 
		{
			map.put(pageType.type_code, pageType);
		}
	}

	public static BgpPathAttributeTypeCode valueOf(int pageType) 
	{
		return (BgpPathAttributeTypeCode) map.get(pageType);
	}
}
