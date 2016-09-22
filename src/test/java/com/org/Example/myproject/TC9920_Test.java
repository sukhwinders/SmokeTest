package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Date;
import java.util.List;
import java.util.Set;
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

public class TC9920_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	 static Date d = new Date(System.currentTimeMillis());
	 static String container_Name="VD2TestContainer "+d;
	 static String Layout_Name="TestLayout "+d;
	 static String Tab_Name="TestTab "+d;
	 static String Section_Name="TestSection "+d;
	 static String QuestionText="Test Question "+d;
	 static String answerType="Answer type "+d;

     Data_loading guitils = new Data_loading();
	 String userName1   = guitils.getUserName("RequestorUsername");
	 String password1   = guitils.getPassword("RequestorPassword");
	 String Answertype = guitils.getDATA("AnswerType");

	@BeforeClass
	public void beforeClass() {
	  baseUrl = "https://login.salesforce.com";
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.navigate().to(baseUrl);
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

	  @Test
	  public void createNew_form() throws Exception {
		  driver.findElement(By.id("username")).clear();
		  driver.findElement(By.id("username")).sendKeys(userName1);
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys(password1);
		  driver.findElement(By.id("Login")).click();
		  switchtoLightining();
		  driver.findElement(By.linkText("App Launcher")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.linkText("ICIX")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		  driver.switchTo().frame(0);

		  //Adding Container
		  driver.findElement(By.name("j_id0:form:j_id7")).click();
		  driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerName")).clear();
		  driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerName")).sendKeys(container_Name);
		  new Select(driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerContainerType"))).selectByVisibleText("Single Form");
		  new Select(driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerType"))).selectByVisibleText("Form");
		  driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm")).click();
		  new Select(driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary"))).selectByVisibleText("Existing");
		  driver.findElement(By.id("j_id0:form:containerBlock:createContainer")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.id("j_id0:form:buttonSave")).click();
		  Thread.sleep(3000);

		  //Adding layout
		  driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		  driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName")).clear();
		  driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName")).sendKeys(Layout_Name);
		  new Select(driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutSharing"))).selectByVisibleText("Public");
		  driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutIsValid")).click();
		  new Select(driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutUiType"))).selectByVisibleText("desktop");
		  driver.findElement(By.id("j_id0:form:layoutBlock:createLayout")).click();
		  Thread.sleep(6000);
		  driver.findElement(By.id("j_id0:form:buttonSave")).click();
		  Thread.sleep(9000);

		  //Adding tabs
		  for(int i=0;i<3;i++){
			  driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
			  Thread.sleep(4000);
			  driver.findElement(By.id("j_id0:form:createTab")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.id("j_id0:form:tabBlock:tabSection:tabTable:"+i+":j_id46")).sendKeys(Tab_Name+" "+i);
			  Thread.sleep(3000);
			  driver.findElement(By.id("j_id0:form:tabBlock:tabSection:tabTable:"+i+":j_id57")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.id("j_id0:form:buttonSave")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:"+i+":selectTab']")).click();
			  Thread.sleep(3000);
			  System.out.println("tab"+i);

			  //Adding sections
			  for(int j=0;j<6;j++){
				  	driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
				  	Thread.sleep(5000);
		   			driver.findElement(By.id("j_id0:form:createSection")).click();
		   			driver.findElement(By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"+j+":j_id73")).click();
		   			Thread.sleep(5000);
		   			driver.findElement(By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"+j+":j_id73")).sendKeys(Section_Name);
		   			Thread.sleep(5000);
		   			new Select(driver.findElement(By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"+j+":j_id88"))).selectByVisibleText("Row");
		   			Thread.sleep(5000);
		   			driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		   			Thread.sleep(6000);
		   			driver.findElement(By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"+j+":selectSection")).click();
		   			Thread.sleep(3000);
		   			System.out.println("section"+j);
		   			for(int k=0;k<1;k++){
		   				//Script for Linked in Questions
		   				driver.findElement(By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']")).click();
		   				Thread.sleep(5000);

		   				//Enter parameter for number of questions to be added
		    			createQuestion_text(1);
		    			createQuestion_checkbox(1);
		   				createQuestion_multiPickList(1);
		    			createQuestion_longText(1);
		    			createQuestion_pickList(1);
		   				createQuestion_radio(1);
		   			}
			  }
		 }

		//Publishing the form
  		driver.findElement(By.id("j_id0:form:buttonPublish")).click();
  		System.out.println("published");
	  }

	public void switchtoLightining() throws InterruptedException {
		if(driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() >0 ){

	         driver.findElement(By.id("userNavLabel")).click();
	          driver.findElement(By.xpath("//a[@title='Switch to Lightning Experience']")).click();
	          String parentWindow= driver.getWindowHandle();
	          Set<String> allWindows = driver.getWindowHandles();
	          for(String curWindow : allWindows){
	              driver.switchTo().window(curWindow);
	              driver.findElement(By.xpath("//div[@style='line-height:12px; margin-top: 12px']")).click();
	              driver.findElement(By.id("simpleDialog0button0")).click();
	              driver.switchTo().window(parentWindow);
	              Thread.sleep(8000);
	              driver.navigate().refresh();
	          }
		}
		else if(driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() < 0 ){
		  driver.findElement(By.linkText("App Launcher")).click();
		}		
	}

	public void createQuestion_text(int questionCnt) throws InterruptedException{
		for(int i=0;i<questionCnt;i++){
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName")).sendKeys(QuestionText+" "+i);
			driver.findElement(By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']")).sendKeys(QuestionText+" "+i);
			new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType"))).selectByVisibleText("text");
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion")).click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_checkbox(int questionCnt) throws InterruptedException{
		for(int i=0;i<questionCnt;i++){
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName")).sendKeys(QuestionText+" "+i);
			driver.findElement(By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']")).sendKeys(QuestionText+" "+i);
			new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType"))).selectByVisibleText("checkbox");
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion")).click();
			Thread.sleep(4000);
			}
	}

	public void createQuestion_longText(int questionCnt) throws InterruptedException{
		for(int i=0;i<questionCnt;i++){
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName")).sendKeys(QuestionText+" "+i);
			driver.findElement(By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']")).sendKeys(QuestionText);
			new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType"))).selectByVisibleText("long text");
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion")).click();
			Thread.sleep(4000);
			}
	}

	public void createQuestion_pickList(int questionCnt) throws InterruptedException{
		for(int i=0;i<questionCnt;i++){
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName")).sendKeys(QuestionText);
			driver.findElement(By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']")).sendKeys(QuestionText);
			new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType"))).selectByVisibleText("picklist");
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion")).click();
			Thread.sleep(5000);

			//clicking the select button
			WebElement tblQst= driver.findElement(By.xpath(".//tbody[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:tb']"));
			List<WebElement> RowsOfTable=tblQst.findElements(By.tagName("tr"));
			List<WebElement> ColOfTable;
			WebElement btnSel;

			for (int r=0;r<RowsOfTable.size();r++)
			{
			ColOfTable=RowsOfTable.get(r).findElements(By.tagName("td"));

				for (int tdcount=0;tdcount<ColOfTable.size();tdcount++)
				{
					String tdText=ColOfTable.get(tdcount).getText();
					String textToVerify="picklist";
					if(tdText.equals(textToVerify))
					{
						btnSel=RowsOfTable.get(r).findElement(By.xpath(".//input[@value='select']"));
						Thread.sleep(3000);
						btnSel.click();
						Thread.sleep(4000);
						break;
					}
				}
			}
	
			//Adding the values
			for(int awsCnt=0;awsCnt<4;awsCnt++){
				Thread.sleep(3000);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:createAnswerOption")).click();
				Thread.sleep(4000);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+awsCnt+":j_id166")).sendKeys(answerType);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+awsCnt+":j_id170")).sendKeys(answerType);
				Thread.sleep(3000);
			}

			//Saving the question
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(4000);

			//Clearing the previous values
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion")).click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_multiPickList(int questionCnt) throws InterruptedException{
		for(int i=0;i<questionCnt;i++){
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName")).sendKeys(QuestionText);
			driver.findElement(By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']")).sendKeys(QuestionText);
			new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType"))).selectByVisibleText("multi-picklist");
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion")).click();
			Thread.sleep(5000);

			WebElement tblQst= driver.findElement(By.xpath(".//tbody[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:tb']"));
			List<WebElement> RowsOfTable=tblQst.findElements(By.tagName("tr"));
			List<WebElement> ColOfTable;
			WebElement btnSel;

			for (int r=0;r<RowsOfTable.size();r++)
			{
			ColOfTable=RowsOfTable.get(r).findElements(By.tagName("td"));

				for (int tdcount=0;tdcount<ColOfTable.size();tdcount++)
				{
					String tdText=ColOfTable.get(tdcount).getText();
					String textToVerify="multi-picklist";
					if(tdText.equals(textToVerify))
					{
						btnSel=RowsOfTable.get(r).findElement(By.xpath(".//input[@value='select']"));
						Thread.sleep(3000);
						btnSel.click();
						Thread.sleep(4000);
						break;
					}
				}
			}

			//Adding the values
			for(int awsCnt=0;awsCnt<4;awsCnt++){
				Thread.sleep(3000);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:createAnswerOption")).click();
				Thread.sleep(4000);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+awsCnt+":j_id166")).sendKeys(answerType);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+awsCnt+":j_id170")).sendKeys(answerType);
				Thread.sleep(3000);
			}

			//Saving the question
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(4000);
			//Clearing the previous values
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion")).click();
			Thread.sleep(4000);
		}
	}

	public void createQuestion_radio (int questionCnt) throws InterruptedException{
		for(int i=0;i<questionCnt;i++){
			Thread.sleep(3000);
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName")).sendKeys(QuestionText);
			driver.findElement(By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']")).sendKeys(QuestionText);
			new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType"))).selectByVisibleText("radio");
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion")).click();
			Thread.sleep(5000);

			WebElement tblQst= driver.findElement(By.xpath(".//tbody[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:tb']"));
			List<WebElement> RowsOfTable=tblQst.findElements(By.tagName("tr"));
			List<WebElement> ColOfTable;
			WebElement btnSel;

			for (int r=0;r<RowsOfTable.size();r++)
			{
			ColOfTable=RowsOfTable.get(r).findElements(By.tagName("td"));

				for (int tdcount=0;tdcount<ColOfTable.size();tdcount++)
				{
					String tdText=ColOfTable.get(tdcount).getText();
					String textToVerify="radio";
					if(tdText.equals(textToVerify))
					{
						btnSel=RowsOfTable.get(r).findElement(By.xpath(".//input[@value='select']"));
						Thread.sleep(3000);
						btnSel.click();
						Thread.sleep(4000);
						break;
					}
				}
			}

			//Adding the values			
			for(int awsCnt=0;awsCnt<4;awsCnt++){
				Thread.sleep(3000);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:createAnswerOption")).click();
				Thread.sleep(4000);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+awsCnt+":j_id166")).sendKeys(answerType);
				driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+awsCnt+":j_id170")).sendKeys(answerType);
				Thread.sleep(3000);
			}

			//Saving the question
			driver.findElement(By.id("j_id0:form:buttonSave")).click();
			Thread.sleep(4000);

			//Clearing the previous values
			driver.findElement(By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion")).click();
			Thread.sleep(4000);
		}
	}
}