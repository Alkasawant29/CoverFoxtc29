package coverFoxTest;

import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coverFoxBase.Base;

import coverFoxUsingPOMandExcel.CoverFoxAdressDetailsPage;
import coverFoxUsingPOMandExcel.CoverFoxHomePage;
import coverFoxUsingPOMandExcel.CoverFoxMemberDetailsPage;
import coverFoxUsingPOMandExcel.CoverFoxResultPage;
import coverFoxUsingPOMandExcel.CoverFoxhealthPlanPage;
import coverFoxUtility.Utility;
import dev.failsafe.internal.util.Assert;


public class CoverFoxTC1 extends Base
{
	CoverFoxHomePage homePage;
	CoverFoxhealthPlanPage healthPlanPage;
	CoverFoxAdressDetailsPage addressDetailsPage;
	CoverFoxMemberDetailsPage memberDetailsPage;

	CoverFoxResultPage resultPage;
	String filePath;
	@BeforeTest
	public void launchBrowser() 
	{
	 openBrowser();
     homePage = new CoverFoxHomePage(driver);
	 healthPlanPage = new CoverFoxhealthPlanPage(driver);
	 addressDetailsPage = new CoverFoxAdressDetailsPage(driver);
	 memberDetailsPage = new CoverFoxMemberDetailsPage(driver);
	 resultPage = new CoverFoxResultPage(driver);
	 filePath = "C:\\Users\\LENOVO\\Documents\\Excelsheet\\excelTest.xlsx";
	}
	@BeforeClass
	public void preConditions() throws InterruptedException, EncryptedDocumentException, IOException 
	{
     homePage.clickOnGenderButton();
     Thread.sleep(1000);
	 healthPlanPage.clickOnNextButton();
	 Thread.sleep(1000);
	 memberDetailsPage.handleAgeDropDown(coverFoxUtility.Utility.readDataFromExcel(filePath, filePath, 0, 0));
	 memberDetailsPage.clickOnNextButton();
	 Thread.sleep(1000);
	 addressDetailsPage.enterPincode(Utility.readDataFromExcel(filePath, " ",0, 1));
	 addressDetailsPage.enterMobileNumber(Utility.readDataFromExcel(filePath," ", 0, 2));
     addressDetailsPage.clickONNextButton();
     
	}
	
	@Test
	public void validateBanners() throws InterruptedException 
	{
	 Thread.sleep(4000);
	 int bannerPlanNumbers = resultPage.getPlanNumersFromBanners();
	 int StringplanNumbers = resultPage.getPlanNumersFromString();
	 org.testng.Assert.assertEquals(StringplanNumbers, bannerPlanNumbers,"Plans on banners not matching with results, TC failed");

	}
	
	@Test
	public void validatePresenceOfSortButton() throws IOException, InterruptedException 
	{
     Thread.sleep(4000);
	 org.testng.Assert.assertTrue(resultPage.is_displaySortPlan(), "Sort Plan filter is not displayed,TC is failed");
     Utility.takeScreenShot(driver, "validatePresenceOfSortButton");
	
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException 
	{
	browserClose();
	
	}
}
