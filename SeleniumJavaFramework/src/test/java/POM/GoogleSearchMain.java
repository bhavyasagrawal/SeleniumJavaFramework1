package POM;

import java.util.HashMap;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchMain {
	
	public static void main(String[] args) throws Exception {
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

		@SuppressWarnings("deprecation")
		WebDriver driver = new ChromeDriver(caps);

		Thread.sleep(2000);

		driver.get("https://www.google.com");

		Thread.sleep(2000);

		GoogleSearch.searchTextbox(driver).sendKeys("India");
		Thread.sleep(2000);

		GoogleSearch.searchbutton(driver).sendKeys(Keys.RETURN);
		Thread.sleep(4000);

		GoogleSearch.close(driver);

	}

}
