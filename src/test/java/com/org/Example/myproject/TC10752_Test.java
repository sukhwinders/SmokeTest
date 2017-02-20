package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Date;






import com.utils.Data_loading;

import ModuleLocatorRepository.FormBuilderRepo;


public class TC10752_Test {
	
	Data_loading guitils = new Data_loading();	
	String ReqUserName = guitils.getUserName("RequestorUsername");
	String ReqPassword = guitils.getPassword("RequestorPassword");	
	String ResUserName = guitils.getUserName("ResponderUsername");
	String ResPassword = guitils.getPassword("ResponderPassword");	
	
	FormBuilderRepo ObjForm=new FormBuilderRepo();

	Date date = new Date(System.currentTimeMillis());
	String tpgName = "VerifySendReqAtRespSide" +date; // Trading partner Group Name
	String tpgTags[] = {"Organic"};  // Tag Names
	String tpgStatus[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	String tpgType[] = {}; // tpg Relationship types
	
	String requestType[] = {"All"};
	
	String saveOrSend  = "btnSend"; // save or send reqs, supported values are btnSave and btnSend
	
	String tabName = "Trading Partner Groups"; // on which object you want to search 
	//String searchKeyWord = ObjForm.container_Name+guitils.d;// name of the record
	
	@BeforeClass
	public void beforeClass() {
		guitils.InitilizeBrowser();	
	}

	@AfterClass
	public void afterClass() {	
		guitils.logoutFromPortal();
		guitils.driver.quit();
	}

	@Test
	public void VerifySendReqAtRespSide() throws Exception {
		guitils.loginToSalesForce(ReqUserName, ReqPassword);		
// Create a form
		guitils.createNewForm();
		String formNames[] = {ObjForm.container_Name+guitils.d};
		String searchKeyWord = ObjForm.container_Name+guitils.d;// name of the record
		
// Create a Trading partner Group		
		guitils.createTPG(tpgName, tpgTags, tpgStatus, tpgType);
		guitils.driver.manage().deleteAllCookies();
		  Thread.sleep(10000);
// Set the Requirements then send 		
		guitils.SetRequirement(requestType,formNames, saveOrSend );	
//	Verify the request at Responder	side
		guitils.logoutFromPortal();
		Thread.sleep(400000);
		guitils.loginToSalesForce(ResUserName, ResPassword);
		Thread.sleep(5000);
		guitils.searchAnything(tabName,searchKeyWord);	
	}
}
