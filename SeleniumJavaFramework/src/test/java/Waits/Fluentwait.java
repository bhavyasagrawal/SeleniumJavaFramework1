package Waits;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fluentwait {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		fluentWait();
	}
	
	public static void fluentWait() throws Exception 
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
	   // driver.findElement(By.linkText("Manual Testing Tutorial: What is, Concepts, Types & Tool")).click();
	    
	    
	 // Waiting 30 seconds for an element to be present on the page, checking
	    // for its presence once every 5 seconds.
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	        .withTimeout(Duration.ofSeconds(30))
	        .pollingEvery(Duration.ofSeconds(5))
	        .ignoring(NoSuchElementException.class);

	    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	      public WebElement apply(WebDriver driver) {
	    	  WebElement linkelement = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3"));
	    	  if(linkelement.isEnabled())
	    	  {
	    		  System.out.println("Element found");
	    	  }
	       return linkelement;
	      }
	    });
	    element.click();
	    
		Thread.sleep(2000);
	    driver.close();
	    driver.quit();
	}

}
