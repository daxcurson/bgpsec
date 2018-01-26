package ar.strellis.com.bgpsec.model;

public class BgpPathAttribute 
{
	private BgpAttributeTypeCode attribute_type_code;
	private long attribute_value;
	public BgpAttributeTypeCode getAttribute_type_code() {
		return attribute_type_code;
	}
	public void setAttribute_type_code(BgpAttributeTypeCode attribute_type_code) {
		this.attribute_type_code = attribute_type_code;
	}
	public long getAttribute_value() {
		return attribute_value;
	}
	public void setAttribute_value(long attribute_value) {
		this.attribute_value = attribute_value;
	}
}
