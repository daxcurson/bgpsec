package ar.strellis.com.bgp.messages;

public class Address 
{
	public enum Type
	{
		AF_INET(2),
		AF_INET6(10),
		AF_ETHERNET(17),
		AF_PACKET(17);
		
		private final int code;
		private Type(int code)
		{
			this.code=code;
		}
		public int getCode()
		{
			return this.code;
		}
	}
	private Prefix prefix;
	private byte[] address;
	private int addressFamily;
	private int flags;
	public Prefix getPrefix() {
		return prefix;
	}
	public void setPrefix(Prefix addr) {
		this.prefix = addr;
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public byte[] getAddress() {
		return address;
	}
	public void setAddress(byte[] address) {
		this.address = address;
	}
	public int getAddressFamily() {
		return addressFamily;
	}
	public void setAddressFamily(int addressFamily) {
		this.addressFamily = addressFamily;
	}
}
