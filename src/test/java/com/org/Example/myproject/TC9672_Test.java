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
String ReqUserName = guitils.getUserName("RequestorUsername");
String ReqPassword = guitils.getPassword("RequestorPassword");	
String RespUserName = guitils.getUserName("ResponderUsername");
String RespPassword = guitils.getPassword("RequestorPassword");
String FormName="BSE Statement";
WebDriver driver;	

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
	guitils.loginToSalesForce(ReqUserName, ReqPassword);		
	guitils.SalesForceLightiningView();		
	//guitils.LightiningView(driver);
	CreateNewForm();
	guitils.SendRequest();
	
	// code for logout
	guitils.logoutSalesForce();
	
	guitils.loginToSalesForce(RespUserName, RespPassword);	
	guitils.SalesForceLightiningView();	
	guitils.FillFormAndSubmitRequest();	
		
	// logout responder
	guitils.logoutSalesForce();
}
public void CreateNewForm() throws InterruptedException
{
	guitils.CreateContaniner();
	guitils.CreateLayout();		
	guitils.AddTab();
	guitils.AddSection();
	guitils.AddLinkedQuestion();
	guitils.SalesForceLightiningView();
}
}
