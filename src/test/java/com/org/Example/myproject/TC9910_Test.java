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


public class TC9910_Test {

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

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void createNew_form() throws InterruptedException {
		driver.manage().window().maximize();
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
		Thread.sleep(5000);

		System.out
				.println("TC9910:Verify create BP Form using 1 Tab, 1 sections and 5 Questions(With different Answer types) (Scenario 30-BPF)");
		// click on forms button
		Thread.sleep(5000);
		driver.findElement(By.name("j_id0:form:j_id7")).click();
		createContainer();

		createLayout();
		Thread.sleep(5000);
		// Click on tabs button
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		createTabs();
		// Create sections for 1st tab
		// select first tab
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:selectTab"))
				.click();
		// create 4 sections
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
		createQuestionLongText();
		createQuestionDateAndTime();
		createQuestionRadio();
		createQuestionPicklist();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		/* ################Section 1 End#################### */

		

		
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

		
		  driver.findElement( By.xpath(
		  "//input[@id='j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm']"
		  )) .click();
		 

		Select Librarydropdown = new Select(
				driver.findElement(By
						.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary")));

		Librarydropdown.selectByVisibleText("Existing");

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
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);
		/* System.out.println("Layout Created successfully"); */

	}

	public void createTabs() throws InterruptedException {

		Thread.sleep(4000);
		Thread.sleep(7000);
		driver.findElement(By.id("j_id0:form:createTab")).click();

	/*	for (int i = 0; i <= 1; i++) {
			Thread.sleep(7000);
			driver.findElement(By.id("j_id0:form:createTab")).click();

		}*/
		Thread.sleep(6000);
		// Send name for Tab 1
		/*
		 * driver.findElement(
		 * By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46")) .clear();
		 */
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.sendKeys("Tab1");
		Thread.sleep(1000);

		// Send name for Tab 2
		/*
		 * driver.findElement(
		 * By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46")) .clear();
		 */
		/*driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.sendKeys("Tab2");*/
		// Send name for Tab 3
		/*
		 * driver.findElement(
		 * By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46")) .clear();
		 */
	/*	driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:2:j_id46"))
				.sendKeys("Tab3");*/
		// Send name for Tab 4
		/*
		 * driver.findElement(
		 * By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46")) .clear();
		 */
	/*	driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:3:j_id46"))
				.sendKeys("Tab4");*/

		// Save tabs
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();

	}

	public void createSections() throws InterruptedException {

		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(5000);
		// create 4 sections
		/*
		 * for (int i = 0; i <= 3; i++) { driver.findElement(
		 * By.xpath("//input[@id='j_id0:form:createSection']")) .click();
		 * Thread.sleep(5000); }
		 */
		// Send name for Section 1
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:j_id73"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:j_id73"))
				.sendKeys("Section 1");
		Thread.sleep(1000);

	

