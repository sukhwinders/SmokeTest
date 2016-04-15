package com.org.Example.myproject;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.utils.Data_loading;


public class Tp_createrequestTest  {
 
  Date d = new Date(System.currentTimeMillis());
	String Reqname			="AutoTest"+d;
	String firstwindow;
	String secondwindow;
	
	 Data_loading guitils = new Data_loading();
	 String userName1 = guitils.getUserName("RequestorUsername");
	 String password1 = guitils.getPassword("RequestorPassword");
	 String Responder = guitils.getDATA("TPResponder");
	
	
	WebDriver driver;
	 String baseUrl; 
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
  public void testTp() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys(userName1);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(password1);
    driver.findElement(By.id("Login")).click();
    driver.findElement(By.cssSelector("div.icon-waffle")).click();
    driver.findElement(By.linkText("ICIX")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Requests')]")).click();
    Thread.sleep(2000);
    Set<String> window=driver.getWindowHandles();
    Iterator<String> iter=window.iterator();
    firstwindow=iter.next();
    driver.findElement(By.xpath("//div[contains(@title,'New')]")).click();
    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
    Thread.sleep(2000);
    driver.findElement(By.id("requestName")).clear();
    driver.findElement(By.id("requestName")).sendKeys(Reqname);
    driver.findElement(By.id("tradingPartnerDropDown")).clear();
    driver.findElement(By.id("tradingPartnerDropDown")).sendKeys(Responder);
    driver.findElement(By.cssSelector("h3.ng-binding")).click();
   
    driver.findElement(By.cssSelector("button.slds-button.slds-button--neutral")).click();
    driver.findElement(By.xpath("//a[contains(@ng-click,'populateDocTemplate(d.name);')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
    driver.findElement(By.xpath("//div[3]/div/label/span[2]")).click();
    driver.findElement(By.cssSelector("div.slds-modal__footer.slds-modal__footer--directional > button.slds-button.slds-button--brand")).click();
    driver.findElement(By.xpath("//button[3]")).click();
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='date']")).click();
    driver.findElement(By.xpath("//div[2]/button")).click();
    driver.findElement(By.xpath("//span[contains(.,'1')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.slds-button.slds-button--neutral")).click();
    driver.findElement(By.xpath("//button[@ng-click='CancelAttachDialog()']")).click();
  
    driver.findElement(By.id("comments")).sendKeys("Test");
    Thread.sleep(2000);

    driver.findElement(By.xpath("//button[contains(.,'Send')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@ng-click='redirectToRequestListPage();']")).click();
    Thread.sleep(10000);
    driver.findElement(By.linkText(Reqname)).click();
    Thread.sleep(6000);

  }
  }

  