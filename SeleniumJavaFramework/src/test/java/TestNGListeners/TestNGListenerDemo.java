package TestNGListeners;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNGListeners.Listeners.class)
public class TestNGListenerDemo 
{
	@Test
	public void test4()
	{
		System.out.println("I am inside Test4");
	}
	@Test
	public void test5() throws Exception
	{
		System.out.println("I am inside Test5");
	//	Assert.assertTrue(false);
		
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"\\Drivers\\\\ChromeDriver\\\\chromedriver.exe");
		
		 DesiredCapabilities caps = new DesiredCapabilities();

			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			Map<String, Object> profile = new HashMap<String, Object>();
			Map<String, Object> contentSettings = new HashMap<String, Object>();

			contentSettings.put("cookies", 2);
			profile.put("managed_default_content_settings", contentSettings);
			prefs.put("profile", profile);
			options.setExperimentalOption("prefs", prefs);
			caps.setCapability(ChromeOptions.CAPABILITY, options);

			@SuppressWarnings("deprecation")
			WebDriver driver = new ChromeDriver(caps);
		
			Thread.sleep(2000);
		    
		    driver.get("https://www.google.com");
		    driver.findElement(By.name("q")).sendKeys("Manual Testing");
		    driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		    driver.close();
		    
	}
	@Test
	public void test6()
	{
		System.out.println("I am inside Test6");
		throw new SkipException("This test is skipped");
	}

}
