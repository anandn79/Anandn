package org.automation.twitter.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.automation.twitter.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class DriverInstance {
	
    public WebDriver driver;
    
    @BeforeMethod
    public void initiateDriverinstance() throws Exception
    {
    	if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome"))
    	{
 		
    		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        	driver = new ChromeDriver();	
        	//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	}
    		
    	else if (Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
    		driver = new FirefoxDriver();	
    	}
    	driver.get(Utility.fetchPropertyValue("applicationURL").toString());
    }
    
	@AfterMethod
	public void closeDriverInstance()
	{
		driver.quit();
	}

}
