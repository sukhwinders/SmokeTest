package icix.Tests;

import java.lang.reflect.Method;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.TPGroupCompliance;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TakeScreenshots;
import icix.Utils.TestBase;

public class TC10752_Test{
	
	LoginOut objLoginOut = new LoginOut();
	FormList ObjFormList=new FormList();
	TPGroupCompliance ObjTP=new TPGroupCompliance();	
	
	public  void VerifySendReqAtRespSide(Method method) throws Exception {
		ConsoleLog.info("The testcase name is :" + method.getName());
		TakeScreenshots.takescreenshotOnSuccess();		

		objLoginOut.loginAs(LoginOutTestData.Responder);
//		Thread.sleep(8000);
		ObjTP.searchAnythingTest(FormListTestData.formNames_TC9670[0], FormListTestData.tPRequestName);	
		Thread.sleep(4000);
		
		objLoginOut.logout();
	}
}
