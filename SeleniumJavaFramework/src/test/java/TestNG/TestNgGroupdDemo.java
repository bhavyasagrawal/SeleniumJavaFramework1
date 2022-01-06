package TestNG;

import org.testng.annotations.Test;

@Test(groups = {"AllClassTests"})
public class TestNgGroupdDemo 
{
	@Test(groups = {"sanity"})
	public void test1()
	{
		System.out.println("This is test1");
	}
	@Test(groups = {"sanity","smoke"})
	public void test2()
	{
		System.out.println("This is test2");
	}
	@Test(groups = {"sanity","regression"})
	public void test3()
	{
		System.out.println("This is test3");
	}
	@Test(groups = {"windows.smoke"})//this is for regular expression
	public void test4()
	{
		System.out.println("This is test4");
	}
	@Test
	public void test5()
	{
		System.out.println("This is test5");
	}
}
