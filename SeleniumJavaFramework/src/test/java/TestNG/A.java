package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class A
{
  @Test
  public void f() 
  {
	  System.out.println("Developer A");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("Client A");
  }
 

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("Tester A");
  }

}
