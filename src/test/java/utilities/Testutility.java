package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Testbase.Baseclass;

public class Testutility extends Baseclass {
	public static void clickonelementjs(WebElement e)
	{
		
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		
		j.executeScript("arguments[0].click();", e);
		
}
	public static void clickonelementjs1(WebElement e)
	{
		
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		
		j.executeScript("arguments[0].click();",e);
		
}
	public static void creatscreenshot() throws IOException
	{
		File nfile=new File("./screenshot");
		if(!nfile.isDirectory())
		{
			
		
		nfile.mkdir();
		}
		
		TakesScreenshot tk=(TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("./"+"sceenshot"+getDate()+"_image.jpg"));
	}
	private static String getDate()
	{
	Date dt=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSS");
String temp=sdf.format(dt);
System.out.println(temp);
	return temp;
		
		}
	
	public static void attachScreenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String image="<img src=\"data:image/png;base64,"+src+"\" height=\"600\" width=\"800\" />";
		Reporter.log(image);
	}
	public static void waitforelement(WebElement  textonpage)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf( textonpage));
	}
}
