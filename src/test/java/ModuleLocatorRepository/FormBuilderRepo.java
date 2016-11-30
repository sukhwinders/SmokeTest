package ModuleLocatorRepository;
import java.util.Date;

public class FormBuilderRepo {
		
	public String lnkFormList="//span[@class='label slds-truncate slds-text-link'][contains(.,'FormList')]";
	public String ButtonsBlock="buttonsBlock";
	public String btnBtn1=".//*[@id='buttonsBlock']/input[1]";
	public String txtContainerName="//input[@id='j_id0:form:containerBlock:containerNew:inputContainerName']";
	public String drpContainerConType="j_id0:form:containerBlock:containerNew:inputContainerContainerType";
	public String drpContainerType="j_id0:form:containerBlock:containerNew:inputContainerType";
	public String chkFormType="j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm";
	public String btnCreateCon="j_id0:form:containerBlock:createContainer";
	public String btnSaveCon="j_id0:form:buttonSave";
	public String TabLayout="j_id0:form:tabLayout_lbl";
	public String txtLayoutName="j_id0:form:layoutBlock:layoutNew:inputLayoutName";
	public String LayoutType="j_id0:form:layoutBlock:layoutNew:inputLayoutUiType";
	public String btnCreateLayout="j_id0:form:layoutBlock:createLayout";
	public String btnSaveLayout="j_id0:form:buttonSave";
	public String tabTabs="j_id0:form:tabTabs_lbl";
	public String btnCreateTab="j_id0:form:createTab";
	public String tbllist="//table[@class='list']";
	public String tblElement="tr";
	public String txtName="//input[@type='text']";
	public String btnSaveTab="j_id0:form:buttonSave";
	public String btnSelectTab="j_id0:form:tabBlock:tabSection:tabTable:0:selectTab";
	public String tabSection="j_id0:form:tabSections_lbl";
	public String btnAddSection="//input[contains(@id,'createSection')]";
	public String btnSaveSection="//input[@value='SAVE']";
	public String btnSelectSection="//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection']";
	public String tabQst="j_id0:form:tabLinkedQuestions_lbl";
	public String txtQstName="j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName";
	public String txtAreaAns="//textarea[contains(@id,'inputQuestionQuestionText')]";
	public String btnAddQst="j_id0:form:newElementWithQuestion:addNewLinkedQuestion";
	public String btnSaveAll="j_id0:form:buttonSave";
	public String btnPublish="j_id0:form:buttonPublish";
	
	
	public Date d = new Date(System.currentTimeMillis());
	public String container_Name = "Testcontainer" + d;
	public String Layout_Name = "QA_Testlayout" + d;
	public String Tab_Name = "Testtab" + d;
	public String Section_Name = "Testsection" + d;
	public String QuestionName = "QAQuestion1";
	public String AnswerName = "QAAnswer";
	
	
	

}
