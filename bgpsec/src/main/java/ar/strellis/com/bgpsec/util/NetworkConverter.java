package ar.strellis.com.bgpsec.util;

public class NetworkConverter 
{
	public static long convertStringIPtoLong(String ip)
	{
		long ipAsLong=0;
		String[] ipAddressInArray = ip.split("\\.");
		// Now I cycle the bytes in the array, accumulating the byte and shifting to the left.
		for(int i=0;i<4;i++)
		{
			ipAsLong=ipAsLong << 8;
			ipAsLong+=Long.parseLong(ipAddressInArray[i]);
		}
		return ipAsLong;
	}
}
