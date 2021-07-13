package Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginCredentials;
import PageObjects.LoginPage;
import Resources.Base;

public class LoginPageTest extends Base{
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(LoginPageTest.class.getName());
	
@BeforeTest
public void url() throws IOException {
	driver=initializeBrowser();
	log.info("Driver is initialized");
	driver.get(prop.getProperty("url"));
	log.info("Navigating to home page");
}
@Test
public void loginpagenavigation() throws IOException
{
	LoginPage lp=new LoginPage(driver);
	lp.login().click();
	log.info("Clicked on Login button");
	
}
@Test(dataProvider="getData")
public void passingcredentials(String emailID, String password)
{
	LoginCredentials lc=new LoginCredentials(driver);
	lc.Email().sendKeys(emailID);
	lc.Password().sendKeys(password);
	lc.Login().click();
	Assert.assertEquals(lc.getTitle().getText(),"WebServices1 Testing using SoapUI");


}
@DataProvider
public Object[][] getData()
{
Object[][] data=new Object[2][2];
data[0][0]= "preethi@abc.com";
data[0][1]="123456";

data[1][0]="ammu@abc.com";
data[1][1]="439587";
return data;
}
@AfterTest
public void closingbrowsers()
{
	driver.close();
}
}
