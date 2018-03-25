package ar.strellis.com.bgpsec.model;

import java.util.HashMap;
import java.util.Map;

public enum BgpOriginType 
{
	IGP(0),
	EGP(1),
	INCOMPLETE(2);
	private final int type_code;
	private static Map<Integer,BgpOriginType> map = new HashMap<>();
	BgpOriginType(int type_code)
	{
		this.type_code=type_code;
	}
	public int code()
	{
		return this.type_code;
	}
	static {
		for (BgpOriginType pageType : BgpOriginType.values()) 
		{
			map.put(pageType.type_code, pageType);
		}
	}

	public static BgpOriginType valueOf(int pageType) 
	{
		return (BgpOriginType) map.get(pageType);
	}
}
