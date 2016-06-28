/**
 * 
 */
package com.org.Example.myproject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9886_Test {

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

		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		driver.switchTo().frame(0);
		Thread.sleep(3000);

		System.out
				.println("Verify create a CF Form using 2 Tabs, 4 sections and 4 Question in each section with mandatory and linked questions");
		// script to container template

		driver.findElement(By.name("j_id0:form:j_id8")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:containerBlock:containerNew:inputContainerName']"))
				.sendKeys("Demo Container");

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
		 * Select Librarydropdown = new Select( driver.findElement(By
		 * .id("j_id0:form:containerBlock:containerNew:inputContainerLibrary"
		 * )));
		 * 
		 * Librarydropdown.selectByVisibleText("Existing");
		 */

		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);

		System.out.println("Container Tab created successfully");

		// script for Layout template
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys("Demo Layout");
		/*
		 * new Select(driver.findElement(By
		 * .id("j_id0:form:layoutBlock:layoutNew:inputLayoutSharing")))
		 * .selectByVisibleText("Public"); driver.findElement(
		 * By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutIsValid"))
		 * .click();
		 */
		new Select(driver.findElement(By
				.id("j_id0:form:layoutBlock:layoutNew:inputLayoutUiType")))
				.selectByVisibleText("desktop");
		driver.findElement(By.id("j_id0:form:layoutBlock:createLayout"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);

		// script for creation 2 Tabs
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.sendKeys("Tab1");
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.sendKeys("Tab2");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);

		// script for tab1- section1

		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:selectTab"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:j_id73"))
				.sendKeys("Tab1Section1");
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.sendKeys("Tab1Section2");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection']"))
				.click();
		Thread.sleep(6000);

		// Script for Linked in Question 1
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		// script for tab1section2

		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:1:selectSection']"))
				.click();
		// Script for Linked in Question 2
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(5000);
		create_Questions();
		// #################---#################################

		// script for tab2- 2 sections
		// script for tab2section1

		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:selectTab"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:j_id73"))
				.sendKeys("Tab2Section1");
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.sendKeys("Tab2Section2");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection']"))
				.click();
		Thread.sleep(6000);

		// Script for Linked in Question 1
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		// script for tab2section2

		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:1:selectSection']"))
				.click();
		// Script for Linked in Question 2
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(5000);
		create_Questions();

	}

	public void create_Questions() throws InterruptedException {

		// Text Question with 1 value

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Text Question");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Text Question");

		// read only field selection
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newElementBlock:inputElementReadOnly']"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:0:selectElement"))
				.click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Text Question");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		// checkbox Question with 2 values
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("check box questioin");

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("check box question");
		/*
		 * // library question
		 * 
		 * driver.findElement(By.xpath("//img[@title='Search']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.id("input_searchLibraryQuestion")).sendKeys(
		 * "text"); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//img[@title='Filter List']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//a[contains(.,'LQ-000025')]")).click();
		 */
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("checkbox");
		// mandatory field selection
		driver.findElement(
				By.xpath("//label[@for='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired']"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:1:selectElement"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		// Value 1
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("check box question 1");
		Thread.sleep(1000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		Thread.sleep(1000);
		// Value 2
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("check box question 2");
		Thread.sleep(1000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		Thread.sleep(1000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);

		// Radio Question with 2 Values

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Radio Question");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Radio Question");
		/*
		 * // library question
		 * 
		 * driver.findElement(By.xpath("//img[@title='Search']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.id("input_searchLibraryQuestion")).sendKeys(
		 * "text"); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//img[@title='Filter List']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//a[contains(.,'LQ-000025')]")).click();
		 */
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("radio");
		// mandatory field selection
		driver.findElement(
				By.xpath("//label[@for='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired']"))
				.click();
		// read only field selection
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newElementBlock:inputElementReadOnly']"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:2:selectElement"))
				.click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		// value 1
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Radio Question 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value 2
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Radio Question 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);

		// Piclist Question with 3 Values

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Piclist Question");
		Thread.sleep(2000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Piclist Question");
		/*
		 * // library question
		 * 
		 * driver.findElement(By.xpath("//img[@title='Search']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.id("input_searchLibraryQuestion")).sendKeys(
		 * "text"); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//img[@title='Filter List']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//a[contains(.,'LQ-000025')]")).click();
		 */
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("picklist");
		// mandatory field selection
		driver.findElement(
				By.xpath("//label[@for='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired']"))
				.click();
		// read only field selection
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newElementBlock:inputElementReadOnly']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:3:selectElement"))
				.click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		// value 1
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Piclist Question 1");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value 2
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Piclist Question 2");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// value 3
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Piclist Question 3");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		driver.findElement(By.id("j_id0:form:buttonSave")).click();

		Thread.sleep(5000);

	}
}
