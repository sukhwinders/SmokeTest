package icix.Tests;

import java.lang.reflect.Method;

import icix.Locators.FormListRepo;
import icix.Locators.TPGroupComplianceRepo;
import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.TPGroupCompliance;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.RequestTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.Common;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

import org.testng.annotations.Test;

//Scenario : Tp Group Compliance - Automatic request creation by adding a member automatically to a group

public class TC10799_Test extends TestBase{

	FormList ObjFormList=new FormList();
	TPGroupCompliance ObjTP=new TPGroupCompliance();
	LoginOut objLoginOut = new LoginOut();

	@Test(description="Tp Group Compliance - Automatic request creation by adding a member automatically to a group")
	public void AutoReqCreationAddTP(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());
		
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		Log.info("Login as a Responder");
		
		ObjFormList.createNewForm(FormListTestData.BPform, FormListTestData.NoOfTabs, FormListTestData.NoOfSections, FormListTestData.generateServiceSection, 
				FormListTestData.NoOfQuestions, FormListTestData.NoOfLinkedQuest, FormListTestData.NoOfReqQuest, FormListTestData.NoOfReadOnlyQuest,
				FormListTestData.ansType, FormListTestData.picklistVal, FormListTestData.MultiPickVal, 
				FormListTestData.NamenValue, FormListTestData.defaultVal, FormListTestData.dependencyValue, 
				FormListTestData.newFeature, FormListTestData.formNames);
		
		// Creating New Trading Partner Group with the combination of tag,status and Type
		ObjTP.createTPG(TPGroupComplianceTestData.tpgName, TPGroupComplianceTestData.tpgTagsTC10799, TPGroupComplianceTestData.tpgStatusTC10799, TPGroupComplianceTestData.tpgTypeTC10799);
		Log.info("Trading Partner Created sucessfully");
		// Set the Requirements then send 		
		ObjTP.SetRequirement(TPGroupComplianceTestData.requestType, FormListTestData.formNames, TPGroupComplianceTestData.buttonsave);
		Log.info("Requirement saved");
		// Edit tpg to add members
		Log.info("Edit tpg to add members");
		ObjTP.editTPG(TPGroupComplianceTestData.tpgTagsQA);
		Log.info("TP Group Edited");
		// Search for request
		Log.info("Search for TP Compliance Request");
		Common.GlobalSearch("Requests", FormListTestData.formNames[0]);
		//ObjTP.searchAnythingTest(FormListTestData.formNames[0], FormListTestData.tPRequestName);	
/*
		Common.openAppLauncher();
		Common.ClickElement(FormListRepo.lnkFormList, 10);
		Common.GlobalSearch("Requests", "565655323232");*/
	//	Common.ClickLink("Automation form Fri Aug 25 11:57:55 IST 2017", 6000);
		
		//Common.search("Requests", "5847852222");
	//	Common.ClickLink(FormListTestData.RequestName, 6000);
		
		
		//ObjTP.searchAnything(TPGroupComplianceTestData.tabName, TPGroupComplianceTestData.searchKeyWord);
		Log.info("Automatic Request created sucessfully");
		
		
	}
}
