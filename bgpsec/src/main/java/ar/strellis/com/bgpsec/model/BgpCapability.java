package ar.strellis.com.bgpsec.model;

public class BgpCapability 
{
	private int capability_code;
	private int capability_length;
	private String capability_value;
	public int getCapability_code() {
		return capability_code;
	}
	public void setCapability_code(int capability_code) {
		this.capability_code = capability_code;
	}
	public int getCapability_length() {
		return capability_length;
	}
	public void setCapability_length(int capability_length) {
		this.capability_length = capability_length;
	}
	public String getCapability_value() {
		return capability_value;
	}
	public void setCapability_value(String capability_value) {
		this.capability_value = capability_value;
	}
}
