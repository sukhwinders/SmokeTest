package com.org.Example.myproject;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

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
		driver.quit();
	}

	@Test
	public void uploadpublicdocument() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Document Library")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("btn_AddDocument")).click();
		driver.findElement(By.xpath("//a[@id='browseLink']")).click();
		Thread.sleep(5000);
		/*
		 * if(System.getProperty("os.name").toLowerCase().contains("win")){
		 * Runtime
		 * .getRuntime().exec("..\\ProductionAutomation\\file upload.exe");
		 * 
		 * } else
		 * if(System.getProperty("os.name").toLowerCase().contains("mac")){ //
		 * set the file name in clipboard StringSelection ss = new
		 * StringSelection("ProductionAutomation\\upload dociment.docx");
		 * Toolkit
		 * .getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		 * Thread.sleep(3000);
		 */
		// Sleep time to detect the window dialog box

		// Perform native keystrokes for CTRL+V and ENTER keys
		StringSelection sel = new StringSelection(System.getProperty("user.dir") + "\\test.txt\\");

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("selection" + sel);
		// Create object of Robot class
		Robot robot = new Robot();
		Thread.sleep(1000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// }
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='category']")).click();
		driver.findElement(By.id("category")).click();
		//driver.findElement(By.xpath("//a[contains(.,'Product Spec')]")).click();
		driver.findElement(By.xpath("//*[@id='category']/option[1]")).click();
		
		driver.findElement(By.className("slds-checkbox--faux")).click();		
		//driver.findElement(By.xpath("//span[@class='slds-checkbox--faux']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		driver.findElement(By.id("documentDialogSaveButton")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("uploadButton")).click();
		Thread.sleep(6000);

	}

}
