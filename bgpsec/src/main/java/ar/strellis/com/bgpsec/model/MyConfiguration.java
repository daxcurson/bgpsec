package ar.strellis.com.bgpsec.model;

import java.util.List;

/**
 * Stores the configuration values read from a properties file.
 * @author Agust�n Villafa�e
 *
 */
public class MyConfiguration 
{
	private List<BgpInterface> interfaces;
	private List<BgpNeighbor> neighbors;
	private String myAS;
	private int myHoldTime;
	private int myKeepAliveTimer;
	
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
	public List<BgpNeighbor> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(List<BgpNeighbor> neighbors) {
		this.neighbors = neighbors;
	}
}
