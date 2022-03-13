package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
   // Define element locator
	@FindBy(name = "identifier")
	public WebElement userName;
	
	@FindBy(xpath= "//span[text() ='Next']")
	public WebElement homeNext;
	
	
	//Constructor method
	public HomePage (RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//operational and observation methods
	public void fillUserName(String x)
	{
		userName.sendKeys(x);
	}
	
	public void clickhomeNext() throws Exception
	{
		homeNext.click();
		Thread.sleep(5000);
	}
}
