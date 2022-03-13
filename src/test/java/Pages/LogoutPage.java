package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	@FindBy(xpath="//a[starts-with(@aria-label,'Google Account')]/img")
 	public WebElement profilepic;
	
	@FindBy(xpath="//div[text() = 'Sign out']") public WebElement signout;
	
	@FindBy(xpath="//span[text()= 'Choose an account']") public WebElement relogin;
	
	//Construtor method
	public LogoutPage (RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//operational and oberservation methods
	public void clickprofilepic() throws Exception 
	{
		profilepic.click();
		Thread.sleep(10000);
	}
	public void clicksignout(RemoteWebDriver driver) throws Exception 
	{
		try
		{
			WebElement e=driver.findElement(By.xpath("(//iframe[@role='presentation'])[2]"));
			driver.switchTo().frame(e);
			signout.click();
			driver.switchTo().defaultContent();
			Thread.sleep(15000);
		}
		catch(Exception ex)
		{
			System.out.println("false");
		}
	}
	public boolean isLoginReDisplayed ()
	{
		if(relogin.isDisplayed())
	{
		return(true);
	}
	else
	{
		return(false);
	}
}

}
