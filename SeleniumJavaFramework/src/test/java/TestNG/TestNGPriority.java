package TestNG;

import org.testng.annotations.Test;

public class TestNGPriority 
{
	//when priorities are same, then alphabetical order of method is considered. If no priority is given, then also alphabetical order

	@Test
	public void one()
	{
		System.out.println("I am inside test1");
	}
	@Test(priority = 1)
	public void two()
	{
		System.out.println("I am inside test2");
	}
	@Test(priority = 1)
	public void three()
	{
		System.out.println("I am inside test3");
	}
}
