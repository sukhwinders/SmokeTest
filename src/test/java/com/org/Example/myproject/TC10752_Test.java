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

public class TC10752_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String tpgName = "Verify TPG Request" + d;

	String firstwindow;
	String secondwindow;
	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	WebDriver driver;
	String baseUrl =  "https://login.salesforce.com";

	//String FormName="California Transparency of Supply Chain Act";
	
	String container_Name = "Testcontainer" + d;
	String Layout_Name = "QA_Testlayout" + d;
	String Tab_Name = "Testtab" + d;
	String Section_Name = "Testsection" + d;
	
	String FormName=container_Name;
	String PartialReq = "Testcontainer";
	
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
		CreateNewForm();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]")).click();
		Thread.sleep(3000);
		
// Creating New Trading Partner Group 				
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		
		driver.findElement(By.id("txtGroupName")).sendKeys(tpgName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'qa1')]")).click();
		//driver.findElement(By.xpath("//span[contains(.,'Refresh')]")).click();
		Thread.sleep(2000);
		
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
		if(driver.findElement(By.xpath("//span[@title='Show more actions for this record']")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[@title='Show more actions for this record']")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//a[@title='Set Requirements']")).click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("RequestType0")))
		.selectByVisibleText("All");
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("DocType0")))
		.selectByVisibleText(FormName);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[4]/span"))).click().build().perform();
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
		Thread.sleep(50000);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(3000);
		
// Search For Requests
		driver.findElement(By.xpath("//input[@title='Search Salesforce']")).sendKeys(FormName);
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath("//input[@title='Search Salesforce']"));
		Thread.sleep(3000);
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.partialLinkText(FormName)).click();
	}
	public void CreateNewForm() throws InterruptedException
	{
		guitils.CreateContaniner(driver, container_Name);
		guitils.CreateLayout(driver, Layout_Name);		
		guitils.AddTab(driver, Tab_Name);
		guitils.AddSection(driver, Section_Name);
		guitils.AddLinkedQuestion(driver);
		guitils.LightiningView(driver);
	}
}	