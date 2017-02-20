package com.org.Example.myproject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Date;






import com.utils.Data_loading;

import ModuleLocatorRepository.FormBuilderRepo;



public class TC9666_Test {

	Data_loading guitils = new Data_loading(); 
	String ReqUserName = guitils.getUserName("RequestorUsername");
	String ReqPassword = guitils.getPassword("RequestorPassword"); 
	WebDriver driver; 
	FormBuilderRepo ObjForm1=new FormBuilderRepo();

	Date date = new Date(System.currentTimeMillis());
	String tpgName = "VerifySendRequirement" +date; // Trading partner Group Name
	//String tpgTags[] = {"New1"};  // Tag Names (New1)
	String tpgTags[] = {"Organic"};  // Tag Names (New1) // Tag Names  for r3lqa03rk@icix.com
	//String tpgTags[] = { "High Risk"}; // Tag Names  for KLRespStg@icix.com
	//String tpgTags[] = { "qa1"};  // Tag Names for q@pkgo1rk@icix.com
	String tpgStatus[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	String tpgType[] = {}; // tpg Relationship types

	String requestType[] = {"All"};

	String saveOrSend  = "btnSend"; // save or send reqs, supported values are btnSave and btnSend

	@BeforeClass
	public void beforeClass() {
		guitils.InitilizeBrowser(); 
	}

	@AfterClass
	public void afterClass() { 
		//guitils.logoutFromPortal();
        guitils.driver.close();
	}

	@Test
	public void VerifySendRequirement() throws Exception {
		guitils.loginToSalesForce(ReqUserName, ReqPassword);  
		guitils.createNewForm();
		String formNames[] = {ObjForm1.container_Name+guitils.d};
		//String formNames[] = {"Smoke Test Container"};
		
		 System.out.println(formNames);
		//String formNames[] = {"TestcontainerTue Feb 07 15:54:01 IST 2017"};

		guitils.createTPG(tpgName, tpgTags, tpgStatus, tpgType);
		guitils.driver.manage().deleteAllCookies();
		  Thread.sleep(10000);

		
		guitils.SetRequirement(requestType,formNames, saveOrSend );
	}

}