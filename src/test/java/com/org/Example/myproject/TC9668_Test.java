package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Date;
import java.util.List;
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

public class TC9668_Test {
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
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.linkText("Product Groups")).click();
		WebElement we = driver.findElement(By.linkText("Product Groups"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",we);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
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
		driver.findElement(By.xpath("//input[@id='txtGroupName']")).clear();
		driver.findElement(By.xpath("//input[@id='txtGroupName']")).sendKeys(
				Group);

		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]"))
				.click();
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		//driver.findElement(By.linkText("App Launcher")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//driver.findElement(By.linkText("Product Groups")).click();
		WebElement we1 = driver.findElement(By.linkText("Product Groups"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",we1);
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.findElement(By.linkText(Group)).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("div[title=\"Edit\"]")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]"))
				.click();
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();

	}

}