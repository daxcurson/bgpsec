package bgpsec.messagequeue;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.strellis.com.bgp.messages.RouteAdded;

/**
 * Message queue test using Apache's ActiveMQ
 * @author Agustín Villafañe
 *
 */
public class TestActiveMQ 
{
	private static BrokerService broker;
	@BeforeClass
	public static void startBroker()
	{
		try 
		{
			broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"),true);
		} 
		catch (URISyntaxException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test
	public void synchronousMessageTest()
	{
		try
		{
		Connection connection=null;
		// Producer
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");
		connection = connectionFactory.createConnection();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("customerQueue");
		String payload = "Important Task";
		Message msg = session.createTextMessage(payload);
		MessageProducer producer = session.createProducer(queue);
		System.out.println("Sending text '" + payload + "'");
		producer.send(msg);

		// Consumer
		MessageConsumer consumer = session.createConsumer(queue);
		connection.start();
		TextMessage textMsg = (TextMessage) consumer.receive();
		System.out.println(textMsg);
		System.out.println("Received: " + textMsg.getText());
		session.close();
		}
		catch(JMSException e)
		{
			System.out.println("Exception during test synchronous message test: "+e);
		}
	}
	@Test
	public void asynchronousMessageTest()
	{
		Connection connection = null;
		try {
			// Producer
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					"tcp://localhost:61616");
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("customerQueue");
			String payload = "Important Task";
			Message msg = session.createTextMessage(payload);
			ObjectMessage msg2=session.createObjectMessage();
			RouteAdded a=new RouteAdded();
			a.setMessage("Route added");
			msg2.setObject(a);
			MessageProducer producer = session.createProducer(queue);
			System.out.println("Sending text '" + payload + "'");
			producer.send(msg);
			producer.send(msg2);

			// Consumer
			MessageConsumer consumer = session.createConsumer(queue);
			consumer.setMessageListener(new ConsumerMessageListener("Consumer"));
			connection.start();
			Thread.sleep(1000);
			session.close();
		} 
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
	@AfterClass
	public static void shutdownBroker()
	{
		try 
		{
			broker.stop();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
