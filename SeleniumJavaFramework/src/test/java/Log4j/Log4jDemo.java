package Log4j;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;

public class Log4jDemo {

	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) 
	{

		System.out.println("Hello World   \n");	
		
		log.trace("This is the trace message");
		log.info("This is the information message");
		log.error("This is the information message");
		log.warn("This is the warn message");
		log.fatal("This is the fatal message");
		
		System.out.println("\n   Completed");
	}

}
