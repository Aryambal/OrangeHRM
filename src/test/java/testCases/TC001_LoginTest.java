package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass
{
	
	@Test
	public void loginTest() 
	{
		try
		{
			
		logger.info("-------Starting Login Test---------");	
		LoginPage LP=new LoginPage(driver);
		LP.setUsername(rb.getString("email"));
		LP.setPassword(rb.getString("pwd"));
		LP.clickLogin();
		
		HomePage HP=new HomePage(driver);
		
		if(HP.hdrText().equals("Dashboard"))
		{
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		
		}
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
		
		logger.info("----------Finished Login Test----------");
		
	}
	
	
	
	
}
