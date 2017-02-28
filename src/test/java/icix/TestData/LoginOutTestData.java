package icix.TestData;

import icix.Utils.Log;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

public class LoginOutTestData {

	//Login user types - Added by Vishal Dhiman on 13/02/2017 12:04PM 
	public static String Requestor = "Requestor";
	public static String Responder = "Responder";
	public static String Laboratory = "Laboratory";
	
	//Login
	public static String ResponderUsername;		//"qadbt02rk@icix.com";
	public static String ResponderPassword;			//"testing@1234";
	public static String RequesterUserName; 		//"r3lqa03rk@icix.com";
	public static String RequestorPassword; 			//"Test@12345"
	public static String LabUserName;		//"feature06@icix.com";
	public static String LabPassword;
	
	
	public static void initialiseLoginParameters(ITestContext context) throws Exception {
		Log.info("getting parameters from xml file");
		ResponderUsername = context.getCurrentXmlTest().getParameter("ResponderUsername");
		ResponderPassword = context.getCurrentXmlTest().getParameter("ResponderPassword");
		RequesterUserName = context.getCurrentXmlTest().getParameter("RequesterUserName");
		RequestorPassword = context.getCurrentXmlTest().getParameter("RequestorPassword");
		LabUserName = context.getCurrentXmlTest().getParameter("LabUserName");
		LabPassword = context.getCurrentXmlTest().getParameter("LabPassword");
	}

}
