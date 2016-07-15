package com.org.Example.myproject;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9678_Test {
	Date d = new Date(System.currentTimeMillis());
	String Document = "Testdocument" + d;
	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	String sTblAccounts = "html/body/div[1]/table/tbody";
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TradingPartnerName");
	String comment = guitils.getDATA("Comments");

	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void send_document() throws Exception {

		guitils.loginToPortal(userName1,password1,driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Document Library")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("btn_ShowMore1")).click();
		driver.findElement(By.cssSelector("#link_Send1 > p.slds-truncate"))
				.click();
		driver.findElement(By.id("requestName")).clear();
		driver.findElement(By.id("requestName")).sendKeys(Document);
		driver.findElement(By.id("recipients")).clear();
		driver.findElement(By.id("recipients")).sendKeys(Responder,Keys.TAB);
		driver.findElement(By.id("comments")).clear();
		driver.findElement(By.id("comments")).sendKeys(comment);
		driver.findElement(By.id("sendDialogSendButton")).click();
		driver.findElement(
				By.cssSelector("div.slds-x-small-buttons--horizontal > #btn_sendConfirmDialogCloseButton"))
				.click();

	}

}
