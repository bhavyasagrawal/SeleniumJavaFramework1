package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestNGMultiBrowserDemo 
{
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName)
	{
		System.out.println("Browser name is: "+browserName);
		System.out.println("Thread id is:  "+Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void test1() throws Exception
	{
		driver.get("https://www.google.com");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("Test Completed successfully");
	}
}
