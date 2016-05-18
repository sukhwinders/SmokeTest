package com.org.Example.myproject;
	import java.util.Date;
import java.util.List;
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

public class TC9678_Test  {
	Date d = new Date(System.currentTimeMillis());
	String 	Document		="Testdocument"+d;
	
	WebElement tblAccounts;
	List <WebElement> RowsOfTable;
	WebElement ColOfTable;
	String  sTblAccounts ="html/body/div/table/tbody";
	
	Data_loading guitils = new Data_loading();
	 String userName1 = guitils.getUserName("RequestorUsername");
	 String password1 = guitils.getPassword("RequestorPassword");
	 String Responder = guitils.getDATA("Responder");
	 String comment = guitils.getDATA("Comments");
	 String userName2 = guitils.getUserName("ResponderUsername");
	 String password2 = guitils.getPassword("RequestorPassword");
	
	
	WebDriver driver;
	 String baseUrl; 
	@BeforeClass
	  public void beforeClass() {
		  baseUrl = "https://login.salesforce.com";      
	      driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	    driver.findElement(By.linkText("App Launcher")).click();
	    driver.findElement(By.linkText("ICIX")).click();
	    driver.findElement(By.linkText("Document Library")).click();
	    driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
	    /*tblAccounts= driver.findElement(By.xpath(sTblAccounts));		
		RowsOfTable=tblAccounts.findElements(By.tagName("tr"));		
		
		for (int r=0;r<RowsOfTable.size();r++)
		{System.out.println(RowsOfTable);
			ColOfTable=RowsOfTable.get(r).findElement(By.tagName("td"));
			String tdText=ColOfTable.getText();
			System.out.println(tdText);
			String textToVerify="Yes";
			
			if(tdText.equals(textToVerify))
			{
				System.out.println("i am in table ");
				RowsOfTable.get(r).findElement(By.id("btn_ShowMore1")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("#link_Send1 > p.slds-truncate")).click();				
				break;
			}
			
		}*/
	    driver.findElement(By.id("btn_ShowMore1")).click();
	    driver.findElement(By.cssSelector("#link_Send1 > p.slds-truncate")).click();
	    driver.findElement(By.id("requestName")).clear();
	    driver.findElement(By.id("requestName")).sendKeys(Document);
	    driver.findElement(By.id("recipients")).clear();
	    driver.findElement(By.id("recipients")).sendKeys(Responder);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[@data-type='partner']")).click();
	    driver.findElement(By.id("comments")).clear();
	    driver.findElement(By.id("comments")).sendKeys(comment);
	    driver.findElement(By.id("sendDialogSendButton")).click();
	    driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > #btn_sendConfirmDialogCloseButton")).click();
	    driver.switchTo().defaultContent();
	    if(System.getProperty("os.name").toLowerCase().contains("win")){
			driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).sendKeys(Keys.CONTROL + "t");

		}
		else if(System.getProperty("os.name").toLowerCase().contains("mac")){
			driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]")).sendKeys(Keys.COMMAND + "t");
		}
		driver.get(baseUrl);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName2);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password2);
		driver.findElement(By.id("Login")).click();
		switchtoLightining();
		driver.findElement(By.linkText("App Launcher")).click();
		Thread.sleep(5000);
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
			} 
			else {                                             
				break;
			}
		}    

		tblAccounts= driver.findElement(By.xpath("html/body/div[6]/div[1]/section/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div/table/tbody"));		
		RowsOfTable=tblAccounts.findElements(By.tagName("tr"));		
		driver.findElement(By.linkText(Document)).click();
		Thread.sleep(4000);
	    
	    
	    
	    
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

	  