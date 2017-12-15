package bgpsec;

import static org.junit.Assert.*;

import org.it4y.net.link.LinkManager;
import org.it4y.net.link.NetworkInterface;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

class TestNetworkInterface {

	@BeforeClass
	static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	static void tearDownAfterClass() throws Exception {
	}

	@Before
	void setUp() throws Exception {
	}

	@After
	void tearDown() throws Exception {
	}

	@Test
	void test01ListNetworkInterfaces() 
	{
		LinkManager linkManager=new LinkManager();
		linkManager.ReadLock();
		System.out.println("Interfaces in this system:");
		try {
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
