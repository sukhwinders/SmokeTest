package com.org.Example.myproject;
	import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;
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
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
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
		switchtoLightining();
	    driver.findElement(By.cssSelector("div.r6")).click();
	    driver.findElement(By.linkText("ICIX")).click();
	    driver.findElement(By.linkText("Document Library")).click();
	    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
	    driver.findElement(By.id("btn_ShowMore1")).click();
	    driver.findElement(By.cssSelector("#link_Send1 > p.slds-truncate")).click();
	    driver.findElement(By.id("requestName")).clear();
	    driver.findElement(By.id("requestName")).sendKeys(Document);
	    driver.findElement(By.id("recipients")).clear();
	    driver.findElement(By.id("recipients")).sendKeys(Responder);
	    driver.findElement(By.xpath("//a[@data-type='partner']")).click();
	    driver.findElement(By.id("comments")).clear();
	    driver.findElement(By.id("comments")).sendKeys(comment);
	    driver.findElement(By.id("sendDialogSendButton")).click();
	    driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > #btn_sendConfirmDialogCloseButton")).click();
	  }
	  public void switchtoLightining()  { 
		  System.out.println("I am in clasic1");
		  
			if(driver.findElements(By.linkText("App Launcher")).size() < 0){
				System.out.println("I am in clasic");
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
			       
			       driver.navigate().refresh();
			          }
			     }
			     else if(driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() < 0 ){
			    	 System.out.println("I am in clasic2");
			    	 driver.findElement(By.linkText("App Launcher")).click();
			     }}	
	  }

	  