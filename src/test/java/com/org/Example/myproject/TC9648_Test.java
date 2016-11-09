package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9648_Test {

	WebDriver driver;
	//String baseUrl;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Partner = guitils.getDATA("CompenyName");
	String baseUrl =  "https://login.salesforce.com";

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void SearchByCompanyName() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(8000);
		// switchtoLightining();
		guitils.LightiningView(driver);
		//Thread.sleep(3000);
		//driver.findElement(By.linkText("ICIX")).click();

		//driver.findElement(By.cssSelector("div.list > ul > li > a")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]")).click();
		Thread.sleep(5000);
		// New button
		/*driver.findElement(
				By.xpath("/html/body/div[6]/div[1]/section/div[1]/div[2]/div[4]/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/a"))
				.click();*/

		 //driver.findElement(By.xpath("//div[@class='topRightHeaderRegion']/div/div/ul/li[1]/a")).click();
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.xpath("//a[@title='New']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Additional information")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys(Partner);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand"))
				.click();
		String company_Name = driver.findElement(
				By.xpath("//h1[@class='slds-text-heading--small']"))
				.getText();
		Assert.assertEquals(company_Name, Partner, "Name is not matched");

	}

}
