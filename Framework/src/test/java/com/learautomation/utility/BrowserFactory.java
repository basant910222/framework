package com.learautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	WebDriver drivers; 

	public static WebDriver StartApplication( WebDriver driver, String browserName, String appURL) {
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.IE.driver", "./Drivers/IEDriverserver.exe");
			driver=new InternetExplorerDriver();	
		}
		else {
			System.out.println("We do not support browser");
		}
		
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(appURL);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
