package TestNGListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener
{

	// to get these methods, we need to : Right click(on the Listeners class ) -> go to source-> click on overide/implement methods -> select the check boxes for the ITest listener 
	//(make sure all check box inside it should be checked )->click on oK. That's it !!!

	public void onTestStart(ITestResult result) 
	{

		System.out.println("*********Test Started: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("*********Test Success: "+result.getName());

	}

	public void onTestFailure(ITestResult result) 
	{

		System.out.println("*********Test Failed: "+result.getName());
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("*********Test Skipped: "+result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{


	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{


	}

	public void onStart(ITestContext context) 
	{


	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("*********Test Completed: "+context.getName());

	}

}
