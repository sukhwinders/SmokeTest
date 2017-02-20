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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;
import com.utils.Data_loading_Old;

import ModuleLocatorRepository.FormBuilderRepo;
import ModuleLocatorRepository.RequestRepo;
import ModuleLocatorRepository.TPGroupCompRepo;

public class TC10799_Test {

	Data_loading guitils = new Data_loading();	
	Data_loading_Old get = new Data_loading_Old();
	String ReqUserName = guitils.getUserName("RequestorUsername");
	String ReqPassword = guitils.getPassword("RequestorPassword");		
	WebDriver driver;
	FormBuilderRepo ObjForm=new FormBuilderRepo();

	Date date = new Date(System.currentTimeMillis());
	String tpgName = "AutoReqCreationAddTP" +date; // Trading partner Group Name
	String tpgTags[] = {"Kosher"};  // Tag Names
	String tpgStatus[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	String tpgType[] = {}; // tpg Relationship types

	String requestType[] = {"All"};

	String saveOrSend  = "btnSave"; // save or send reqs, supported values are btnSave and btnSend

	String tabName = "Workflows"; // on which object you want to search 


	String wfStatus = "Open"; // Workflow status, supported values are Closed, Open.
	String ReqStatus = ""; // Request Status , Supported values are New,Approved, Rejected, Cancelled etc..

	String editTags[] = {"Kosher","Organic"}; // Tpg tags for editing tpg

	@BeforeClass
	public void beforeClass() {
		guitils.InitilizeBrowser();	
	}

	@AfterClass
	public void afterClass() {	
		//guitils.logoutFromPortal();
		guitils.driver.quit();
	}

	@Test
	public void AutoReqCreationAddTP() throws Exception {
		guitils.loginToSalesForce(ReqUserName, ReqPassword);		
		// Create a form


		guitils.createNewForm();
		String formNames[] = {ObjForm.container_Name+guitils.d};
		//String formNames[] = {"TestcontainerThu Feb 16 15:17:20 IST 2017"};
		
		String searchKeyWord =ObjForm.container_Name+guitils.d;// name of the record
		// Create a Trading partner Group		



		guitils.createTPG(tpgName, tpgTags, tpgStatus, tpgType);
		guitils.driver.manage().deleteAllCookies();
		  Thread.sleep(10000);

		// Set the Requirements then save 		
		guitils.SetRequirement(requestType,formNames, saveOrSend);	
		// Edit tpg to add members
		guitils.editTPG(editTags);
		// Search for request



		guitils.searchAnything(tabName,searchKeyWord);



	}
}
