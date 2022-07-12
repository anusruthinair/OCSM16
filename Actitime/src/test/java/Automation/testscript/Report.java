package Automation.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Automation.genericLib.BaseClass;

public class Report extends BaseClass {
	@Test
	public void tilte()
	{
		driver.findElement(By.cssSelector(".content.reports")).click();
		System.out.println(driver.getTitle());
	}

}
