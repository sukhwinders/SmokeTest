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

public class TC9923_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	Date d = new Date(System.currentTimeMillis());
	String container_Name = "TestContainer" + d;
	String Layout_Name = "TestLayout" + d;
	String Tab_Name = "TestTab" + d;
	String Section_Name = "TestSection" + d;
	String QuestionText = "TestQuestion" + d;

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
	public void afterClass() throws Exception {
		driver.findElement(By.id("j_id0:form:buttonPreview")).click();
		Thread.sleep(9000);
		driver.findElement(By.id("j_id0:form:buttonPublish")).click();
		Thread.sleep(6000);
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
		driver.findElement(By.xpath("//input[@onclick='newFormAction()']"))
				.click();
		Thread.sleep(5000);
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
		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(3000);

		// script for Layout template
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys(Layout_Name);
		new Select(driver.findElement(By
				.id("j_id0:form:layoutBlock:layoutNew:inputLayoutUiType")))
				.selectByVisibleText("desktop");
		driver.findElement(By.id("j_id0:form:layoutBlock:createLayout"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(9000);

		// script for Tabs template
		for (int p = 0; p < 1; p++) {
			driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:createTab")).click();
			Thread.sleep(3000);
			driver.findElement(
					By.id("j_id0:form:tabBlock:tabSection:tabTable:" + p
							+ ":j_id46")).sendKeys(Tab_Name);
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(8000);
			driver.findElement(
					By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:"
							+ p + ":selectTab']")).click();
			Thread.sleep(9000);

			// Script for Sections template
			for (int q = 0; q < 1; q++) {
				driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
				Thread.sleep(3000);
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:createSection']"))
						.click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[contains(@id,'id73')]"))
						.sendKeys("Section_Name" + q);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='SAVE']")).click();
				Thread.sleep(4000);
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:"
								+ q + ":selectSection']")).click();
				Thread.sleep(6000);

				// Script for Linked in Questions
				driver.findElement(
						By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
						.click();
				Thread.sleep(5000);
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
						.click();
				Thread.sleep(5000);
				create_Questions();
			}
		}

	}

	public void create_Questions() throws InterruptedException {

		// multipicklist
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
				By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:0:selectElement']"))
				.click();
		Thread.sleep(5000);
		for (int k = 0; k <= 1; k++) {
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
					.click();
			Thread.sleep(5000);
			// passing Parameters
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
							+ k + ":j_id166']")).sendKeys("MultiPick " + k);
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
							+ k + ":j_id170']")).sendKeys("TestValue" + k);
		}
		Thread.sleep(8000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(8000);

		// checkbox
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(8000);
		for (int c = 0; c <= 4; c++) {
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
					.sendKeys(QuestionText + c);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(QuestionText);
			new Select(
					driver.findElement(By
							.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
					.selectByVisibleText("checkbox");
			if (c == 0) {
				driver.findElement(
						By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"))
						.click();
			}
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
					.click();
			Thread.sleep(5000);
		}

		// Textbox
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(8000);
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
				By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"))
				.click();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);

		// Long Text
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(8000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys(QuestionText);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys(QuestionText);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
				.selectByVisibleText("long text");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);

		// Email Address
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(8000);
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']"))
				.sendKeys(QuestionText);
		driver.findElement(
				By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
				.sendKeys(QuestionText);
		new Select(
				driver.findElement(By
						.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
				.selectByVisibleText("email address");
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
				.click();
		Thread.sleep(5000);

		// radio
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
				.click();
		Thread.sleep(8000);
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
		Thread.sleep(9000);
		driver.findElement(
				By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:9:selectElement"))
				.click();
		Thread.sleep(9000);
		for (int r = 0; r <= 4; r++) {
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
					.click();
			Thread.sleep(5000);
			// passing Parameters
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
							+ r + ":j_id166']")).sendKeys("TestRadio " + r);
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
							+ r + ":j_id170']")).sendKeys("Radio" + r);
		}
		Thread.sleep(8000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(8000);
	}

}
