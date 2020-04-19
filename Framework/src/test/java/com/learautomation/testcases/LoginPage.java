package com.learautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUp;
	@FindBy(className="btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left")
	WebElement Login;
	@FindBy(xpath="//input[@name='email']")
	WebElement Username;
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginButton;
	
	public void loginToCRM(String uname, String pass) {
			Username.sendKeys(uname);
			Password.sendKeys(pass);
			LoginButton.click();
	
	}
	
}
