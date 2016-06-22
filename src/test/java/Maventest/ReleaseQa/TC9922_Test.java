package Maventest.ReleaseQa;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9922_Test {

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
		Thread.sleep(2000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		driver.switchTo().frame(0);
		Thread.sleep(5000);

		System.out.println("Scenario 41 -BPF");
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
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		createQuestionMultiPicklist();
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
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		createQuestionMultiPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 2 End#################### */

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
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		createQuestionMultiPicklist();
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
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		createQuestionMultiPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 2 End#################### */
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
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		createQuestionMultiPicklist();
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
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		createQuestionMultiPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 2 End#################### */

		/* Tab : 3 Sections 2 */
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
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		createQuestionMultiPicklist();
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
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		createQuestionMultiPicklist();
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

	public void createQuestionText() throws InterruptedException {
		// Text Question with 1 value
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Text Question");

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"))
				.click();

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Text Question");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:0:selectElement"))
				.click();
		Thread.sleep(6000);
		// val 1
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
		/* _______________________End_________________________ */

	}

	public void createQuestionCheckbox() throws InterruptedException {
		// Checkbox with 5 values
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Question Chekbox ");
		/*
		 * driver.findElement( By.id(
		 * "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"
		 * )) .click();
		 */

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Question Chekbox ");
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("checkbox");

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:1:selectElement"))
				.click();
		Thread.sleep(7000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(7000);

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Chekbox  1");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// val 2
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Chekbox 2");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// val 3
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Chekbox 3");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		// val 4
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("Chekbox 4");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.sendKeys("V4");
		// val 5
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166"))
				.sendKeys("Chekbox 5");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170"))
				.sendKeys("V5");

		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		/* _______________________End_________________________ */
	}

	public void createQuestionRadio() throws InterruptedException {
		// Radio Question with 5 Values

		/*
		 * driver.findElement( By.id(
		 * "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"
		 * )) .clear();
		 */
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Radio Question");
		/*
		 * driver.findElement( By.id(
		 * "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"
		 * )) .click();
		 */
		// Read only
		/*
		 * Thread.sleep(3000); driver.findElement( By.id(
		 * "j_id0:form:newElementWithQuestion:newElementBlock:inputElementReadOnly"
		 * )) .click();
		 */

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();
		/*
		 * driver.findElement( By.id(
		 * "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"
		 * )) .clear();
		 */
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Radio Question");
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("radio");
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(4000);
		// Select question Note : change id here
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:2:selectElement"))
				.click();
		Thread.sleep(6000);
		// value 1
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Radio 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value 2
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Radio 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// value 3
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Radio 3");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		// value 4
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("Radio 4");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.sendKeys("V4");
		// value 5
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166"))
				.sendKeys("Radio 5");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170"))
				.sendKeys("V5");

		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		/* _______________________End_________________________ */
	}

	public void createQuestionPicklist() throws InterruptedException {
		// Picklist Question with 5 Values
		Thread.sleep(5000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Picklist Question");

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Picklist Question");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();
		Thread.sleep(5000);
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("picklist");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:3:selectElement"))
				.click();
		Thread.sleep(6000);
		for (int i = 0; i <= 4; i++) {
			Thread.sleep(4000);
			driver.findElement(
					By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
					.click();
			Thread.sleep(4000);
		}
		// Value 1

		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Picklist Question 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// Value 2

		Thread.sleep(4000);

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Picklist Question 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// Value 3

		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Picklist Question 3");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		// Value 4
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("Picklist Question 4");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.sendKeys("V4");
		// Value 5

		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166"))
				.sendKeys("Picklist Question 5");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170"))
				.sendKeys("V5");

		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		/* _______________________End_________________________ */

	}

	public void createQuestionMultiPicklist() throws InterruptedException {
		// MultiPicklist Question with 5 Values
		Thread.sleep(5000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("multi-picklist Question");

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("multi-picklist Question");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();
		Thread.sleep(5000);
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("multi-picklist");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:4:selectElement"))
				.click();
		Thread.sleep(6000);
		for (int i = 0; i <= 4; i++) {
			Thread.sleep(4000);
			driver.findElement(
					By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
					.click();
			Thread.sleep(4000);
		}
		// Value 1

		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("multi-picklist Question 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// Value 2
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("multi-picklist Question 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// Value 3
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("multi-picklist Question 3");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		// Value 4
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("multi-picklist Question 4");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.sendKeys("V4");
		// Value 5
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166"))
				.sendKeys("multi-picklist Question 5");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170"))
				.sendKeys("V5");

		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		/* _______________________End_________________________ */

	}

	public void createQuestionDateAndTime() throws InterruptedException {
		// Date Time Question with 4 Values
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Date Time Question");
		/*
		 * driver.findElement( By.id(
		 * "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"
		 * )) .click();
		 */

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Date Time Question");
		Thread.sleep(4000);
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("datetime");
		/*
		 * // Link existing question driver.findElement( By.xpath(
		 * ".//*[@id='j_id0:form:newElementWithQuestion:newElementBlock:inputElementLinkedQuestion_lkwgt']/img"
		 * )) .click();
		 * 
		 * driver.findElement(
		 * By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
		 * .click(); Thread.sleep(5000); driver.findElement( By.id(
		 * "j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:1:selectElement"
		 * )) .click(); Thread.sleep(6000); driver.findElement(
		 * By.id("j_id0:form:answerOptionBlock:createAnswerOption")) .click();
		 * Thread.sleep(8000); driver.findElement( By.id(
		 * "j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"
		 * )) .sendKeys("text");
		 */
		/*
		 * // Code for link question
		 * driver.findElement(By.xpath("//img[@title='Search']")).click();
		 * Thread.sleep(3000); driver.findElement(
		 * By.xpath("//input[@id='input_searchLibraryQuestion']")).clear();
		 * driver.findElement(
		 * By.xpath("//input[@id='input_searchLibraryQuestion']"))
		 * .sendKeys("text");
		 * 
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("//img[@title='Filter List']")).click();
		 * Thread.sleep(5000); driver.findElement(
		 * By.xpath("//*[@id='divLibraryQuestionList']/table/tbody/tr/td[1]/a"))
		 * .click(); -------------------------------------------
		 */
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
		Thread.sleep(5000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Date Time Question 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");

		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		/* _______________________End_________________________ */

	}

}