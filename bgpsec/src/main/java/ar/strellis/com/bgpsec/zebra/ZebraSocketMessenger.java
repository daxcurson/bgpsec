package ar.strellis.com.bgpsec.zebra;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.Channels;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import ar.strellis.com.bgp.messages.RouteAdded;
import jnr.unixsocket.UnixSocketAddress;
import jnr.unixsocket.UnixSocketChannel;

public class ZebraSocketMessenger extends DefaultConsumer
{
	private String zebraSocket;
	private Channel channel;
	private DataOutputStream out;
	private DataInputStream in;

	public ZebraSocketMessenger(Channel channel) 
	{
		super(channel);
		this.channel=channel;
	}
	public ZebraSocketMessenger(Channel channel,String zebraSocket)
	{
		super(channel);
		this.zebraSocket=zebraSocket;
	}
	public void openZebraSocket() throws IOException
	{
		File zebraSocketFile=new File(zebraSocket);
		UnixSocketAddress address = new UnixSocketAddress(zebraSocketFile);
        UnixSocketChannel channel = UnixSocketChannel.open(address);
        System.out.println("connected to " + channel.getRemoteSocketAddress());
        out=new DataOutputStream(Channels.newOutputStream(channel));
        in=new DataInputStream(Channels.newInputStream(channel));
	}
	public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException
	{
		long deliveryTag = envelope.getDeliveryTag();
		// (process the message components here ...)
		
		String type=properties.getType();
		if(type.equals("RouteAdded"))
		{
			RouteAdded ra=(RouteAdded)SerializationUtils.deserialize(body);
			System.out.println("Message received asynchronously: "+ra.getMessage());
		}

		channel.basicAck(deliveryTag, false);
	}
}
