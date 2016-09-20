package com.org.Example.myproject;

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

public class TC10460_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String tpgName = "Test Tags Only" + d;

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
/*		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);*/
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
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(.,'Trading Partner Group')]")).click();
		Thread.sleep(3000);
		// Creating New Trading Partner Group 				
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		driver.findElement(By.id("txtGroupName")).sendKeys(tpgName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'GFSI Certified')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Refresh')]")).click();
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
		
		
	}
}	