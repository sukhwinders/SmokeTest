package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC10467_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String tpgName = "tags_status_and_Type" + d;

	String firstwindow;
	String secondwindow;
	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	WebDriver driver;
	String baseUrl =  "https://login.salesforce.com";

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		guitils.logoutFromPortal(driver);
		driver.quit();
	}

	@Test
	public void TPG_tag_status_and_Type() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		//driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(.,'Trading Partner Group')]")).click();
		WebElement we = driver.findElement(By.xpath("//a[contains(.,'Trading Partner Group')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",we);
		Thread.sleep(3000);
		// Creating New Trading Partner Group with the combination of tag,status and Type	 			
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		driver.findElement(By.id("txtGroupName")).sendKeys(tpgName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'GFSI Certified')]")).click();
		//driver.findElement(By.xpath("//span[contains(.,'Refresh')]")).click();
		Thread.sleep(2000);
	  
		driver.findElement(By.xpath("//a[contains(.,'Status')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Pending')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Active')]")).click();
		driver.findElement(By.xpath(".//*[@id='icnMoveRight']")).click();
		
		
		driver.findElement(By.xpath("//a[contains(.,'Type')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(.,'Agent')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Broker')]")).click();
		Thread.sleep(3000);
		
		List<WebElement> ar=driver.findElements(By.id("icnMoveRight"));
		//It is finding 2 elements of same ID
		//driver.findElement(By.id("icnMoveRight")).click();
		//clicking the 2nd one
		ar.get(1).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(3000);
		driver.findElement(By
				.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		WebElement rateElement = driver.findElement(By.linkText(tpgName));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		
		
	}
}	