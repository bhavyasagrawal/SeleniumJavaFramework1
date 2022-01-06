package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo 
{
	//check the result in test-output folder with name: testng-failed.xml
	
	@Test
	public void test1()
	{
		System.out.println("I am inside test1");
	}
	@Test
	public void test2()
	{
		System.out.println("I am inside test2");
		//int i =1/0;
	}
	@Test(retryAnalyzer = TestNGListeners.RetryAnalyzer.class)
	public void test3()
	{
		System.out.println("I am inside test3");
		Assert.assertTrue(0>1);
	}
}
