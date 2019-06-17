package bgpsec;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import ar.strellis.com.bgp.messages.RouteAdded;

/**
 * Simple Message receiver, implements Runnable because it will be launched as a
 * thread from within the test for message queues.
 * 
 * @author Agustín Villafañe
 *
 */
public class MessageReceiver extends MessageQueueTestObject implements Runnable, Consumer
{
	private Connection connection;
	private Channel channel;
	public MessageReceiver() 
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();

			channel.queueDeclare(MESSAGE_QUEUE, false, false, false, null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	}

	@Override
	public void run() 
	{
		while (keepRunning()) 
		{
			// keep doing what this thread should do.
			System.out.println("Running");
			try 
			{
				channel.basicConsume(MESSAGE_QUEUE, true, this);
				Thread.sleep(3L * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void handleCancel(String consumerTag) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleCancelOk(String consumerTag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleConsumeOk(String consumerTag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
			throws IOException {
		String type=properties.getType();
		if(type.equals("RouteAdded"))
		{
			RouteAdded ra=(RouteAdded)SerializationUtils.deserialize(body);
			System.out.println("Message received: "+ra.getMessage());
		}
	}

	@Override
	public void handleRecoverOk(String consumerTag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
		// TODO Auto-generated method stub
		
	}
}
