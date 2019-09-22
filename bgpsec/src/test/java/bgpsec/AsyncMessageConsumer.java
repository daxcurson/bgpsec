package bgpsec;

import java.io.IOException;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import ar.strellis.com.zebra.messages.RouteAdded;

public class AsyncMessageConsumer extends DefaultConsumer
{
	private Channel channel;
	public AsyncMessageConsumer(Channel channel) 
	{
		super(channel);
		this.channel=channel;
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
