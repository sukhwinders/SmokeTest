package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
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

public class TC9659_Test {
	WebDriver driver;
	String baseUrl;
	Date d = new Date(System.currentTimeMillis());
	String Tags = "Test" + d;
	String randomNumbers = RandomStringUtils.randomNumeric(8);
	String UPCproduct = "1111" + randomNumbers;
	String firstwindow;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String strTPName = guitils.getUserName("TPResponder");
	String Responder = guitils.getDATA("TradingPartnerName");


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
	public void Tagstest() throws Exception {
		guitils.loginToPortal(userName1,password1,driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(text(),'ICIX Products')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		driver.findElement(By.id("txt_SearchTermTradingPartner")).clear();
		driver.findElement(By.id("txt_SearchTermTradingPartner")).sendKeys(Responder,Keys.TAB);		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id='tradingPartnerModal']/div[2]/ul/li[1]/div/div[2]/span")).click();
		driver.findElement(By.xpath("//*[@id='s01']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("txt_SearchTerm")).clear();
		driver.findElement(By.id("txt_SearchTerm")).sendKeys(UPCproduct);
		
		Thread.sleep(2000);
		driver.findElement(By.id("btnProductSearch")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("btnCreateProduct")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ProductName']")).sendKeys("TEST Product");
		Thread.sleep(2000);
		driver.findElement(By.id("btn_UPRelationship_Next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn_UPRelationship_Next")).click();
		
		Thread.sleep(2000);

		driver.findElement(By.id("tab-ProductRelationship-1__item")).click();
		driver.findElement(By.xpath("//a[@id='btn_UPRelationship_Tag_Add']")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@id='txt_UPRelationship_Tag_New']")).sendKeys(Tags);
		WebElement TagField = driver.findElement(By.id("txt_UPRelationship_Tag_New"));
		TagField.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.id("btn_UPRelationship_Save")).click();
		driver.switchTo().defaultContent();

	}

}
