package com.org.Example.myproject;

import org.testng.annotations.AfterMethod;
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

public class TC9651_Test {

	WebDriver driver;
	String baseUrl;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Postalcode = guitils.getDATA("PostalCode");

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@Test
	public void testSearchByIcixId() throws Exception {

		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		driver.findElement(By.cssSelector("div.slds-icon-waffle")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]")).click();
		Thread.sleep(3000);
		// New button
		/*driver.findElement(
				By.xpath("/html/body/div[6]/div[1]/section/div[1]/div[2]/div[4]/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/a"))
				.click();*/
		driver.findElement(By.xpath("//li//a//div[@title='New']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		driver.findElement(By.xpath("//input[@placeholder='Postal Code']"))
				.clear();
		driver.findElement(By.xpath("//input[@placeholder='Postal Code']"))
				.sendKeys(Postalcode);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--brand"))
				.click();
	//	String postasid = driver
		//		.findElement(
		//				By.xpath("//p[@class='slds-text-body--regular ng-binding'][3]"))
		//		.getText();

		//System.out.println(postasid);

	}

	@AfterMethod
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	
}
