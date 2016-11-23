package com.org.Example.myproject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC10782_Test {
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
	String PrdName;
	String strIXN;
	int IXNFlag=0;
	String UniNo = RandomStringUtils.randomNumeric(10);


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
	public void CreateProductWithUniversalId() throws Exception {
		guitils.loginToPortal(userName1,password1,driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'ICIX Products')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'ICIX Products')]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		driver.findElement(By.xpath("//a[@title='New']")).click();
		Thread.sleep(3000);
		
		
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		WebElement frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
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
		PrdName="TEST Product_" + UPCproduct;
		driver.findElement(By.xpath("//input[@id='ProductName']")).sendKeys(PrdName);
		Thread.sleep(1000);
		Select drpUniNo=new Select(driver.findElement(By.id("ddl_product_UniversalId_Type0")));
		drpUniNo.selectByIndex(1);
		Thread.sleep(1000);
		driver.findElement(By.id("txt_product_UniversalId_Value0")).sendKeys(UniNo);
		
		Thread.sleep(2000);
		driver.findElement(By.id("btn_UPRelationship_Next")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.id("btn_UPRelationship_Next")).click();
			
		Thread.sleep(3000);
		
		driver.findElement(By.id("btn_UPRelationship_Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@ng-click='vm.close()']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		/*
		strIXN=driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div/div/div[2]/div[1]/div/div/section/div/form/section/div[1]/div/section[1]/ul/div[1]/li[2]/div[2]/div")).getText();
		
		if (!strIXN.isEmpty())
		{
			IXNFlag=1; // Means there must not be IXN ID 
		}
		
		Assert.assertEquals(IXNFlag,0,"IXN Number must be blank");
		*/
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'ICIX Product ID')]/following::span[2]")).getText().isEmpty() ,"IXN Number must be blank");
		//Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'ICIX Product ID')]/following::span[2]")).getText().isEmpty() ,"IXN Number must be blank");

		

	}

}
