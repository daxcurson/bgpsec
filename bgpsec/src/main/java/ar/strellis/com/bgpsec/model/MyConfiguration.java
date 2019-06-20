package ar.strellis.com.bgpsec.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Stores the configuration values read from a properties file.
 * @author Agust�n Villafa�e
 *
 */
public class MyConfiguration 
{
	private List<BgpInterface> interfaces;
	private Map<String,BgpNeighbor> neighbors;
	private String myRouterKind;
	private String myAS;
	private int myHoldTime;
	private int myKeepAliveTimer;
	private String zebraSocket;
	
	public String getMyAS() {
		return myAS;
	}
	public void setMyAS(String myAS) {
		this.myAS = myAS;
	}
	public int getMyHoldTime() {
		return myHoldTime;
	}
	public void setMyHoldTime(int myHoldTime) {
		this.myHoldTime = myHoldTime;
	}
	public int getMyKeepAliveTimer() {
		return myKeepAliveTimer;
	}
	public void setMyKeepAliveTimer(int myKeepAliveTimer) {
		this.myKeepAliveTimer = myKeepAliveTimer;
	}
	public List<BgpInterface> getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(List<BgpInterface> interfaces) {
		this.interfaces = interfaces;
	}
	public Map<String,BgpNeighbor> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(Map<String,BgpNeighbor> neighbors) {
		this.neighbors = neighbors;
	}
	/**
	 * Retrieves the interface that belongs to the same net as the BGP peer that I'm addressing.
	 * @return
	 */
	public BgpInterface getInterfaceForPeerAddress(long bgpIdentifier)
	{
		// The BGP Identifier is a representation of the peer's IP.
		// I'll return the interface whose inMyNetwork value is true, 
		// meaning, that the interface itself will tell me if the IP of the peer 
		// is in its network.
		boolean found=false;
		BgpInterface result=null;
		Iterator<BgpInterface> listInterfaces=this.interfaces.iterator();
		while(!found && listInterfaces.hasNext())
		{
			BgpInterface e=listInterfaces.next();
			if(e.inMyNetwork(bgpIdentifier))
			{
				found=true;
				result=e;
			}
		}
		return result;
	}
	public String getMyRouterKind() {
		return myRouterKind;
	}
	public void setMyRouterKind(String myRouterKind) {
		this.myRouterKind = myRouterKind;
	}
	public String getZebraSocket() {
		return zebraSocket;
	}
	public void setZebraSocket(String zebraSocket) {
		this.zebraSocket = zebraSocket;
	}
}
