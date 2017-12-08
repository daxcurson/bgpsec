package ar.strellis.com.bgpsec.model;

public class BgpNotification extends BgpMessage
{
	private int error_code;
	private int error_subcode;
	private String data;
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public int getError_subcode() {
		return error_subcode;
	}
	public void setError_subcode(int error_subcode) {
		this.error_subcode = error_subcode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
