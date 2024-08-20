package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	public static void takeScreenShot(WebDriver driver, String fileName) throws IOException
 {

	 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 //File dest = new File(System.getProperty("user.dir") + "\\screenshot\\" +fileName + ".png");
	 Reporter.log("taking Screenshot",true);
	 File dest = new File(System.getProperty("user.dir") + "\\coverfoxscreenshot\\" +fileName + ".png");
     FileHandler.copy(src, dest);
     Reporter.log("saving file at location"+dest,true);
 }

	public static String readDataFromExcel(String filePath, String sheetName, int rowNum,int cellNum) throws EncryptedDocumentException, IOException
{
	FileInputStream myFile = new FileInputStream(filePath);
	String value =WorkbookFactory.create(myFile).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

	return value;
	}
	public static String readDataFromPropertiesFile(String key) throws IOException 
	{
	 FileInputStream myFile = new FileInputStream(System.getProperty("user.dir") +"//coverfoxdata.properties");

	 Properties prop = new Properties();
	 prop.load(myFile);
	 Reporter.log("Reading data from property file"+key,true);
	 String value = prop.getProperty(key);
	 return value;
	}
	

}
