package ebay.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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
	  String path = "C:\\Users\\acer\\git\\Amazon_Mobile\\src\\Resources";
	  String filename = "TestData.xlsx";
	  String locatorsheet = "Locators";
	  String datasheet = "Test_Data";
	 Map<String, List <String>> TestData = new HashMap<String, List<String>>();
	 List<String> list = new ArrayList<String>();
	  Map <String,String> Locators= new HashMap<String,String>();
	  
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
	
	
	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook DataWorkbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    DataWorkbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	        DataWorkbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet datasheet = DataWorkbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = datasheet.getLastRowNum()-datasheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = datasheet.getRow(i);
	        	list = new ArrayList<String>();
	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console
	        	if(sheetName.contentEquals("Test_Data")) {
	        		//added to list item
	        		list.add(row.getCell(j).getStringCellValue());
	        		//added to map and list item at particular row
	        	TestData.put(row.getCell(0).getStringCellValue(),list);
	        	} else if (sheetName.contentEquals("Locators"))
	        	{
	        		Locators.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
	        	}
	        		

	           // System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	            
	            
	        }

	        System.out.println();
	    } 

	    }  

// Reading only locator from excel workbook sheet
		public String fetchLocator(String locator_ID) throws IOException
	{
		//	Reading value from excel	
		readExcel(path,filename,locatorsheet);
		//Reading value from HashMap
		String obj=Locators.get(locator_ID);
		//Testing working of function
		//System.out.println(obj);
		
	return obj;
			
	}
		
		//Reading the test data from excel
		public String fetchData(String TestId,String Data_Value) throws IOException
		{
			//Reading data value from excel
			readExcel(path,filename,datasheet);
			List<String> values = TestData.get(TestId);
			switch(Data_Value)
				{
				case "username" :
					System.out.println(values.get(1));
				 return values.get(1);
				case "password" :
					return values.get(2);
				case "data1" :
					return values.get(3);
				case "data2" :
					System.out.println(values.get(4));
					return values.get(4);
					
					default:
						return null;
				}
		
		}
		
}