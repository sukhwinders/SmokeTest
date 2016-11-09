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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC10796_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String tpgName = "Verify request status" + d;

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
	public void TPG_Tags() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Group')]")).click();
		Thread.sleep(3000);
// Creating New Trading Partner Group 				
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		driver.findElement(By.id("txtGroupName")).sendKeys(tpgName);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[contains(.,'GFSI Certified')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'New1')]")).click();
		Thread.sleep(2000);
	    //driver.findElement(By.xpath("//a[@id='tab-scoped-1__item']")).click();
		//new Select(driver.findElement(By.id("ddlAttrStatus"))).selectByVisibleText("Pending");
		
		//Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='tab-scoped-2__item']")).click();
		//new Select(driver.findElement(By.id("ddlAttrType"))).selectByVisibleText("Agent");
		//Thread.sleep(2000);
		
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
	
// Set requirements
		driver.findElement(By.xpath("//a[@title='Set Requirements']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("RequestType0")))
		.selectByVisibleText("Form");
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("DocType0")))
		.selectByVisibleText("Attempt_2");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[6]/span"))).click().build().perform();
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("RequirementType0")))
				.selectByVisibleText("Approval");
		
		driver.findElement(By.xpath("//button[@id='btnSend']")).click();
		Thread.sleep(50000);
		driver.findElement(By.xpath("//button[@ng-click='CloseModalPopup();']")).click();
		Thread.sleep(50000);
		driver.switchTo().defaultContent();
		
// Logout 		
		guitils.logoutFromPortal(driver);
		Thread.sleep(50000); 
// Login to Responder org
		guitils.loginToPortal(userName2, password2, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(90000); 
		
// Search For Requests
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys("Attempt_2");
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		Thread.sleep(3000);
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.partialLinkText("Attempt_2")).click();
		
// submit request
		driver.findElement(By.xpath("//span[contains(.,'Related')][@class='title']")).click();
		//driver.findElement(By.xpath("//span[contains(.,'Workflows')][@class='header-label']")).click();
		driver.findElement(By.xpath("//div/div/div/article[1]/div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='Submit']")).click();
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.xpath("//button[@onclick='submitWorkflow()']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(50000);
		
// Logout 		
		guitils.logoutFromPortal(driver);
		Thread.sleep(50000);	
		
// Login to Requester org
		guitils.loginToPortal(userName1, password2, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(80000);
		
// Search For Requests
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys("Attempt_2");
		Thread.sleep(3000);
		WebElement webElement1 = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		Thread.sleep(3000);
		webElement1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.partialLinkText("Attempt_2")).click();	
		
// verify the request status (must be submitted)
		driver.findElement(By.xpath("//span[contains(.,'Related')][@class='title']")).click();
		//driver.findElement(By.xpath("//span[contains(.,'Workflows')][@class='header-label']")).click();
		driver.findElement(By.xpath("//div/div/div/article[1]/div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a")).click();
		Thread.sleep(3000);
	//	driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		String Status = driver.findElement(By.xpath("//div[4]/div[2]/div/div[2]/div")).getText();
	//	driver.switchTo().defaultContent();
		Assert.assertEquals(Status, "Submitted");	
//remove the requirement 
		driver.findElement(By.cssSelector("div[class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Group')]")).click();
	
		// Search For tpg
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys(tpgName);
		Thread.sleep(3000);
		WebElement webElement2 = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		Thread.sleep(3000);
		webElement2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.linkText(tpgName)).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@title='Set Requirements']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/form/div[1]/div[6]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@ng-click='CloseModalPopup();']")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
// Again verify the request status (must be closed)		
		driver.findElement(By.cssSelector("div[class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys("Attempt_2");
		Thread.sleep(3000);
		
		WebElement webElement3 = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		Thread.sleep(3000);
		webElement3.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.linkText("Attempt_2")).click();
		
		driver.findElement(By.xpath("//span[contains(.,'Related')][@class='title']")).click();
		//driver.findElement(By.xpath("//span[contains(.,'Workflows')][@class='header-label']")).click();
		driver.findElement(By.xpath("//div/div/div/article[1]/div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a")).click();
		Thread.sleep(3000);
		String Status2 = driver.findElement(By.xpath("//div[4]/div[2]/div/div[2]/div")).getText();
		Assert.assertEquals(Status2, "Closed");
		
	} 
}
