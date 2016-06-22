package Maventest.ReleaseQa;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9829_Test {

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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void createNew_form() throws InterruptedException {

		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		driver.switchTo().frame(0);
		Thread.sleep(5000);

		System.out.println("Scenario 04 -BPF");
		// click on forms button
		driver.findElement(By.name("j_id0:form:j_id8")).click();
		createContainer();

		createLayout();
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		createTabs();
		// Create sections for 1st tab
		// select first tab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:selectTab"))
				.click();
		// create 2 sections
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		createSections();
		/* ################Section 1 Start#################### */
		// Select 1st section
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection"))
				.click();
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		create_Questions();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 1 End#################### */

		/* ################Section 2 Start#################### */
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		// Select 2nd section
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:selectSection"))
				.click();
		Thread.sleep(8000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		create_Questions();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 2 End#################### */
		try {
			/* Tab : 2 sections : 2 */
			// Click on tabs button
			driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
			// select 2ndtab
			driver.findElement(
					By.id("j_id0:form:tabBlock:tabSection:tabTable:1:selectTab"))
					.click();
			// Click on sections button
			Thread.sleep(8000);
			driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
			Thread.sleep(3000);
			createSections();
			/* ################Section 1 End#################### */
			// Select 1st section
			driver.findElement(
					By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection"))
					.click();
			Thread.sleep(5000);
			// click on questions tab
			driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl"))
					.click();
			Thread.sleep(5000);
			// Create questions for 1st section
			create_Questions();
			Thread.sleep(5000);
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(5000);
			/* ################Section 1 End#################### */

			/* ################Section 2 Start#################### */
			// Click on sections button
			Thread.sleep(5000);
			driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
			Thread.sleep(3000);
			// Select 2nd section
			driver.findElement(
					By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:selectSection"))
					.click();
			Thread.sleep(5000);
			// click on questions tab
			driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl"))
					.click();
			Thread.sleep(5000);
			// Create questions for 1st section
			create_Questions();
			Thread.sleep(5000);
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(5000);
			/* ################Section 2 End#################### */
		} catch (Exception e) {
			WebElement element = driver.findElement(By
					.id("j_id0:form:tabSections_lbl"));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();
		}
		/* Tab : 3 Sections 2 */
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		// select 2ndtab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:selectTab"))
				.click();
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		createSections();
		/* ################Section 1 End#################### */
		// Select 1st section
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection"))
				.click();
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		create_Questions();
		Thread.sleep(7000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 1 End#################### */

		/* ################Section 2 Start#################### */
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		// Select 2nd section
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:selectSection"))
				.click();
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		create_Questions();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 2 End#################### */

		/* Tab : 4 Sections 2 */
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		// select 2ndtab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:selectTab"))
				.click();
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		createSections();
		/* ################Section 1 End#################### */
		// Select 1st section
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:selectSection"))
				.click();
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		create_Questions();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 1 End#################### */

		/* ################Section 2 Start#################### */
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		// Select 2nd section
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:selectSection"))
				.click();
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		create_Questions();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 2 End#################### */

		/* _______________________End_________________________ */

	}

	public void createContainer() throws InterruptedException {
		// script to container template

		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:containerBlock:containerNew:inputContainerName"))
				.clear();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:containerBlock:containerNew:inputContainerName']"))
				.sendKeys("container_Name");

		Select Typedropdown = new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:containerBlock:containerNew:inputContainerType']")));

		Typedropdown.selectByVisibleText("Form");

		Select Containertypedropdown = new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:containerBlock:containerNew:inputContainerContainerType']")));

		Containertypedropdown.selectByVisibleText("Single Form");
		driver.findElement(
				By.id("j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm"))
				.click();

		/*
		 * driver.findElement( By.xpath(
		 * "//input[@id='j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm']"
		 * )) .click();
		 */

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

		/* System.out.println("Container Tab created successfully"); */

	}

	public void createLayout() throws InterruptedException {
		// script for Layout template
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys("Layout_Name");
		/*
		 * new Select(driver.findElement(By
		 * .id("j_id0:form:layoutBlock:layoutNew:inputLayoutSharing")))
		 * .selectByVisibleText("Public");
		 */
		/*
		 * driver.findElement(
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
		/* System.out.println("Layout Created successfully"); */

	}

	public void createTabs() throws InterruptedException {

		Thread.sleep(4000);

		for (int i = 0; i <= 3; i++) {
			Thread.sleep(5000);
			driver.findElement(By.id("j_id0:form:createTab")).click();

		}

		// Send name for Tab 1
		/*
		 * driver.findElement(
		 * By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46")) .clear();
		 */
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.sendKeys("Tab1");
		Thread.sleep(3000);

		// Send name for Tab 2
		/*
		 * driver.findElement(
		 * By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46")) .clear();
		 */
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.sendKeys("Tab2");
		// Send name for Tab 3
		/*
		 * driver.findElement(
		 * By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46")) .clear();
		 */
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46"))
				.sendKeys("Tab3");
		// Send name for Tab 4
		/*
		 * driver.findElement(
		 * By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46")) .clear();
		 */
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46"))
				.sendKeys("Tab4");

		// Save tabs
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();

	}

	public void createSections() throws InterruptedException {

		Thread.sleep(3000);
		// create 2 sections
		for (int i = 0; i <= 1; i++) {
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:createSection']"))
					.click();
			Thread.sleep(5000);
		}
		// Send name for Section 1
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:j_id73"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:j_id73"))
				.sendKeys("Section 1");
		Thread.sleep(1000);

		// Send name for Section 2
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id73"))
				.sendKeys("Section 2");

		// Save tabs
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		/* System.out.println("2 tabs created successfully"); */

	}

	public void create_Questions() throws InterruptedException {

		// Text
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys("QuestionText");
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys("QuestionText");
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
				.sendKeys("Checkbox");
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys("Checkbox");
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
				.sendKeys("radio");
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys("radio");
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
		Thread.sleep(2000);
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
				.sendKeys("picklist");
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys("picklist");
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

}