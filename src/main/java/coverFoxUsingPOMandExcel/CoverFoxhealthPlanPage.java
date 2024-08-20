package coverFoxUsingPOMandExcel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxhealthPlanPage 
{
	//datamember------>webElements
	@FindBy(className="next-btn") private WebElement next_btn;
	
	//constuctor
	public CoverFoxhealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	//methods
	public void clickOnNextButton()
	{
		next_btn.click();
	}
	
}
