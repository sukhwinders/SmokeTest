package icix.Tests;

import java.lang.reflect.Method;
import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.Request;
import icix.Modules.TPGroupCompliance;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

import org.testng.annotations.Test;

//Scenario: Verify Create A New TP Request at requester and verify the request in Responder

public class TC9672_Test extends TestBase {

	FormList ObjForm = new FormList();
	TPGroupCompliance ObjTP = new TPGroupCompliance();
	Request ObjReq=new Request();
	LoginOut objLoginOut = new LoginOut();
	;
	String FormName = TPGroupComplianceTestData.FormName_TC9672;

	@Test
	public void TwoActorWorkFlow(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());

		objLoginOut.loginAs(LoginOutTestData.Requestor);

		ObjReq.sendRequest(TPGroupComplianceTestData.RequestName_TC9672, TPGroupComplianceTestData.selectTP_TC9672, TPGroupComplianceTestData.TradingPartnerName_TC9672,
				TPGroupComplianceTestData.ProductName_TC9672, TPGroupComplianceTestData.DocumentName_TC9672, TPGroupComplianceTestData.SendRequestComments_TC9672);

		objLoginOut.loginAs(LoginOutTestData.Responder);
				ObjReq.submitBackToRequestor(TPGroupComplianceTestData.RequestName_TC9672, TPGroupComplianceTestData.ContainerName_TC9672, 
				TPGroupComplianceTestData.AttentionComments_TC9672, TPGroupComplianceTestData.TestingFacility_TC9672);
	}

}