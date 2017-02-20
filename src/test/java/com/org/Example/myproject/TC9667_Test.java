package com.org.Example.myproject;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ModuleLocatorRepository.TPGroupCompRepo;

import com.utils.Data_loading_Old;
/* Verify Create a New Product Group  */

public class TC9667_Test {
	WebDriver driver;
	String baseUrl;
	Date d = new Date(System.currentTimeMillis());
	String Group = "Productgroup " + d;

	Data_loading_Old guitils = new Data_loading_Old();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	//String partner_name = guitils.getDATA("Partner_name");

	@BeforeClass
	 public void beforeClass() {  
	  driver = guitils.openBrowser(driver);
	 }

	@AfterClass
	public void afterClass() {
		//guitils.logoutFromPortal(driver);
		driver.quit();
	}

	@Test
	public void Productgroup() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		
		WebElement wb = driver.findElement(By.linkText("Product Groups"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",wb);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(4000);
		List<WebElement> frame1=driver.findElements(By.tagName("iframe"));
		System.out.println(frame1.size());
		
		if(frame1.size()>1)
		{
			driver.switchTo().frame(frame1.get(1));
		}
		else
		{
			driver.switchTo().frame(frame1.get(0));
		}


		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtGroupName'][@type='text']")).sendKeys(Group);
//		driver.findElement(By.id("txtGroupName")).sendKeys(Group);
		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]"))
				.click();
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		/*String msg = driver.findElement(By.xpath(TPGroupCompRepo.successMsg)).getText();
		Assert.assertTrue(msg.contains("Group saved successfully."));*/
       /* driver.navigate().refresh();
		Thread.sleep(4000);*/
		//driver.findElement(By.linkText(Group)).click();
	//	driver.findElement(By.xpath(".//a[contains(@title,'"+Group+"')]")).click();

	}

}
