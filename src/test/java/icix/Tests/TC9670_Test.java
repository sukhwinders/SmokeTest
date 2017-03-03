package icix.Tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.TestBase;

//Scenario: Verify Create a New  From using form Builder

public class TC9670_Test extends TestBase{
	
	LoginOut objLoginOut = new LoginOut();
	FormList objFormList = new FormList();

	@Test
	public void createNew_form(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());
		
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		objFormList.createNewForm(FormListTestData.BPform_TC9670, FormListTestData.NoOfTabs_TC9670, FormListTestData.NoOfSections_TC9670, FormListTestData.generateServiceSection_TC9670, 
				FormListTestData.NoOfQuestions_TC9670, FormListTestData.NoOfLinkedQuest_TC9670, FormListTestData.NoOfReqQuest_TC9670, FormListTestData.NoOfReadOnlyQuest_TC9670,
				FormListTestData.ansType_TC9670, FormListTestData.picklistVal_TC9670, FormListTestData.MultiPickVal_TC9670, 
				FormListTestData.NamenValue_TC9670, FormListTestData.defaultVal_TC9670, FormListTestData.dependencyValue_TC9670, 
				FormListTestData.newFeature_TC9670, FormListTestData.formNames_TC9670);
	}
}
