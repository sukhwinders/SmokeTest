package com.org.Example.myproject;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.Data_loading;


public class Create_PublicproductTest {
	 WebDriver driver;
	 String baseUrl; 
    Date d = new Date(System.currentTimeMillis());
	String 	Product		="TestProduct"+d;
	String randomNumbers = RandomStringUtils.randomNumeric(8);
	String UPCproduct = "1111" + randomNumbers; 
	String firstwindow;
	
	 Data_loading guitils = new Data_loading();
	 String userName1 = guitils.getUserName("RequestorUsername");
	 String password1 = guitils.getPassword("RequestorPassword");
	 String userName2 = guitils.getUserName("ResponderUsername");
	 String password2 = guitils.getPassword("RequestorPassword");
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
	    driver.findElement(By.id("txtProductName")).sendKeys(Product);
	    driver.findElement(By.id("txtIdValue0")).clear();
	    driver.findElement(By.id("txtIdValue0")).sendKeys(UPCproduct);
	    Thread.sleep(9000);
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
	    
	    driver.findElement(By.id("btn_UPRelationship_Next")).click();
	    driver.findElement(By.id("rdPermissionOption1")).click();
	    driver.findElement(By.xpath("//fieldset/div/label[2]")).click();
	    driver.findElement(By.id("btn_UPRelationshipPermission_Save")).click();
	    driver.findElement(By.xpath("//message-dialog/div[2]/div/div/div[3]/button")).click();
	    driver.switchTo().defaultContent();
	    Thread.sleep(5000);
	    
	    
	    
	    if(System.getProperty("os.name").toLowerCase().contains("win")){
			   driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).sendKeys(Keys.CONTROL + "t");
			   
	 	}
	 	else if(System.getProperty("os.name").toLowerCase().contains("mac")){
	 		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).sendKeys(Keys.COMMAND + "t");
		     	}
	driver.get(baseUrl);
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys(userName1);
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(password1);
	driver.findElement(By.id("Login")).click();
	driver.findElement(By.cssSelector("div.icon-waffle")).click();
	driver.findElement(By.linkText("ICIX")).click();
	driver.findElement(By.xpath("//a[contains(.,'Product Search')]")).click();

	driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
	driver.findElement(By.id("txtIdValue0")).clear();
	driver.findElement(By.id("txtIdValue0")).sendKeys(UPCproduct);
	Thread.sleep(5000);
	driver.findElement(By.id("btnProductSearch")).click();
	Thread.sleep(6000);
	Assert.assertTrue(driver.findElement(By.xpath("//td[5]/button")).isDisplayed(), "product is not avilable");
    
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

 
