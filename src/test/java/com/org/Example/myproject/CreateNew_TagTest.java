package com.org.Example.myproject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class CreateNew_TagTest {
	WebDriver driver;
	String baseUrl; 
    Date d = new Date(System.currentTimeMillis());
	String 	Tags		="Test"+d;
	String randomNumbers = RandomStringUtils.randomNumeric(8);
	String UPCproduct = "1111" + randomNumbers; 
	String firstwindow;
	
	
	 Data_loading guitils = new Data_loading();
	 String userName2 = guitils.getUserName("ResponderUsername");
	 String password2 = guitils.getPassword("RequestorPassword");
	 String strTPName = guitils.getUserName("TradingPartnerName");
	 
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
  public void test1() throws Exception {
	  driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(userName2);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password2);
	    driver.findElement(By.id("Login")).click();
	    driver.findElement(By.cssSelector("div.icon-waffle")).click();
	    driver.findElement(By.linkText("ICIX")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'ICIX Products')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
	    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
	    
	    driver.findElement(By.id("txtIdValue0")).clear();
	    driver.findElement(By.id("txtIdValue0")).sendKeys(UPCproduct);
	    Thread.sleep(10000);
	    driver.findElement(By.id("btnProductSearch")).click();
	    driver.findElement(By.id("btnCreateProduct")).click();
	    new Select(driver.findElement(By.id("ddl_UPRelationship_Type"))).selectByVisibleText("Buy");
	    String strTypeDrp="//select[@id='ddl_UPRelationship_Status']";
	    
	    if(System.getProperty("os.name").toLowerCase().contains("win")){
	    	
	    	driver.switchTo().activeElement().equals(driver.findElement(By.xpath(strTypeDrp)));
	        driver.findElement(By.xpath(strTypeDrp)).sendKeys(Keys.ARROW_DOWN);
	      		   
	 	}
	 	else if(System.getProperty("os.name").toLowerCase().contains("mac")){
	 		 driver.switchTo().activeElement().equals(driver.findElement(By.xpath(strTypeDrp)));
	 	      driver.findElement(By.xpath(strTypeDrp)).sendKeys(Keys.chord(Keys.ARROW_DOWN));
		     	}
	    driver.findElement(By.xpath("//a[contains(@id,'btn_UPRelationship_Tag_Add')]")).click();
	    driver.findElement(By.xpath("//input[@id='txt_UPRelationship_Tag_New']")).sendKeys(Tags);
	    driver.findElement(By.xpath("//textarea[@id='txt_UPRelationship_Comment'] ")).click();
	 	    
	    
}}
