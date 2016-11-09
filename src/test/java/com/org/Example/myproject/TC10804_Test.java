package com.org.Example.myproject;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC10804_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String tpgName = "AutoSendReqsAddMembers" + d;

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
	public void Aut0SendReqsAddMembers() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]")).click();
		Thread.sleep(3000);

// Creating New Trading Partner Group with no members				
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.id("txtGroupName")).sendKeys(tpgName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'Test 100')]")).click();
		
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
		Thread.sleep(6000);
		
// Set Requirements then save		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'Set Requirements')]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(4000);

		Select dropdown1 = new Select(driver.findElement(By.id("RequestType0")));
		dropdown1.selectByVisibleText("All");
		Thread.sleep(3000);		
		Select dropdown = new Select(driver.findElement(By.id("DocType0")));
		dropdown.selectByVisibleText("Attempt_3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input")).click();		
		driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[7]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();

// 	Edit Trading Partner Group to add  members
		driver.findElement(By.xpath("//div[@title='Edit']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(4000);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[contains(.,'Test 100')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'GFSI Certified')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(3000);
		driver.findElement(By
				.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		driver.switchTo().defaultContent(); 
		driver.manage().deleteAllCookies();
		Thread.sleep(8000);

// verify Request is sent
		guitils.LightiningView(driver); 
		WebElement we = driver.findElement(By.
		xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", we);
		Thread.sleep(3000);
		
		 driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys("Attempt_3");
		 Thread.sleep(3000);
		 WebElement webElement2 = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		 Thread.sleep(3000);
		 webElement2.sendKeys(Keys.ENTER);
		 Thread.sleep(3000); 
		 driver.findElement(By.partialLinkText("Attempt_3")).click();
		 Thread.sleep(4000);
		 
		 List<WebElement> related = driver.findElements(By.cssSelector("span.title"));
		 related.get(1).click();

		 //driver.findElement(By.xpath("//div[4]/div/div/div[2]/div/div/div/div/ul/li/a/span[2][contains(.,'Related')]")).click();
		 Thread.sleep(4000);         
		 List<WebElement> workflows = driver.findElements(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div/section[2]/div/div/div/article[1]/div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th"));	
		 if(workflows.size()>0){
			 workflows.get(0).click();
		 }
		 Thread.sleep(5000);

		 String WfStatus =  driver.findElement(By.xpath("//span[contains(.,'Workflow Status')]/following::span[2]")).getText();
		 System.out.println("Request Status:"+WfStatus);
		 Assert.assertEquals(WfStatus, "Open");
		 
		 String ReqStatus =  driver.findElement(By.xpath("//span[contains(.,'Request Status')]/following::span[2]")).getText();
		 System.out.println("Request Status:"+ReqStatus);
		 Assert.assertEquals(ReqStatus, "New");
		 
		 
		
	}
}	