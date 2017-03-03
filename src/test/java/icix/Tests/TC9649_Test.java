package icix.Tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import icix.Modules.Account;
import icix.Modules.LoginOut;
import icix.TestData.AccountTestData;
import icix.TestData.LoginOutTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.TestBase;

//Scenario: Verify Trading partner search by using trading partner icix id

public class TC9649_Test extends TestBase{

	LoginOut objLoginOut = new LoginOut();
	Account objAccount = new Account();
	String icixId = AccountTestData.icixId;

	@Test
	public void testSearchByIcixId(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());

		// Login to the salesforce
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		objAccount.searchTPBy("IcixId");
	}
}
