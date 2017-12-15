package bgpsec;

import static org.junit.jupiter.api.Assertions.*;

import org.it4y.net.link.LinkManager;
import org.it4y.net.link.NetworkInterface;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNetworkInterface {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
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
