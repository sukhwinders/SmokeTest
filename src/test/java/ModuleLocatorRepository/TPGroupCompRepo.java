package ModuleLocatorRepository;

public class TPGroupCompRepo {
	// tpg 	
		public static String tpgTab = "//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]";
		public static String tpgNewBtn = "div[title='New']";
		public static String tpgName = "txtGroupName";
		public static String tagName = "//span[contains(.,'GFSI Certified')]";
		public static String tpgSave = ".//*[@id='btnSave']";
		public static String successMsg = "//p[@class='ng-binding']";
		public static String tpgPopupClose = "div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand";
		//public static String tpgClose="//button[@class='slds-button slds-button--brand']";
		public static String statusTab = "//a[contains(.,'Status')]";
		public static String statusPending = "//span[contains(.,'Pending')]";
		public static String statusActive = "//span[contains(.,'Active')]";
		public static String moveIconRight = ".//*[@id='icnMoveRight']";
		public static String typeTab = "//a[contains(.,'Type')]";
		public static String typeAgent = "//span[contains(.,'Agent')]";
		public static String typeBroker = "//span[contains(.,'Broker')]";
		public static String editTPG = "//a[@title='Edit']";

	// tpg compliance 	
		//public static String showMoreActionsIcon = "//span[@title='Show more actions for this record']";
		//public static String showMoreActionsIcon = "//a[@title='Show more actions for this record']";
		public static String showMoreActionsIcon="//a[contains(@title,'Show more actions for this record')]";
		
		public static String setReqBtn = "//a[@title='Set Requirements']";
		public static String tpgRelated = "//span[contains(.,'Related')]";
		public static String tpgCompLink = "//span[contains(.,'Trading Partner Group Requirements')]";
		public static String RequestType = "RequestType0";
		public static String DocType ="DocType0";
		public static String dueDate = "//input[@id='']";
		public static String calender = ".slds-day.ng-binding.ng-scope";
		public static String reqSaveUpdateMsg = "//h3[@class='ng-binding']";
		public static String reqSendMsg=".ng-binding>div";
		public static String reqList = "//div/div[2]/div/div[3]/div/div/table/tbody/tr/th/a";
		 public static String reqLists ="//th[@tabindex='-1']";
	// Global	
		public static String searchBox = "//input[@title='Search Salesforce']";
	
	// Workflows
		public static String wfStatus = "//span[contains(.,'Workflow Status')]/following::span[2]";
		public static String ReqStatus = "//span[contains(.,'Request Status')]/following::span[2]";
}
