package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br)
	{
		if(br.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		
		
		rb=ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(this.getClass());
		
		logger.info("Launching the browser");
		driver.manage().deleteAllCookies();
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		logger.info("Closing the browser");
	}
	
	public String randomGeneratedString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomGeneratedNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+generatednumber);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
}
