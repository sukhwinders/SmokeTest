package com.org.Example.myproject;
	import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.Data_loading;

public class Send_DocumentsTest  {
	Date d = new Date(System.currentTimeMillis());
	String 	Document		="Testdocument"+d;
	
	Data_loading guitils = new Data_loading();
	 String userName1 = guitils.getUserName("RequestorUsername");
	 String password1 = guitils.getPassword("RequestorPassword");
	 String Responder = guitils.getDATA("Responder");
	 String comment = guitils.getDATA("Comments");
	
	
	
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
	  public void send_document() throws Exception {
	   
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(userName1);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password1);
	    driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector("div.r6")).click();
	    driver.findElement(By.cssSelector("a.appName")).click();
	    driver.findElement(By.linkText("Document Library")).click();
	    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
	    driver.findElement(By.id("btn_ShowMore1")).click();
	    driver.findElement(By.cssSelector("#link_Send1 > p.slds-truncate")).click();
	    driver.findElement(By.id("requestName")).clear();
	    driver.findElement(By.id("requestName")).sendKeys(Document);
	    driver.findElement(By.id("recipients")).clear();
	    driver.findElement(By.id("recipients")).sendKeys(Responder);
	    driver.findElement(By.linkText("SDQA2")).click();
	    driver.findElement(By.id("comments")).clear();
	    driver.findElement(By.id("comments")).sendKeys(comment);
	    driver.findElement(By.id("sendDialogSendButton")).click();
	    driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > #btn_sendConfirmDialogCloseButton")).click();
	  }

	  }

	  