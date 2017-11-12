package ar.strellis.com.bgpsec.model;

/**
 * A BGP Session. Uses the session attributes specifed in the RFC 4271
 * @author daxcurson
 *
 */
public class BgpSession 
{
	private String state;
	private int connect_retry_counter;
	private int connect_retry_timer;
	private int connect_retry_time;
	private int hold_timer;
	private int keepalive_timer;
	private int keepalive_time;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getConnect_retry_counter() {
		return connect_retry_counter;
	}
	public void setConnect_retry_counter(int connect_retry_counter) {
		this.connect_retry_counter = connect_retry_counter;
	}
	public int getConnect_retry_timer() {
		return connect_retry_timer;
	}
	public void setConnect_retry_timer(int connect_retry_timer) {
		this.connect_retry_timer = connect_retry_timer;
	}
	public int getConnect_retry_time() {
		return connect_retry_time;
	}
	public void setConnect_retry_time(int connect_retry_time) {
		this.connect_retry_time = connect_retry_time;
	}
	public int getHold_timer() {
		return hold_timer;
	}
	public void setHold_timer(int hold_timer) {
		this.hold_timer = hold_timer;
	}
	public int getKeepalive_timer() {
		return keepalive_timer;
	}
	public void setKeepalive_timer(int keepalive_timer) {
		this.keepalive_timer = keepalive_timer;
	}
	public int getKeepalive_time() {
		return keepalive_time;
	}
	public void setKeepalive_time(int keepalive_time) {
		this.keepalive_time = keepalive_time;
	}
}