		// Save tabs
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		/* System.out.println("2 tabs created successfully"); */

	}

	

	public void createQuestionText() throws InterruptedException {
		// Text Question with 1 value
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Text Question");
		
		  driver.findElement( By.id(
		  "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"
		  )) .click();
		 

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Text Question");
		//Link existing question
		driver.findElement(By.xpath(".//*[@id='j_id0:form:newElementWithQuestion:newElementBlock:inputElementLinkedQuestion_lkwgt']/img")).click();
		
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
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Text Question");
		//Code for link question
		driver.findElement(By.xpath("//img[@title='Search']")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//input[@id='input_searchLibraryQuestion']")).clear();
		driver.findElement(
				By.xpath("//input[@id='input_searchLibraryQuestion']"))
				.sendKeys("text");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Filter List']")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//*[@id='divLibraryQuestionList']/table/tbody/tr/td[1]/a"))
				.click();
		/*-------------------------------------------*/
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

	public void createQuestionLongText() throws InterruptedException {
		// Long Text Question with 4 values

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Long Text Question");

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Long Text Question");
		  driver.findElement( By.id(
				  "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"
				  )) .click();
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("long text");
	/*	Select dependencydropdwn = new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionDependencyAction']")));
		dependencydropdwn.selectByVisibleText("Show");*/
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:1:selectElement"))
				.click();
		Thread.sleep(6000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Long Text Question 1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Long Text Question 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Long Text Question 3");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("Long Text Question 4");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.clear();
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

	public void createQuestionDateAndTime() throws InterruptedException {
		// Date Time Question with 4 Values
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Date Time Question");
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"))
				.click();

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.sendKeys("Date Time Question");
		new Select(
				driver.findElement(By
						.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
				.selectByVisibleText("datetime");
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
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("Date Time Question 2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("Date Time Question 3");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("Date Time Question 4");
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.clear();
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

	public void createQuestionRadio() throws InterruptedException {
		// Radio Question with 5 Values

				Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.sendKeys("Radio Question");
		
		 driver.findElement( By.id(
		  "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"
		 )) .click();
		 
		/*// Read only
		Thread.sleep(3000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newElementBlock:inputElementReadOnly"))
				.click();*/

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText"))
				.click();
		
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
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:3:selectElement"))
				.click();
		Thread.sleep(6000);
		for(int i =0; i<=14; i++){
			Thread.sleep(4000);
			driver.findElement(
					By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
					.click();
			Thread.sleep(4000);
		}
		// value 1	
		Thread.sleep(4000);		
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("Radio 1");	
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value 2
			Thread.sleep(4000);		
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
		// value 5
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166"))
				.sendKeys("Radio 5");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170"))
				.sendKeys("V5");
		// value 6
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:5:j_id166"))
				.sendKeys("Radio 6");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:5:j_id170"))
				.sendKeys("V6");
		// value 7
			Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:6:j_id166"))
				.sendKeys("Radio 7");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:6:j_id170"))
				.sendKeys("V7");
		// value 8
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:7:j_id166"))
				.sendKeys("Radio 8");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:7:j_id170"))
				.sendKeys("V8");
		// value 9
			Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:8:j_id166"))
				.sendKeys("Radio 9");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:8:j_id170"))
				.sendKeys("V9");
		// value 10
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:9:j_id166"))
				.sendKeys("Radio 10");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:9:j_id170"))
				.sendKeys("V10");
		// value 11
			Thread.sleep(4000);		
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:10:j_id166"))
				.sendKeys("Radio 11");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:10:j_id170"))
				.sendKeys("V11");
		// value 12
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:11:j_id166"))
				.sendKeys("Radio 12");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:11:j_id170"))
				.sendKeys("V12");
		// value 13
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:12:j_id166"))
				.sendKeys("Radio 13");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:12:j_id170"))
				.sendKeys("V13");
		// value 14
			Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:13:j_id166"))
				.sendKeys("Radio 14");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:13:j_id170"))
				.sendKeys("V14");
		// value 15

		Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:14:j_id166"))
				.sendKeys("Radio 15");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:14:j_id170"))
				.sendKeys("V15");
				

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
		 driver.findElement( By.id(
				  "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"
				  )) .click();
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
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:4:selectElement"))
				.click();
		Thread.sleep(6000);
		for(int i =0; i<=14; i++){
			Thread.sleep(4000);
			driver.findElement(
					By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
					.click();
			Thread.sleep(4000);
		}
		// value 1	
		Thread.sleep(4000);		
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
				.sendKeys("PickList 1");	
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170"))
				.sendKeys("V1");
		// value 2
			Thread.sleep(4000);		
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166"))
				.sendKeys("PickList 2");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170"))
				.sendKeys("V2");
		// value 3
				Thread.sleep(4000);		
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166"))
				.sendKeys("PickList 3");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170"))
				.sendKeys("V3");
		// value 4
				Thread.sleep(4000);		
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166"))
				.sendKeys("PickList 4");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
				.sendKeys("V4");
		// value 5
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166"))
				.sendKeys("PickList 5");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170"))
				.sendKeys("V5");
		// value 6
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:5:j_id166"))
				.sendKeys("PickList 6");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:5:j_id170"))
				.sendKeys("V6");
		// value 7
			Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:6:j_id166"))
				.sendKeys("PickList 7");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:6:j_id170"))
				.sendKeys("V7");
		// value 8
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:7:j_id166"))
				.sendKeys("PickList 8");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:7:j_id170"))
				.sendKeys("V8");
		// value 9
			Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:8:j_id166"))
				.sendKeys("PickList 9");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:8:j_id170"))
				.sendKeys("V9");
		// value 10
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:9:j_id166"))
				.sendKeys("PickList 10");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:9:j_id170"))
				.sendKeys("V10");
		// value 11
			Thread.sleep(4000);		
		driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:10:j_id166"))
				.sendKeys("PickList 11");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:10:j_id170"))
				.sendKeys("V11");
		// value 12
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:11:j_id166"))
				.sendKeys("PickList 12");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:11:j_id170"))
				.sendKeys("V12");
		// value 13
				Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:12:j_id166"))
				.sendKeys("PickList 13");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:12:j_id170"))
				.sendKeys("V13");
		// value 14
			Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:13:j_id166"))
				.sendKeys("PickList 14");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:13:j_id170"))
				.sendKeys("V14");
		// value 15

		Thread.sleep(4000);
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:14:j_id166"))
				.sendKeys("PickList 15");
				driver.findElement(
				By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:14:j_id170"))
				.sendKeys("V15");

		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);
		Thread.sleep(4000);
		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
				.click();
		Thread.sleep(6000);
		/* _______________________End_________________________ */

	}
public void dependancy(){
	
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
