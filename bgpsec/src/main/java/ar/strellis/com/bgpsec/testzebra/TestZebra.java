package ar.strellis.com.bgpsec.testzebra;

import java.io.BufferedReader;
import java.io.IOException;

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
		z.openSocketZebra();
		Thread t=new Thread()
				{
			public void run()
			{
				BufferedReader r=z.getIn();
				for(;;)
				{
					try {
						int i=r.read();
						System.out.println("Read: "+i);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				};
		t.start();
	}
}
