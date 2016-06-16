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

public class TC9652_Test {

	WebDriver driver;
	String baseUrl;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String TPname = guitils.getDATA("CompenyName");
	String TpAddress = guitils.getDATA("Address");

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
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
		driver.findElement(By.linkText("ICIX")).click();

		driver.findElement(By.cssSelector("div.list > ul > li > a")).click();
		Thread.sleep(3000);
		// New button
		// driver.findElement(By.xpath("/html/body/div[6]/div[1]/section/div[1]/div[2]/div[4]/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/a")).click();
		driver.findElement(
				By.xpath("//div[@class='topRightHeaderRegion']/div/div/ul/li[1]/a"))
				.click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.xpath("//input[@id='companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys(
				TPname);
		driver.findElement(By.xpath("//input[@placeholder='Street']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Street']"))
				.sendKeys(TpAddress);
		Thread.sleep(3000);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand"))
				.click();
		Thread.sleep(3000);
		String compeny_Name = driver.findElement(
				By.xpath("//h1[@class='slds-text-heading--small ng-binding']"))
				.getText();
		Assert.assertEquals(compeny_Name, TPname, "Name is not matched");
		String Stret = driver.findElement(
				By.xpath("//p[@class='slds-text-body--regular ng-binding']"))
				.getText();
		Assert.assertEquals(Stret, TpAddress, "Name is not matched");

	}

}
