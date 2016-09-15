package com.org.Example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class RunConsole {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("ResponderUsername");
	String password1 = guitils.getPassword("ResponderPassword");
	String Icixid = guitils.getDATA("icixid");

	@Test
	public void Run_Command_In_Console() throws Exception {
		//Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		Thread.sleep(8000);

		// switchtoLightining();
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//span[@class='icon-settings-component icon-settings-bolt']")).click();
		//driver.findElement(By.xpath("//a[@title='Developer Console']")).click();
		
		
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(By.xpath("//a[@title='Developer Console']")).click(); // click some link that opens a new window
		Thread.sleep(8000);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}

		//code to do something on new window
		WebElement rateElement = driver.findElement(By.id("debugMenuEntry-btnEl"));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		  Thread.sleep(3000);
		driver.findElement(By.id("openExecuteAnonymousWindow-textEl")).click();
		 Thread.sleep(3000);
		 

		//WebElement eb= driver.findElement(By.cssSelector(".CodeMirror-scroll"));
		//eb.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".CodeMirror-scroll")).sendKeys("aDatabase.executeBatch(new MessageProcessor(), 1);");
		//driver.close(); // close newly opened window when done with it
		//driver.switchTo().window(parentHandle); // switch back to the original window
		

	}

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	

}
