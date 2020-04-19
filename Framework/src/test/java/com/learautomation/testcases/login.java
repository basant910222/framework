package com.learautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

public static void main(String args[]) {
System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("https://ui.freecrm.com/");
driver.findElement(By.xpath("//input[@name='email']")).sendKeys("basa");


}}
