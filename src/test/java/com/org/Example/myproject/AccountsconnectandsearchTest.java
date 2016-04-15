package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.utils.Data_loading;



public class AccountsconnectandsearchTest {
	  String firstwindow;
	  WebDriver driver;
	  String baseUrl; 
	
	
	 Data_loading guitils = new Data_loading();
	 String userName1 = guitils.getUserName("RequestorUsername");
	 String password1 = guitils.getPassword("RequestorPassword");
	 String Icixid = guitils.getDATA("icixid");
	 
  @Test
  public void Auccount_verification() throws InterruptedException {
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(userName1);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password1);
	    driver.findElement(By.id("Login")).click();
	    Thread.sleep(5000);
	   
	    driver.findElement(By.cssSelector("div.r5")).click();
	    driver.findElement(By.linkText("ICIX")).click();

	    driver.findElement(By.cssSelector("div.list > ul > li > a")).click();
	    Thread.sleep(3000);
	    //New button
	    //driver.findElement(By.xpath("/html/body/div[6]/div[1]/section/div[1]/div[2]/div[4]/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/a")).click();
	    driver.findElement(By.xpath("//div[@class='topRightHeaderRegion']/div/div/ul/li[1]/a")).click();
	    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
	    
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	 
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Icixid);
	    driver.findElement(By.cssSelector("button.slds-button.slds-button--brand")).click();
	    driver.switchTo().defaultContent();
	    Thread.sleep(8000);
	    driver.findElement(By.cssSelector("img.profileTrigger")).click();
	    driver.findElement(By.linkText("Log Out")).click(); 
	  
  }
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

}
