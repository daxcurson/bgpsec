package ar.strellis.com.bgp.messages;

public class Prefix 
{
	private byte[] addr;
	private int length;
	public byte[] getAddr() {
		return addr;
	}
	public void setAddr(byte[] addr) {
		this.addr = addr;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
