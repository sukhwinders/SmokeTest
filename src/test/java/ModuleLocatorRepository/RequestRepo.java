package ModuleLocatorRepository;

import java.util.Date;

public class RequestRepo {
	
	// Locators/Webelements
	
	public String lnkRequest="//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]";
	public String lnkWorkflows="//span[@class='label slds-truncate slds-text-link'][contains(.,'Workflows')]";
	public String btnNew="//a[contains(@title,'New')]";
	public String FrameTag="iframe";
	
	//public String txtReqName="requestName";
	public String txtReqName="txtRequestName_Request";
	
	//public String drpTpName="tradingPartnerDropDown"; 
	public String drpTpName="ddlTradingPartnerDropDown";	
	
	public String TpCssSelector="h3.ng-binding";
	
	
	//public String TpCssSelector1="button.slds-button.slds-button--neutral";
	public String btnSelectDocument="btnSelectDocument";
	
	
	//public String TemplateCategory="//a[contains(@ng-click,'populateDocTemplate(d.name);')]";
	public String anchorTemplateCategory="All";
	
	public String MainDivForForm="//div[@ng-show='showCategoryModal']";
	public String InnerDivForForm="//div[@class='ng-scope']";
	public String chkForm="//label[@class='slds-checkbox']";
	
	
	//public String btnFormPopCssSelector1="div.slds-modal__footer.slds-modal__footer--directional > button.slds-button.slds-button--brand";
	public String btnAttachRelatedRequest="btnAttachRelatedRequest";	
	
	//public String btnOnPop="//button[3]";
	public String btnSaveRelatedRequest="btnSaveRelatedRequest";
	
	public String txtDate="dueDate";
	public String tblMonth="//table[@class='datepicker__month']";
	public String tblElementByTag="td";
	public String txtComments="comments";
	
	//public String btnSend="//button[contains(.,'Send')]";
	public String btnSend="btnSend";
	
	
	//public String btnClose="//button[contains(text(),'Close')]";
	public String btnCloseMessage="btnCloseMessage";
	
	
	public String txtGlobalSrc="//input[@placeholder='Search Salesforce']";
	public String lnkRelated="//a[@title='Related']";
	public String ArrowForMenu="//a[@class='menuTrigger']";
	public String OpenFormOption="[role='menuitem'][title='Open Form']";
	public String txtForRespAns="//label[contains(.,'QAAnswer')]/following::input[1]";
	public String btnFormSubmit="//button[@ng-click='vm.onSubmit()']";
	public String cssSelectorOfSameElements = "[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']";
	public String lnkApprove="Approve";
	public String txtAreaForAppRej="txt_Comment";
	public String btnSaveAppRej="btn_Save";
	public String lnkReject="Reject";
	//public String txtRejectComments="//label[contains(.,'Comments')]/following::textarea[1]";
	public String txtRejectComments="pagRequestReject:frmMain:pblMainBlock:txtComment";
	//public String btnSubmit="//input[@value='Submit']";	
	public String btnSubmit="pagRequestReject:frmMain:pblMainBlock:btnSubmit";
	public String test="qa";
	public String optReview="Review";
	public String optReAssign="Reassign";
	public String drpReassign="select-01";
	public String btnSubmitReassign="btnSubmit";
	public String btnReassignClose="btnClosePopupBottom";
	public String optCancelRequest="Cancel";
	public String ArrowNextMonth="//button[@title='Next Month']";
	
	
	//--------------------
	//Other Strings for run time test data
	public Date d = new Date(System.currentTimeMillis());
	public String container_Name = "Testcontainer" + d;
	public String Layout_Name = "QA_Testlayout" + d;
	public String Tab_Name = "Testtab" + d;
	public String Section_Name = "Testsection" + d;
	public String FormName=container_Name;
	public String PartialReq = "AutoTest";
	public String PartialContainer = "Testcontainer";
	public String Reqname = "AutoTest" + d;
	public String ResponderComments="Comments from responder";
	public String SendReqComments="Request is sent..";
	public String ApproveComments="Request Approved";
	public String RejectComments="Request Rejected";
	

}
