package com.org.Example.myproject;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class TwoActorworkflowTest {
	  
	 
	  Date d = new Date(System.currentTimeMillis());
		String Reqname	="AutoTest"+d;
		
		String firstwindow;
		String secondwindow;
		WebElement tblAccounts;
		List <WebElement> RowsOfTable;
		WebElement ColOfTable;	
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
	  public void testTp() throws Exception {
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("sdqa01rk@sd.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Test@123");
	    driver.findElement(By.id("Login")).click();
	    switchtoLightining();
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
        System.out.println(Reqname);
	    driver.findElement(By.id("tradingPartnerDropDown")).clear();
	    driver.findElement(By.id("tradingPartnerDropDown")).sendKeys("sdqa2");
	    driver.findElement(By.cssSelector("h3.ng-binding")).click();
	   
	    driver.findElement(By.cssSelector("button.slds-button.slds-button--neutral")).click();
	    driver.findElement(By.xpath("//a[contains(@ng-click,'populateDocTemplate(d.name);')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//span[@class='slds-checkbox--faux'])[2]")).click();
	    driver.findElement(By.cssSelector("div.slds-modal__footer.slds-modal__footer--directional > button.slds-button.slds-button--brand")).click();
	    driver.findElement(By.xpath("//button[3]")).click();
	   
	    Thread.sleep(2000);
	   /* driver.findElement(By.xpath("//input[@id='date']")).click();
	    driver.findElement(By.xpath("//div[2]/button")).click();
	    driver.findElement(By.xpath("//span[contains(.,'1')]")).click();*/
	    
	    driver.findElement(By.xpath("//input[@placeholder='Pick a Date']")).click();
	    driver.findElement(By.xpath("//button[contains(.,'Next Month')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[contains(.,'12')]")).click();
	    driver.findElement(By.cssSelector("button.slds-button.slds-button--neutral")).click();
	    driver.findElement(By.xpath("//button[@ng-click='CancelAttachDialog()']")).click();
	  
	    driver.findElement(By.id("comments")).sendKeys("Test");
	    Thread.sleep(2000);

	    driver.findElement(By.xpath("//button[contains(.,'Send')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@ng-click='redirectToRequestListPage();']")).click();
	    driver.navigate().refresh();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(Reqname)).click();
	    Thread.sleep(2000);
	   
	    if(System.getProperty("os.name").toLowerCase().contains("win")){
			   driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).sendKeys(Keys.CONTROL + "t");
			   
	    	}
	    	else if(System.getProperty("os.name").toLowerCase().contains("mac")){
	    		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).sendKeys(Keys.COMMAND + "t");
		     	}
	    driver.get(baseUrl);
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("sdqa02rk@sd.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Test@1234");
	    driver.findElement(By.id("Login")).click();
	    switchtoLightining();
	    driver.findElement(By.cssSelector("div.icon-waffle")).click();
	    driver.findElement(By.linkText("ICIX")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Requests')]")).click();
	    
	    driver.findElement(By.xpath("//span[@class='triggerLinkText selectedListView uiOutputText']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Find list']")).sendKeys("All");
		driver.findElement(By.xpath("//input[@placeholder='Find list']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Find list']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[contains(@role,'option')]")).click();
		   
		Thread.sleep(7000);
		while(true){
		String Total_requests=driver.findElement(By.xpath("//span[@class='uiOutputText forceListViewStatusInfo']")).getText();
		if (Total_requests.indexOf("+") > -1 ) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		   			jse.executeScript("scrollContent = document.evaluate('html/body/div[6]/div[1]/section/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;scrollContent.scrollTop = scrollContent.scrollHeight;");
		   			} else {                                             
			   break;
			   }
		   }    
		   
		   tblAccounts= driver.findElement(By.xpath("html/body/div[6]/div[1]/section/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div/table/tbody"));		
	  		RowsOfTable=tblAccounts.findElements(By.tagName("tr"));		
	  		System.out.println("checking for the table2");
	  		
	  		
	  		driver.findElement(By.linkText(Reqname)).click();
	  		driver.findElement(By.xpath("//div[@title='Submit']")).click();
	  		
	  		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
	  		driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
	  		Thread.sleep(5000);
	  	    driver.switchTo().defaultContent();
	  		
	  		if(System.getProperty("os.name").toLowerCase().contains("win")){
	  		  driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).sendKeys(Keys.CONTROL + "w");
	     	}
	     	else if(System.getProperty("os.name").toLowerCase().contains("mac")){
	     		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).sendKeys(Keys.COMMAND + "w");
	     	}	
		  
	  		driver.navigate().refresh();
	  		driver.findElement(By.xpath("//a[contains(@title,'Related')]")).click();
	  		
	  		driver.findElement(By.xpath(".//div[@class='scroller actionBarPlugin fixedHeaderPlugin']/table/tbody/tr/th/div/a")).click();
		    driver.findElement(By.linkText("Show more actions for this record")).click();
		  	Thread.sleep(2000);
		  		   
		  	driver.findElement(By.linkText("Approve")).click();
		    Thread.sleep(2000);
		  		   
		  	driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		  	driver.findElement(By.xpath("//textarea[@name='j_id0:j_id40:commentBlock:j_id44']")).sendKeys("Request Approve");
		    Thread.sleep(5000);
		  	driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();	   
		  	Thread.sleep(5000);	   
		  			
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

	  