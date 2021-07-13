package Selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import Resources.Base;

public class HomePage extends Base{
	
	public WebDriver driver;
@BeforeTest
public void url() throws IOException {
	driver=initializeBrowser();
	driver.get(prop.getProperty("url"));
}
	@Test
	public void basepageNavigation() throws IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES");
		Assert.assertTrue(lp.home().isEnabled());
		
	}
	
	@AfterTest
	public void closingbrowsers()
	{
		driver.close();
	}
		
		

}
