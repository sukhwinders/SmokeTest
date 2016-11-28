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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9663_Test {
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	//String partner_name = guitils.getDATA("Responder");
	String partner_name = guitils.getDATA("TPRelationship");
	

	@BeforeClass
	public void beforeClass() {
		/*baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
		*/
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void Edit_TradingPartner() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.xpath("//a[contains(.,'Trading Partner Relationships')]")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Relationships')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(partner_name)).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
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
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		//new Select(driver.findElement(By.id("ddl_UURelationship_Status"))).selectByVisibleText("Pending");
		new Select(driver.findElement(By.xpath("//select[@id='ddl_UURelationship_Type']"))).selectByVisibleText("Cold Storage");
		driver.findElement(By.id("btn_UPRelationship_Save")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//message-dialog/div[2]/div/div/div[3]/button")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		Thread.sleep(4000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
		frame1=driver.findElements(By.tagName("iframe"));
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
		Select drpType=new Select(driver.findElement(By.xpath("//select[@id='ddl_UURelationship_Type']")));
		WebElement drpFirstOption=drpType.getFirstSelectedOption();
		String ChangedRelTyp=drpFirstOption.getText();
		Assert.assertEquals(ChangedRelTyp, "Cold Storage","Relationship Type could not be changed");
		new Select(driver.findElement(By.xpath("//select[@id='ddl_UURelationship_Type']"))).selectByVisibleText("Farm");
		driver.findElement(By.id("btn_UPRelationship_Save")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//message-dialog/div[2]/div/div/div[3]/button")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		
		Thread.sleep(6000);
		//driver.findElement(By.cssSelector("img.profileTrigger")).click();
		//driver.findElement(By.linkText("Log Out")).click();
		//Thread.sleep(8000);

	}

}