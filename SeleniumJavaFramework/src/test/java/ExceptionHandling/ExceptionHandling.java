package ExceptionHandling;

public class ExceptionHandling {

	public static void main(String[] args) {

		try {
			demo();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void demo() throws Exception
	{

		//try
	//	{
			System.out.println("Hellow World   ");
			throw new ArithmeticException("not valid operation");
			//int i = 1/0;
			//System.out.println("Completed");
		//}
		//catch(Exception e)
		//{
		//	System.out.println("I am in catch block");
		//	System.out.println("Message is: "+e.getMessage());
		//	System.out.println("Cause is: "+e.getCause());
		//	e.printStackTrace();
	//	}
		//finally
		//{
		//	System.out.println("I am in finally block");
		//}
	}

}
