package com.org.Example.myproject;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9830_Test {

	WebDriver driver;
	String baseUrl;

	Date d = new Date(System.currentTimeMillis());
	String container_Name = "Testcontainer" + d;
	String Layout_Name = "Testlayout" + d;
	String Tab_Name = "Testtab" + d;
	String Section_Name = "Testsection" + d;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Answertype = guitils.getDATA("AnswerType");

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@Test
	public void createNew_form() throws Exception {

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName1);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Test@123");
		driver.findElement(By.id("Login")).click();
		switchtoLightining();
		driver.findElement(By.linkText("App Launcher")).click();
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		// script to container template

		driver.findElement(By.name("j_id0:form:j_id7")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:containerBlock:containerNew:inputContainerName"))
				.clear();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:containerBlock:containerNew:inputContainerName']"))
				.sendKeys("Container_Templete1");

		Select Typedropdown = new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:containerBlock:containerNew:inputContainerType']")));

		Typedropdown.selectByVisibleText("Form");

		Select Containertypedropdown = new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:containerBlock:containerNew:inputContainerContainerType']")));

		Containertypedropdown.selectByVisibleText("Single Form");

		driver.findElement(
				By.xpath("//input[@id='j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm']"))
				.click();

		/*
		 * // Code for effective date List<WebElement> EffectiveDate = driver
		 * .findElements(By
		 * .id("j_id0:form:containerBlock:containerNew:inputContainerEffectiveDate"
		 * ));
		 * 
		 * int Total_node = EffectiveDate.size();
		 * 
		 * for (int i = 0; i < Total_node; i++) { String Date =
		 * EffectiveDate.get(i).getText(); if (Date.equals("10")) {
		 * EffectiveDate.get(i).click(); }
		 * 
		 * }
		 * 
		 * // Code for expiration date List<WebElement> ExpirationDate = driver
		 * .findElements(By .id(
		 * "//input[@id='j_id0:form:containerBlock:containerNew:inputContainerExpirationDate']"
		 * ));
		 * 
		 * int Total_nodes = ExpirationDate.size();
		 * 
		 * for (int i = 0; i < Total_nodes; i++) { String Dates =
		 * ExpirationDate.get(i).getText(); if (Dates.equals("29")) {
		 * ExpirationDate.get(i).click(); }
		 * 
		 * }
		 */
		Select Librarydropdown = new Select(
				driver.findElement(By
						.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary")));

		Librarydropdown.selectByVisibleText("Existing");

		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(3000);

		System.out.println("Container Tab created successfully");

		// script for Layout template
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys("Layout_Name123");
		new Select(driver.findElement(By
				.id("j_id0:form:layoutBlock:layoutNew:inputLayoutSharing")))
				.selectByVisibleText("Public");
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutIsValid"))
				.click();
		new Select(driver.findElement(By
				.id("j_id0:form:layoutBlock:layoutNew:inputLayoutUiType")))
				.selectByVisibleText("desktop");
		driver.findElement(By.id("j_id0:form:layoutBlock:createLayout"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(9000);

		System.out.println("Layout Created successfully");

		// script for creation of 5 Tabs
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.sendKeys("Tab1");
		Thread.sleep(1000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.sendKeys("Tab2");
		Thread.sleep(1000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46"))
				.sendKeys("Tab3");
		Thread.sleep(1000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46"))
				.sendKeys("Tab4");
		Thread.sleep(1000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:4:j_id46"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:4:j_id46"))
				.sendKeys("Tab5");
		driver.findElement(By.id("j_id0:form:buttonSave")).click();

		System.out.println("5 tabs created successfully");

		// Creation sections for tab1
		Thread.sleep(5000);
		// click on tab button
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:selectTab"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				"Tab1Section1");
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.sendKeys("tab1Section2");

		/*
		 * new Select(driver.findElement(By
		 * .id("j_id0_form_sectionBlock_sectionSection_sectionTable_0_j_id86")))
		 * .selectByVisibleText("Row"); new Select(driver.findElement(By
		 * .id("j_id0_form_sectionBlock_sectionSection_sectionTable_1_j_id86")))
		 * .selectByVisibleText("Row");
		 */
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection']"))
				.click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		System.out.println("Tab1 sections run successfully");

		// Creation sections for tab2
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(3000);
		/*
		 * driver.findElement(By.xpath(
		 * "j_id0:form:tabBlock:tabSection:tabTable:1:selectTab']")).click();
		 */
		driver.findElement(
				By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:1:selectTab']"))
				.click();

		Thread.sleep(5000);

		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				"Tab2Section1");
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.sendKeys("tab2Section2");
		/*
		 * new Select(driver.findElement(By
		 * .xpath("//select[contains(@id,'id88')]")))
		 * .selectByVisibleText("Row");
		 */
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection']"))
				.click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		System.out.println("tab2 sections runs successfully");

		// Creation sections for tab3
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:tabBlock:tabSection:tabTable:2:selectTab']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				"Tab3Section1");
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.sendKeys("tab3Section2");
		/*
		 * new Select(driver.findElement(By
		 * .xpath("//select[contains(@id,'id88')]")))
		 * .selectByVisibleText("Row");
		 */
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection']"))
				.click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();
		System.out.println("tab3 sections runs successfully");

		// Creation sections for tab4
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:tabBlock:tabSection:tabTable:3:selectTab']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				"Tab4Section1");
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.sendKeys("tab4Section2");
		/*
		 * new Select(driver.findElement(By
		 * .xpath("//select[contains(@id,'id88')]")))
		 * .selectByVisibleText("Row");
		 */
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection']"))
				.click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();
		System.out.println("tab4 sections runs successfully");

		// Creation sections for tab5
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:tabBlock:tabSection:tabTable:4:selectTab']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				"Tab5Section1");
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.sendKeys("tab5Section2");
		/*
		 * new Select(driver.findElement(By
		 * .xpath("//select[contains(@id,'id88')]")))
		 * .selectByVisibleText("Row");
		 */
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection']"))
				.click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();
		System.out.println("tab5 sections runs successfully");
	}

	public void create_Questions() throws InterruptedException {

		// Text
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys("QuestionText");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys("QuestionText");
		Thread.sleep(2000);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
				.selectByVisibleText("text");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//label[@for='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired']"))
				.click();
		System.out.println("Mandatory field selected");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:0:selectElement']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		// passing Parameters
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("Test data one");
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(

				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166']"))
				.sendKeys("Test data one");
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170']"))
				.sendKeys("T1");
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();

		// Checkbox
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys("QuestionText");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys("QuestionText");
		Thread.sleep(2000);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
				.selectByVisibleText("checkbox");
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:1:selectElement']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		// passing Parameters
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("Test data one");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166']"))
				.sendKeys("Test data one");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170']"))
				.sendKeys("T1");
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();

		// radio
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newElementBlock:inputElementReadOnly']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys("QuestionText");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys("QuestionText");
		Thread.sleep(2000);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
				.selectByVisibleText("radio");
		Thread.sleep(2000);
		Select dependencydropdwn = new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionDependencyAction']")));
		dependencydropdwn.selectByVisibleText("Show");
		Thread.sleep(2000);

		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(7000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:2:selectElement']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		// passing Parameters
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("yes");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");

		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();

		// picklist
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys("QuestionText");
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys("QuestionText");
		Thread.sleep(2000);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
				.selectByVisibleText("picklist");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:3:selectElement']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		// passing Parameters
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("Test data one");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");

		Thread.sleep(7000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(8000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(8000);

	}

	public void switchtoLightining() throws InterruptedException {

		if (driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() > 0) {

			driver.findElement(By.id("userNavLabel")).click();
			driver.findElement(
					By.xpath("//a[@title='Switch to Lightning Experience']"))
					.click();
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for (String curWindow : allWindows) {
				driver.switchTo().window(curWindow);
				// perform operation on popup
				driver.findElement(
						By.xpath("//div[@style='line-height:12px; margin-top: 12px']"))
						.click();
				driver.findElement(By.id("simpleDialog0button0")).click();
				// switch back to parent window
				driver.switchTo().window(parentWindow);
				Thread.sleep(8000);
				driver.navigate().refresh();
			}
		} else if (driver.findElements(By.xpath("//span[@id='userNavLabel']"))
				.size() < 0) {

			driver.findElement(By.linkText("App Launcher")).click();
		}
	}
}
