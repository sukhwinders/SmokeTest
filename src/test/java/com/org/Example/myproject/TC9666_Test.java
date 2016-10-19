package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;



import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9666_Test {

	Date d = new Date(System.currentTimeMillis());
	String TP_Group = "Test Group " + d;
	String firstwindow;
	String secondwindow;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");

	WebDriver driver;
	String baseUrl;


	@BeforeClass
	 public void beforeClass() {  
	  driver = guitils.openBrowser(driver);
	 }


	@AfterClass
	public void afterClass() {
		guitils.logoutFromPortal(driver);
		driver.quit();
	}

	@Test
	public void SetAndSendCompilince() throws Exception {

		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.linkText("Trading Partner Groups")).click();
		WebElement wb = driver.findElement(By.linkText("Trading Partner Groups"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",wb);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		WebElement frame=driver.findElement(By.tagName("iframe"));
		
		driver.switchTo().frame(frame);
		driver.findElement(By.id("txtGroupName")).clear();
		driver.findElement(By.id("txtGroupName")).sendKeys(TP_Group);

		//driver.findElement(By.xpath("//*[@id='tab-scoped-0']/div/div[13]/div/label/span[1]")).click();
		List<WebElement> tags = driver.findElements(By.xpath("//span[@class='slds-checkbox--faux']"));
		if(tags.size()>0){
			tags.get(0).click();
		}
		
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("App Launcher")).click();
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Trading Partner Groups")).click();
		Thread.sleep(2000); 
		// Search Trading Partner 
				driver.findElement(By.id("754:9;a")).sendKeys(TP_Group);
				Thread.sleep(3000);
				WebElement webElement = driver.findElement(By.id("754:9;a"));
				webElement.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				webElement.sendKeys(Keys.ENTER);
				Thread.sleep(3000);	
				driver.findElement(By.linkText(TP_Group)).click();
		
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@data-aura-class='forceIconDeprecated']")).click();		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'Set Requirements')]")).click();
		Thread.sleep(3000);
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(4000);
		/*if (System.getProperty("os.name").toLowerCase().contains("win")) {

			driver.switchTo()
					.activeElement()
					.equals(driver.findElement(By
							.xpath("html/body/div[1]/div/div[2]/form/div[2]/div[2]/section/div/div/div/select")));
			driver.findElement(
					By.xpath("html/body/div[1]/div/div[2]/form/div[2]/div[2]/section/div/div/div/select"))
					.sendKeys(Keys.ARROW_DOWN);

		} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {

			driver.switchTo()
					.activeElement()
					.equals(driver.findElement(By
							.xpath("html/body/div[1]/div/div[2]/form/div[2]/div[2]/section/div/div/div/select")));
			driver.findElement(
					By.xpath("html/body/div[1]/div/div[2]/form/div[2]/div[2]/section/div/div/div/select"))
					.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		}*/
		
		Select dropdown1 = new Select(driver.findElement(By.id("RequestType0")));
		dropdown1.selectByIndex(1);
		Thread.sleep(3000);		
		Select dropdown = new Select(driver.findElement(By.id("DocType0")));
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		
		//driver.findElement(By.name("dateid")).click();
				driver.findElement(By.xpath("/html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input")).click();		
				//driver.findElement(By.xpath("//button[contains(.,'Next Month')]")).click();
				//Thread.sleep(3000);
				driver.findElement(By.xpath("html/body/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[7]/span")).click();
				//driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[7]/span")).click();
				Thread.sleep(3000);


		driver.findElement(By.id("btnSend")).click();
		Thread.sleep(3000);
		System.out.println("test3");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		

	}

}
