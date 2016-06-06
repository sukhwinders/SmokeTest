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


public class TC9875_Test {

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

		System.out
				.println("TC9875 : Verify create Custom Form using 1 Tab, 1 sections and 5 Questions (Scenario 47 -CF)");
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

	/*	driver.findElement(
				By.xpath("//input[@id='j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm']"))
				.click();*/

		Select Librarydropdown = new Select(
				driver.findElement(By
						.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary")));

		Librarydropdown.selectByVisibleText("Existing");

		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);

	/*	System.out.println("Container Tab created successfully");*/

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
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);

		/*System.out.println("Layout Created successfully");*/

		// script for creation of 1 Tabs
		driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);
		/*driver.findElement(By.id("j_id0:form:createTab")).click();
		Thread.sleep(4000);*/
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46"))
				.sendKeys("Tab1");
		Thread.sleep(1000);
	/*	driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:1:j_id46"))
				.sendKeys("Tab2");*/
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		/*System.out.println("2 tabs created successfully");*/

		// Creation sections for tab1
		Thread.sleep(6000);
		// click on tab button
		driver.findElement(
				By.id("j_id0:form:tabBlock:tabSection:tabTable:0:selectTab"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(
				"Tab1Section1");
		Thread.sleep(3000);
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
		
		//Publish form
				Thread.sleep(7000);
				driver.findElement(By.id("j_id0:form:buttonPublish")).click();
				Thread.sleep(6000);

		/*System.out.println("Tab1 sections run successfully");*/

		

	}

	public void create_Questions() throws InterruptedException {

		// Text Question with 4 values

		driver.findElement(
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
				.clear();
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
				.clear();
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
				.sendKeys("Text Question");
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
				.sendKeys("Text Question");
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
				.sendKeys("Text Question");
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
		/*_______________________End_________________________*/
		// Checkbox Question with 4 Values
	
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
						.clear();
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
						.sendKeys("Question Chekbox ");
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
						.sendKeys("Question Chekbox ");
				new Select(
						driver.findElement(By
								.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
						.selectByVisibleText("checkbox");
				Select dependencydropdwn = new Select(
					    driver.findElement(By
					      .xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionDependencyAction']")));
					  dependencydropdwn.selectByVisibleText("Show");
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
						.click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:1:selectElement"))
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
						.sendKeys("Chekbox  1");
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
						.sendKeys("Chekbox 2");
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
						.sendKeys("Chekbox 3");
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
						.sendKeys("Chekbox 4");
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
				/*_______________________End_________________________*/
				
				// Date Question with 4 Values
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
						.clear();
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
						.sendKeys("Date  Question ");
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
						.sendKeys("Date  Question ");
				new Select(
						driver.findElement(By
								.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
						.selectByVisibleText("date");
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
						.sendKeys("Date Question 1");
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
						.sendKeys("Date Question 2");
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
						.sendKeys("Date Question 3");
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
						.sendKeys("Date Question 4");
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
				/*_______________________End_________________________*/
				
				// Radio Question with 4 Values

				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
						.clear();
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
						.sendKeys("Radio Question");
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
						.sendKeys("Radio Question");
				new Select(
						driver.findElement(By
								.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
						.selectByVisibleText("radio");
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
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
						.clear();
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166"))
						.sendKeys("Radio Question");
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
						.sendKeys("Radio Question");
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
						.sendKeys("Radio Question");
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
						.sendKeys("Radio Question");
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
						.clear();
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
						.sendKeys("V4");
				driver.findElement(By.id("j_id0:form:buttonSave")).click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
						.click();				      
				Thread.sleep(6000);
				/*_______________________End_________________________*/
				
				// Picklist Question with 4 Values

				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
						.clear();
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
						.sendKeys("Piclist Question");
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
						.sendKeys("Piclist Question");
				new Select(
						driver.findElement(By
								.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
						.selectByVisibleText("picklist");
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
						.click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:4:selectElement"))
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
						.sendKeys("Piclist Question");
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
						.sendKeys("Piclist Question");
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
						.sendKeys("Piclist Question");
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
						.sendKeys("Piclist Question");
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
						.clear();
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170"))
						.sendKeys("V4");
				driver.findElement(By.id("j_id0:form:buttonSave")).click();

				Thread.sleep(5000);
				/*_______________________End_________________________*/

				

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
