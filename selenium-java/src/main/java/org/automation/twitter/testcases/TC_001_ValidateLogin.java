package org.automation.twitter.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.twitter.base.DriverInstance;
import org.automation.twitter.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_ValidateLogin extends DriverInstance {
	
	@Test(dataProvider = "Excel")
	public void TC_001(String uname, String pass) throws Exception
	{
		LoginPage login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pass);
		login.clickSignin();
	}

	/* @DataProvider(name="static")
	public Object[][] testDataGenerator()
	{
		Object[][] testData = {{"uname1", "pass1"},{"uname2", "pass2"}};
		
		return testData;
		
	} */
	
	@DataProvider(name="Excel")
	public Object[][] testDataGenerator() throws Exception
	{
     FileInputStream file = new FileInputStream("./testdata/testdata.xlsx");
     XSSFWorkbook workbook = new XSSFWorkbook(file);
     XSSFSheet loginSheet = workbook.getSheet("Login");
     int numberofdata = loginSheet.getPhysicalNumberOfRows();
     Object[][] testData= new Object[numberofdata][2];
     
     for(int i=0; i<numberofdata; i++)
     {
    	 XSSFRow row = loginSheet.getRow(i);
    	 XSSFCell username = row.getCell(0);
    	 XSSFCell password = row.getCell(1);
    	 testData[i][0] = username.getStringCellValue();
    	 testData[i][1] = password.getStringCellValue();
     
     }
     
	 return testData;
	}
	
}
