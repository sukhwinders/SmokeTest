package com.org.Example.myproject;

import java.util.List;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading_Old;

public class TC9653_Test {

	WebDriver driver;
	String baseUrl;
	String ICIXId;
	Data_loading_Old guitils = new Data_loading_Old();
	String RequestorUsername = guitils.getUserName("RequestorUsername");
	String RequestorPassword = guitils.getPassword("RequestorPassword");
	
	String ResponderUsername = guitils.getUserName("ResponderUsername");
	String ResponderPassword = guitils.getPassword("ResponderPassword");
	
	/*String userName1="admin@icix.SandboxDemo0208001";
	String password1="Welcome123!";
	String userName2="admin@icix.SandboxDemo010";
	String Password2="Welcome123!";*/
	 
	String strTPName = "dev";
	String TagName = "Organic";
	String relationshitpType="Packhouse";
	/*String wait = ("Thread.sleep(2000);");*/
	
	@BeforeClass
	public void Browser(){
		driver = guitils.openBrowser(driver);
	}
	
	
	@Test(priority=1)
	public void GetIcixId() throws InterruptedException
	{
		guitils.loginToPortal(ResponderUsername,ResponderPassword,driver);
		
		WebElement btnBlock = (new WebDriverWait(driver, 50))
				   .until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@class,'profileTrigger')]")));
		
	 // driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"));
 		
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
		.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//img[contains(@class,'profile-card-avatar')]")).click();
		Thread.sleep(6000);
		 ICIXId =driver.findElement(By.xpath("//span[contains(.,'Primary ICIX Id')]//following::div[@class='itemBody'][1]")).getText();
		
		 System.out.println(ICIXId);
		 
	}
	
	@Test(priority=2)
	public void SearchTP() throws Exception{
		guitils.loginToPortal(RequestorUsername,RequestorPassword,driver);
		guitils.SalesForceLightiningView();		
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		Thread.sleep(3000);
		 List<WebElement> frame=driver.findElements(By.tagName("iframe"));
		  System.out.println(frame.size());
		  
		  if (frame.size()>0)
		  {
		   if (frame.size()>1)
		   {
			   driver.switchTo().frame(frame.get(1));
			   Thread.sleep(4000);
		   }
		   else
		   {
			   driver.switchTo().frame(frame.get(0));
			   Thread.sleep(4000);
		   }
		  }
		  driver.findElement(By.xpath("//a[contains(text(),'Additional information')]")).click();
		  Thread.sleep(2000);
		 /* driver.findElement(By.xpath("//*[@id='companyName']")).clear();
		  driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys(IcixId);*/
			driver.findElement(By.xpath("//input[contains(@ng-model,'avm.newPartner.icixId')]")).clear();
			driver.findElement(By.xpath("//input[contains(@ng-model,'avm.newPartner.icixId')]")).sendKeys(ICIXId);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
			Thread.sleep(500);
			driver.manage().deleteAllCookies();
		 
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[contains(text(),'Connect')]")).click();
			Thread.sleep(3000);	
			
			driver.findElement(By.xpath("//select[@ng-options='type for type in vm.main.tradingPartnerRelationshipTypes']")).click();
			driver.findElement(By.xpath("//option[contains(.,'"+relationshitpType+"')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@id='tab-PartnerRelationship-1__item']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='slds-form-element__label ng-binding']")).click();
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//div/div/div/div/div[3]/div/div/div/div/div/div[5]/div/div[1]/label/span")).click();
			/*driver.findElement(By.id("btn_UURelationship_Tag_Add")).click();
			Thread.sleep(500);
			driver.findElement(By.id("txt_UURelationship_Tag_New")).clear();
			driver.findElement(By.id("txt_UURelationship_Tag_New")).sendKeys("QA-Auto");
			Thread.sleep(5000);*/
			
			Thread.sleep(2000);
			 
		//	driver.findElement(By.id("btn_UPRelationship_Save")).click();
			Thread.sleep(3000);
			
			}
	
	public void close(){
		guitils.logoutFromPortal(driver);
		driver.close();
	}
	
}
