package ar.strellis.com.bgpsec.model;

public class BgpPathAttributeOrigin extends BgpPathAttribute 
{
	private BgpOriginType origin;
	@Override
	public void loadValue(byte[] value) 
	{
		// RFC 4271: the data octet can assume the following values:
		// 0 - IGP - Network layer reachability information is interior to the originating AS
		// 1 - BGP - Network layer reachability information learned via the EGP protocol, RFC 904
		// 2 - INCOMPLETE - Network Layer reachability information learned by some other means.
		// Only one data octet.
		setOrigin(BgpOriginType.valueOf(value[0]));
	}
	public BgpOriginType getOrigin() {
		return origin;
	}
	public void setOrigin(BgpOriginType origin) {
		this.origin = origin;
	}
}
