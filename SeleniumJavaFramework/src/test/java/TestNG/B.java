package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class B {
  @Test
  public void f() { System.out.println("Developer B");
  }
  @BeforeTest
  public void beforeTest() { System.out.println("Client B");
  }

  @AfterTest
  public void afterTest() { System.out.println("Tester B");
  }

}
