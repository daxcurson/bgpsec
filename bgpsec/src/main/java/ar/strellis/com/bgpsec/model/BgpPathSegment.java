package ar.strellis.com.bgpsec.model;

import java.util.LinkedList;
import java.util.List;

public class BgpPathSegment 
{
	private BgpPathSegmentType type;
	private int length;
	private List<Integer> as_numbers;
	
	public BgpPathSegment()
	{
		as_numbers=new LinkedList<Integer>();
	}
	
	public BgpPathSegmentType getType() {
		return type;
	}
	public void setType(BgpPathSegmentType type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public List<Integer> getAs_numbers() {
		return as_numbers;
	}
	public void setAs_numbers(List<Integer> as_numbers) {
		this.as_numbers = as_numbers;
	}
}
