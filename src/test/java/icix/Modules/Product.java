package icix.Modules;

import icix.Locators.ProductRepo;
import icix.TestData.ProductTestData;
import icix.Utils.Common;
import icix.Utils.TakeScreenshots;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Product {
	String randomNumbers = RandomStringUtils.randomNumeric(10);

	public void createProductManager(String ProgramName,String CategoryName,String TestClass,
			String TestName,String  TestType,String TestMethodName,String Operator,String Value,String Measure,String Message) throws InterruptedException{

		Common.ClickElement(ProductRepo.lnkProductTestManager, 10);

		Common.SwitchToFrame();

		Common.ClickElement(ProductRepo.btnCreateNewTestProgram,6000);
		Common.ClearAndSendKeys(ProductRepo.txtBoxTestProgramName, ProgramName, 3000);
		Common.ClickElement(ProductRepo.btnProgramNameNext,3000);
		Common.ClickElement(ProductRepo.selectApprovedLabs,3000);
		Common.ClickElement(ProductRepo.moveRight,6000);
		Common.ClickElement(ProductRepo.btnCreateTProgram,3000);
		//AddNewCategory
		Common.ClickElement(ProductRepo.btnAddNewCategory,3000);
		Common.ClearAndSendKeys(ProductRepo.txtBoxCategoryName, CategoryName, 3000);
		Common.ClearAndSendKeys(ProductRepo.txtBoxTestClass, TestClass, 3000);
		Common.ClearAndSendKeys(ProductRepo.txtBoxTestName, TestName, 3000);
		Common.SelectDropdownText(ProductRepo.dropDownTestType, TestType, 1000);
		Common.ClearAndSendKeys(ProductRepo.txtBoxTestMethod, TestMethodName, 8000);
		Common.mouseHover(ProductRepo.dropdownLimit,ProductRepo.limti,5000);
		Common.SelectDropdownText(ProductRepo.dropDownOperator, Operator, 1000);
		Common.ClearAndSendKeys(ProductRepo.txtboxValue, Value, 2000);
		Common.SelectDropdownText(ProductRepo.dropDownMeasure, Measure, 1000);
		Common.SelectDropdownText(ProductRepo.dropDownMessage,Message, 4000);
		Common.ClickElement(ProductRepo.btnAddTestLimit,5000);
		Common.ClickElement(ProductRepo.btnSaveCategory,3000);
		Common.SwitchToDefaultContent(2000);


	}


	public void Container(String FormName, String ProgramName) throws InterruptedException
	{
		Common.SwitchToLightiningView();
		Common.ClickElement(ProductRepo.lnkContainerTemplates,6000);
		Common.searchAndPublishProductForm(FormName);
		Common.ClickElement(ProductRepo.statusbutton,6000);
		Common.ClickElement(ProductRepo.StatusDropdown,6000);
		Common.ClearAndSendKeys(ProductRepo.searchTestingProgram,ProgramName, 2000);
		Common.ClickElement(By.xpath("//div[@title='"+ProgramName+"']"),6000);
		Common.ClickElement(ProductRepo.btnSaveForm,6000);

	}
	///code fo 3 actor  create product 
	public void createProduct(String SearchProductForTradingPartner, String NameofProduct,String ProductRelationshipWithTP,String ProgramName,String privacysetting,String UPCproduct) throws InterruptedException

	{

		Common.SwitchToLightiningView();
		Common.ClickElement(ProductRepo.linkProduct,8000);
		Common.RefreshPage(3000);
		Common.ClickElement(ProductRepo.btnNewProduct,3000);

		Common.SwitchToFrame();
		Common.ClearAndSendKeys(ProductRepo.tbSearchTP, SearchProductForTradingPartner, 2000);
		Common.ClickElement(ProductRepo.selectTP,6000);
		Common.ClickElement(ProductRepo.btnProductSearch,6000);
		Common.ClickElement(ProductRepo.btnCreateProduct,6000);
		Common.ClearAndSendKeys(ProductRepo.tbPName, NameofProduct, 4000);
		Common.ClickElement(ProductRepo.btnNextProduct,5000);
		Common.ClearAndSendKeys(ProductRepo.tbRelationshipTPName,ProductRelationshipWithTP, 3000);
		Common.ClickElement(ProductRepo.selectTPforProduct,6000);

		Common.ClickElement(ProductRepo.tabPravacySettings,5000);
		Common.ClickElement(ProductRepo.rbtnPublic,4000);

		Common.ClickElement(ProductRepo.btnSavePro,5000);
		Common.assertText(ProductRepo.verifyCreateProductMessage,"New Product Relationship created successfully.", 1000); 
		Common.ClickElement(ProductRepo.popupClose,5000);

	}

	public void addProductGroup(String prodGrpName){

		Common.openAppLauncher();
		//Open Product group page
		Common.ClickElement(ProductRepo.lnkProductGroups, 3000);
		Common.ClickElement(ProductRepo.btnNew, 2000);

		Common.SwitchToFrame();
		//enter product group details
		Common.ClearAndSendKeys(ProductRepo.txtNameOfGroup, prodGrpName, 2000);

		//add tags
		Common.ClickElementByIndex(ProductRepo.chkbxTag, 0, 0);

		//add status
		Common.ClickElement(ProductRepo.tabStatus, 2000);
		Common.ClickElement(ProductRepo.activeStatus, 0);
		Common.ClickElement(ProductRepo.btnMoveRight, 2000);
		Common.ClickElement(ProductRepo.btnSaveProdGrp, 3000);

	}

	public void verifySuccessMessage(){
		if(Common.checkExistenceOfElement(ProductRepo.successMessageProdGrp, 2000)==true){
			Assert.assertTrue(true, "Group saved successfully.");
		}
		else{
			Assert.assertFalse(true, "Success message did not appear.");
		}
	}	

	public void addAndVerifyTag(String SearchProductForTradingPartner, String NameofProduct, String tagName) throws InterruptedException{
		Common.ClickElement(ProductRepo.linkProduct,8000);
		Common.RefreshPage(3000);
		Common.ClickElement(ProductRepo.btnNewProduct,3000);

		Common.SwitchToFrame();
		Common.ClearAndSendKeys(ProductRepo.tbSearchTP, SearchProductForTradingPartner, 2000);
		Common.ClickElement(ProductRepo.selectTP,6000);
		Common.ClickElement(ProductRepo.btnProductSearch,6000);
		Common.ClickElement(ProductRepo.btnCreateProduct,6000);
		Common.ClearAndSendKeys(ProductRepo.tbPName, NameofProduct, 4000);
		Common.ClickElement(ProductRepo.btnNextProduct,6000);
		Common.ClickElement(ProductRepo.tabRelationshipTags, 2000);
		Common.ClickElement(ProductRepo.lnkAddATag, 5000);
		Common.ClearAndSendKeys(ProductRepo.txtAddATag, tagName, 2000);
		Common.ClickElement(ProductRepo.tabRelationshipTags, 2000);

		for(int counter=0; counter<= Common.getCount(ProductRepo.divRelTagTagName, 2000); counter++){
			if(tagName.equals(Common.getElementText(ProductRepo.divRelTagTagName, 1000)))
				Assert.assertTrue(true);
		}
	}


	public void  createproductgroup(String Group) throws InterruptedException
	{

		Common.SwitchToLightiningView();
		Common.ClickElement(ProductRepo.LinkProduct, 3000);	
		Common.ClickElement(ProductRepo.btnNewProduct, 5000);
		Common.SwitchToFrame();
		Common.ClearAndSendKeys(ProductRepo.txtgroup, Group, 2000);
		Common.ClickElement(ProductRepo.ckeckbox, 2000);
		Common.ClickElement(ProductRepo.btnSaveCategory, 2000);
		Thread.sleep(5200);
		Common.RefreshPage(3000);
		Common.SwitchToDefaultContent(2000);

	}
	public void editproductgroup(String Group) throws InterruptedException
	{

		Common.SwitchToLightiningView();	
		Common.ClickElement(ProductRepo.LinkProduct, 3000);	
		Common.ClickElement(By.xpath("//a[@title='"+Group+"']"), 3000);
		Thread.sleep(3000);
		Common.ClickElement(ProductRepo.Editbutton, 2000);
		Common.SwitchToFrame();
		Common.ClickElement(ProductRepo.ckeckbox, 2000);
		Common.ClickElement(ProductRepo.saveproductgroup, 2000);
		Thread.sleep(4000);
		//	Common.ClickElement(ProductRepo.close, 2000);
	}

	public void verifycreateProduct (String SearchProductForTradingPartner,String ProductRelationshipWithTP,String NameofProduct,String UPCproduct,String productstatus) throws InterruptedException

	{
		Common.SwitchToLightiningView();
		Common.ClickElement(ProductRepo.linkProduct,8000);
		Common.RefreshPage(3000);
		Common.ClickElement(ProductRepo.btnNewProduct,3000);
		Common.SwitchToFrame();
		Common.ClearAndSendKeys(ProductRepo.tbSearchTP, SearchProductForTradingPartner, 2000);
		Common.ClickElement(ProductRepo.tpDrop,6000);
		Common.ClearAndSendKeys(ProductRepo.searchBoxPName, UPCproduct, 2000);
		Common.ClickElement(ProductRepo.btnProductSearch,6000);
		if(productstatus=="Connect to Product")
		{
			Common.assertText(By.xpath("//td[contains(.,'"+productstatus+"')]"),productstatus,2000);

		}

	}


	////////////////////////created by pradeep for product search 

	public void ProductSearchByUniID(String TradingPartner, String UniID, String ProductNam, String Upcode, String Upcodetxt,
			String Productdisc, String TPRelation) throws InterruptedException{
		Common.openAppLauncher();
		Common.ClickElement(ProductRepo.lnkIcixProduct, 5000);
		Common.ClickElement(ProductRepo.btnNew, 500);
		List<WebElement> NewRequestFrame=Common.FindAllElements(ProductRepo.frame,10);
		System.out.println(NewRequestFrame.size());
		if (NewRequestFrame.size()>0)
		{
			if (NewRequestFrame.size()>1)
			{
				Common.SwitchToFrame(NewRequestFrame.get(1), 1000);
			}
			else
			{
				Common.SwitchToFrame(NewRequestFrame.get(0), 1000);
			}
		}
		Common.ClearAndSendKeys(ProductRepo.SearchTP, TradingPartner, 120);
		Common.ClickElement(ProductRepo.tpDrop, 120);
		Common.ClearAndSendKeys(ProductRepo.universalID, UniID + randomNumbers, 120);
		Common.ClickElement(ProductRepo.btnSearch, 120);
		Common.waitForElementToBeVisible(ProductRepo.productSearchResults, 6);
		Common.ClickElement(ProductRepo.createPrdt, 120);
		Common.ClearAndSendKeys(ProductRepo.productName, ProductNam, 120);
		Common.SelectDropdownText(ProductRepo.idsDrop, Upcode, 120);
		Common.ClearAndSendKeys(ProductRepo.idTxt, Upcodetxt + randomNumbers, 120);
		Common.ClearAndSendKeys(ProductRepo.productDescrip, Productdisc, 120);
		Common.ClickElement(ProductRepo.btnNext, 120);
		Common.ClearAndSendKeys(ProductRepo.relationTP, TPRelation, 120);
		Common.ClickElement(ProductRepo.btnSave, 120);
		Common.SwitchTab(120);
		Common.ClickElement(ProductRepo.btnClose, 120);
		Assert.assertTrue(Common.getElementText(ProductRepo.icixProductID, 90).equalsIgnoreCase(""));
		TakeScreenshots.takescreenshotOnSuccess();

	}


	public void ProductSearchWithoutUID(String TradingPartner,  String ProductNam, String Upcode, String Upcodetxt,
			String Productdisc, String TPRelation) throws InterruptedException{

		Common.openAppLauncher();
		Common.ClickElement(ProductRepo.lnkIcixProduct, 90);
		Common.ClickElement(ProductRepo.btnNew, 500);
		List<WebElement> NewRequestFrame=Common.FindAllElements(ProductRepo.frame,10);
		System.out.println(NewRequestFrame.size());
		if (NewRequestFrame.size()>0)
		{
			if (NewRequestFrame.size()>1)
			{
				Common.SwitchToFrame(NewRequestFrame.get(1), 1000);
			}
			else
			{
				Common.SwitchToFrame(NewRequestFrame.get(0), 1000);
			}
		}
		Common.ClearAndSendKeys(ProductRepo.SearchTP, TradingPartner, 120);
		Common.ClickElement(ProductRepo.tpDrop, 120);
		Common.ClickElement(ProductRepo.btnSearch, 120);
		Common.ClickElement(ProductRepo.createPrdt, 120);
		Common.ClearAndSendKeys(ProductRepo.productName, ProductNam, 120);
		Common.SelectDropdownText(ProductRepo.idsDrop, Upcode, 120);
		Common.ClearAndSendKeys(ProductRepo.productDescrip, Productdisc, 120);
		Common.ClickElement(ProductRepo.btnNext, 120);
		Common.ClearAndSendKeys(ProductRepo.relationTP, TPRelation, 120);
		Common.SelectDropdownText(ProductRepo.Relationtype,ProductTestData.RelationshipType , 3);
		Common.ClickElement(ProductRepo.btnSave, 120);
		Common.SwitchTab(500);
		Common.ClickElement(ProductRepo.btnClose, 50);
		Assert.assertTrue(!Common.getElementText(ProductRepo.icixProductID, 50).equalsIgnoreCase(""));
		TakeScreenshots.takescreenshotOnSuccess();
	}
}
