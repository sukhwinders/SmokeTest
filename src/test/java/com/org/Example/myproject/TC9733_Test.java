package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9733_Test {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Responder = guitils.getDATA("TPResponder");
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
	String baseUrl =  "https://login.salesforce.com";

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
	public void Approve_Request() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Requests")).click();
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
		/*driver.findElement(
		By.xpath("//span[contains(.,'California Transparency of Supply Chain Act')]"))
		.click();*/
		driver.findElement(By.xpath("html/body/div[8]/div[1]/div/div[2]/div[2]/div[15]/div/div[1]/div/div/label/span")).click();
		
		driver.findElement(
				By.cssSelector("div.slds-modal__footer.slds-modal__footer--directional > button.slds-button.slds-button--brand"))
				.click();
		driver.findElement(By.xpath("//button[3]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.id("dueDate")).click();
		driver.findElement(By.xpath("html/body/div[5]/div/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[6]/span")).click();
		/*Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='date']")).click();
		driver.findElement(By.xpath("//div[2]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'12')]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--neutral"))
				.click();
		driver.findElement(
				By.xpath("//button[@ng-click='CancelAttachDialog()']")).click(); */

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
		// code for logout
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
				.click();
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(5000);

		/*
		 * if (System.getProperty("os.name").toLowerCase().contains("win")) {
		 * driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		 * .sendKeys(Keys.CONTROL + "t");
		 * 
		 * } else if
		 * (System.getProperty("os.name").toLowerCase().contains("mac")) {
		 * driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		 * .sendKeys(Keys.COMMAND + "t"); }
		 */
		
		/*------------------------------------------------*/
		/*------------ Login To Responder Org ------------*/
		/*------------------------------------------------*/ 
		
		driver.get(baseUrl);
		guitils.loginToPortal(userName2, password2, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//a[@title='App Launcher']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(20000);
		driver.findElement(By.linkText("Requests")).click();
		Thread.sleep(250000);
		driver.findElement(
				By.xpath("//span[@class='triggerLinkText selectedListView uiOutputText']"))
				.click();
		/*
		 * driver.findElement(By.xpath("//input[@placeholder='Find list']"))
		 * .sendKeys("All");
		 * driver.findElement(By.xpath("//input[@placeholder='Find list']"))
		 * .click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@placeholder='Find list']"))
		 * .click(); Thread.sleep(4000);
		 * driver.findElement(By.xpath("//a[contains(@role,'option')]"
		 * )).click();
		 */

		// click on all option
		driver.findElement(
				By.xpath("html/body/div[5]/div[3]/div[2]/div/div[1]/div/div/div/div/div[1]/div/ul/li[1]/a"))
				.click();

		Thread.sleep(7000);
		while (true) {
			String Total_requests = driver
					.findElement(
							By.xpath("//span[@class='countSortedByFilteredBy uiOutputText forceListViewStatusInfo']"))
					.getText();
			if (Total_requests.indexOf("+") > -1) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("scrollContent = document.evaluate('/html/body/div[5]/div[1]/section/div[1]/div[1]/div/div/div[2]/div[1]/div/div[2]/div/div[3]/div', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;scrollContent.scrollTop = scrollContent.scrollHeight;");
			} else {
				break;
			}
		}
		
		tblAccounts = driver
				.findElement(By
						.xpath("//div[@class = 'scroller actionBarPlugin fixedHeaderPlugin']//table[1]"));
		RowsOfTable = tblAccounts.findElements(By.tagName("tr"));
		//driver.findElement(By.linkText("AutoTestThu Sep 15 15:18:24 IST 2016")).click();
		Thread.sleep(1000);
		WebElement rateElement = driver.findElement(By.linkText(Reqname));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		  
		// driver.findElement(By.linkText("AutoTestTue Jun 21 10:48:47 IST 2016")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Related']")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//a[contains(@title,'California Proposition 65 Warranty')]"))
				.click();
		Thread.sleep(5000);
		// Click on open form button
		driver.findElement(
				By.cssSelector("[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']"))
				.click();
		// driver.findElement(By.xpath("//div[@title='Open Form']")).click();
		Thread.sleep(4000);
		/*
		 * driver.findElement(
		 * By.xpath("//span[@title='Show more actions for this record']"))
		 * .click();
		 */
		// driver.findElement(By.linkText("Open Form")).click();
		driver.findElement(
				By.cssSelector("[role='menuitem'][title='Open Form']")).click();

		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));

		// List <WebElement>
		// RdoYes=driver.findElements(By.xpath(".//label[starts-with(@for,'Yes')]"));
		List<WebElement> RdoNo = driver.findElements(By
				.xpath(".//label[starts-with(@for,'No')]"));

		RdoNo.get(0).click();

		/*
		 * * RdoYes.get(1).click();
		 * 
		 * RdoNo.get(2).click(); RdoYes.get(3).click(); RdoNo.get(4).click();
		 * RdoYes.get(5).click(); RdoNo.get(6).click();
		 */
		driver.findElement(By.xpath("//input[@id='QuestionSignature']"))
				.sendKeys(comment);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@ng-click='vm.onSubmit(vm)']"))
				.click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//a[@title='Related']")).click();
		driver.findElement(
				By.xpath("//div[@class='full forcePageBlock forceRecordLayout']/section[1]/ul/div[2]/li[1]/div[2]/div/div/a"))
				.click();
		Thread.sleep(8000);

		// driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		// driver.findElement(By.xpath("//div[@title='Submit']")).click();
		driver.findElement(By.linkText("Submit")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.xpath("//button[@onclick='submitRequest()']"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		// logout responder
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
				.click();
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(5000);

		/*
		 * if (System.getProperty("os.name").toLowerCase().contains("win")) {
		 * driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		 * .sendKeys(Keys.CONTROL + "w"); } else if
		 * (System.getProperty("os.name").toLowerCase().contains("mac")) {
		 * driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		 * .sendKeys(Keys.COMMAND + "w"); }
		 * driver.switchTo().window(firstwindow); driver.navigate().refresh();
		 */
		/*
		 * driver.findElement(By.xpath("//a[@title='Related']")).click();
		 * driver.findElement(By.xpath(
		 * "//div[@class='uiScroller scroller-wrapper scroll-bidirectional native']/div/table/tbody/tr/th/div/a"
		 * )).click();
		 */

		/*------------------------------------------------*/
		/*------------ Login To Requester Org ------------*/
		/*------------------------------------------------*/ 		
		
		
		// login by requester
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(5000);
		// driver.navigate().refresh();

		driver.findElement(By.xpath("//a[contains(.,'Workflows')]")).click();
		Thread.sleep(280000);
		// click on all option
		// code for scroll
		// code for click req.
		// click on all option
		
		driver.findElement(
				By.xpath("//span[@class='triggerLinkText selectedListView uiOutputText']"))
				.click();
		driver.findElement(
				By.xpath("html/body/div[5]/div[3]/div[2]/div/div[1]/div/div/div/div/div[1]/div/ul/li[1]/a"))
				.click();
		Thread.sleep(7000);
		while (true) {
			String Total_requests = driver
					.findElement(
							By.xpath("//span[@class='countSortedByFilteredBy uiOutputText forceListViewStatusInfo']"))
					.getText();
			if (Total_requests.indexOf("+") > -1) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("scrollContent = document.evaluate('/html/body/div[5]/div[1]/section/div[1]/div[1]/div/div/div[2]/div[1]/div/div[2]/div/div[3]/div', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;scrollContent.scrollTop = scrollContent.scrollHeight;");
			} else {
				break;
			}
		}
	
		tblAccounts = driver
				.findElement(By
						.xpath("//div[@class = 'scroller actionBarPlugin fixedHeaderPlugin']//table[1]"));
		RowsOfTable = tblAccounts.findElements(By.tagName("tr"));
	
		
		WebElement rateElement1 = driver.findElement(By.linkText(Reqname));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement1);
		
		//driver.findElement(By.linkText("AutoTestThu Sep 15 15:18:24 IST 2016")).click();
	
		
		Thread.sleep(5000);
		// Approve request
		// driver.findElement(By.xpath("//span[@class='forceIconDeprecated forceIcon']")).click();
		String cssSelectorOfSameElements = "[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']";

		List<WebElement> a = driver.findElements(By
				.cssSelector(cssSelectorOfSameElements));
		a.get(0).click();
		
		// a.get(1).click();
		// a.get(2).click();

		/*
		 * driver.findElement(By.linkText("Show more actions for this record"))
		 * .click();
		 */
		Thread.sleep(8000);

		driver.findElement(By.linkText("Approve")).click();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(
				By.xpath("//textarea[@placeholder='Enter Comments ']"))
				.sendKeys("test comment");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[contains(@value,'Submit')]"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Assert.assertTrue(
				driver.findElement(By.xpath("//span[contains(.,'Approved')]"))
						.isDisplayed(), "Status is not getting Changed");

	}
}
