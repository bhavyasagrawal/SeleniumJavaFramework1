package TestNG;

import java.util.HashMap;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {

	private static WebDriver driver = null;

	@BeforeTest
	@SuppressWarnings("deprecation")
	public static void setUpTest() throws Exception {
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

		Thread.sleep(2000);
	}

	@AfterTest
	public void tearDownTest() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void googleSearch() throws Exception {

		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("Automation testing");
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).sendKeys(Keys.RETURN);

	}

}
