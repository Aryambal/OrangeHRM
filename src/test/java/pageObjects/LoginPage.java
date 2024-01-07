package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(name="username")
	WebElement txtboxusername;
	
	@FindBy(name="password")
	WebElement txtboxpwd;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	public void setUsername(String email)
	{
		txtboxusername.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtboxpwd.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
	
}
