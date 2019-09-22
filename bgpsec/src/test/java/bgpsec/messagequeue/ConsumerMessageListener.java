package bgpsec.messagequeue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import ar.strellis.com.zebra.messages.RouteAdded;

public class ConsumerMessageListener implements MessageListener {
	private String consumerName;
	public ConsumerMessageListener(String consumerName) 
	{
		this.consumerName = consumerName;
	}

	public void onMessage(Message message) 
	{
		try 
		{
			System.out.println("Consumer receives something");
			if(message instanceof TextMessage)
			{
				TextMessage textMessage = (TextMessage) message;
				System.out.println(consumerName + " received " + textMessage.getText());
			}
			if(message instanceof ObjectMessage)
			{
				ObjectMessage o=(ObjectMessage)message;
				RouteAdded a=(RouteAdded) o.getObject();
				System.out.println(consumerName+" received a route added message "+a.getMessage());
			}
		} 
		catch (JMSException e) 
		{          
			e.printStackTrace();
		}
	}
}
