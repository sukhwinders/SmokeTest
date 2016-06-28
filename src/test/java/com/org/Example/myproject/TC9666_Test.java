package com.org.Example.myproject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	/*@AfterClass
	public void afterClass() {
		driver.quit();
	}*/

	@Test
	public void SetAndSendCompilince() throws Exception {

		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Trading Partner Groups")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("txtGroupName")).clear();
		driver.findElement(By.id("txtGroupName")).sendKeys(TP_Group);

		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux'][1]"))
				.click();
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Thread.sleep(2000);

		driver.findElement(
				By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("App Launcher")).click();
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Trading Partner Groups")).click();
		driver.findElement(By.linkText(TP_Group)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@data-aura-class='forceIconDeprecated']")).click();
		
		driver.findElement(By.xpath("//a[contains(.,'Set Requirements')]")).click();
		
		driver.switchTo().frame(1);

		Thread.sleep(3000);
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
		
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@ng-change='populateDocumentType(row)']")));
		dropdown1.selectByIndex(1);
		Thread.sleep(6000);
		
		Select dropdown = new Select(driver.findElement(By.id("DocType0")));
		dropdown.selectByIndex(5);
		Thread.sleep(2000);
		

		driver.findElement(By.xpath("//input[@name='dateid']")).click();
		driver.findElement(By.xpath("//button[contains(.,'Next Month')]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("html/body/div[1]/div/div[2]/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[2]/td[6]/span"))
				.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("html/body/div[1]/div/div[3]/button[3]"))
				.click();
		Thread.sleep(3000);
		System.out.println("test3");
		driver.findElement(
				By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
				.click();
		Thread.sleep(3000);

	}

}
