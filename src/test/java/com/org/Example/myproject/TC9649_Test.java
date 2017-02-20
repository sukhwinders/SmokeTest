package com.org.Example.myproject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import com.utils.Data_loading_Old;

public class TC9649_Test {

	WebDriver driver;
	String baseUrl;
	Data_loading_Old guitils = new Data_loading_Old();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String ICIX_ID = guitils.getDATA("IcixId");
	//String Partner = guitils.getDATA("CompanyN");

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void testSearchByIcixId() throws Exception {

		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.cssSelector("div.slds-icon-waffle")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li//a//div[@title='New']")).click();
		Thread.sleep(3000);
		List<WebElement> frame1=driver.findElements(By.tagName("iframe"));
		System.out.println(frame1.size());
		
		if(frame1.size()>1)
		{
			driver.switchTo().frame(frame1.get(1));
		}
		else
		{
			driver.switchTo().frame(frame1.get(0));
		}
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Advanced Search")).click();
		//driver.findElement(By.linkText("Additional information")).click();
	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@ng-model='avm.newPartner.icixId']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='avm.newPartner.icixId']")).sendKeys(
				ICIX_ID);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
		Thread.sleep(4000);
		/*String company_Name = driver.findElement(
				By.xpath("//h1[@class='slds-text-heading--small']"))
				.getText();
		Assert.assertEquals(company_Name, Partner, "Name is not matched");
		*/
		

}
}
