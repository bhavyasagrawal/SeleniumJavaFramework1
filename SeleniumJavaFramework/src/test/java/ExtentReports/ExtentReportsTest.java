package ExtentReports;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsTest {

	private static WebDriver driver = null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		ExtentSparkReporter spark = new ExtentSparkReporter("SampleExtentReport.html");

		// create extentreports and attach reporters

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);

		//Test for Pass
		ExtentTest test1 = extent.createTest("Google Search Test 1",
				"This is a test to validate google search functionality");

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

		test1.log(Status.INFO, "Starting Test case");
		driver.get("https://www.google.com");
		test1.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Automation testing");
		test1.pass("Entered text in searchbox");
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");

		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		test1.info("Test Completed");
		
		
		
		//Test for Fail
				ExtentTest test2 = extent.createTest("Google Search Test 2",
						"This is a test to validate google search functionality");

				Thread.sleep(2000);
				
				WebDriverManager.chromedriver().setup();

				DesiredCapabilities caps1 = new DesiredCapabilities();

				ChromeOptions options1 = new ChromeOptions();
				Map<String, Object> prefs1 = new HashMap<String, Object>();
				Map<String, Object> profile1 = new HashMap<String, Object>();
				Map<String, Object> contentSettings1 = new HashMap<String, Object>();

				contentSettings.put("cookies", 2);
				profile1.put("managed_default_content_settings", contentSettings1);
				prefs1.put("profile", profile);
				options1.setExperimentalOption("prefs", prefs1);
				caps1.setCapability(ChromeOptions.CAPABILITY, options1);

				// @SuppressWarnings("deprecation")
				driver = new ChromeDriver(caps1);

				Thread.sleep(2000);
				

				test2.log(Status.INFO, "Starting Test case");
				driver.get("https://www.google.com");
				test2.pass("Navigated to google.com");

				driver.findElement(By.name("q")).sendKeys("Manual testing");
				test2.pass("Entered text in searchbox");
				Thread.sleep(4000);

				driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).sendKeys(Keys.RETURN);
				test2.fail("Failed Pressing keyboard enter key");

				driver.close();
				driver.quit();
				test2.pass("Closed the browser");
				test2.info("Test Completed");
		
				extent.flush();

	}

}
