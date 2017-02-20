package icixTestData;

import java.util.Date;

import org.openqa.selenium.WebDriver;

import ModuleLocatorRepository.FormBuilderRepo;

import com.utils.Data_loading;

public class FormBuilderTestData {
	
	Data_loading guitils = new Data_loading();
	public String ReqUserName = guitils.getUserName("RequestorUsername");
	public String ReqPassword = guitils.getPassword("RequestorPassword");
	public String Responder = guitils.getDATA("TPResponder");
	public String ResUserName = guitils.getUserName("ResponderUsername");
	public String ResPassword = guitils.getPassword("RequestorPassword");
	public String comment = guitils.getPassword("Comments");
	//WebDriver driver;
	
	public boolean BPform = true; // Best practice form or not?
	public int NoOfTabs = 1; // No of Tabs
	public int NoOfSections = 1; // No of sections in each tab
	public boolean generateServiceSection = false; // generate Service Section
	public int NoOfQuestions = 1; // No of Questions in each Section
	public int NoOfLinkedQuest = 0; // No of Linked Questions
	public int NoOfReqQuest = 0; // No of Mandatory fields Questions in Total questions 
	public int NoOfReadOnlyQuest = 0; // No of Read Only Questions in Total questions 
	public String ansType[] = {"text"}; // for different answer type, available types text,checkbox, date, datetime,multi-picklist, number,picklist,long text,upload,search,multi-search,radio,email address
	public String picklistVal;  // If answer type is picklist then set values available types boolean,chemicals,countries,currencies,ingredients,microbiological,months
	public String MultiPickVal; // If answer type is multi-picklist then set values available types boolean,chemicals,countries,currencies,ingredients,microbiological,months
	public String NamenValue[][] = {{}, // add picklist or multi-picklist options -- add name here
							 {}}; // // add picklist  or multi-picklist options -- add Value here
	public String defaultVal; // Select default value for picklist and multi-picklist
	public String dependencyValue ;  // Select dependency value , It should be in NamenValue list
	public String newFeature; // it's created for feature purpose, now leave it. 

	
	public Date d = new Date(System.currentTimeMillis());
	public String tpgName = "SendMultipleRequirement" + d; // Trading partner Group Name
	public String tpgTags[] = { "easy" };  // Tag Names
	public String tpgStatus[]= {}; // tpg Status
	public String tpgType[] = {}; // tpg Relationship types
	
	public String container_Name = "Testcontainer" + d;
	//For FormBuilder
	
	FormBuilderRepo ObjForm=new FormBuilderRepo();
	
	//TP_Compliance tpc=new TP_Compliance();
	
	public String requestType[] = {"All"};
	public String formNames[] = {ObjForm.container_Name,"SC_Demo_Form"};
	public String btnClick = "btnSend"; // save or send reqs, supported values are btnSave and btnSend
	public String saveOrSend = "btnSend"; // save or send reqs, supported values are btnSave and btnSend
	public String wfStatus = "Open"; // Workflow status, supported values are Closed, Open.
	public String ReqStatus = "New"; // Request Status , Supported values are New,Approved, Rejected, Cancelled etc..
	//String tabName = "Workflows"; // on which object you want to search 
	//String searchKeyWord = ObjForm.container_Name;// name of the record
	
	public String FormName="container_Name";
	public int assertReqsSize = formNames.length; // No of Requirements for Assert. i.e No of forms 
	public boolean removeReqs = false; // remove requirements or not?
	
	
	

}
