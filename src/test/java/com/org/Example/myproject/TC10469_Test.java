package com.org.Example.myproject;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC10469_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String tpgName = "Save Multiple requirements" + d;

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
/*		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);*/
	}

	@AfterClass
	public void afterClass() {
		guitils.logoutFromPortal(driver);
		driver.quit();
	}

	@Test
	public void Save_Multiple_Requirements() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(.,'Trading Partner Group')]")).click();
		Thread.sleep(3000);

// Creating New Trading Partner Group 				
		driver.findElement(By.cssSelector("div[title='New']")).click();	
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		driver.findElement(By.id("txtGroupName")).sendKeys(tpgName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'GFSI Certified')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Refresh')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
		Thread.sleep(5000);
		driver.findElement(By
				.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath(".//a[contains(@title,'"+tpgName+"')]")).click();
				
		/*WebElement rateElement = driver.findElement(By.linkText(tpgName));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);*/
		
		
/*		// Search Trading Partner 
				driver.findElement(By.id("84:2;a")).sendKeys("Test Tags OnlyFri Sep 16 12:32:48 IST 2016");
				Thread.sleep(3000);
				WebElement webElement = driver.findElement(By.id("84:2;a"));
				webElement.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				webElement.sendKeys(Keys.ENTER);
				Thread.sleep(3000);	
				driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/a"))
						.click();*/

// Set Requirements 		
		//driver.findElement(By.xpath("//span[@title='Show more actions for this record']")).click();
		driver.findElement(By.xpath("//a[@title='Set Requirements']")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		for(int i=1; i<3; i++){
			int id=i-1;
			int reqid=i+1;
		Select type = new Select(driver.findElement(By.id("RequestType"+id+"")));
		type.selectByIndex(1);
		
		Thread.sleep(5000);
		Select Doc = new Select(driver.findElement(By.id("DocType"+id+"")));
		Doc.selectByIndex(i);
		
		Thread.sleep(5000);

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("html/body/form/div["+i+"]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("html/body/form/div["+i+"]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[6]/span"))).click().build().perform();

		Thread.sleep(5000);
		new Select(driver.findElement(By.id("RequirementType"+id+"")))
				.selectByVisibleText("Approval");
		
		Thread.sleep(5000);
		if(i<2){
		// add new requirement
		driver.findElement(By.xpath("html/body/form/div["+reqid+"]/div[2]/button")).click();
		Thread.sleep(5000);
		}
		}

		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
	//	driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div[3]/div/button")).click();
		//driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@ng-click='CloseModalPopup();']")).click();
		driver.switchTo().defaultContent();
// check the requirements	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'Related')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'Trading Partner Group Requirements')]")).click();
		
		List<WebElement> listInputs =  driver.findElements(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div/div[2]/div/div[3]/div/div/table/tbody/tr"));
		
		if(listInputs.size()>0)
		 {
			System.out.println("Success: Requirements Saved " +listInputs.size());
		 }
		else{
			System.out.println("Failed: Requirements Saved " +listInputs.size());
		}
	}
}	