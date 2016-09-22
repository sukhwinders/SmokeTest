package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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

public class TC9924_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	static Date d = new Date(System.currentTimeMillis());
	static String container_Name = "Test_Container " + d;
	static String layout_Name = "Test_Layout " + d;
	static String tab_Name = "Test_Tab " + d;
	static String section_Name = "Test_Section " + d;
	static String questionText = "TestQuestion " + d;
	static String answerType = "Answer_type " + d;
	String answerValue = "Value";

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Answertype = guitils.getDATA("AnswerType");

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		driver.switchTo().frame(0);

		// Adding Container
		driver.findElement(By.xpath("//input[@onclick='newFormAction()']"))
				.click();
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
		// Select(driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary"))).selectByVisibleText("Existing");
		driver.findElement(By.id("j_id0:form:containerBlock:createContainer"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);

		// Adding layout
		driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		driver.findElement(
				By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName"))
				.sendKeys(layout_Name);
		// new
		// Select(driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutSharing"))).selectByVisibleText("Public");
		// driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutIsValid")).click();
		new Select(driver.findElement(By
				.id("j_id0:form:layoutBlock:layoutNew:inputLayoutUiType")))
				.selectByVisibleText("desktop");
		driver.findElement(By.id("j_id0:form:layoutBlock:createLayout"))
				.click();
		Thread.sleep(6000);

		// Adding tabs
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("j_id0:form:createTab")).click();
			Thread.sleep(3000);
			driver.findElement(
					By.id("j_id0:form:tabBlock:tabSection:tabTable:" + i
							+ ":j_id46")).sendKeys(tab_Name + " " + i);
			Thread.sleep(3000);
			if (i == 0)
				driver.findElement(
						By.id("j_id0:form:tabBlock:tabSection:tabTable:" + i
								+ ":j_id57")).click();
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			driver.findElement(
					By.id("j_id0:form:tabBlock:tabSection:tabTable:" + i
							+ ":selectTab")).click();
			Thread.sleep(3000);
			System.out.println("tab" + i);

			// Adding sections
			for (int j = 0; j < 2; j++) {
				driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
				driver.findElement(By.id("j_id0:form:createSection")).click();
				driver.findElement(
						By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"
								+ j + ":j_id73")).click();
				driver.findElement(
						By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"
								+ j + ":j_id73")).sendKeys(section_Name);
				new Select(
						driver.findElement(By
								.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"
										+ j + ":j_id88"))).selectByIndex(j);
				driver.findElement(By.xpath("//input[@value='SAVE']")).click();
				driver.findElement(
						By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"
								+ j + ":selectSection")).click();
				Thread.sleep(3000);
				System.out.println("section" + j);

				// Script for Linked in Questions
				for (int k = 0; k < 1; k++) {
					Thread.sleep(5000);
					driver.findElement(
							By.id("j_id0:form:tabLinkedQuestions_lbl")).click();

					// Enter parameter for number of questions to be added
					createQuestion_text(1);
					createQuestion_checkbox(1);
					createQuestion_multiPickList(1);
					createQuestion_longText(1);
					createQuestion_pickList(1);
					createQuestion_radio(1);
				}
			}
		}

		// Publishing the form
		driver.findElement(By.id("j_id0:form:buttonPublish")).click();
		System.out.println("published");
	}

	public void createQuestion_text(int questionCnt)
			throws InterruptedException {
		for (int i = 0; i < questionCnt; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(questionText + " " + i);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(questionText + " " + i);
			new Select(
					driver.findElement(By
							.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
					.selectByVisibleText("text");
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired"))
					.click(); // mandatory field
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
					.click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_checkbox(int questionCnt)
			throws InterruptedException {
		for (int i = 0; i < questionCnt; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(questionText + " " + i);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(questionText + " " + i);
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

	public void createQuestion_longText(int questionCnt)
			throws InterruptedException {
		for (int i = 0; i < questionCnt; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(questionText + " " + i);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(questionText);
			new Select(
					driver.findElement(By
							.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
					.selectByVisibleText("long text");
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
					.click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_pickList(int questionCnt)
			throws InterruptedException {
		for (int i = 0; i < questionCnt; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(questionText);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(questionText);
			new Select(
					driver.findElement(By
							.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType")))
					.selectByVisibleText("picklist");
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion"))
					.click();
			Thread.sleep(5000);

			// Clicking the select button
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
			for (int ansCnt = 0; ansCnt < 2; ansCnt++) {
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
						.click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ ansCnt + ":j_id166")).sendKeys(answerType);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ ansCnt + ":j_id170")).sendKeys(
						answerValue + ansCnt);
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

	public void createQuestion_multiPickList(int questionCnt)
			throws InterruptedException {
		for (int i = 0; i < questionCnt; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(questionText);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(questionText);
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
			for (int ansCnt = 0; ansCnt < 4; ansCnt++) {
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
						.click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ ansCnt + ":j_id166")).sendKeys(answerType);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ ansCnt + ":j_id170")).sendKeys(
						answerValue + ansCnt);
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

	public void createQuestion_radio(int questionCnt)
			throws InterruptedException {
		for (int i = 0; i < questionCnt; i++) {
			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(questionText);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(questionText);
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
			for (int ansCnt = 0; ansCnt < 2; ansCnt++) {
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:createAnswerOption"))
						.click();
				Thread.sleep(4000);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ ansCnt + ":j_id166")).sendKeys(answerType);
				driver.findElement(
						By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ ansCnt + ":j_id170")).sendKeys(
						answerValue + ansCnt);
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