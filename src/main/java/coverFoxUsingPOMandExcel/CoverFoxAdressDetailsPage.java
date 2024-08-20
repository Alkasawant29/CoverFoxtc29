package coverFoxUsingPOMandExcel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAdressDetailsPage 
{
	@FindBy(className="mp-input-text")private WebElement pincodebar;
	@FindBy(id="want-expert")private WebElement mobNumberField;
	@FindBy(className="next-btn")private WebElement next_button;
	
    public CoverFoxAdressDetailsPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    
    public void enterPincode(String pincodeValue)
    {
    	pincodebar.sendKeys(pincodeValue);
    	Reporter.log("select Pincode",true);
    }
    
    public void enterMobileNumber(String mobileNumber)
    {
    	mobNumberField.sendKeys(mobileNumber);
    	Reporter.log("select mobilenumber",true);
    }
    
    public void clickONNextButton()
    {
    	next_button.click();
    	Reporter.log("click on next button",true);
    }
    
    
    
    
    
}
