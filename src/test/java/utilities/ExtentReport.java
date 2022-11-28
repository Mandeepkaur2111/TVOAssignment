package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends TestListenerAdapter{
	public WebDriver driver;
	public ExtentSparkReporter spark;
	//public ExtentReporter xtentHtml;
	public ExtentReports extent;
	public ExtentTest test;
	@BeforeTest
	public void startReport() {
	         // Create an object of Extent Reports
	extent = new ExtentReports();
	
	spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/TVOExtentReport.html");
	extent.attachReporter(spark);
	extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
    extent.setSystemInfo("Environment", "Production");
extent.setSystemInfo("User Name", "Rajkumar SM");
spark.config().setDocumentTitle("Title of the Report Comes here ");
           // Name of the report
spark.config().setReportName("Name of the Report Comes here ");
           // Dark Theme
spark.config().setTheme(Theme.STANDARD);
	}
	@BeforeMethod
	public void setup() {
	System.setProperty("webdriver.firefox.driver","C://AutomationFramework//Drivers//geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	}
	@Test
			public void verifymainpage()
		{
 test = extent.createTest("open the TVOMedia main page","this is to verify with TVOMedia main page open after given the URL");
	driver.get(" https://www.tvo.org/");
}
	@Test
	public void verifytest() {
test = extent.createTest("To verify text");
driver.findElement(By.xpath("//div[text()='Docs & Series']/ancestor::a")).click();
	boolean text= driver.findElement(By.xpath("//p[text()='Featured Documentary']")).isDisplayed();
	test.createNode("text is Present");
	Assert.assertTrue(text);
	test.createNode("text is not Present");
	Assert.assertFalse(text);
	}
	
@AfterMethod

	public void teardown()
	{
		driver.quit();
		}
	
@AfterTest
public void endReport() {
extent.flush();
}
}
