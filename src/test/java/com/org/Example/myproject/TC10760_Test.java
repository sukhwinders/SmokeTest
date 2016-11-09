package com.org.Example.myproject;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC10760_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String tpgName = "Relationship Status In-Active" + d;

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
		guitils.logoutFromPortal(driver);
		driver.quit();
	}

	@Test
	public void SendRequestToInActiveTPStatus() throws Exception {
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
		driver.findElement(By.xpath("//a[contains(.,'Status')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Inactive')]")).click();
		driver.findElement(By.xpath(".//*[@id='icnMoveRight']")).click();
		
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(3000);
		driver.findElement(By
				.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		WebElement rateElement = driver.findElement(By.linkText(tpgName));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);

//Set Requirements then send	
		//driver.findElement(By.xpath("//span[@alt='Show more actions for this record']")).click();
		driver.findElement(By.xpath("//a[@title='Set Requirements']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("RequestType0")))
		.selectByVisibleText("All");
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("DocType0")))
		.selectByVisibleText("BSE Statement");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[6]/span"))).click().build().perform();
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("RequirementType0")))
				.selectByVisibleText("Approval");
		
		driver.findElement(By.xpath("//button[@id='btnSend']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@ng-click='CloseModalPopup();']")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
// Logout 		
		guitils.logoutFromPortal(driver);
// Login to Responder org
		guitils.loginToPortal(userName2, password2, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(3000);
				
// Search For Requests
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys("BSE Statement");
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		Thread.sleep(3000);
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.partialLinkText("BSE Statement"))
				.click();
		
	}
}
