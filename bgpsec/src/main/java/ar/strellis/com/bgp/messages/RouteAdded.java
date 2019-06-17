package ar.strellis.com.bgp.messages;

public class RouteAdded extends KernelMessage
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
