package com.org.Example.myproject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;
//import com.utils.*;

public class TC9653_Test {
	WebDriver driver;
	String baseUrl;
	String sTblAccounts = "//table[@class='forceRecordLayout uiVirtualDataGrid--default uiVirtualDataGrid forceVirtualGrid resizable-cols']//tbody";
	Data_loading guitils = new Data_loading();
	//Data_loading l=new Data_loading();
	
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String strTPName = "dev";//guitils.getPassword("TradingPartnerName");

	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;

	@BeforeClass
	public void beforeClass() {		
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void Account_verification() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.cssSelector("div.list > ul > li > a")).click();
				

		//tblAccounts = driver.findElement(By.xpath(sTblAccounts));
		//RowsOfTable = tblAccounts.findElements(By.tagName("tr"));

		/*for (int r = 0; r < RowsOfTable.size(); r++) {
			ColOfTable = RowsOfTable.get(r).findElement(By.tagName("th"));
			String tdText = ColOfTable.getText();
			String textToVerify = strTPName;

			if (tdText.equals(textToVerify)) {

				RowsOfTable.get(r).findElement(By.cssSelector(".forceIcon"))
						.click();
				Thread.sleep(2000);
				driver.findElement(
						By.linkText("Delete"))
						.click();
				driver.findElement(
						By.cssSelector("button[title='Delete'][type='button']"))
						.click();
				break;
			}

		}*/
		Thread.sleep(3000);
		driver.findElement(By.linkText("New")).click();
		Thread.sleep(3000);
		WebElement frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);;
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.cssSelector("input[id=\"companyName\"]")).sendKeys(strTPName);
		driver.findElement(By.xpath(".//*[@class='slds-button slds-button--brand']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[contains(text(),'Connect')]")).click();
		
		List<WebElement> acs = driver.findElements(By.cssSelector(".slds-button.slds-button--brand.slds-button--large.ng-scope"));
		if(acs.size()>0){
			acs.get(0).click();
		}
		Thread.sleep(3000);
		//new Select(driver.findElement(By.xpath("//select[contains(@id,'ddl_UURelationship_Status')]"))).selectByVisibleText("Active");
		//String strTypeDrp = "//select[@id='ddl_UURelationship_Type']";
		
		Select dropdown = new Select(driver.findElement(By.id("ddl_UURelationship_Type")));
		dropdown.selectByIndex(1);
		
		driver.findElement(By.xpath(".//*[@id='btn_UPRelationship_Save']")).click();
		System.out.println(driver.findElement(
				By.xpath("html/body/main/div/div[2]")).getText());

		driver.switchTo().defaultContent();
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("img.profileTrigger")).click();
		driver.findElement(By.linkText("Log Out")).click();

	}

}
