import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverManagerTest {

	public static void main(String[] args)
	{
		//Use Webdrivermanager if we dont need to use and set system path
//	WebDriverManager.chromedriver().browserVersion("96.0").setup(); // we can even set the browser version here
	
		WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.google.com");
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.close();
	

	}

}
