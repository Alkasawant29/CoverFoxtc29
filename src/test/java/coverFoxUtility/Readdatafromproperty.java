package coverFoxUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readdatafromproperty
{
public static void main(String[] args) throws IOException 
{
	FileInputStream myFile = new FileInputStream(System.getProperty("user.dir") +"//Coverfoxadu.properties");

	 Properties prop = new Properties();
	 prop.load(myFile);
	 String value = prop.getProperty("age");
	System.out.println(value); 
	
}
}
