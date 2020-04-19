package com.learautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	public Properties pro;
	public ConfigDataProvider() {
		File src=new File("./Config/config.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
		    pro =new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Not able to get Config file" + e.getMessage());
		}
		
	}

public String getDataFromConfig(String KetTosearch) {
	
	return pro.getProperty("KetTosearch");
}

public String getURL() {
	
	return pro.getProperty("url");
}

public String getBrowser() {
	return pro.getProperty("Browser");
}


}


	

