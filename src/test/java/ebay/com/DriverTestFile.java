package ebay.com;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DriverTestFile {
	Application_Amazon amz = new Application_Amazon();
	
	@BeforeTest
	public void connectionToMobile() throws Exception, InterruptedException
	{
		amz.connectToBrowserStack();
		System.out.println("Befor Class executed");
	}
	
	
	@Test
	public void purchage_Item_test() throws Exception
	{
		
			amz.loginToApplication();
			
			amz.search_Items();
			
			amz.checkOutProduct_screen();
			
		
	}

	
	@AfterTest
	public void end_Test()
	{
		amz.End_Test();
	}
	
}
