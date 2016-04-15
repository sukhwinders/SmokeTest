package com.org.Example.myproject;


import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.Data_loading;



public class Tp_groupTest  {

 Date d = new Date(System.currentTimeMillis());
	String 	Group		="Testgroup"+d;
	Data_loading guitils = new Data_loading();
	 String userName1 = guitils.getUserName("RequestorUsername");
	 String password1 = guitils.getPassword("RequestorPassword");
	
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
 public void test() throws Exception {
	 
   driver.findElement(By.id("username")).clear();
   driver.findElement(By.id("username")).sendKeys(userName1);
   driver.findElement(By.id("password")).clear();
   driver.findElement(By.id("password")).sendKeys(password1);
   driver.findElement(By.id("Login")).click();
   Thread.sleep(5000);
   driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
   driver.findElement(By.linkText("ICIX")).click(); 
   driver.findElement(By.linkText("Trading Partner Groups")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//div[@class='topRightHeaderRegion']/div/div/ul/li/a")).click();
   driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
   driver.findElement(By.id("txtGroupName")).clear();
   driver.findElement(By.id("txtGroupName")).sendKeys(Group);
   Thread.sleep(2000);
   driver.findElement(By.xpath("//span[@class='slds-checkbox--faux']")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//button[@class='slds-button ng-binding ng-scope']")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//div[3]/button")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
   Thread.sleep(3000);
   driver.navigate().refresh();
   Assert.assertTrue(driver.findElement(By.linkText(Group)).isDisplayed(), "TpGroup is not created");
   driver.findElement(By.linkText(Group)).click();
   Thread.sleep(5000);
 }

}
