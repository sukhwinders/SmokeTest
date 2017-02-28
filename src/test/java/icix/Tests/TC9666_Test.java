package icix.Tests;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.TPGroupCompliance;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;
import java.lang.reflect.Method;
import org.testng.annotations.Test;

//Scenario: Verify User able to send the Requirements to the trading partner group Members

public class TC9666_Test extends TestBase {

	FormList ObjFormList = new FormList();
	TPGroupCompliance ObjTPGroupCompliance = new TPGroupCompliance();
	LoginOut objLoginOut = new LoginOut();

	@Test(priority=1)
	public void VerifySendRequirement(Method method) throws Exception {
		ConsoleLog.info("The testcase name is: " + method.getName());
		
		//Login the application with requestor
		objLoginOut.loginAs(LoginOutTestData.Requestor);

		// Create a form
		ObjFormList.createNewForm(FormListTestData.BPform_TC9670, FormListTestData.NoOfTabs_TC9670, FormListTestData.NoOfSections_TC9670, FormListTestData.generateServiceSection_TC9670, 
				FormListTestData.NoOfQuestions_TC9670, FormListTestData.NoOfLinkedQuest_TC9670, FormListTestData.NoOfReqQuest_TC9670, FormListTestData.NoOfReadOnlyQuest_TC9670,
				FormListTestData.ansType_TC9670, FormListTestData.picklistVal_TC9670, FormListTestData.MultiPickVal_TC9670, 
				FormListTestData.NamenValue_TC9670, FormListTestData.defaultVal_TC9670, FormListTestData.dependencyValue_TC9670, 
				FormListTestData.newFeature_TC9670, FormListTestData.formNames_TC9670);


		// Create a Trading partner Group
		ObjTPGroupCompliance.createTPG(TPGroupComplianceTestData.tpgName, TPGroupComplianceTestData.tpgTags, TPGroupComplianceTestData.tpgStatus, TPGroupComplianceTestData.tpgType);

		// Set the Requirements then send 		
		ObjTPGroupCompliance.SetRequirement(TPGroupComplianceTestData.requestType, FormListTestData.formNames_TC9670, TPGroupComplianceTestData.saveOrSend);
//		ObjFormList.deleteForm(FormListTestData.formNames_TC9670);
		objLoginOut.logout();
	}
	
	@Test(priority=2)
	public void VerifySendReqAtRespSide(Method method) throws Exception{
		TC10752_Test test=new TC10752_Test();
		test.VerifySendReqAtRespSide(method);
	}

	@Test(priority=3)
	public void VerifyRequestClosedAfterRemovingRequirement(Method method) throws Exception{
		TC10753_Test test=new TC10753_Test();
		test.VerifyRequestClosedAfterRemovingRequirement(method);
	}

}
