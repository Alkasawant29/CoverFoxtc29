package coverFoxUsingPOMandExcel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHomePage 
{
	//webElements=dataMembers
	@FindBy(xpath="//div[text()='Male']") private WebElement maleButton;
	
    //constructor
	public  CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
    //methods
	public void clickOnGenderButton()
	{
		maleButton.click();
	}

}
