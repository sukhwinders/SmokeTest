package com.org.Example.myproject;


	

	import java.util.Date;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.utils.Data_loading;

	public class TC9891_Test {
		String firstwindow;
		WebDriver driver;
		String baseUrl;
		 
		 Date d = new Date(System.currentTimeMillis());
		 String container_Name ="Testcontainer"+d;
		 String Layout_Name    ="Testlayout"+d;
		 String Tab_Name       ="Testtab"+d;
		 String Section_Name   ="Testsection"+d;
		 String QuestionText   ="TestQ"+d;
		 
	     Data_loading guitils = new Data_loading();
		 String userName1   = guitils.getUserName("RequestorUsername");
		 String password1   = guitils.getPassword("RequestorPassword");
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
		    
		    // script for container template
		    driver.findElement(By.name("j_id0:form:j_id7")).click();
		   
		    driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerName")).sendKeys(container_Name);
		    new Select(driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerContainerType"))).selectByVisibleText("Single Form");
		    new Select(driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerType"))).selectByVisibleText("Form");
		    driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm")).click();
		    new Select(driver.findElement(By.id("j_id0:form:containerBlock:containerNew:inputContainerLibrary"))).selectByVisibleText("New");
		    driver.findElement(By.id("j_id0:form:containerBlock:createContainer")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.id("j_id0:form:buttonSave")).click();
		    Thread.sleep(3000);
		    
		    //script for Layout template
		    driver.findElement(By.id("j_id0:form:tabLayout_lbl")).click();
		    driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName")).sendKeys(Layout_Name);
		    new Select(driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutSharing"))).selectByVisibleText("Public");
		    driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutIsValid")).click();
		    new Select(driver.findElement(By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutUiType"))).selectByVisibleText("desktop");
		    driver.findElement(By.id("j_id0:form:layoutBlock:createLayout")).click();
		    Thread.sleep(6000);
		    driver.findElement(By.id("j_id0:form:buttonSave")).click();
		    Thread.sleep(9000);
		    
		    //script for Tabs template
		    
		     
		    driver.findElement(By.id("j_id0:form:tabTabs_lbl")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.id("j_id0:form:createTab")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.id("j_id0:form:tabBlock:tabSection:tabTable:0:j_id46")).sendKeys(Tab_Name);
		    Thread.sleep(3000);
		    driver.findElement(By.id("j_id0:form:buttonSave")).click();
		    Thread.sleep(8000);
		    driver.findElement(By.xpath(".//*[@id='j_id0:form:tabBlock:tabSection:tabTable:0:selectTab']")).click();
		    Thread.sleep(9000);
		    
		    //Script for Sections template
		    driver.findElement(By.id("j_id0:form:tabSections_lbl")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='j_id0:form:createSection']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[contains(@id,'id73')]")).sendKeys(Section_Name);
		    Thread.sleep(3000);
		    
		    driver.findElement(By.xpath("//input[@value='SAVE']")).click();
		    Thread.sleep(6000);
		    
		    //Script for Linked in Questions
		    driver.findElement(By.xpath("//td[@id='j_id0:form:tabLinkedQuestions_lbl']")).click();
		    Thread.sleep(5000);
		    create_Questions();
		    	    

		  }
		   public void create_Questions() throws InterruptedException  { 
			   
			       
		  //multipicklist 
		       
			    driver.findElement(By.xpath("//input[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName']")).sendKeys(QuestionText);
			    driver.findElement(By.xpath("//textarea[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionQuestionText']")).sendKeys(QuestionText);
			    new Select(driver.findElement(By.xpath("//select[@id='j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType']"))).selectByVisibleText("multi-picklist");
			    driver.findElement(By.xpath("//input[@id='j_id0:form:newElementWithQuestion:addNewLinkedQuestion']")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("//input[@id='j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:0:selectElement']")).click();
			    Thread.sleep(5000);
			   for(int k=0; k<=3; k++){
			    driver.findElement(By.xpath("//input[@id='j_id0:form:answerOptionBlock:createAnswerOption']")).click();
			    Thread.sleep(5000);
			    //passing Parameters
				driver.findElement(By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+k+":j_id166']")).sendKeys("Vikram "+k);
				driver.findElement(By.xpath("//input[@id='j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+k+":j_id170']")).sendKeys("T"+k);
				
//				act.moveToElement(driver.findElement(By.id("j_id0_form_answerOptionBlock_answerOptionSection_answerOptionTable_0_j_id175_ileinneredit"))).doubleClick().build().perform();
				if(k<=1)
				{
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.id("j_id0_form_answerOptionBlock_answerOptionSection_answerOptionTable_"+k+"_j_id175_chkbox"))).doubleClick().build().perform();
				driver.findElement(By.id("j_id0_form_answerOptionBlock_answerOptionSection_answerOptionTable_"+k+"_j_id175")).click();	
				driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection")).click();
				}
		   }
			   		   
				Thread.sleep(8000);
			    driver.findElement(By.id("j_id0:form:buttonSave")).click();
			   
			   
			    Thread.sleep(8000);
			 
			    

			   }   
			   
		   
		   public void switchtoLightining() throws InterruptedException  { 
				 
				  
					if(driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() >0 ){
						
					         driver.findElement(By.id("userNavLabel")).click();
					          driver.findElement(By.xpath("//a[@title='Switch to Lightning Experience']")).click();
					          String parentWindow= driver.getWindowHandle();
					          Set<String> allWindows = driver.getWindowHandles();
					          for(String curWindow : allWindows){
					              driver.switchTo().window(curWindow);
					          //perform operation on popup
					              driver.findElement(By.xpath("//div[@style='line-height:12px; margin-top: 12px']")).click();
					              driver.findElement(By.id("simpleDialog0button0")).click();
					           // switch back to parent window
					       driver.switchTo().window(parentWindow);
					       Thread.sleep(8000);
					       driver.navigate().refresh();
					          }
					     }
					     else if(driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() < 0 ){
					    	
					    	 driver.findElement(By.linkText("App Launcher")).click();
					     }
					}	

	

}