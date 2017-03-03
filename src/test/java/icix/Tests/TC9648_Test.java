package icix.Tests;

//Scenario: Verify Trading partner search by using Trading partner Company Name

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import icix.Modules.Account;
import icix.Modules.LoginOut;
import icix.TestData.AccountTestData;
import icix.TestData.LoginOutTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.TestBase;

public class TC9648_Test extends TestBase {

	Account objAccount=new Account();
	LoginOut objLoginOut = new LoginOut();
	String companyName = AccountTestData.SearchbyCompanyName;

	@Test
	public void SearchByCompanyName(Method method) throws Exception {
		ConsoleLog.info("Test Case Name is : "+method.getName());

		// Login to the salesforce
		objLoginOut.loginAs(LoginOutTestData.Requestor);

		objAccount.searchTPBy(companyName);
	}

}
