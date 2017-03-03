package icix.TestData;

import java.util.Date;

public class TPGroupComplianceTestData {

	static Date d = new Date(System.currentTimeMillis());
	
	//Test data for TC9672
	public static String FormName_TC9672 = "BSE Statement";
	public static String[] formNames_TC9672 = {"Testing-Tr"};
	public static String RequestName_TC9672 = "AutoTest"+ d;
	public static boolean selectTP_TC9672 = true;
	public static String TradingPartnerName_TC9672 = "Rel PKG 05"; //"sdd3v06";
	public static String ProductName_TC9672 = null;
	public static String DocumentName_TC9672 = "Dev PKG 02";
	public static String SendRequestComments_TC9672 = "Test comment";
	public static String ContainerName_TC9672 = "Testcontainer";
	public static String AttentionComments_TC9672 = "Request is sent..";
	public static String TestingFacility_TC9672 = null;
	
	//Test data for TC9666
	public static String tpgName = "VerifySendRequirement " +d; // Trading partner Group Name
	public static String tpgTags[] = {"Organic"};  // Tag Names (New1) // Tag Names  for r3lqa03rk@icix.com
	public static String tpgStatus[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	public static String tpgType[] = {}; // tpg Relationship types
	public static String requestType[] = {"All"};
	public static String saveOrSend  = "btnSend"; // save or send reqs, supported values are btnSave and btnSend
	public static String searchKeyWord ="Automation";
	
	//Test data for TC10799
	public static String tpgName_TC10799 = "AutoReqCreationAddTP " + d; // Trading partner Group Name
	public static String tpgTags_TC10799[] = {"Kosher"};  // Tag Names
	public static String tpgStatus_TC10799[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	public static String tpgType_TC10799[] = {}; // tpg Relationship types
	public static String requestType_TC10799[] = {"All"};
	public static String saveOrSend_TC10799  = "btnSave"; // save or send reqs, supported values are btnSave and btnSend
	public static String tabName_TC10799 = "Requests"; // on which object you want to search 
	public static String wfStatus_TC10799 = "Open"; // Workflow status, supported values are Closed, Open.
	public static String ReqStatus_TC10799 = "New"; // Request Status , Supported values are New,Approved, Rejected, Cancelled etc..
	public static String editTags_TC10799[] = {"Kosher","Organic"}; // Tpg tags for editing tpg
	public static String formNames_TC10799[] = { "Automation" };
	public static String[] searchKeyWord_TC10799 = FormListTestData.formNames_TC9670; // Requirement
}
