package com.org.Example.myproject;

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

		guitils.loginToPortal(userName1, password1, driver);

		guitils.LightiningView(driver);

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
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("img.profileTrigger")).click();
		driver.findElement(By.linkText("Log Out")).click();

	}

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
