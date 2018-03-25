package ar.strellis.com.bgpsec.model;

import java.util.LinkedList;
import java.util.List;

/**
 * The path attribute that represents the list of AS that there are between here and the announced route.
 * @author Agustín Villafañe
 *
 */
public class BgpPathAttributeAsPath extends BgpPathAttribute
{
	private List<BgpPathSegment> as_path_segment;

	public BgpPathAttributeAsPath()
	{
		as_path_segment=new LinkedList<BgpPathSegment>();
	}
	public List<BgpPathSegment> getAs_path_segment() 
	{
		return as_path_segment;
	}

	public void setAs_path_segment(List<BgpPathSegment> as_path_segment) 
	{
		this.as_path_segment = as_path_segment;
	}

	@Override
	public void loadValue(byte[] value) 
	{
		// Now I have to read the path attribute called AS_PATH from the array of bytes that I receive.
		int length=0;
		while(length<value.length)
		{
			// RFC 4271: the AS_PATH is a well-known mandatory attribute that is composed of a sequence
			// of AS path segments. Each path segment is represented by a triple
			// <path segment type, path segment length, path segment value>
			
			// The path segment type is a 1-octet length field with the following values defined:
			// AS_SET(1): unordered set of ASes a route in the UPDATE message has traversed
			// AS_SEQUENCE(2): ordered set of ASes a route in the UPDATE message has traversed.
			BgpPathSegment s=new BgpPathSegment();
			s.setType(BgpPathSegmentType.valueOf(value[length]));
			length++;
			// The path segment length is a 1-octet length field, containing the number of ASes (not the number
			// of octets) in the path segment value field.
			s.setLength(value[length]);
			length++;
			// The path segment value field contains one or more AS numbers, each encoded as a 2-octet length field.
			int as_quantity=s.getLength();
			while(as_quantity>0)
			{
				// The values MUST be unsigned!!!
				int as_value=(unsignedByte(value[length]) << 8)+unsignedByte(value[length+1]);
				length+=2;
				as_quantity--;
				s.getAs_numbers().add(as_value);
			}
			// I read the BGP Path segment, now I save it!!!
			this.as_path_segment.add(s);
		}
	}
	private int unsignedByte(byte val)
	{
		return val & 0xFF;
	}
}
