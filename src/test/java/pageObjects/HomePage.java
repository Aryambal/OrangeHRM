package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//h6[normalize-space()='Dashboard']")
	WebElement hdrtext;
	
	public String hdrText()
	{
		return(hdrtext.getText());
	}
	
}
