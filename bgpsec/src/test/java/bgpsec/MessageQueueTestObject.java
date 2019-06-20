package bgpsec;

public class MessageQueueTestObject 
{
	protected final static String MESSAGE_QUEUE = "message_queue";
	private boolean doStop = false;

	protected synchronized void doStop() 
	{
		this.doStop = true;
	}

	protected synchronized boolean keepRunning() 
	{
		return this.doStop == false;
	}
}
