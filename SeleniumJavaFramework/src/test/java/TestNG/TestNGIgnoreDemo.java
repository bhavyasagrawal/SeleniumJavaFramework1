package TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore   //(here we can ignore at the class level)
public class TestNGIgnoreDemo 
{
	@Ignore
	@Test
	public void test1()
	{
		System.out.println("I am inside test1");
	}
	@Test
	public void test2()
	{
		System.out.println("I am inside test2");
	}
	@Test
	public void test3()
	{
		System.out.println("I am inside test3");
	}
}
