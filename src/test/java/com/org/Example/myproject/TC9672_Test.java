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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9672_Test {

Data_loading guitils = new Data_loading();
String userName1 = guitils.getUserName("RequestorUsername");
String password1 = guitils.getPassword("RequestorPassword");
String Responder = guitils.getDATA("TPResponder");
String userName2 = guitils.getUserName("ResponderUsername");
String password2 = guitils.getPassword("RequestorPassword");
Date d = new Date(System.currentTimeMillis());
String Reqname = "AutoTest" + d;

String firstwindow;
String secondwindow;
WebElement tblAccounts;
List<WebElement> RowsOfTable;
WebElement ColOfTable;
WebDriver driver;
String baseUrl =  "https://login.salesforce.com";
String FormName="BSE Statement";
String comment = guitils.getPassword("Comments");

@BeforeClass
public void beforeClass() {
	driver = guitils.openBrowser(driver);
}

@AfterClass
public void afterClass() {
	driver.quit();
}

@Test
public void TwoActorWorkFlow() throws Exception {
	guitils.loginToPortal(userName1, password1, driver);
	Thread.sleep(3000);
	guitils.LightiningView(driver);
	Thread.sleep(5000);
	
	guitils.SendRequest(driver, Reqname, Responder, FormName, comment);
	
	// code for logout
	driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]")).click();
	driver.findElement(By.linkText("Log Out")).click();		

	//driver.get(baseUrl);
	guitils.loginToPortal(userName2, password2, driver);
	Thread.sleep(3000);
	guitils.LightiningView(driver);
	Thread.sleep(5000);
	
	guitils.SearchRequest(driver, Reqname);
}
}
