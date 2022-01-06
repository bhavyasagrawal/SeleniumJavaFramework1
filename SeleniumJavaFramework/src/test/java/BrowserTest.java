import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {
public static void main(String[] args) throws Exception {
	
	String projectpath = System.getProperty("user.dir");
	System.out.println("Project path: "+projectpath);
	
	//Chrome
	
	//System.setProperty("webdriver.chrome.driver", projectpath+"\\Drivers\\ChromeDriver\\chromedriver.exe");	
	//System.setProperty("webdriver.chrome.driver", "D:\\Learnings\\MyWorkspace\\SeleniumJavaFramework\\Drivers\\ChromeDriver\\chromedriver.exe");
    //WebDriver driver = new ChromeDriver();
	//driver.get("https://www.google.com");
	
	//Thread.sleep(10000);
	
	//FF
	
	/*
	 * System.setProperty("webdriver.gecko.driver",
	 * projectpath+"\\Drivers\\GeckoDriver\\geckodriver.exe");
	 * 
	 * WebDriver driver = new FirefoxDriver(); driver.get("https://selenium.dev");*/
	
	//IE
	//We can also set system property in environment path variable and then restart the machine. Nowe dont need that setproperty line
	
	//	System.setProperty("webdriver.edge.driver", projectpath+"\\Drivers\\EdgeDriver\\msedgedriver.exe");
		WebDriver driverie = new EdgeDriver();
		driverie.get("https://selenium.dev");
		
		Thread.sleep(10000);
	//driver.close();
}
}
