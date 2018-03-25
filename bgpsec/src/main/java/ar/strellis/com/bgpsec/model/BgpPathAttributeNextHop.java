package ar.strellis.com.bgpsec.model;

public class BgpPathAttributeNextHop extends BgpPathAttribute {

	@Override
	public void loadValue(byte[] value) 
	{
		// I receive some kind of value!!!
		this.setAttribute_value(value);
	}
}
