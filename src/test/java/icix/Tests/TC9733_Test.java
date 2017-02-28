package icix.Tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.Request;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.ProductTestData;
import icix.TestData.RequestTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

//Scenario: Verify Trading Partner two Actor Workflow Approve request

public class TC9733_Test extends TestBase{

	FormList ObjForm=new FormList();
	Request ObjReq=new Request();
	LoginOut objLoginOut = new LoginOut();

	@Test
	public void Approve_Request(Method method) throws Exception {
		Log.info("The Testcase name is :" + method.getName());
		ConsoleLog.info("The Testcase name is :" + method.getName());
		
		//Login with requestor
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		//Send request to responder
		ObjReq.sendRequest(RequestTestData.RequestName, RequestTestData.selectTP, RequestTestData.TradingPartnerName, ProductTestData.ProductName, 
				FormListTestData.DocumentNamefor2Actor, RequestTestData.SendRequestComments);

		//Logout from requestor
		objLoginOut.logout();
		
		//Login with responder
		objLoginOut.loginAs(LoginOutTestData.Responder);
		
		//Search request and submit back to requestor
		ObjReq.submitBackToRequestor(RequestTestData.RequestName, RequestTestData.ContaninerNamefor2Actor, RequestTestData.AttentionComments, RequestTestData.DocumentName);

		//Logout from responder
		objLoginOut.logout();

		//Login with requestor
		objLoginOut.loginAs(LoginOutTestData.Requestor);

		//Search request and approve
		ObjReq.ApproveRequest(RequestTestData.RequestName, RequestTestData.ApprovedComments);
		
		//Verify status
		ObjReq.VerifyRequestStatus("Approved");
	}	

}

