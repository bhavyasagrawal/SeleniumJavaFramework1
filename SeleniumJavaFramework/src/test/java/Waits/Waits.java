package Waits;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) throws Exception {
	
		seleniumWaits();

	}
	@SuppressWarnings("deprecation")
	public static void seleniumWaits() throws Exception
	{
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"\\Drivers\\ChromeDriver\\chromedriver.exe");
	    
	    
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
	    
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //250ms search time
	    driver.get("https://www.google.com");
	    driver.findElement(By.name("q")).sendKeys("Manual Testing");
	    driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));
	    driver.findElement(By.name("abcd")).click(); // purpose added this non existing element to test implicit wait
	    
	    //try not to use both waits
	    
	    driver.close();
	    driver.quit();
	
	}

}
