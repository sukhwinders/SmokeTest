package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9649_Test {

	WebDriver driver;
	String baseUrl;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String ICIX_ID = guitils.getDATA("ICIX_ID");

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
	public void testSearchByIcixId() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Accounts")).click();
		Thread.sleep(3000);
		// New button
		driver.findElement(By.linkText("New")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));

		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(
				ICIX_ID);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand"))
				.click();
		String ICIXID = driver.findElement(
				By.xpath("//b[contains(.,'ICIX ID:')]")).getText();
		System.out.println(ICIXID);

	}

}
