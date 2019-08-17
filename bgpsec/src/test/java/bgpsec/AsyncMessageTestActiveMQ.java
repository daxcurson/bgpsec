package bgpsec;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Message queue test using Apache's ActiveMQ
 * @author Agustín Villafañe
 *
 */
public class AsyncMessageTestActiveMQ 
{
	BrokerService broker;
	@BeforeClass
	public void startBroker()
	{
		try 
		{
			broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
			broker.start();
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
	@AfterClass
	public void shutdownBroker()
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
