package ar.strellis.com.bgpsec.zebra;

import java.io.DataOutputStream;
import java.io.IOException;
import ar.strellis.com.bgpsec.messages.Op;

import ar.strellis.com.bgpsec.messages.RoutingMessage;

/**
 * Encodes a message to send to the Zebra socket
 * @author Agustín Villafañe
 *
 */
public class ZebraSocketMessageEncoder 
{
	private final int VERSION=6;
	private final int MARKER=254;
	private final int ZEBRA_HEADER_SIZE=10;
	private static ZebraSocketMessageEncoder me;
	public static ZebraSocketMessageEncoder getInstance()
	{
		if(me==null)
			me=new ZebraSocketMessageEncoder();
		return me;
	}
	
	public ZebraSocketMessageEncoder()
	{
	}
	
	public void sendMessage(DataOutputStream out,RoutingMessage message) throws IOException
	{
		/*
		 * Message header
		 * Header size - 2 bytes
		 * Marker - 1 byte
		 * Version - 1 byte
		 * VRF ID - 4 bytes
		 * Command - 2 bytes
		 */
		out.writeShort(ZEBRA_HEADER_SIZE);
		out.writeByte(MARKER);
		out.writeByte(VERSION);
		out.writeInt(message.getVrf_id());
		out.writeShort(message.getOp().getCode());
		/*
		 * Now for the message types.
		 */
		switch(message.getOp())
		{
		case ZEBRA_ROUTE_ADD:
			break;
		default:
			break;
		}
	}
}
