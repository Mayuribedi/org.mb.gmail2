package glue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Pages.ComposePage;
import Pages.HomePage;
import Pages.Loginpage;
import Pages.LogoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail2
{
public RemoteWebDriver driver;
public HomePage obj1;
public Loginpage obj2;
public ComposePage obj3;
public LogoutPage obj4;

 @Given("open {string} Browser")
 public void method1(String bn)
 {
    if(bn.equalsIgnoreCase("chrome"))
    {
    	WebDriverManager.chromedriver().setup();
    	//define objects
    	driver=new ChromeDriver();
    	obj1=new HomePage(driver);
    	obj2=new Loginpage(driver);
    	obj3=new ComposePage(driver);
    	obj4=new LogoutPage(driver);
    
    }
}
 @When("launch site using {string}")
 public void method2(String url) throws Exception
{
    driver.get(url);
    Thread.sleep(5000);
}


 @When("do login using {string} and {string}")
 public void method3(String un, String pwd) throws Exception  
 {
	obj1.fillUserName(un);
	obj1.clickhomeNext();
	obj2.Fillpassword(pwd);
	obj2.ClickLoginNext();

 }
 
@Then("compose is displayed")
public void method4() 
{
    if(obj3.isComposeDisplayed())
    {
    	System.out.println("compose is displayed");
    }
    else
    {
    	System.out.println("compose is not displayed");
    }
    
}

 @When ("click on compose page and fill field and send mail and check response")
public void method5(DataTable dt) throws Exception
{
    //take data from datatable
	 List<Map<String, String>> l=dt.asMaps();
	 for(int i =0; i<l.size(); i++)
	 {    //click on compose
		 obj3.clickcompose();
		 //fill fields
		 obj3.fillto(l.get(i).get("to"));
		 obj3.fillsubject(l.get(i).get("subject"));
		 obj3.fillbody(l.get(i).get("body"));
		 obj3.Fillfilepath(l.get(i).get("attachment"));
		 //click on send
		 obj3.clicksend();
			 // get msg
		 System.out.println(obj3.getOutmsg());
	 }
    
}
 @When("do logout")
public void method6() throws Exception
{
   
   obj4.clickprofilepic();
   obj4.clicksignout(driver);
   Thread.sleep(15000);
}
    
@Then("login page should be displayed")
public void method7()
{
 if(obj4.isLoginReDisplayed())
 {
	 System.out.println("Successful logout");
 }
 else
 {
	 System.out.println("Unsuccessful logout");
 }
}
 

  @Then("closed site")
  public void method8()
  {
    driver.close();
 }

 }
