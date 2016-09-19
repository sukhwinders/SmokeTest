package com.org.Example.myproject;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9681_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TradingPartnerName");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String Reqname = "AutoTest" + d;

	String firstwindow;
	String secondwindow;
	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void SubmitformBYresponder() throws Exception {
		// Login to the salesforce
		guitils.loginToPortal(userName2,password2,driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Requests')]"))
				.click();
		Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iter = window.iterator();
		firstwindow = iter.next();
		driver.findElement(By.xpath("//div[contains(@title,'New')]")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		Thread.sleep(2000);
		driver.findElement(By.id("requestName")).clear();
		driver.findElement(By.id("requestName")).sendKeys(Reqname);
		driver.findElement(By.id("tradingPartnerDropDown")).clear();
		driver.findElement(By.id("tradingPartnerDropDown")).sendKeys(Responder);
		driver.findElement(By.cssSelector("h3.ng-binding")).click();

		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--neutral"))
				.click();
		driver.findElement(
				By.xpath("//a[contains(@ng-click,'populateDocTemplate(d.name);')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[contains(.,'California Transparency of Supply Chain Act')]"))
				.click();

		driver.findElement(
				By.cssSelector("div.slds-modal__footer.slds-modal__footer--directional > button.slds-button.slds-button--brand"))
				.click();
		driver.findElement(By.xpath("//button[3]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='date']")).click();
		driver.findElement(By.xpath("//div[2]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'12')]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--neutral"))
				.click();
		driver.findElement(
				By.xpath("//button[@ng-click='CancelAttachDialog()']")).click();

		driver.findElement(By.id("comments")).sendKeys(comment);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(.,'Send')]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//button[@ng-click='redirectToRequestListPage();']"))
				.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
		driver.findElement(By.linkText(Reqname)).click();
		Thread.sleep(10000);

		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
					.sendKeys(Keys.CONTROL + "t");

		} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
					.sendKeys(Keys.COMMAND + "t");
		}
		driver.get(baseUrl);
		// Login to the salesforce
		guitils.loginToPortal(userName1,password1,driver);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Requests')]"))
				.click();

		driver.findElement(
				By.xpath("//span[@class='triggerLinkText selectedListView uiOutputText']"))
				.click();
		driver.findElement(By.xpath("//input[@placeholder='Find list']"))
				.sendKeys("All");
		driver.findElement(By.xpath("//input[@placeholder='Find list']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Find list']"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(@role,'option')]")).click();

		Thread.sleep(7000);
		while (true) {
			String Total_requests = driver
					.findElement(
							By.xpath("//span[@class='uiOutputText forceListViewStatusInfo']"))
					.getText();
			if (Total_requests.indexOf("+") > -1) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("scrollContent = document.evaluate('html/body/div[6]/div[1]/section/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;scrollContent.scrollTop = scrollContent.scrollHeight;");
			} else {
				break;
			}
		}

		tblAccounts = driver
				.findElement(By
						.xpath("html/body/div[6]/div[1]/section/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div/table/tbody"));
		RowsOfTable = tblAccounts.findElements(By.tagName("tr"));
		driver.findElement(By.linkText(Reqname)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Related']")).click();

		driver.findElement(
				By.xpath("//a[contains(@title,'California Transparency of Supply Chain Act')]"))
				.click();
		driver.findElement(By.xpath("//div[@title='Open Form']")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));

		/*
		 * List<WebElement> RdoYes = driver.findElements(By
		 * .xpath(".//label[starts-with(@for,'Yes')]"));
		 */
		List<WebElement> RdoNo = driver.findElements(By
				.xpath(".//label[starts-with(@for,'No')]"));

		RdoNo.get(0).click();
		/*
		 * RdoYes.get(1).click();
		 * 
		 * RdoNo.get(2).click(); RdoYes.get(3).click(); RdoNo.get(4).click();
		 * RdoYes.get(5).click(); RdoNo.get(6).click();
		 */
		driver.findElement(By.xpath("//input[@id='QuestionSignature']"))
				.sendKeys(comment);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@ng-click='vm.onSubmit(vm)']"))
				.click();
		driver.findElement(By.xpath("//a[@title='Related']")).click();
		// driver.findElement(By.linkText(Reqname)).click();
		// driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();

	}

}
