package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginCredentials {
	public LoginCredentials(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebDriver driver;
	private By email=By.id("user_email");
	private By password=By.xpath("//input[@id='user_password']");
	private By clicklogin = By.cssSelector("input[value='Log In']");
	private By title=By.cssSelector("a[class='navbar-brand']");

	public WebElement Email()
	{
		return driver.findElement(email);
	}
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	public WebElement Login()
	{
		return driver.findElement(clicklogin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	
		
	

}
