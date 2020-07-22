package ebay.com;

import java.util.List;

import org.testng.Assert;

import io.appium.java_client.android.AndroidElement;

public class Application_Amazon extends CommonUtils {
	
	//Function to login to application
	
		public void loginToApplication() throws Exception
		{
			/*
			 * Thread.sleep(3000); AndroidElement element = null; element =
			 * driver.findElementById(fetchLocator("LoginId.Obj1")); element.click();
			 * Thread.sleep(3000); element =
			 * driver.findElementByClassName(fetchLocator("LoginId.Obj2")); element.click();
			 * element = driver.findElementByClassName(fetchLocator("LoginId.Obj2"));
			 * element.sendKeys(fetchData("Test001","username")); element =
			 * driver.findElementByXPath(fetchLocator("LoginId.Obj3")); element.click();
			 * element = driver.findElementByClassName(fetchLocator("LoginId.Obj4"));
			 * element.click(); element =
			 * driver.findElementByClassName(fetchLocator("LoginId.Obj4"));
			 * element.sendKeys(fetchData("Test001","password")); element =
			 * driver.findElementByXPath(fetchLocator("LoginId.Obj5")); element.click();
			 * Thread.sleep(3000);
			 */
		    
		    //Need to Handle OTP feature of Amazon
		    
		    //Skinping login process
			Thread.sleep(3000); 
			AndroidElement element = null; 
			element = driver.findElementById(fetchLocator("LoginSkip.Obj9")); 
			element.click();
			Thread.sleep(3000);
		}
		
		
		
		//Function to search the item in Electronic department and capture the details of the searched items
		
		
		public void search_Items() throws Exception
		{
			/* Write your Custom code here */
			AndroidElement element = null;
		    element = driver.findElementById(fetchLocator("Search.Obj6"));
		    element.click();
		    Thread.sleep(3000);
		    element = driver.findElementById(fetchLocator("Search.Obj6"));
		    element.sendKeys(fetchData("Test001","data1"));
		    element.click();
		    Thread.sleep(5000);
		    element = driver.findElementById(fetchLocator("Search.Obj7"));
		    element.click();
		    //For Navigating maximum four pages as per requirement
		    for(int i=0;i<=4;i++)
		    {
		    //Initialize the bucket again for searching particular items
		    List<AndroidElement> elements = driver.findElementsById(fetchLocator("SearchList.Obj8"));
		    boolean found_item = false;
		    for(AndroidElement xelement : elements)
		    {
		    	text = xelement.getText();
		    	System.out.println(text);
		    	//action.s
		    	if(text.contains(fetchData("Test001","data2"))){
		    		found_item = true;
		    		System.out.println(text);
		    		
		    		Assert.assertEquals(text, text);
		    		break;
		    	}
		    	
		    	}
		    if(found_item)
		    	break;
		    
		    swipe(driver, DIRECTION.UP,10);
		    
		    }
		}
		
		
		
		// End the session 
		public void End_Test()
		{
		driver.quit();
		}
		
		
		// Check out the item in cart and pick all description and compare with search item
		public void checkOutProduct_screen()
		{
			AndroidElement element = null;
			//element = driver.findElementById("loc_ux_gps_auto_detect");
			//element.click();
			//Model of the TV
			Assert.assertEquals(false, text.contentEquals("TV 65X8000H"));
			Assert.assertEquals(true, text.contentEquals("2020 Model"));
			Assert.assertEquals(true, text.contentEquals("Sony Bravia"));
			Assert.assertEquals(true, text.contentEquals("1,39,990"));
			
				
		}
		
		//Payment steps till payment options
		
		public void paymentforprocut()
		{
			
		}

}
