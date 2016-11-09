package com.org.Example.myproject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		driver.findElement(By.xpath("//li//a//div[@title='New']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		driver.findElement(By.xpath("//input[@id='companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys(
				ICIX_ID);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand"))
				.click();
		//String ICIXID = driver.findElement(By.xpath("//p[contains(.,'ICIX ID:')]")).getText();
		Thread.sleep(3000);
		List <WebElement> partnerslist = driver.findElements(By.tagName("partner-match-card"));
		System.out.println(partnerslist.size());
		Assert.assertTrue(partnerslist.size()>0, "No Partners found");

	}

}
