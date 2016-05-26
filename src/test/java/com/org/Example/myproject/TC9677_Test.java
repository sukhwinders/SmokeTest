package com.org.Example.myproject;
	import java.awt.Robot;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.event.KeyEvent;
import com.utils.Data_loading;


public class TC9677_Test  {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String TPname = guitils.getDATA("TPName");
	String Responder = guitils.getDATA("Partner_name");
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void send_document() throws Exception {
		// Login to the portal
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName1);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		switchtoLightining();
		// Click on App Launcher button
		driver.findElement(By.linkText("App Launcher")).click();
		// Click on ICIX button
		driver.findElement(By.linkText("ICIX")).click();
		// Click on Document Library
		driver.findElement(By.linkText("Document Library")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("btn_AddDocument")).click();
		new Select(driver.findElement(By.id("ddTemplate")))
				.selectByVisibleText("GFSI Certification");
		driver.findElement(By.id("createButton")).click();
		// Get the current window handle
		// String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		// Get the list of window handles
		ArrayList<String> tabs2 = new ArrayList<String>(
				driver.getWindowHandles());
		System.out.println("size is:" + tabs2.size());
		/*
		 * switch to first window driver.switchTo().window(tabs2.get(0));
		 */
		// Switching to the new window
		driver.switchTo().window(tabs2.get(1));
		driver.findElement(
				By.xpath(".//*[@id='origin-main']/div[1]/div[2]/button[1]"))
				.click();

		// Robot class is used to handle model box
		// key press events are used to manage actions
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);

		// Switch to the parent old window
		Thread.sleep(3000);
		driver.switchTo().window(tabs2.get(0));
		// Switch to the iFrame
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		// Click on the upload button
		driver.findElement(By.xpath(".//*[@id='uploadButton']")).click();
		Thread.sleep(8000);

	}

	public void switchtoLightining() throws InterruptedException {
		if (driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() > 0) {
			driver.findElement(By.id("userNavLabel")).click();
			driver.findElement(
					By.xpath("//a[@title='Switch to Lightning Experience']"))
					.click();
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for (String curWindow : allWindows) {
				driver.switchTo().window(curWindow);
				// perform operation on popup
				driver.findElement(
						By.xpath("//div[@style='line-height:12px; margin-top: 12px']"))
						.click();
				driver.findElement(By.id("simpleDialog0button0")).click();
				// switch back to parent window
				driver.switchTo().window(parentWindow);
				Thread.sleep(5000);
				driver.navigate().refresh();
			}
		} else if (driver.findElements(By.xpath("//span[@id='userNavLabel']"))
				.size() < 0) {

			driver.findElement(By.linkText("App Launcher")).click();
		}
	}
	  }





   