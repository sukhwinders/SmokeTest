package com.org.Example.myproject;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;
/* Verify Upload New Public document  in ICIX Document library
*/
public class TC9675_Test {
	Date d = new Date(System.currentTimeMillis());
	String Document = "Testdocument" + d;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	//String DocuResponder = guitils.getDATA("DOcumentreciver");
	//String comment = guitils.getDATA("Comments");
	//Enter Location of document which you what to upload
	//String documentLocation = "D:\\ICIX\\Package14Scripts\\PKG_Automation_Smoke_07Feb_CPKR\\PKG_Automation_Smoke_07Feb_CPKR\\TestFile.doc";
	//String documentLocation= "D:\\data\\Task.txt";
	WebDriver driver;
	String baseUrl;
	
	@BeforeClass
	 public void beforeClass() {  
	  driver = guitils.openBrowser(driver);
	 }


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void uploadpublicdocument() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.SalesForceLightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Document Library')]")).click();
		Thread.sleep(2000);
		
		List<WebElement> frame1=driver.findElements(By.tagName("iframe"));
		
		if(frame1.size()>1)
		{
			driver.switchTo().frame(frame1.get(1));
		}
		else
		{
			driver.switchTo().frame(frame1.get(0));
		}
		
		Thread.sleep(3000);
		Thread.sleep(3000);
		driver.findElement(By.id("btn_AddDocument")).click();
		
		driver.findElement(By.xpath("//a[@id='browseLink']")).click();
		Thread.sleep(5000);
		
		
	// New Code
		
		//browser.findElement(By.className("import­button")).click();
		 
		//Thread.sleep(2000);
		 
		//File Need to be imported
		 
		File file = new File("TestFile.doc");
		 
		StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
		 
		//Copy to clipboard 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		 
		Robot robot = new Robot();
		 
		// Cmd + Tab is needed since it launches a Java app and the browser looses focus
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_TAB);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_TAB);
		 
		robot.delay(500);
		 
		//Open Goto window
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_SHIFT);
		 
		robot.keyPress(KeyEvent.VK_G);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_SHIFT);
		 
		robot.keyRelease(KeyEvent.VK_G);
		 
		//Paste the clipboard value
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_V);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_V);
		 
		//Press Enter key to close the Goto window and Upload window
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		 
		robot.keyRelease(KeyEvent.VK_ENTER);
		 
		robot.delay(2000);
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		 
		//robot.keyRelease(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		
		//robot.keyRelease(KeyEvent.VK_ENTER);
		
		// Till here		
		
		Thread.sleep(3000);
		driver.findElement(By.id("category")).click();
		driver.findElement(By.xpath("//*[@id='category']/option[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("documentDialogSaveButton")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("uploadButton")).click();
		Thread.sleep(6000);

	}

}


























/*package com.org.Example.myproject;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;
 Verify Upload New Public document  in ICIX Document library

public class TC9675_Test {
	Date d = new Date(System.currentTimeMillis());
	String Document = "Testdocument" + d;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String DocuResponder = guitils.getDATA("DOcumentreciver");
	String comment = guitils.getDATA("Comments");

	WebDriver driver;
	String baseUrl;
	
	@BeforeClass
	 public void beforeClass() {  
	  driver = guitils.openBrowser(driver);
	 }


	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	@Test
	public void uploadpublicdocument() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(10000);
		guitils.SalesForceLightiningView();
		Thread.sleep(4000);
		
		
		//driver.findElement(By.linkText("ICIX")).click();
		
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Document Library')]")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.linkText("Document Library")).click();
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		WebElement frame=driver.findElement(By.tagName("iframe"));
		
		
		
		List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		if(frames.size()>1){
			driver.switchTo().frame(frames.get(1));
		}
		else{
			driver.switchTo().frame(frames.get(0));
		}
		driver.findElement(By.id("btn_AddDocument")).click();
		
		// Specify the file location with extension
		// StringSelection sel = new StringSelection(".\\TestFile.doc");
		 StringSelection sel = new StringSelection(".\\TestFile.doc");
		 
		 // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
	
		 // This will click on Browse button
		 driver.findElement(By.xpath("//a[@id='browseLink']")).click();
			Thread.sleep(7000);
		  System.out.println("Browse button clicked");
		 
		 // Create object of Robot class
		 Robot robot = new Robot();
		 Thread.sleep(1000);
		      
		  // Press Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
	    // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
	  //   Press Enter 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		
		
 			
	// New Code
		
		//browser.findElement(By.className("import­button")).click();
		 
		//Thread.sleep(2000);
		 
		//File Need to be imported
		 
		File file = new File("TestFile.doc");       
		 
		StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
		 
		//Copy to clipboard 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		 
		Robot robot = new Robot();
		 
		// Cmd + Tab is needed since it launches a Java app and the browser looses focus
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_TAB);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_TAB);
		 
		robot.delay(500);
		 
		//Open Goto window
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_SHIFT);
		 
		robot.keyPress(KeyEvent.VK_G);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_SHIFT);
		 
		robot.keyRelease(KeyEvent.VK_G);
		 
		//Paste the clipboard value
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_V);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_V);
		 
		//Press Enter key to close the Goto window and Upload window
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		 
		robot.keyRelease(KeyEvent.VK_ENTER);
		 
		robot.delay(2000);
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		 
		//robot.keyRelease(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		
		//robot.keyRelease(KeyEvent.VK_ENTER);
		
		// Till here		
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='category']")).click();
		driver.findElement(By.id("category")).click();
		//driver.findElement(By.xpath("//a[contains(.,'Product Spec')]")).click();
		driver.findElement(By.xpath("//*[@id='category']/option[1]")).click();
		
		//driver.findElement(By.className("slds-checkbox--faux")).click();		
		//driver.findElement(By.xpath("//span[@class='slds-checkbox--faux']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		driver.findElement(By.id("documentDialogSaveButton")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("uploadButton")).click();
		Thread.sleep(6000);

	}

}
*/