package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	// this webdriver is private because we are not extending this page class
	private WebDriver driver;
	//constructor
	public Homepage(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver,this);
		
		
	}

	 @FindBy(xpath="//div[text()='Docs & Series']/ancestor::a")
	 WebElement docseries;
	
	 @FindBy(xpath="//span[text()='All']/ancestor::button")
	 WebElement clickonAll;
	 @FindBy(xpath="//p[text()='Featured Documentary']")
	 WebElement textonpage;
	 @FindBy(xpath="//span[text()='Docs']/ancestor::button[@type='button']")
	 WebElement docs;
	 @FindBy(xpath="//span[text()='Watch Now']/ancestor::a")
	 WebElement viralnews;
	 @FindBy(xpath="//div[text()='Newsletter']/ancestor::a")
	 WebElement newsletter;
	 @FindBy(xpath="//input[@name=\"EMAIL\"]")
	 WebElement Email;
	 @FindBy(xpath="//input[@name=\"group[4553][128]\"]")
	 WebElement checkbox;
	 
	 @FindBy(xpath="//input[@type=\"submit\"]")
	 WebElement subscribe;
	
	 @FindBy(xpath="//span[text()='Remind me later']")
	 WebElement remind;
	 @FindBy(xpath="//button[@aria-label=\"go to search page\"]")
	 WebElement searchbutton;
	 
	 @FindBy(xpath="//input[@name=\"search\"]")
	 WebElement searchinput;
	 
	 public void opendocseries( ) {
		 docseries.click();
	 }

	 public void clickall()
	 {
		 clickonAll.click();
	 }
	 public boolean istextdisplay()
	 {
		boolean b=false;
		try
				{
			b=textonpage.isDisplayed();
				}catch(Exception e)
		{
					e.printStackTrace();
		}
		return b;
	 }
	 public void viralnews()
	 {
		 viralnews.click();
	 }
	 public void msgnewsletters()
	 {
		 newsletter.click();
		 Email.sendKeys("ghaishallu0@gmail.com");
		 checkbox.isSelected();
		 subscribe.click();
	 }
	 
public void clickdocs()
{
	
	docs.click();
}
public void clickremind()
{
	remind.click();
}
public void searchbutton()
{
	searchbutton.click();
	searchinput.sendKeys("19 Days");
}
}
