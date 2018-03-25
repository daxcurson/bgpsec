package ar.strellis.com.bgpsec.model;

/**
 * A BGP Path attribute.
 * @author Agustín Villafañe
 *
 */
public abstract class BgpPathAttribute 
{
	private BgpAttributeTypeCode attribute_type_code;
	private byte[] attribute_value;
	private int optional;
	private int transitive;
	private int partial;
	
	/**
	 * The subclass will have the responsiblility of loading the value it needs,
	 * due to the fact that the different options have different ways of saving its value.
	 * What they all have in common, is that they receive an array of bytes.
	 * @param value
	 */
	public abstract void loadValue(byte[] value);
	
	public BgpAttributeTypeCode getAttribute_type_code() {
		return attribute_type_code;
	}
	public void setAttribute_type_code(BgpAttributeTypeCode attribute_type_code) {
		this.attribute_type_code = attribute_type_code;
	}
	public byte[] getAttribute_value() {
		return attribute_value;
	}
	public void setAttribute_value(byte[] attribute_value) {
		this.attribute_value = attribute_value;
	}
	public int getOptional() {
		return optional;
	}
	public void setOptional(int optional) {
		this.optional = optional;
	}
	public int getTransitive() {
		return transitive;
	}
	public void setTransitive(int transitive) {
		this.transitive = transitive;
	}
	public int getPartial() {
		return partial;
	}
	public void setPartial(int partial) {
		this.partial = partial;
	}
}
