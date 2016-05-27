package com.org.Example.myproject;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9883_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;
	 
	 Date d = new Date(System.currentTimeMillis());
	 String container_Name ="Testcontainer"+d;
	 String Layout_Name    ="Testlayout"+d;
	 String Tab_Name       ="Testtab"+d;
	 String Section_Name   ="Testsection"+d;
	 String QuestionText   ="TestQ"+d;
	 String FName;
	 
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
//		  driver.findElement(By.id("j_id0:form:buttonPreview")).click();
//		  Thread.sleep(9000);
//		    driver.findElement(By.id("j_id0:form:buttonPublish")).click();
//		    Thread.sleep(6000);
		 // driver.quit();
	  }
	
	  @Test
	  public void Copy_form() throws Exception {
	    
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
	    FName = driver.findElement(By.id("j_id0:form:dataPageBlock:j_id38:0:j_id40")).getText();
	    driver.findElement(By.id("j_id0:form:dataPageBlock:j_id38:0:j_id54")).click();
 	    String str = driver.findElement(By.linkText("Copy of "+FName)).getText();
	    if (str.contains(FName))
	    	
	    {
	    	System.out.println("Pass");
	    }
	    else
	    {
	    	System.out.println("Fail");
	    }
	    
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
				     }}	
}
