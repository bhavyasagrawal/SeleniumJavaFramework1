package TestNG;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class TestCase1 {
	
	// This entire code is copied from Katalon Recorder Chrome extension and was just pasted and run here. And it works well. Just the setproperty was added
	
	
	
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  //@SuppressWarnings("deprecation")
@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "D:\\Learnings\\MyWorkspace\\SeleniumJavaFramework\\Drivers\\ChromeDriver\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
  //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testCase1() throws Exception {
    driver.get("https://opensource-demo.orangehrmlive.com/");
 //   driver.findElement(By.xpath("//div[@id='divUsername']/span")).click(); Thread.sleep(2000);
    driver.findElement(By.id("txtUsername")).clear(); Thread.sleep(2000);
    driver.findElement(By.id("txtUsername")).sendKeys("Admin"); Thread.sleep(2000);
    driver.findElement(By.id("txtPassword")).clear(); Thread.sleep(2000);
    driver.findElement(By.id("txtPassword")).sendKeys("admin123"); Thread.sleep(2000);
    driver.findElement(By.id("btnLogin")).click(); Thread.sleep(2000);
    driver.findElement(By.id("welcome")).click(); Thread.sleep(2000);
    driver.findElement(By.linkText("Logout")).click(); Thread.sleep(2000);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
