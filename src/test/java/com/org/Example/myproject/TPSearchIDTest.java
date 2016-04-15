package com.org.Example.myproject;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.Data_loading;


public class TPSearchIDTest{
 
  WebDriver driver;
  String baseUrl; 
  Data_loading guitils = new Data_loading();
  String userName1     = guitils.getUserName("RequestorUsername");
  String password1     = guitils.getPassword("RequestorPassword");
  String ICIX_ID       = guitils.getDATA("ICIX_ID");

  
  
  
  
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
  public void testSearchByIcixId() throws Exception {
    
	  driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(userName1);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password1);
	    driver.findElement(By.id("Login")).click();
	    Thread.sleep(5000);
    
    driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).click();
    driver.findElement(By.linkText("ICIX")).click();
    driver.findElement(By.cssSelector("div.list > ul > li > a")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[6]/div[1]/section/div[1]/div[2]/div[4]/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/a")).click();
    
    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));

    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(ICIX_ID);
    driver.findElement(By.cssSelector("button.slds-button.slds-button--brand")).click();
    String ICIXID= driver.findElement(By.xpath("//b[contains(.,'ICIX ID:')]")).getText();
    System.out.println(ICIXID);
    
  }

  }

  
