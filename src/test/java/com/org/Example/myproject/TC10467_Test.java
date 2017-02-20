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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

import ModuleLocatorRepository.FormBuilderRepo;
import ModuleLocatorRepository.RequestRepo;
import ModuleLocatorRepository.TPGroupCompRepo;

public class TC10467_Test {
	Data_loading guitils = new Data_loading();
	String ReqUserName = guitils.getUserName("RequestorUsername");
	String ReqPassword = guitils.getPassword("RequestorPassword");
//	WebDriver driver;
	
	Date d = new Date(System.currentTimeMillis());
	String tpgName = "TPG_tag_status_and_Type" + d; // Trading partner Group Name
	String tpgTags[] = {"Organic"};  // Tag Names
	String tpgStatus[]= {"Active"}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	String tpgType[] = {"Agent","Broker"}; // tpg Relationship types
	
	@BeforeClass
	public void beforeClass() {
		guitils.InitilizeBrowser();	
	}

	@AfterClass
	public void afterClass() {
		guitils.logoutFromPortal();
		guitils.driver.close();
	}

	@Test
	public void TPG_RelationshipType() throws Exception {

		
		guitils.loginToSalesForce(ReqUserName, ReqPassword);
// Creating New Trading Partner Group with the combination of tag,status and Type	
		guitils.createTPGN(tpgName, tpgTags, tpgStatus, tpgType);
	}
}	