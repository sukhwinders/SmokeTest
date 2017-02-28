package icix.Tests;

import java.lang.reflect.Method;

import icix.Modules.LoginOut;
import icix.Modules.TPGroupCompliance;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TakeScreenshots;
import icix.Utils.TestBase;
import org.testng.annotations.Test;

//Scenario - Verify user is able to create Trading Partner group with the combination of tag,status and Type

public class TC10467_Test extends TestBase{
	
	LoginOut objLoginOut = new LoginOut();
	TPGroupCompliance ObjTP=new TPGroupCompliance();

	@Test
	public void TPG_RelationshipType(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());

		//Login with requestor
		objLoginOut.loginAs(LoginOutTestData.Requestor);

		// Creating New Trading Partner Group with the combination of tag,status and Type
		ObjTP.createTPG(TPGroupTestData.tpgName_TC10467, TPGroupTestData.tpgTags_TC10467, TPGroupTestData.tpgStatus_TC10467, TPGroupTestData.tpgType_TC10467);
		TakeScreenshots.takescreenshotOnSuccess();
	}
}	