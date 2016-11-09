package com.org.Example.myproject;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9733_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String Reqname = "AutoTest" + d;	
	//String Reqname = "AutoTestWed Nov 09 13:00:44 IST 2016";

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
	String PartialReq = "AutoTest";
	String PartialContainer = "Testcontainer";

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {	
		driver.quit();
	}

	@Test
	public void Approve_Request() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(3000);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		
		CreateNewForm();
		Thread.sleep(5000);
		guitils.SendRequest(driver, Reqname, Responder, FormName, comment);
		
		// code for logout
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]")).click();
		driver.findElement(By.linkText("Log Out")).click();		
	
		//driver.get(baseUrl);
		guitils.loginToPortal(userName2, password2, driver);
		Thread.sleep(3000);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		
		guitils.FillFormAndSubmitRequest(driver, Reqname, comment,PartialContainer);	
			
		// logout responder
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]")).click();
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(5000);

		// login by requester
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(3000);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		
		guitils.ApproveRequest(driver, Reqname, PartialReq);
				
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.navigate().refresh();	
		Thread.sleep(20000);
		//Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'Workflow Status')]/following::span[2]")).getText(), "Status is not getting Changed");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'Workflow Status')]/following::span[2]")).getText(), "Closed","Workflow status is not closed");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'Request Status')]/following::span[2]")).getText(), "Approved","Request status is not approved");
		
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

