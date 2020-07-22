package ebay.com;

import java.util.List;

import ebay.com.CommonUtils.DIRECTION;
import io.appium.java_client.android.AndroidElement;

public class Application_Amazon extends CommonUtils {
	
	//Function to login to application
	
		public void loginToApplication() throws Exception
		{
			Thread.sleep(3000);
		    AndroidElement element = null;
		    element = driver.findElementById(fetchLocator("Login.Obj1"));
		    element.click();
		}
		
		
		
		//Function to search the item in Electronic department and capture the details of the searched items
		
		
		public void search_Items(String serach_item) throws Exception
		{
			/* Write your Custom code here */
			AndroidElement element = null;
		    element = driver.findElementById("rs_search_src_text");
		    element.click();
		    Thread.sleep(3000);
		    element = driver.findElementById("rs_search_src_text");
		    element.sendKeys(serach_item);
		    element.click();
		    Thread.sleep(5000);
		    element = driver.findElementById("iss_search_dropdown_item_department");
		    element.click();
		    //For Navigating maximum four pages as per requirement
		    for(int i=0;i<=4;i++)
		    {
		    //Initialize the bucket again for searching particular items
		    List<AndroidElement> elements = driver.findElementsById("item_title");
		    boolean found_item = false;
		    for(AndroidElement xelement : elements)
		    {
		    	String text = xelement.getText();
		    	System.out.println(text);
		    	//action.s
		    	if(text.contains("CloudWalker")){
		    		found_item = true;
		    		System.out.println("Item found");
		    		break;
		    	}
		    	
		    	}
		    if(found_item)
		    	break;
		    
		    swipe(driver, DIRECTION.UP,4);
		    
		    }
		    
		    
		    
		}
		
		
		
		// End the session 
		public void End_Test()
		{
		driver.quit();
		}
		
		
		// Check out the item in cart and pick all description and compare with search item
		public void checkOutProduct()
		{
			AndroidElement element = null;
			element = driver.findElementById("loc_ux_gps_auto_detect");
			element.click();
				
		}
		
		//Payment steps till payment options
		
		public void paymentforprocut()
		{
			
		}

}
