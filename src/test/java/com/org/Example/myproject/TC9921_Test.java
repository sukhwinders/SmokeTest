package com.org.Example.myproject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9921_Test {

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
	public void createNew_form() throws InterruptedException {

		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(2000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		driver.switchTo().frame(0);
		Thread.sleep(5000);

		System.out.println("(Scenario 40 -CF)");
		// click on forms button
		Thread.sleep(2000);
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
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(2000);
		createSections();
		/* ################Section 1 End#################### */
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(2000);
		// Create questions for 1st section
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Tab1 Section 1 End#################### */

		/* Tab : 2 sections : 1 */
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		// select 2ndtab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:selectTab"))
				.click();
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		createSections();
		/* ################Section 1 End#################### */
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Tab2 Section 1 End#################### */

		/* Tab : 3 sections : 1 */
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		// select 3rd tab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:selectTab"))
				.click();
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		createSections();
		/* ################Section 1 End#################### */
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Tab3 Section 1 End#################### */

		/* Tab : 4 sections : 1 */
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		// select 4th tab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:selectTab"))
				.click();
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		createSections();
		/* ################Section 1 End#################### */
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Tab4 Section 1 End#################### */

		/* Tab : 5 sections : 1 */
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		// select 5th tab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:4:selectTab"))
				.click();
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		createSections();
		/* ################Section 1 End#################### */
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Tab5 Section 1 End#################### */

		/* Tab : 6 sections : 1 */
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		// select 3rd tab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:5:selectTab"))
				.click();
		// Click on sections button
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		createSections();
		/* ################Section 1 End#################### */
		Thread.sleep(5000);
		// click on questions tab
		driver.findElement(By.id("j_id0:form:tabLinkedQuestions_lbl")).click();
		Thread.sleep(5000);
		// Create questions for 1st section
		createQuestionText();
		createQuestionCheckbox();
		createQuestionRadio();
		createQuestionPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Tab6 Section 1 End#################### */

	}

	public void createContainer() throws InterruptedException {
		// script to container template

		Thread.sleep(3000);
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

		/*driver.findElement(
				By.xpath("//input[@id='j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm']"))
				.click();*/
		/*Select Librarydropdown = new Select(
				driver.findElement(By
						.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary")));

		Librarydropdown.selectByVisibleText("Existing");*/

		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);

	}

	public void createLayout() throws InterruptedException {
		// script for Layout template
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys("Layout_Name");
		/*new Select(driver.findElement(By
				.id("j_id0:form:layoutBlock:layoutNew:inputLayoutSharing")))
				.selectByVisibleText("Public");
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutIsValid"))
				.click();*/
		new Select(driver.findElement(By
				.id("j_id0:form:layoutBlock:layoutNew:inputLayoutUiType")))
				.selectByVisibleText("desktop");
		driver.findElement(By.id("j_id0:form:layoutBlock:createLayout"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);

	}

	public void createTabs() throws InterruptedException {

		Thread.sleep(4000);

		for (int i = 1; i <= 6; i++) {
			Thread.sleep(2000);
			driver.findElement(By.id("j_id0:form:createTab")).click();

		}
		Thread.sleep(2000);
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.sendKeys("Tab1");
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.sendKeys("Tab2");
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46"))
				.sendKeys("Tab3");
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46"))
				.sendKeys("Tab4");
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:4:j_id46"))
				.sendKeys("Tab5");
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:5:j_id46"))
				.sendKeys("Tab6");
		Thread.sleep(2000);
		// Save tabs
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
	}

	public void createSections() throws InterruptedException {

		Thread.sleep(2000);
		// create section
		for (int i = 1; i <= 1; i++) {
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:createSection']"))
					.click();
			Thread.sleep(2000);
		}
		// Send name for Section 1
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:j_id73"))
				.sendKeys("Section1");
		Thread.sleep(1000);

		// Save tabs
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();

	}

	public void createQuestionText() throws InterruptedException {
		// Text Question with 4 values
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Text Question");

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Text Question");
		// mandatory field selection
		driver.findElement(
				By.xpath("//label[@for='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired']"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:0:selectElement"))
				.click();
		Thread.sleep(6000);
		// value1
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Text Question 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value2
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Text Question 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// value3
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Text Question 3");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		// value4
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("Text Question 4");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.sendKeys("V4");
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);

		/* _______________________End_________________________ */

	}

	public void createQuestionCheckbox() throws InterruptedException {
		// Checkbox with 3 values
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Question Chekbox ");

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
		Thread.sleep(5000);
		// value1
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Chekbox  1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value2
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
		// value3
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
		Thread.sleep(2000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
	}

	public void createQuestionRadio() throws InterruptedException {
		// Radio Question with 6 Values

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Radio Question");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Radio Question");
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("radio");
		// mandatory field selection
		driver.findElement(
				By.xpath("//label[@for='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired']"))
				.click();

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(4000);
		// Select question Note : change id here
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:2"
						+ ":selectElement")).click();
		Thread.sleep(6000);

		for (int i = 1; i <= 6; i++) {
			driver.findElement(
					By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
					.click();
			Thread.sleep(5000);
		}
		// value1
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Radio 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value 2

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Radio 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// value 3

		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Radio 3");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		// value 4

		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("Radio 4");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.sendKeys("V4");
		// Value5

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166"))
				.sendKeys("Radio 5");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170"))
				.sendKeys("V5");
		// Value6

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:5:j_id166"))
				.sendKeys("Radio 6");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:5:j_id170"))
				.sendKeys("V6");
		Thread.sleep(1000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);

	}

	public void createQuestionPicklist() throws InterruptedException {
		// Picklist Question with 3 Values
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
		for (int i = 1; i <= 3; i++) {
			driver.findElement(
					By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
					.click();
			Thread.sleep(5000);
		}
		// value1
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Picklist 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value 2

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Picklist 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// value 3

		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Picklist 3");

		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		Thread.sleep(1000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		/* _______________________End_________________________ */

	}
}
