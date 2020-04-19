package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learautomation.utility.BrowserFactory;
import com.learautomation.utility.ConfigDataProvider;
import com.learautomation.utility.ExcelDataProvider;
import com.learautomation.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite() {	
		
	 Reporter.log("setting up report and test is getting ready", true);	
	 excel=new ExcelDataProvider();
	 config=new ConfigDataProvider(); 
	 ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/FreeCRM"+Helper.getCurrentDateTime()+".html"));
	 report=new ExtentReports();
	 report.attachReporter(extent);
	 
	 Reporter.log("setting up report and test started", true);
	
	}
	
	@BeforeClass
	public void setup()
	{
		 Reporter.log(" Trying to start Browser and applicationis getting ready", true);
		driver=BrowserFactory.StartApplication(driver, config.getBrowser(), config.getURL());
		 Reporter.log("Browser and app is launch", true);
		}

	@AfterClass
	public void tearDown() {

		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {

		 Reporter.log("Test is about to end", true);
		
	if(result.getStatus()==ITestResult.FAILURE) {
		logger.fail("Test Fail",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		logger.pass("Test passed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
	}
	else if(result.getStatus()==ITestResult.SKIP) {
		logger.skip("Test skipped ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
	}
	
	report.flush();
	 Reporter.log("Test completed", true);
	}
   
}
