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


//String FormName="BSE Statement";

Data_loading guitils = new Data_loading();	
String ReqUserName = guitils.getUserName("RequestorUsername");
String ReqPassword = guitils.getPassword("RequestorPassword");
String ResUserName = guitils.getUserName("ResponderUsername");
String ResPassword = guitils.getPassword("ResponderPassword");	

boolean BPform = true; // Best practice form or not?
int NoOfTabs = 1; // No of Tabs
int NoOfSections = 1; // No of sections in each tab
boolean generateServiceSection = false; // generate Service Section
int NoOfQuestions = 2; // No of Questions in each Section
int NoOfLinkedQuest = 1; // No of Linked Questions
int NoOfReqQuest = 1 ;// No of Mandatory fields Questions in Total questions 
int NoOfReadOnlyQuest = 1; // No of Read Only Questions in Total questions 
String ansType[] = {"text"}; // for different answer type, available types text,checkbox, date, datetime,multi-picklist, number,picklist,long text,upload,search,multi-search,radio,email address
String picklistVal;  // If answer type is picklist then set values available types boolean,chemicals,countries,currencies,ingredients,microbiological,months
String MultiPickVal; // If answer type is multi-picklist then set values available types boolean,chemicals,countries,currencies,ingredients,microbiological,months
String NamenValue[][] = {{}, // add picklist or multi-picklist options -- add name here
						 {}}; // // add picklist  or multi-picklist options -- add Value here
String defaultVal; // Select default value for picklist and multi-picklist
String dependencyValue ;  // Select dependency value , It should be in NamenValue list
String newFeature; // it's created for feature purpose, now leave it. 


@BeforeClass
public void beforeClass() {
	guitils.InitilizeBrowser();	
}

@AfterClass
public void afterClass() {
	//guitils.logoutFromPortal();
	//guitils.driver.quit();
}

@Test
public void TwoActorWorkFlow() throws Exception {
	guitils.loginToSalesForce(ReqUserName, ReqPassword);				
		
	guitils.createNewForm();
	
	//guitils.SendRequest();
	guitils.NormalReq();
	// code for logout
	guitils.logoutSalesForce();
	
	guitils.loginToSalesForce(ResUserName, ResPassword);
	//guitils.SalesForceLightiningView();	
	guitils.FillFormAndSubmitRequest();	
		
	// logout responder
	guitils.logoutFromPortal();
}

}
