package bgpsec;

import static org.junit.Assert.*;

import org.it4y.net.link.LinkManager;
import org.it4y.net.link.NetworkInterface;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNetworkInterface {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test01ListNetworkInterfaces() 
	{
		LinkManager linkManager=new LinkManager();
		linkManager.start();
		linkManager.ReadLock();
		System.out.println("Interfaces in this system:");
		try {
			System.out.println("Interfaces discovered: "+linkManager.getInterfaceList().size());
			for (String name:linkManager.getInterfaceList()) 
			{
				NetworkInterface x=linkManager.findByInterfaceName(name);
				System.out.println(x.getName());
			}
		} 
		finally 
		{
			linkManager.ReadUnLock();
		}
	}
}
