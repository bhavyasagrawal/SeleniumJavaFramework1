import java.util.Set;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {

	public static void main(String[] args) throws Exception {
		
		
		//This didnt work. Check UsingLocators class
		
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url ="https://www.google.com/";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
      //  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        
        //For creating a new cookie we should pass the name of the cookie and its value
        Cookie cname = new Cookie("myCookie", "12345678999");
        driver.manage().addCookie(cname);
 
        Set<Cookie> cookiesList =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println(getcookies );
        }
        
        //delete the newly created cookie
        driver.manage().deleteCookie(cname);
        Set<Cookie> cookiesListNew =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesListNew) {
            System.out.println(getcookies );
        }
        
    	
		driver.findElement(By.name("q")).sendKeys("Automation testing");
		Thread.sleep(4000);
		
        driver.close();

	}

}
