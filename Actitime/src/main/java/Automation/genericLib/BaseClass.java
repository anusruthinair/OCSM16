package Automation.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Automation.elementRepository.LoginLocators;

public class BaseClass {
	public WebDriver driver;
	public static  WebDriver listenerdriver;
	public DataUtility du=new DataUtility();
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser()
	{
		
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			listenerdriver=driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void loginApp() throws IOException
	{
		driver.get(du.getDataFromproperties("url"));
		LoginLocators ll=new LoginLocators(driver);
		ll.login(du.getDataFromproperties("username"),du.getDataFromproperties("password"));
		
	}
	@AfterMethod(alwaysRun=true)
	public void logoutApp()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void close()
	{
		driver.close();
	}
}










