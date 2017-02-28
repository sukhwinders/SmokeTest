package icix.Tests;

import java.lang.reflect.Method;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.Request;
import icix.Modules.TPGroupCompliance;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TakeScreenshots;
import icix.Utils.TestBase;

import org.testng.annotations.Test;


public class TC10753_Test extends TestBase{
	FormList ObjFormList=new FormList();
	TPGroupCompliance ObjTP=new TPGroupCompliance();
	LoginOut objLoginOut = new LoginOut();
	Request objRequest = new Request();

	public void  VerifyRequestClosedAfterRemovingRequirement(Method method) throws Exception {
		ConsoleLog.info("The testcase name is VerifyRequestClosedAfterRemovingRequirement");
		TakeScreenshots.takescreenshotOnSuccess();	
		
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		Thread.sleep(8000);
		ObjTP.searchAnythingTest(FormListTestData.formNames_TC9670[0], FormListTestData.tPRequestName);
		objRequest.VerifyRequestStatus("Open");
		ObjTP.deleteRequirement(TPGroupComplianceTestData.tpgName);
		ObjTP.searchAnythingTest(FormListTestData.formNames_TC9670[0], FormListTestData.tPRequestName);
		objRequest.VerifyRequestStatus("Closed");

		//Deleting the form
		ObjFormList.deleteForm(FormListTestData.formNames_TC9670);

	}
}
