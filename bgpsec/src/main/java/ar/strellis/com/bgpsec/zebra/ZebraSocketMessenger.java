package ar.strellis.com.bgpsec.zebra;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.Channels;

import org.apache.commons.lang.SerializationUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

import ar.strellis.com.bgpsec.messages.AddressAdd;
import ar.strellis.com.bgpsec.messages.AddressDelete;
import ar.strellis.com.bgpsec.messages.InterfaceDown;
import ar.strellis.com.bgpsec.messages.InterfaceUp;
import ar.strellis.com.bgpsec.messages.RoutingMessage;
import ar.strellis.com.zebra.messages.RouteAdded;
import jnr.unixsocket.UnixSocketAddress;
import jnr.unixsocket.UnixSocketChannel;

public class ZebraSocketMessenger extends DefaultConsumer implements Runnable
{
	private static Logger log=LogManager.getLogger(ZebraSocketMessenger.class); 

	private String zebraSocket;
	private Channel channelToZebra;
	private Channel channelToBgpsec;
	private DataOutputStream out;
	private DataInputStream in;
	private boolean running;

	public ZebraSocketMessenger(Channel channelToZebra,Channel channelToBgpsec,String zebraSocket) 
	{
		super(channelToZebra);
		this.channelToZebra=channelToZebra;
		this.channelToBgpsec=channelToBgpsec;
		this.zebraSocket=zebraSocket;
		running=false;
	}
	public ZebraSocketMessenger(Channel channelToZebra,String zebraSocket)
	{
		super(channelToZebra);
		this.zebraSocket=zebraSocket;
	}
	public void openZebraSocket() throws IOException
	{
		log.info("Opening socket to the Zebra daemon located at: "+zebraSocket);
		File zebraSocketFile=new File(zebraSocket);
		UnixSocketAddress address = new UnixSocketAddress(zebraSocketFile);
        UnixSocketChannel channel = UnixSocketChannel.open(address);
        log.info("connected to " + channel.getRemoteSocketAddress());
        out=new DataOutputStream(Channels.newOutputStream(channel));
        in=new DataInputStream(Channels.newInputStream(channel));
	}
	public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException
	{
		long deliveryTag = envelope.getDeliveryTag();
		// (process the message components here ...)
		RoutingMessage message=null;
		String type=properties.getType();
		if(type.equals("RouteAdded"))
		{
			message=(RouteAdded)SerializationUtils.deserialize(body);
			log.info("Received a RouteAdded message: "+message.getMessage());
		}
		channelToZebra.basicAck(deliveryTag, false);
		// Now we should inform Zebra that there is a message coming.
	}
	@Override
	public void run() 
	{
		running=true;
		DataInputStream r=in;
		ZebraSocketMessageDecoder factory=ZebraSocketMessageDecoder.getInstance();
		while(running)
		{
			try {
				RoutingMessage message=factory.getMessage(r);
				String messageType="";
				if(message!=null)
					System.out.println("The op of this message is "+message.getOp().name());
				if(message instanceof InterfaceUp)
				{
					System.out.println("Interface up");
					messageType="InterfaceUp";
				}
				if(message instanceof InterfaceDown)
				{
					System.out.println("Interface down");
					messageType="InterfaceDown";
				}
				if(message instanceof AddressAdd)
				{
					System.out.println("Address Add");
					messageType="AddressAdd";
				}
				if(message instanceof AddressDelete)
				{
					System.out.println("Address Delete");
					messageType="AddressDelete";
				}
				// Here we inform the rest of the server of the kind of message we received from Zebra
				channelToBgpsec.basicPublish("", "BgpsecQueue", new BasicProperties.Builder().type(messageType).build(), SerializationUtils.serialize(message));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void stop()
	{
		running=false;
	}
}
