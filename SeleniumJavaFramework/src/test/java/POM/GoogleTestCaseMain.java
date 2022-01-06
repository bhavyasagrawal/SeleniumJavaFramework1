package POM;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTestCaseMain 
{
	private static WebDriver driver = null;
	
	@SuppressWarnings("deprecation")
	public static void googleSearchTest() throws Exception
	{
		
		WebDriverManager.chromedriver().setup();

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

		//@SuppressWarnings("deprecation")
		driver = new ChromeDriver(caps);

		Thread.sleep(2000);
		
		GooglePageObject obj = new GooglePageObject(driver);

		driver.get("https://www.google.com");
		
		obj.searchTextbox("India");
		Thread.sleep(2000);
		
		obj.searchButton();
		Thread.sleep(2000);
		
		driver.close();
	}
	
	public static void main(String[] args) throws Exception 
	{
		
		googleSearchTest();
	}

}
