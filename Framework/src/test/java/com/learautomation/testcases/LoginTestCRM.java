package com.learautomation.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;

public class LoginTestCRM extends BaseClass{

@Test
	public void loginApp() {
	
	    logger=report.createTest("Login to CRM");
	    
		LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Start application");
		
		loginpage.loginToCRM(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
	
		logger.pass("login sucess");
}

}
