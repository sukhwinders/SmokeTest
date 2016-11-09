package com.org.Example.myproject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9667_Test {
	WebDriver driver;
	String baseUrl;
	Date d = new Date(System.currentTimeMillis());
	String Group = "Productgroup" + d;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String partner_name = guitils.getDATA("Partner_name");

	@BeforeClass
	 public void beforeClass() {  
	  driver = guitils.openBrowser(driver);
	 }

	@AfterClass
	public void afterClass() {
		guitils.logoutFromPortal(driver);
		driver.quit();
	}

	@Test
	public void Productgroup() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.linkText("Product Groups")).click();
		WebElement wb = driver.findElement(By.linkText("Product Groups"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",wb);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtGroupName']")).sendKeys(Group);
		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]"))
				.click();
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		driver.findElement(		By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		Thread.sleep(2000);

		//driver.switchTo().defaultContent();
		WebElement we1 = driver.findElement(By.linkText("App Launcher"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",we1);
		
		//driver.findElement(By.linkText("App Launcher")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@title='ICIX']")).click();
		//driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Product Groups")).click();
		WebElement we2 = driver.findElement(By.linkText("Product Groups"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",we2);
		Thread.sleep(3000);
		driver.navigate().refresh();
		//driver.findElement(By.linkText(Group)).click();
		driver.findElement(By.xpath(".//a[contains(@title,'"+Group+"')]")).click();

	}

}
