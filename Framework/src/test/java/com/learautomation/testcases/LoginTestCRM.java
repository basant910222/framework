package com.learautomation.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;

public class LoginTestCRM extends BaseClass{

@Test
	public void loginApp() {
		LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
		loginpage.loginToCRM(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
	}

}
