package coverFoxUsingPOMandExcel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage 
{
	@FindBy(id="Age-You")private WebElement ageDropDown;
	@FindBy(className="next-btn")private WebElement next_button;
	
	public CoverFoxMemberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void handleAgeDropDown(String age)
	{
	  Select s=new Select(ageDropDown);
	  s.selectByValue(age +"y");
	  Reporter.log("selecting age",true);
	}
    
	public void clickOnNextButton()
	{
		next_button.click();
		Reporter.log("click on next button",true);
	}
	
}
