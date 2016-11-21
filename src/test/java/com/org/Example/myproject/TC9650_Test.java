package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9650_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Address = guitils.getDATA("Address");
	String City = guitils.getDATA("City");
	String State = guitils.getDATA("State");
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void testSearchByIcixId() throws Exception {

		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(5000);

		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.cssSelector("div.slds-icon-waffle")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]")).click();
		Thread.sleep(3000);
		// New button

		driver.findElement(By.xpath("//li//a//div[@title='New']")).click();
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

	/*	driver.findElement(By.xpath("//input[@placeholder='Street']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Street']"))
				.sendKeys(Address);*/
		driver.findElement(By.xpath("//input[contains(@placeholder,'Address1')]")).clear();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Address1')]")).sendKeys(Address);
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'City/Town')]")).sendKeys(
				City);
		driver.findElement(
				By.xpath("//input[contains(@ng-model,'avm.newPartner.address.state')]"))
				.sendKeys(State);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand"))
				.click();
	/*	String Stret = driver.findElement(
				By.xpath("//p[@class='slds-text-body--regular ng-binding']"))
				.getText();*/
	
		List<WebElement> Streetlist = driver.findElements(By.xpath("//div[1]//p[@class='slds-text-body--small ng-binding'][1]"));
		String Stret = Streetlist.get(0).getText();
		System.out.println(Stret);
		Assert.assertEquals(Stret, Address);
		
		//AssertJUnit.assertEquals(Stret, Address, "Name is not matched");

	}

}
