package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebDriver driver;
	private By signin=By.cssSelector("a[href*='sign_in']");
	private By getTitle=By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By hometab=By.xpath("//a[contains(text(),'Home')]");
	
	
	public WebElement login()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(getTitle);
	}
	public WebElement home()
	{
		return driver.findElement(hometab);
	}
	

}
