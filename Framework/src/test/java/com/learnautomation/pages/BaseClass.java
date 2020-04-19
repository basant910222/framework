package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.learautomation.utility.BrowserFactory;
import com.learautomation.utility.ConfigDataProvider;
import com.learautomation.utility.ExcelDataProvider;
import com.learautomation.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setUpSuite() {	
	 excel=new ExcelDataProvider();
	 config=new ConfigDataProvider(); 
	}
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.StartApplication(driver, config.getBrowser(), config.getURL());
		
		}

	@AfterClass
	public void tearDown() {

		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {

	if(result.getStatus()==ITestResult.FAILURE) {
		Helper.CaptureScreenshot(driver);
	}
		
	}

}
