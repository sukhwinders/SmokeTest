package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9647_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Icixid = guitils.getDATA("icixid");

	@Test
	public void Auccount_verification() throws Exception {
		//Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(8000);

		// switchtoLightining();
		guitils.LightiningView(driver);

		Thread.sleep(3000);
		driver.findElement(By.linkText("ICIX")).click();

		driver.findElement(By.cssSelector("div.list > ul > li > a")).click();
		Thread.sleep(3000);
		// New button

		driver.findElement(
				By.xpath("//div[@class='topRightHeaderRegion']/div/div/ul/li[1]/a"))
				.click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));

		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();

		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(
				Icixid);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	
	}

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		guitils.logoutFromPortal(driver);
		driver.quit();
	}

	

}
