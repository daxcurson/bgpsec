package ar.strellis.com.bgpsec.testzebra;

import java.io.DataInputStream;
import java.io.IOException;

import ar.strellis.com.bgpsec.messages.AddressAdd;
import ar.strellis.com.bgpsec.messages.AddressDelete;
import ar.strellis.com.bgpsec.messages.InterfaceDown;
import ar.strellis.com.bgpsec.messages.InterfaceUp;
import ar.strellis.com.bgpsec.messages.RoutingMessage;
import ar.strellis.com.bgpsec.messages.RoutingMessageFactory;
import ar.strellis.com.bgpsec.routingconfig.RoutingConfigurerZebra;

public class TestZebra 
{
	private RoutingConfigurerZebra z;
	
	public static void main(String[] args)
	{
		TestZebra t=new TestZebra();
		t.run();
	}
	public void run()
	{
		z=new RoutingConfigurerZebra();
		try {
			z.openSocketZebra();
			Thread t=new Thread()
				{
					public void run()
					{
						DataInputStream r=z.getIn();
						RoutingMessageFactory factory=RoutingMessageFactory.getInstance();
						for(;;)
						{
							try {
								RoutingMessage message=factory.getMessage(r);
								if(message!=null)
									System.out.println("The op of this message is "+message.getOp().name());
								if(message instanceof InterfaceUp)
									System.out.println("Interface up");
								if(message instanceof InterfaceDown)
									System.out.println("Interface down");
								if(message instanceof AddressAdd)
									System.out.println("Address Add");
								if(message instanceof AddressDelete)
									System.out.println("Address Delete");
								//int b=r.readUnsignedByte();
								//System.out.println("Read: "+b);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				};
		t.start();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
