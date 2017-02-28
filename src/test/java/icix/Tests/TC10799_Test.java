package icix.Tests;

import java.lang.reflect.Method;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.TPGroupCompliance;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

import org.testng.annotations.Test;

//Scenario : Tp Group Compliance - Automatic request creation by adding a member automatically to a group

public class TC10799_Test extends TestBase{

	FormList ObjForm=new FormList();
	TPGroupCompliance ObjTP=new TPGroupCompliance();
	LoginOut objLoginOut = new LoginOut();

	@Test
	public void AutoReqCreationAddTP(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());
		
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		// Create a Trading partner Group
		ObjTP.createTPG(TPGroupComplianceTestData.tpgName_TC10799, TPGroupComplianceTestData.tpgTags_TC10799, TPGroupComplianceTestData.tpgStatus_TC10799, TPGroupComplianceTestData.tpgType_TC10799);

		// Set the Requirements then save
		ObjTP.SetRequirement(TPGroupComplianceTestData.requestType_TC10799, TPGroupComplianceTestData.formNames_TC10799, TPGroupComplianceTestData.saveOrSend_TC10799);	

		// Edit tpg to add members
		ObjTP.editTPG(TPGroupComplianceTestData.editTags_TC10799);
		
		// Search for request
		ObjTP.searchAnything(TPGroupComplianceTestData.tabName_TC10799, TPGroupComplianceTestData.searchKeyWord_TC10799);
		
	}
}
