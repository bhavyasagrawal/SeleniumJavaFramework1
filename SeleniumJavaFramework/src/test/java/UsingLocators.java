import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingLocators {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
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
	

		// driver.manage().deleteAllCookies();
		Thread.sleep(2000);

		driver.get("https://www.google.com");

		Thread.sleep(2000);


		List<WebElement> list = driver.findElements(By.xpath("//input"));
		int count  =  list.size();
		System.out.println("Count of input elements: "+count);
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.name("q")));// .sendKeys("Automation testing");
		driver.findElement(By.name("q")).sendKeys("Automation testing");
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);

		driver.close();

	}

}
