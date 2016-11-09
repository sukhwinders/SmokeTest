package com.org.Example.myproject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9676_Test {
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
		baseUrl = "https://login.salesforce.com";
		driver = guitils.openBrowser(driver);
		//driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.navigate().to(baseUrl);
	}

	
	  @AfterClass
	  public void afterClass() 
	  { driver.quit(); }
	 

	@Test
	public void Private_document() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.linkText("Document Library")).click();		
		
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Document Library')]")).click();
		Thread.sleep(2000);

		WebElement frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("btn_AddDocument")).click();
		driver.findElement(By.xpath("//a[@id='browseLink']")).click();
		Thread.sleep(5000);

		// Specify the file location with extension
		// StringSelection sel = new
		// StringSelection("D:\\Projects\\iCiX\\scripts.txt");
		

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
		 
		robot.delay(500);
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		 
		//robot.keyRelease(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		// }

		Thread.sleep(15000);

		//driver.findElement(By.xpath("//input[contains(@class,'slds-input slds-show')]")).click();   --
		//driver.findElement(By.xpath("//a[contains(.,'Product Spec')]")).click(); --
		// driver.findElement(By.xpath("//span[@class='slds-checkbox--faux']")).click();
		//Thread.sleep(3000); --
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();

		driver.findElement(By.id("uploadButton")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("btn_ShowMore1")).click();
		Thread.sleep(6000);

	}

	
}
