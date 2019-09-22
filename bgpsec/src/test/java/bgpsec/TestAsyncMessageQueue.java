package bgpsec;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.BasicProperties;

import ar.strellis.com.zebra.messages.RouteAdded;

public class TestAsyncMessageQueue 
{
	private AsyncMessageConsumer consumer;
	@Test
	public void testAsyncMessage()
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); 
			Channel channel = connection.createChannel()) 
		{
			consumer=new AsyncMessageConsumer(channel);
				channel.queueDeclare("AsyncMQ", false, false, false, null);
				RouteAdded m=new RouteAdded();
				m.setMessage("HelloAsync");
				channel.basicConsume("AsyncMQ", false,"ConsumerTag",consumer);
				channel.basicPublish("", "AsyncMQ", new BasicProperties.Builder().type("RouteAdded").build(), SerializationUtils.serialize(m));
				System.out.println(" [x] Sent '" + m.getMessage() + "'");
				m.setMessage("AnotherHelloAsync");
				channel.basicPublish("", "AsyncMQ", new BasicProperties.Builder().type("RouteAdded").build(), SerializationUtils.serialize(m));
				System.out.println(" [y] Sent '"+m.getMessage()+"'");
				Thread.sleep(3L * 1000L);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
