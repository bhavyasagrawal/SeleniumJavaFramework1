package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}
	public static void getProperties()
	{
		try {


			InputStream input = new FileInputStream(projectPath+"/src/test/java/Config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);

		} 
		catch (Exception e) {
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();
		}

	}

	public static void setProperties() 
	{
		try {
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/Config/config.properties");
			prop.setProperty("browser", "chrome"); 
			prop.store(output, null);
		}
		catch (Exception e) {
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();
		}

	}

}
