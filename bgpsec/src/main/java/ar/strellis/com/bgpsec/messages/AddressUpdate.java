package ar.strellis.com.bgpsec.messages;

public class AddressUpdate extends RoutingMessage
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4030757619009829126L;
	private int index;
	private Address address;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
