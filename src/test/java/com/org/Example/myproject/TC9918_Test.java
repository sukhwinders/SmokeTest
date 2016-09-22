package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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

public class TC9918_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	Date d = new Date(System.currentTimeMillis());
	String container_Name = "Testcontainer" + d;
	String Layout_Name = "Testlayout" + d;
	String Tab_Name = "Testtab" + d;
	String Section_Name = "Testsection" + d;
	String QuestionText = "TestQuest" + d;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Answertype = guitils.getDATA("AnswerType");

	@BeforeClass
	public void beforeClass() {
		System.out.println("Scenario 37-BPF");
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

		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(3000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		driver.switchTo().frame(0);

		// script for container template
		driver.findElement(By.name("j_id0:form:j_id8")).click();
		driver.findElement(
				By.id("j_id0:form:containerBlock:containerNew:inputContainerName"))
				.clear();
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
		/*new Select(
				driver.findElement(By
						.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary")))
				.selectByVisibleText("Existing");*/
		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(3000);

		// script for Layout template
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys(Layout_Name);
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
		Thread.sleep(5000);
		driver.findElement(
				By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:0:selectTab']"))
				.click();
		Thread.sleep(6000);

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
				.selectByVisibleText("Card");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		Thread.sleep(6000);

		// Script for Linked in Questions
		driver.findElement(
				By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
				.click();
		Thread.sleep(5000);
		create_Questions();

		driver.findElement(By.id("j_id0:form:buttonPublish")).click();
		Thread.sleep(6000);
		// driver.findElement(By.id("j_id0:form:buttonPreview")).click();
		// Thread.sleep(10000);

	}

	public void create_Questions() throws InterruptedException {

		// Textbox
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

		// number
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys(QuestionText);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys(QuestionText);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
				.selectByVisibleText("number");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);

		// Checkbox 1
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

		// radio
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
				.selectByVisibleText("radio");

		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:3:selectElement']"))
				.click();
		Thread.sleep(5000);

		// passing Parameters
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("Option0");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166']"))
				.sendKeys("Option1");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170']"))
				.sendKeys("T1");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166']"))
				.sendKeys("Option2");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170']"))
				.sendKeys("T2");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166']"))
				.sendKeys("Option3");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170']"))
				.sendKeys("T3");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166']"))
				.sendKeys("Option4");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170']"))
				.sendKeys("T4");

		Thread.sleep(5000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(8000);
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
				By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:4:selectElement']"))
				.click();
		Thread.sleep(5000);

		// passing Parameters
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("Test data 0");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166']"))
				.sendKeys("Test data 1");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170']"))
				.sendKeys("T1");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166']"))
				.sendKeys("Test data 2");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170']"))
				.sendKeys("T2");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166']"))
				.sendKeys("Test data 3");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170']"))
				.sendKeys("T3");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166']"))
				.sendKeys("Test data 4");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170']"))
				.sendKeys("T4");

		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);

		// multi-picklist
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
				.selectByVisibleText("multi-picklist");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:5:selectElement']"))
				.click();
		Thread.sleep(5000);

		// passing Parameters
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id166']"))
				.sendKeys("Test data 0");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:0:j_id170']"))
				.sendKeys("T0");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id166']"))
				.sendKeys("Test data 1");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:1:j_id170']"))
				.sendKeys("T1");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id166']"))
				.sendKeys("Test data 2");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:2:j_id170']"))
				.sendKeys("T2");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id166']"))
				.sendKeys("Test data 3");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:3:j_id170']"))
				.sendKeys("T3");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id166']"))
				.sendKeys("Test data 4");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:4:j_id170']"))
				.sendKeys("T4");

		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(6000);

	}

	

}
