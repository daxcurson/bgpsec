package ar.strellis.com.bgpsec.model;

import java.util.HashMap;
import java.util.Map;

public enum BgpPathSegmentType {
	AS_SET(1),
	AS_SEQUENCE(2);
	private final int segment_type;
	private static Map<Integer,BgpPathSegmentType> map = new HashMap<>();
	BgpPathSegmentType(int segment_type)
	{
		this.segment_type=segment_type;
	}
	public int type()
	{
		return this.segment_type;
	}
	static {
		for (BgpPathSegmentType type : BgpPathSegmentType.values()) 
		{
			map.put(type.segment_type, type);
		}
	}

	public static BgpPathSegmentType valueOf(int type) 
	{
		return (BgpPathSegmentType) map.get(type);
	}
}
