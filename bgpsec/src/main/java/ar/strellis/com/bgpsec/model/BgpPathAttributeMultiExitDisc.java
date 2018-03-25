package ar.strellis.com.bgpsec.model;

/**
 * This is an optional non-transitive attribute that is a four-octet unsigned integer. The value of this attribute
 * MAY be used by a BGP speaker's decision process to discriminate among multiple entry points to a neighboring
 * autonomous system.
 * @author Agustín Villafañe
 *
 */
public class BgpPathAttributeMultiExitDisc extends BgpPathAttribute 
{
	@Override
	public void loadValue(byte[] value) 
	{
		loadLongValue(value);
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}

}
