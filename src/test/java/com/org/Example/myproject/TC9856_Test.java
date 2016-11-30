package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9856_Test {
	
	Data_loading guitils = new Data_loading();	
	String ReqUserName = guitils.getUserName("RequestorUsername");
	String ReqPassword = guitils.getPassword("RequestorPassword");	
	String RespUserName = guitils.getUserName("ResponderUsername");
	String RespPassword = guitils.getPassword("ResponderPassword");
	WebDriver driver;	

	@BeforeClass
	public void beforeClass() {
		guitils.InitilizeBrowser();
	}

	@AfterClass
	public void afterClass() {	
		//driver.quit();
	}

	@Test
	public void Reject_Request() throws Exception {
		guitils.loginToSalesForce(ReqUserName, ReqPassword);		
		guitils.SalesForceLightiningView();		
				
		CreateNewForm();
		Thread.sleep(5000);
		guitils.SendRequest();
		
		// code for logout
		guitils.logoutSalesForce();
		
		int RejectCounter;
		String RejectComments;
		
		// Loop to reject the request four times
		for(RejectCounter=1;RejectCounter<=4;RejectCounter++)
		{
			
			guitils.loginToSalesForce(RespUserName, RespPassword);	
			Thread.sleep(3000);
			guitils.SalesForceLightiningView();	
			Thread.sleep(5000);
			
			RejectComments="Rejection - " + RejectCounter;
			guitils.FillFormAndSubmitRequest();	
			
			// logout responder
			guitils.logoutSalesForce();
			Thread.sleep(5000);

			// login by requester
			guitils.loginToSalesForce(ReqUserName, ReqPassword);		
			guitils.SalesForceLightiningView();	
			
			guitils.RejectRequest(RejectComments);
			
			if (RejectCounter<=3)
			{
				Thread.sleep(3000);
				guitils.logoutSalesForce();
				Thread.sleep(5000);
			}			
		}		
				
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.navigate().refresh();	
			
		Thread.sleep(6000);
		//guitils.loginToSalesForce(ReqUserName, ReqPassword);		
		//guitils.SalesForceLightiningView();	
		driver=guitils.SearchReqAndAssignDriver();
		Thread.sleep(5000);
		
		//Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'Workflow Status')]/following::span[2]")).getText(), "Status is not getting Changed");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'Workflow Status')]/following::span[2]")).getText(), "Closed","Workflow status is not closed");
		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'Request Status')]/following::span[2]")).getText(), "Rejected","Request status is not approved");
		
		}
	
	public void CreateNewForm() throws InterruptedException
	{
		guitils.CreateContaniner();
		guitils.CreateLayout();		
		guitils.AddTab();
		guitils.AddSection();
		guitils.AddLinkedQuestion();
		guitils.SalesForceLightiningView();
	}
}
