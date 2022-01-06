package DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilities_Demo {
	private static WebDriver driver = null;

	@SuppressWarnings("deprecation")

	public static void main(String[] args) throws ClassNotFoundException,Exception
	{
		/*
		 * String projectPath = System.getProperty("user.dir");
		 * System.out.println(projectPath);
		 * System.setProperty("webdriver.chrome.driver",
		 * projectPath+"\\Drivers\\ChromeDriver\\chromedriver.exe");
		 * 
		 * WebDriver driver = new ChromeDriver(); driver.get("www.google.com");
		 * 
		 * Thread.sleep(2000);
		 */
		
		
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

		// @SuppressWarnings("deprecation")
		driver = new ChromeDriver(caps);
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Manual testing");
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		
		driver.close();
		
		//there is no example of desired capabilities in this one
	}

}
