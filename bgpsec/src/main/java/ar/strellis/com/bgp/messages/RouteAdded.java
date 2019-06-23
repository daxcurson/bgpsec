package ar.strellis.com.bgp.messages;

import ar.strellis.com.bgpsec.messages.RoutingMessage;

public class RouteAdded extends RoutingMessage
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7403517602967784850L;
	private String message;
	
	public RouteAdded()
	{
		setMessage("");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
