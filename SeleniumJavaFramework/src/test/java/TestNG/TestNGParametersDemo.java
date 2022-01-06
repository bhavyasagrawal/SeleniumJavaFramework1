package TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNGParametersDemo 
{
	@Parameters({"MyName"})
	@Test
	public void test(@Optional("Demo") String name) 
	{
		System.out.println("Name is: "+name);
	}

}
