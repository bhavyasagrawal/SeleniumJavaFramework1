package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePageObject {
	
	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	By button_click = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']");
	
	public GooglePageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void searchTextbox(String text)
	{
		driver.findElement(textbox_search).sendKeys(text);
	}
	public void searchButton()
	{
		driver.findElement(button_click).sendKeys(Keys.RETURN);
	}
}
