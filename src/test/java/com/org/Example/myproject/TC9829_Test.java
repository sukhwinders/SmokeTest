package com.org.Example.myproject;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;


public class TC9829_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	Date d = new Date(System.currentTimeMillis());
	String container_Name = "Testcontainer" + d;
	String Layout_Name = "Testlayout" + d;
	String Tab_Name = "Testtab" + d;
	String Section_Name = "Testsection" + d;
	String QuestionText = "Testsection" + d;

	Data_loading guitils = new com.utils.Data_loading();
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

	@AfterClass
	public void afterClass() {
		driver.quit();
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
		Thread.sleep(3000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		// script for container template
		driver.findElement(By.name("j_id0:form:j_id7")).click();
		driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerName")).clear();
		driver.findElement(
				By.id("j_id0:form:containerBlock:containerNew:inputContainerName"))
				.sendKeys(container_Name);
		new Select(
				driver.findElement(By
						.id("j_id0:form:containerBlock:containerNew:inputContainerContainerType")))
		.selectByVisibleText("Single Form");
		new Select(
				driver.findElement(By
						.id("j_id0:form:containerBlock:containerNew:inputContainerType")))
		.selectByVisibleText("Form");
		driver.findElement(
				By.id("j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm"))
				.click();
		new Select(
				driver.findElement(By
						.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary")))
		.selectByVisibleText("Existing");
		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
		.click();
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		// script for Layout template
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys(Layout_Name);
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
		// script for Tabs template
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.clear();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.sendKeys(Tab_Name);
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id57"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(8000);
		driver.findElement(
				By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:0:selectTab']"))
				.click();
		Thread.sleep(9000);
		// Script for Sections template
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
		.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				Section_Name);
		Thread.sleep(3000);
		new Select(driver.findElement(By
				.xpath("//select[contains(@id,'id88')]")))
		.selectByVisibleText("Row");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		// Script for Sections 2 template
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
		.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73']"))
				.sendKeys(Section_Name);
		Thread.sleep(3000);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id88']")))
		.selectByVisibleText("Row");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:1:selectSection']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		// script for 2 Tab template
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.clear();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.sendKeys(Tab_Name);
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable10:j_id57"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(8000);
		driver.findElement(
				By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:0:selectTab']"))
				.click();
		Thread.sleep(9000);
		// Script for Sections template
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
		.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				Section_Name);
		Thread.sleep(3000);
		new Select(driver.findElement(By
				.xpath("//select[contains(@id,'id88')]")))
		.selectByVisibleText("Row");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		// Script for Sections 2 template
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
		.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73']"))
				.sendKeys(Section_Name);
		Thread.sleep(3000);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id88']")))
		.selectByVisibleText("Row");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:1:selectSection']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		// script for 3 Tab template
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46"))
				.clear();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46"))
				.sendKeys(Tab_Name);
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id57"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(8000);
		driver.findElement(
				By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:0:selectTab']"))
				.click();
		Thread.sleep(9000);
		// Script for Sections template
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
		.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				Section_Name);
		Thread.sleep(3000);
		new Select(driver.findElement(By
				.xpath("//select[contains(@id,'id88')]")))
		.selectByVisibleText("Row");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		// Script for Sections 2 template
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
		.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:2:j_id73']"))
				.sendKeys(Section_Name);
		Thread.sleep(3000);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:2:j_id88']")))
		.selectByVisibleText("Row");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:2:selectSection']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();
		/**
		 * Following block of code contains script for adding 4th tabs. For each
		 * tab there will be two sub sections For each section there will be two
		 * questions
		 */

		/* script for 4 Tab template */
		// Click on Tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(3000);
		// Click on add new button
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(3000);
		// Clear tab name text box
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46"))
				.clear();
		Thread.sleep(3000);
		// Fill tab name in the text box
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46"))
				.sendKeys(Tab_Name);
		Thread.sleep(3000);
		// From action column click on Select button for tab 4
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id57"))
				.click();
		Thread.sleep(6000);
		// Click on save button
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(8000);

		driver.findElement(
				By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:0:selectTab']"))
				.click();
		Thread.sleep(9000);

		/* Script for first Section template */
		// Click on Sections tab
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		// Click on add new button
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
		.click();
		Thread.sleep(3000);
		// Fill section name in the text box
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				Section_Name);
		Thread.sleep(3000);
		// Select style Row
		new Select(driver.findElement(By
				.xpath("//select[contains(@id,'id88')]")))
		.selectByVisibleText("Row");
		Thread.sleep(3000);
		// Click on Save button
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);

		// Script for Linked in Questions for section 1(tab 4)
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		/* Script for second section template */
		Thread.sleep(5000);
		// Click on Sections tab
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		// Click on add new button
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
		.click();
		Thread.sleep(3000);
		// Fill section name in the text box
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:2:j_id73']"))
				.sendKeys(Section_Name);
		Thread.sleep(3000);
		// Select style Row
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:2:j_id88']")))
		.selectByVisibleText("Row");
		Thread.sleep(3000);
		// Click on Save button
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);

		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:2:selectSection']"))
				.click();
		Thread.sleep(5000);

		// Script for Linked in Questions for section 2(tab 4)
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		// Publish form
		driver.findElement(By.id("j_id0:form:buttonPublish")).click();
		Thread.sleep(6000);

	}

	public void create_Questions() throws InterruptedException {

		// Text
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys(QuestionText);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys(QuestionText);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
		.selectByVisibleText("text");
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
		Thread.sleep(6000);
		// passing Parameters

		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("Test data one");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166']"))
				.sendKeys("Test data one");
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
				.sendKeys(QuestionText);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys(QuestionText);
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
		Thread.sleep(6000);
		// passing Parameters
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("Test data one");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166']"))
				.sendKeys("Test data one");
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
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys(QuestionText);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys(QuestionText);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
		.selectByVisibleText("radio");

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
				.sendKeys(QuestionText);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys(QuestionText);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
		.selectByVisibleText("picklist");
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
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");
		Thread.sleep(7000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(7000);

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
