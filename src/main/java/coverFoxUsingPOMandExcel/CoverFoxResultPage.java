package coverFoxUsingPOMandExcel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxResultPage 
{
	@FindBy(xpath="//div[text()='50 matching Health Insurance Plans']")private WebElement resultText;
	@FindBy(className="plan-card-container")private List<WebElement> banners;
	@FindBy(xpath = "//div[@class='title']")private WebElement sortPlan;
	public CoverFoxResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void resultOutput()
	{
		String[] ar=resultText.getText().split(" ");
		int result=Integer.parseInt(ar[0]);
		
		if(result==banners.size())
		{
			System.out.println("Result is matching with banners,TC Passed");
		}
		else
		{
			System.out.println("Result is not matching with banners,TC failed");
		}
	}
	public int getPlanNumersFromString()
	{
	 String ar[]=resultText.getText().split(" ");
	 int result = Integer.parseInt(ar[0]);
	 return result;
	}
	public int getPlanNumersFromBanners()
	{
	     List<WebElement> banners1 = banners;
		 int bannerSize=banners.size();
	     return bannerSize;
	}   
	public boolean is_displaySortPlan()
	{
		boolean CheckSortPlan = sortPlan.isDisplayed();
		return CheckSortPlan;
	}
	
}
