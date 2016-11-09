package com.org.Example.myproject;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC10807_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String tpgName = "Send Multiple requirements" + d;

	String firstwindow;
	String secondwindow;
	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	WebDriver driver;
	String baseUrl =  "https://login.salesforce.com";

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		//guitils.logoutFromPortal(driver);
		driver.quit();
	}

	@Test
	public void Send_Multiple_Requirements() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]")).click();
		Thread.sleep(3000);
// Creating New Trading Partner Group 	 			
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		driver.findElement(By.id("txtGroupName")).sendKeys(tpgName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'GFSI Certified')]")).click();
		//driver.findElement(By.xpath("//span[contains(.,'Refresh')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(5000);
		driver.findElement(By
				.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//a[contains(@title,'"+tpgName+"')]")).click();
		driver.manage().deleteAllCookies();
		Thread.sleep(8000);

// Set Requirements 		
		//driver.findElement(By.xpath("//span[@title='Show more actions for this record']")).click();
		driver.findElement(By.xpath("//a[@title='Set Requirements']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(4000);
		Select dropdown1 = new Select(driver.findElement(By.id("RequestType0")));
		dropdown1.selectByVisibleText("All");
		Thread.sleep(3000);		
		Select dropdown = new Select(driver.findElement(By.id("DocType0")));
		dropdown.selectByVisibleText("BSE Statement");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input")).click();		
		driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[4]/span")).click();
		Thread.sleep(3000);
		
		// add new requirement
		driver.findElement(By.xpath("html/body/form/div[2]/div[2]/button")).click();
		Thread.sleep(5000);
		
		Select dropdown2 = new Select(driver.findElement(By.id("RequestType1")));
		dropdown2.selectByVisibleText("All");
		Thread.sleep(3000);		
		Select dropdown3 = new Select(driver.findElement(By.id("DocType1")));
		dropdown3.selectByVisibleText("Alcoholic Beverage Control License");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/form/div[2]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input")).click();		
		driver.findElement(By.xpath("html/body/form/div[2]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[4]/span")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("btnSend")).click();
		Thread.sleep(50000);
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		Thread.sleep(50000);
		driver.switchTo().defaultContent();
		guitils.logoutFromPortal(driver);
		Thread.sleep(50000);
// check the requirements
		guitils.loginToPortal(userName2, password2, driver);
		Thread.sleep(50000);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys("BSE Statement");
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		Thread.sleep(3000);
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.partialLinkText("BSE Statement")).click();
		
		
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys("Alcoholic Beverage Control License");
		Thread.sleep(3000);
		WebElement webElement1 = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		Thread.sleep(3000);
		webElement1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.partialLinkText("Alcoholic Beverage Control License")).click();
	}
}
