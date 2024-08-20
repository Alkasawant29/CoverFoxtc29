package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxUsingPOMandExcel.CoverFoxAdressDetailsPage;
import coverFoxUsingPOMandExcel.CoverFoxHomePage;
import coverFoxUsingPOMandExcel.CoverFoxMemberDetailsPage;
import coverFoxUsingPOMandExcel.CoverFoxResultPage;
import coverFoxUsingPOMandExcel.CoverFoxhealthPlanPage;
import coverFoxUtility.Utility;

@Listeners(coverFoxUtility.Listener.class)
public class Listerner extends Base 
{
	CoverFoxHomePage homePage;
	CoverFoxhealthPlanPage healthPlan;
	CoverFoxAdressDetailsPage addressPage;
	CoverFoxMemberDetailsPage memberePage;
	CoverFoxResultPage resultPage;
	String Filepath;
    public static Logger logger;
	@BeforeTest
	public void launchBrowser()
	{
		openBrowser();
		logger= Logger.getLogger("coverFox");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("opening Browser");
		homePage = new CoverFoxHomePage(driver);
		healthPlan = new CoverFoxhealthPlanPage(driver);
		addressPage = new CoverFoxAdressDetailsPage(driver);
		memberePage= new CoverFoxMemberDetailsPage(driver);
		resultPage = new CoverFoxResultPage(driver);
		Filepath = "d:\\excel\\Stringdata.xlsx";
	}
	@BeforeClass
	public void preconditions() throws InterruptedException, IOException 
	{
		
		      // Home-Page
				Thread.sleep(1000);
				homePage=new CoverFoxHomePage(driver);
				homePage.clickOnGenderButton();
				logger.info("clicking on Gender Button");

				// Health-Plan Page
				Thread.sleep(2000);
				healthPlan=new CoverFoxhealthPlanPage(driver);
				healthPlan.clickOnNextButton();
				logger.info("clicking on next Button");

				// Member-details Page
				
	Thread.sleep(2000);
				memberePage =new CoverFoxMemberDetailsPage(driver);
		        
		        memberePage.handleAgeDropDown(Utility.readDataFromPropertiesFile("age"));
		        logger.warn("age should be between 18 to 90");
		   	     logger.info("age is selected");
				memberePage.clickOnNextButton();
				logger.info("clicking on next Button");
				

				Thread.sleep(2000);

				// Address-Details Page
				addressPage=new CoverFoxAdressDetailsPage(driver);
				addressPage.enterPincode(Utility.readDataFromPropertiesFile("pincode"));
				logger.warn("enter valid pincode");
				logger.info("entering pincode");
				addressPage.enterMobileNumber(Utility.readDataFromPropertiesFile("mobno"));
				logger.warn("enter valid mobile number");
				 logger.info("entering mobileno");
				addressPage.clickONNextButton();
				logger.info("click on next button");
	Thread.sleep(2000);
	}
	@Test
	public void validationBanners() throws InterruptedException
	{
		Thread.sleep(4000);
		//Assert.fail();
		int bannerPlanNumber= resultPage.getPlanNumersFromBanners();
		int StringPlanNumbers = resultPage.getPlanNumersFromString();
		Assert.assertEquals(StringPlanNumbers,bannerPlanNumber,"Plan on banners not matching with result,TC failed");
		logger.info("validating banners");
	}
	@Test
	public void ChecksortPlan() throws InterruptedException 
	{
		
		Thread.sleep(4000);
		//Assert.fail();
		Assert.assertTrue(resultPage.is_displaySortPlan(),"Sort plan Dropdown is not display,TC is fail");
		logger.info("validating presence of sort plan");
	
		
	}
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();	
		Reporter.log("closing browser",true);
		logger.info("closing browser");
	}	
		
	}


