package Testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Testbase.Baseclass;
import pageobject.Homepage;
import utilities.Testutility;

public class Testclass  {
	WebDriver driver;
	Homepage hp;
	//create browser set up
	@BeforeMethod
	public void beforesetup() throws IOException
	{
		driver = Baseclass.setup();
		hp= new Homepage(driver);
		
	}
	//test to open the application and test the title of page
	@Test
	public void titleverify() throws IOException
	{
		Assert.assertEquals("TVO Today | Current Affairs Journalism, Documentaries and Podcasts", driver.getTitle());
		//Object series;
		Testutility.attachScreenshot();
	}
	// test to click on docs and series link
	@Test
	public void clickondocsandseries() throws IOException
	{
		Testutility.attachScreenshot();
		hp.opendocseries();
		
		}  
	// test to click all and docs and verify text on the page
	@Test 
	public void textverify() throws IOException
	{hp.clickall();
		Testutility.attachScreenshot();;
		String ws1 = driver.getWindowHandle();
		System.out.println("ws1:"+ws1);
		driver.switchTo().window(ws1);
		
		boolean text = false;
		if(hp. istextdisplay()==text)
		{
			
		
		Assert.assertTrue(text);
		}
		
	
		else {
		Assert.assertFalse(text);
		}
		
		
	}
	 //test to click on viralnews link on page and get the current url
	@Test
	
		public void clickonwatchnews()
		{
		hp.viralnews();
		driver.getCurrentUrl();
		
	}
	//test to click on docs and click on remind me later button on donation page
	@Test
	public void docs() throws IOException
		{
		
		Testutility.attachScreenshot();;
		hp.clickdocs();
		
		hp.clickremind();
		
	}
	//test to verify that particular docs will present on screen by typing name onnsearch textbox
	@Test
	public void searchdocs()
	{
		hp.searchbutton();
	}
	// test to the subscribtion of the docs
	@Test
	public void getsubscribtion()
	{
		hp.msgnewsletters();
	}	
	
@AfterMethod
public void teardown()
{
	driver.quit();
}

}
