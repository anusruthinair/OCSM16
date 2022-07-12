package Automation.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Automation.genericLib.BaseClass;
import Automation.genericLib.DataUtility;
@Listeners(Automation.genericLib.ListenerImplementation.class)
public class CreateCustomerTest extends BaseClass {
	@Test
	public void createCust() throws EncryptedDocumentException, IOException
	{
		Random r=new Random();
		int num=r.nextInt(10000);
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsi")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.className("newNameField")).sendKeys(du.getDataFromExcelsheet("Sheet1",0, 0)+num);
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		System.out.println("customer created");
		Reporter.log("created the customer successfully",true);
		
		}
}





