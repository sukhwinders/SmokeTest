package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9663_Test {
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String partner_name = guitils.getDATA("Responder");

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void Edit_TradingPartner() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(
				By.xpath("//a[contains(.,'Trading Partner Relationships')]"))
				.click();
		driver.findElement(By.linkText(partner_name)).click();
		Thread.sleep(2000);
		/* driver.findElement(By.xpath("//a[contains(.,'Edit')]")).click(); */

		driver.findElement(
				By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div/div/div[1]/div/header/div[2]/div[1]/div/div[2]/ul/li[1]/a/div"))
				.click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		new Select(driver.findElement(By.id("ddl_UURelationship_Status")))
				.selectByVisibleText("Pending");
		new Select(driver.findElement(By
				.xpath("//select[@id='ddl_UURelationship_Type']")))
				.selectByVisibleText("Cold Storage");
		driver.findElement(By.id("btn_UPRelationship_Save")).click();
		driver.findElement(
				By.xpath("//message-dialog/div[2]/div/div/div[3]/button"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("img.profileTrigger")).click();
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(8000);

	}

}