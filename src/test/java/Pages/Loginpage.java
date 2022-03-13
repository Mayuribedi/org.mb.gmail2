package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
	//Define Element locators
	@FindBy (name = "password") public WebElement password;
	
	@FindBy (xpath = "//span[text() ='Next']") public WebElement loginNext;
	
	
	//Constructor method
	public Loginpage (RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//operational and observation methods
	public void Fillpassword(String x)
	{
		password.sendKeys(x);
	}

	public void ClickLoginNext() throws Exception
	{
		loginNext.click();
		Thread.sleep(5000);
	}

}


