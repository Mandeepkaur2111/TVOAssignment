package Testbase;


	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Actions;

	public class Baseclass {
	public static 	WebDriver driver;
	public static String browser;
	public static Properties prop;
	public static  WebDriver setup() throws IOException
	{
		//String path="C:\\Users\\mande\\eclipse-workspace\\TVOAssignment\\src\\main\\java\\config\\config.properties";
		String path="./src/main/java/config/config.properties";
		FileInputStream fis =new FileInputStream(new File(path));
		prop= new Properties();
		prop.load(fis);
		browser=prop.getProperty("browser");
		
		
		 if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxDriver"));
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgeDriver"));
			driver= new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
			{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
			driver= new ChromeDriver();
			}
		else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	return driver;
		
	}

	}

