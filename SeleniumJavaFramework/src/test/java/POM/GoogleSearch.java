package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {

	private static WebElement element = null;
	
	public static WebElement searchTextbox(WebDriver driver)
	{
		element = driver.findElement(By.name("q"));
		return element;
	}
	public static WebElement searchbutton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
		return element;
	}
	
	public static void close(WebDriver driver)
	{
		driver.close();
	}
	
}
