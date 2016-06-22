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

public class TC9833_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	Date d = new Date(System.currentTimeMillis());
	String container_Name = "Testcontainer" + d;
	String Layout_Name = "Testlayout" + d;
	String Tab_Name = "Testtab" + d;
	String Section_Name = "Testsection" + d;
	String QuestionText = "TestQ" + d;

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
		/*
		 * new Select( driver.findElement(By
		 * .id("j_id0:form:containerBlock:containerNew:inputContainerLibrary")))
		 * .selectByVisibleText("New");
		 */
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

		// script for Tabs template

		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:createTab")).click();
			Thread.sleep(3000);
			driver.findElement(
					By.id("j_id0:form:tabBlock:tabSection:tabTable:" + i
							+ ":j_id46")).sendKeys(Tab_Name);
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(8000);
			driver.findElement(
					By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:"
							+ i + ":selectTab']")).click();
			Thread.sleep(9000);

			// Script for Sections template
			driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
			Thread.sleep(3000);
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:createSection']"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[contains(@id,'id73')]"))
					.sendKeys(Section_Name);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@value='SAVE']")).click();
			Thread.sleep(6000);

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
		}

	}

	public void create_Questions() throws InterruptedException {
		for (int i = 0; i <= 1; i++) {

			driver.findElement(
					By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName"))
					.sendKeys(QuestionText);
			driver.findElement(
					By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']"))
					.sendKeys(QuestionText);
			new Select(
					driver.findElement(By
							.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']")))
					.selectByVisibleText("text");
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']"))
					.click();
			Thread.sleep(5000);
		}
		driver.findElement(By.id("j_id0:form:buttonSave")).click();
		Thread.sleep(5000);

		// Checkbox
		Thread.sleep(5000);
		for (int j = 2; j <= 3; j++) {
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
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:"
							+ j + ":selectElement']")).click();
			Thread.sleep(5000);
			// passing Parameters
			for (int m = 0; m <= 1; m++) {
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
						.click();
				Thread.sleep(5000);
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ m + ":j_id166']")).sendKeys("CB " + m);
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ m + ":j_id170']")).sendKeys("T" + m);

			}

			Thread.sleep(5000);
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
					.click();
			Thread.sleep(5000);

		}

		// radio
		Thread.sleep(5000);
		for (int k = 4; k <= 5; k++) {
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newElementBlock:inputElementReadOnly']"))
					.click();
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
			Thread.sleep(7000);
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:"
							+ k + ":selectElement']")).click();
			Thread.sleep(5000);
			for (int l = 0; l <= 4; l++) {
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
						.click();
				Thread.sleep(5000);
				// passing Parameters
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ l + ":j_id166']")).sendKeys("yes" + l);
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ l + ":j_id170']")).sendKeys("T" + l);
			}
			Thread.sleep(5000);
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
					.click();
			Thread.sleep(5000);
		}

		// //picklist
		Thread.sleep(5000);
		for (int n = 6; n <= 7; n++) {
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
					By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:"
							+ n + ":selectElement']")).click();
			Thread.sleep(5000);
			for (int o = 0; o <= 4; o++) {
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']"))
						.click();
				Thread.sleep(5000);
				// passing Parameters
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ o + ":j_id166']")).sendKeys("PL " + o);
				driver.findElement(
						By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
								+ o + ":j_id170']")).sendKeys("T" + o);
				Thread.sleep(7000);
			}
			Thread.sleep(8000);
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(8000);
			driver.findElement(
					By.xpath("//input[@id='j_id0:form:newElementWithQuestion:clearNewLinkedQuestion']"))
					.click();
			Thread.sleep(8000);

		}

	}

}
