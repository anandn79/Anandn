package org.automation.twitter.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.automation.twitter.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
    WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void enterUserName(String uname) throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchlocatorValue("login_username_xpath"))).sendKeys(uname);
		
	}

	public void enterPassword(String password) throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchlocatorValue("login_password_xpath"))).sendKeys(password);
	}
	
	public void clickSignin() throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchlocatorValue("login_signin_xpath"))).click();
	}
}
