package bgpsec;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.BasicProperties;

import ar.strellis.com.zebra.messages.RouteAdded;

public class TestMessageQueue 
{
	private MessageSender sender;
	private MessageReceiver receiver;
	private Thread receiverThread;
	
	@Before
	public void startThreads()
	{
		receiver=new MessageReceiver();
		receiverThread=new Thread(receiver);
		receiverThread.start();
	}

	@Test
	public void testMessageSending() 
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(MessageReceiver.MESSAGE_QUEUE, false, false, false, null);
			RouteAdded m=new RouteAdded();
			m.setMessage("Hello");
			channel.basicPublish("", MessageReceiver.MESSAGE_QUEUE, new BasicProperties.Builder().type("RouteAdded").build(), SerializationUtils.serialize(m));
			System.out.println(" [x] Sent '" + m.getMessage() + "'");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	@After
	public void stopThreads()
	{
		receiver.doStop();
		try 
		{
			receiverThread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
