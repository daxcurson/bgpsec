package ar.strellis.com.bgpsec.model;

/**
 * LOCAL_PREF is a well-known attribute taht is a four-octet unsigned integer. A BGP speaker
 * uses it to inform its other internal peers of the advertising speaker's degree of preference
 * for an advertised route.
 * @author Agustín Villafañe
 *
 */
public class BgpPathAttributeLocalPref extends BgpPathAttribute 
{

	@Override
	public void loadValue(byte[] value) 
	{
		this.loadLongValue(value);
	}
	public long getValue()
	{
		return this.value;
	}
}
