package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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


public class TC9665_Test {
	WebDriver driver;
	String baseUrl; 
	Date d = new Date(System.currentTimeMillis());
	String Group ="Testgroup"+d;

	Data_loading guitils = new Data_loading();
	String userName1     = guitils.getUserName("RequestorUsername");
	String password1     = guitils.getPassword("RequestorPassword");
	String partner_name  = guitils.getDATA("Partner_name");

	@BeforeClass
	public void beforeClass() {
		/*baseUrl = "https://login.salesforce.com";      
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);  
		*/
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void test() throws Exception  {
		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.linkText("Trading Partner Groups")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(2000);
		WebElement frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
	
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("txtGroupName")).clear();
		driver.findElement(By.id("txtGroupName")).sendKeys(Group);

		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]")).click();
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Thread.sleep(3000);

		//driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		//driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		driver.findElement(By.xpath("//button[@ng-click='vm.goBackTPGRoup();']")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		//driver.findElement(By.cssSelector("div.r5")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.linkText(Group)).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[title=\"Edit\"]")).click();
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]")).click();
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		//driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		driver.findElement(By.xpath("//button[@ng-click='vm.goBackTPGRoup();']")).click();


	}
	
}