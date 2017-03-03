package icix.Tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import icix.Modules.DocumentLibrary;
import icix.Modules.LoginOut;
import icix.TestData.LoginOutTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.TestBase;

//Scenario: Verify Upload New Public document in ICIX Document library

public class TC9675_Test extends TestBase{

	DocumentLibrary ObjDoc = new DocumentLibrary();
	LoginOut objLoginOut = new LoginOut();


	@Test
	public void Upload(Method method) throws Exception{
		ConsoleLog.info("The Testcase name is :" + method.getName());

		objLoginOut.loginAs(LoginOutTestData.Requestor);
		ObjDoc.UploadDocument(".txt");
	}

}