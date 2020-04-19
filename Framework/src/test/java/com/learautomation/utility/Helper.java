package com.learautomation.utility;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper {
	
	//Screenshot, alerts, fames, windows, sync issue, javascript executor
	
	public static void CaptureScreenshot(WebDriver driver) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		try{
			FileHandler.copy(src, new File("./Screenshots/"+ getCurrentDateTime() + ".png"));
		    System.out.println("screenshot passed");
		
		} 
		
		catch(Exception e) {
			System.out.println("unable to capture screenshot"+e.getMessage());
		}			
	}
	
public static String getCurrentDateTime() {
	DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currentDate=new Date();
	return customFormat.format(currentDate);
		
	}
	
	
/*public void handlealert() {
	Alert alert = driver.switchTo.alert();
	alert.accept();
	alert.dismiss();
		
	}

public void handlwindow() {
	
}

public void handlframes() {
	
	
}

public void dropdown() {
	Dropdown drop=driver
	
}
*/
}
