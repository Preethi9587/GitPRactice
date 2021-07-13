package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeBrowser() throws IOException
	{
	prop=new Properties();
	FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Data.properties");
	prop.load(fs);
	String browserName=System.getProperty("browser");
	//String browserName=prop.getProperty("Browser");
	if(browserName.contains("chrome"))	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		if(browserName.contains("headless"))
		{
		options.addArguments("headless");
		}
		driver= new ChromeDriver(options);
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException
	
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
}
	
