package ar.strellis.com.bgpsec.model;

public class BgpKeepAlive extends BgpMessage
{
	public BgpKeepAlive()
	{
		super();
		this.setType(4);
	}
}
