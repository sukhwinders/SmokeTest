package com.org.Example.myproject;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9913_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	Date d = new Date(System.currentTimeMillis());
	String container_Name = "TestContainer " + d;
	String layout_Name = "Test Layout " + d;
	String tab_Name = "Test Tab " + d;
	String section_Name = "Test Section " + d;
	String question_Text = "Test Question " + d;
	String answer_Text = "Answer " + d;

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
		driver.close();
	}

	@Test
	public void createNew_form() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(3000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("FormList")).click();
		driver.switchTo().frame(0);

		// Adding Container
		driver.findElement(By.name("j_id0:form:j_id12")).click();
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
		/*
		 * new Select( driver.findElement(By
		 * .id("j_id0:form:containerBlock:containerNew:inputContainerLibrary")))
		 * .selectByVisibleText("Existing");
		 */
		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(3000);

		// Adding layout
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.clear();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys(layout_Name);
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
		Thread.sleep(6000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(9000);

		// Adding tabs
		for (int i = 0; i < 1; i++) {
			driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("j_id0:form:createTab")).click();
			Thread.sleep(3000);
			driver.findElement(
					By.id("j_id0:form:tabBlock:tabSection:tabTable:" + i
							+ ":j_id47")).sendKeys(tab_Name + " " + i);
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(3000);
			driver.findElement(
					By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:0:selectTab']"))
					.click();
			Thread.sleep(3000);

			// Adding sections
			for (int j = 0; j < 1; j++) {
				driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("j_id0:form:createSection")).click();
				Thread.sleep(5000);
				driver.findElement(
						By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"
								+ j + ":j_id74")).sendKeys(section_Name);

				Thread.sleep(2000);

				new Select(
						driver.findElement(By
								.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"
										+ j + ":j_id89")))
						.selectByVisibleText("Row");

				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@value='SAVE']")).click();
				Thread.sleep(6000);
				driver.findElement(
						By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"
								+ j + ":selectSection")).click();
				Thread.sleep(3000);

				for (int k = 0; k < 1; k++) {
					// Script for Linked in Questions
					driver.findElement(
							By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']"))
							.click();
					Thread.sleep(5000);

					// Enter parameter for number of questions to be added
					createQuestion_text(1);
					createQuestion_checkbox(1);
					createQuestion_pickList(1);
					createQuestion_multiPickList(1);
					createQuestion_radio(1);
				}
			}
		}

		// Publishing the form
		driver.findElement(By.id("j_id0:form:buttonPublish")).click();
	}

	public void createQuestion_text(int a) throws InterruptedException {

		for (int i = 0; i < a; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(question_Text + " " + i);

			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(question_Text + " " + i);
			new Select(
					driver.findElement(By
							.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
					.selectByVisibleText("text");
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
					.click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_checkbox(int a) throws InterruptedException {
		for (int i = 0; i < a; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(question_Text + " " + i);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(question_Text + " " + i);
			new Select(
					driver.findElement(By
							.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
					.selectByVisibleText("checkbox");
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
					.click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_pickList(int a) throws InterruptedException {
		for (int i = 0; i < a; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(question_Text);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(question_Text);
			new Select(
					driver.findElement(By
							.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
					.selectByVisibleText("picklist");
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
					.click();
			Thread.sleep(5000);

			// clicking the select button
			WebElement tblQst = driver
					.findElement(By
							.xpath(".//tbody[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:tb']"));
			List<WebElement> RowsOfTable = tblQst
					.findElements(By.tagName("tr"));
			List<WebElement> ColOfTable;
			WebElement btnSel;

			for (int r = 0; r < RowsOfTable.size(); r++) {
				ColOfTable = RowsOfTable.get(r).findElements(By.tagName("td"));

				for (int tdcount = 0; tdcount < ColOfTable.size(); tdcount++) {
					String tdText = ColOfTable.get(tdcount).getText();
					String textToVerify = "picklist";
					if (tdText.equals(textToVerify)) {
						btnSel = RowsOfTable.get(r).findElement(
								By.xpath(".//input[@value='select']"));
						btnSel.click();
						Thread.sleep(4000);
						break;
					}
				}
			}

			// Adding the values
			for (int awsCnt = 0; awsCnt < 4; awsCnt++) {
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
						.click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ awsCnt + ":j_id167")).sendKeys(answer_Text);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ awsCnt + ":j_id171")).sendKeys(answer_Text);
			}

			// Saving the question
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(4000);

			// Clearing the previous values
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
					.click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_multiPickList(int a) throws InterruptedException {
		for (int i = 0; i < a; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(question_Text);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(question_Text);
			new Select(
					driver.findElement(By
							.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
					.selectByVisibleText("multi-picklist");
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
					.click();
			Thread.sleep(5000);

			WebElement tblQst = driver
					.findElement(By
							.xpath(".//tbody[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:tb']"));
			List<WebElement> RowsOfTable = tblQst
					.findElements(By.tagName("tr"));
			List<WebElement> ColOfTable;
			WebElement btnSel;

			for (int r = 0; r < RowsOfTable.size(); r++) {
				ColOfTable = RowsOfTable.get(r).findElements(By.tagName("td"));

				for (int tdcount = 0; tdcount < ColOfTable.size(); tdcount++) {
					String tdText = ColOfTable.get(tdcount).getText();
					String textToVerify = "multi-picklist";
					if (tdText.equals(textToVerify)) {
						btnSel = RowsOfTable.get(r).findElement(
								By.xpath(".//input[@value='select']"));
						btnSel.click();
						Thread.sleep(4000);
						break;
					}
				}
			}

			// Adding the values
			for (int awsCnt = 0; awsCnt < 4; awsCnt++) {
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
						.click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ awsCnt + ":j_id167")).sendKeys(answer_Text);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ awsCnt + ":j_id171")).sendKeys(answer_Text);
			}

			// Saving the question
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(4000);
			// Clearing the previous values
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
					.click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_radio(int a) throws InterruptedException {
		for (int i = 0; i < a; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(question_Text);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(question_Text);
			new Select(
					driver.findElement(By
							.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
					.selectByVisibleText("radio");
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
					.click();
			Thread.sleep(5000);

			WebElement tblQst = driver
					.findElement(By
							.xpath(".//tbody[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:tb']"));
			List<WebElement> RowsOfTable = tblQst
					.findElements(By.tagName("tr"));
			List<WebElement> ColOfTable;
			WebElement btnSel;

			for (int r = 0; r < RowsOfTable.size(); r++) {
				ColOfTable = RowsOfTable.get(r).findElements(By.tagName("td"));

				for (int tdcount = 0; tdcount < ColOfTable.size(); tdcount++) {
					String tdText = ColOfTable.get(tdcount).getText();
					String textToVerify = "radio";
					if (tdText.equals(textToVerify)) {
						btnSel = RowsOfTable.get(r).findElement(
								By.xpath(".//input[@value='select']"));
						btnSel.click();
						Thread.sleep(4000);
						break;
					}
				}
			}

			// Adding the values
			for (int awsCnt = 0; awsCnt < 4; awsCnt++) {
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
						.click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ awsCnt + ":j_id167")).sendKeys(answer_Text);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ awsCnt + ":j_id171")).sendKeys(answer_Text);
			}

			// Saving the question
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(4000);

			// Clearing the previous values
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"))
					.click();
			Thread.sleep(4000);
		}
	}
}
