package com.org.Example.myproject;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;


public class Edit_TPgroupTest {
	 WebDriver driver;
	 String baseUrl; 
	 Date d = new Date(System.currentTimeMillis());
	 String Group ="Testgroup"+d;
	
	 Data_loading guitils = new Data_loading();
	 String userName1     = guitils.getUserName("RequestorUsername");
	 String password1     = guitils.getPassword("RequestorPassword");
	 String partner_name  = guitils.getDATA("Partner_name");
	
	@BeforeClass
	  public void beforeClass() {
		    baseUrl = "https://login.salesforce.com";      
	        driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.navigate().to(baseUrl);  
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

	@Test
	 public void test() throws Exception  {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName1);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector("div.r5")).click();
	    driver.findElement(By.linkText("ICIX")).click();
	    driver.findElement(By.linkText("Trading Partner Groups")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@title='New']")).click();
	    driver.switchTo().frame(0);
	    driver.findElement(By.id("txtGroupName")).clear();
	    driver.findElement(By.id("txtGroupName")).sendKeys(Group);
	    driver.findElement(By.id("cbTaga0461000003eSHgAAM")).click();
	    driver.findElement(By.cssSelector("span.slds-checkbox--faux")).click();
	    driver.findElement(By.id("tab-scoped-1__item")).click();
	    new Select(driver.findElement(By.id("ddlAttrStatus"))).selectByVisibleText("Active");
	    driver.findElement(By.id("tab-scoped-2__item")).click();
	    new Select(driver.findElement(By.id("ddlAttrType"))).selectByVisibleText("Co-man");
	    Thread.sleep(2000);
	    driver.findElement(By.id("btnSave")).click();
	    driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
	    driver.navigate().refresh();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.cssSelector("div.r5")).click();
	    driver.findElement(By.linkText("ICIX")).click();
	    driver.findElement(By.linkText("Trading Partner Groups")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.linkText(Group)).click();
	   Thread.sleep(3000);
	   
	   driver.findElement(By.cssSelector("div[title=\"Edit\"]")).click();
	   driver.switchTo().frame(1);
       driver.findElement(By.xpath("//a[@tabindex='1']")).click();
       new Select(driver.findElement(By.id("ddlAttrStatus"))).selectByVisibleText("Pending");
       driver.findElement(By.id("tab-scoped-2__item")).click();
       new Select(driver.findElement(By.id("ddlAttrType"))).selectByVisibleText("Warehouse");
       driver.findElement(By.id("btnSave")).click();
       driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
	   
	   	   
}
}