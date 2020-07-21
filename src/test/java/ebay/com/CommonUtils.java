package ebay.com;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonUtils {
	
	public static String userName = "firozansari3";
	  public static String accessKey = "uGH1Nn6HFQzn24MRxfp5";
	  AndroidDriver<AndroidElement> driver = null;
	
	public void connectToBrowserStack() throws MalformedURLException, InterruptedException
	{
		//Initializing the properties of mobile applications
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("device", "Google Pixel 3");
	    caps.setCapability("os_version", "9.0");
	    caps.setCapability("project", "My First Project");
	    caps.setCapability("build", "My First Build");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");
	    caps.setCapability("app", "bs://fc6e56726f3f10e329c1c2801980a73cdd684bb8");
	    
	    // Android driver initialization
	    driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
	    
	}
	
	
	
	
	
	
	
	
	//Function to swipe in any direction
	
	public void swipe(AndroidDriver driver, DIRECTION direction, long duration)
	{
		Dimension size = driver.manage().window().getSize();
		
		int startX = 0;
		int startY = 0;
		int endX= 0;
		int endY =0;
		
		switch(direction){
		case RIGHT :
			startY= (int)(size.height/2);
			startX = (int)(size.width*0.90);
			endX = (int)(size.width * 0.05);
            new TouchAction(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)))
                    .moveTo(PointOption.point(endX, startY))
                    .release()
                    .perform();
            break;
		case LEFT:
			startY = (int) (size.height / 2);
            startX = (int) (size.width * 0.05);
            endX = (int) (size.width * 0.90);
            new TouchAction(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)))
            .moveTo(PointOption.point(endX, startY))
            .release()
            .perform();
            break;
		case UP :
			endY = (int) (size.height * 0.70);
            startY = (int) (size.height * 0.30);
            startX = (size.width / 2);
            new TouchAction(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)))
            .moveTo(PointOption.point(endX, endY))
            .release()
            .perform();
            break;
		case DOWN:
			startY = (int) (size.height * 0.70);
            endY = (int) (size.height * 0.30);
            startX = (size.width / 2);
            new TouchAction(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)))
            .moveTo(PointOption.point(endX, endY))
            .release()
            .perform();
            break;
		}
			
				
	}
	
	public enum DIRECTION
	{
		DOWN, UP, LEFT, RIGHT;
	}
	
	

}