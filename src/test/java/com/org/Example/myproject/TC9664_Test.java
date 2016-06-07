package com.org.Example.myproject;


import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.Data_loading;



public class TC9664_Test  {

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
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
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
   guitils.LightiningView(driver);
   driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
   driver.findElement(By.linkText("ICIX")).click(); 
   driver.findElement(By.linkText("Trading Partner Groups")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//div[@class='topRightHeaderRegion']/div/div/ul/li/a")).click();
   driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
   driver.findElement(By.id("txtGroupName")).clear();
   driver.findElement(By.id("txtGroupName")).sendKeys(Group);
   Thread.sleep(2000);
   driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
   Thread.sleep(3000);
   driver.navigate().refresh();
   driver.switchTo().defaultContent();
   driver.findElement(By.cssSelector("div.r5")).click();
   driver.findElement(By.linkText("ICIX")).click();
   driver.findElement(By.linkText("Trading Partner Groups")).click();
   Thread.sleep(3000);
   Assert.assertTrue(driver.findElement(By.linkText(Group)).isDisplayed(), "TpGroup is not created");
   driver.findElement(By.linkText(Group)).click();
   Thread.sleep(5000);
 }
 public void switchtoLightining() throws InterruptedException  { 
	  
	  
		if(driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() >0 ){
			
		         driver.findElement(By.id("userNavLabel")).click();
		          driver.findElement(By.xpath("//a[@title='Switch to Lightning Experience']")).click();
		          String parentWindow= driver.getWindowHandle();
		          Set<String> allWindows = driver.getWindowHandles();
		          for(String curWindow : allWindows){
		              driver.switchTo().window(curWindow);
		          //perform operation on popup
		              driver.findElement(By.xpath("//div[@style='line-height:12px; margin-top: 12px']")).click();
		              driver.findElement(By.id("simpleDialog0button0")).click();
		           // switch back to parent window
		       driver.switchTo().window(parentWindow);
		       Thread.sleep(8000);
		       driver.navigate().refresh();
		          }
		     }
		     else if(driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() < 0 ){
		    	 
		    	 driver.findElement(By.linkText("App Launcher")).click();
		     }}		
} 
