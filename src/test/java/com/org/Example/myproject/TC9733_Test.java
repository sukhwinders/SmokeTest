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
	String FormName="California Transparency of Supply Chain Act";

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {	
		driver.quit();
	}

	@Test
	public void Approve_Request() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		/*
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Requests")).click();
		Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iter = window.iterator();
		firstwindow = iter.next();
		*/
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(2000);		
		
		driver.findElement(By.xpath("//div[contains(@title,'New')]")).click();
		
		WebElement frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		//Thread.sleep(2000);
		driver.findElement(By.id("requestName")).clear();
		driver.findElement(By.id("requestName")).sendKeys(Reqname);
		driver.findElement(By.id("tradingPartnerDropDown")).clear();
		driver.findElement(By.id("tradingPartnerDropDown")).sendKeys(Responder);
		driver.findElement(By.cssSelector("h3.ng-binding")).click();

		driver.findElement(By.cssSelector("button.slds-button.slds-button--neutral")).click();
		driver.findElement(By.xpath("//a[contains(@ng-click,'populateDocTemplate(d.name);')]")).click();
		Thread.sleep(2000);
		/*driver.findElement(
		By.xpath("//span[contains(.,'California Transparency of Supply Chain Act')]"))
		.click();*/
		//driver.findElement(By.xpath("html/body/div[8]/div[1]/div/div[2]/div[2]/div[15]/div/div[1]/div/div/label/span")).click();
		
		WebElement MainDiv=driver.findElement(By.xpath("//div[@ng-show='showCategoryModal']"));
		List<WebElement> SubDivs=MainDiv.findElements(By.xpath("//div[@class='ng-scope']"));
		List<WebElement> chkFromdiv=MainDiv.findElements(By.xpath("//label[@class='slds-checkbox']"));
		//System.out.print(SubDivs.size());
		//System.out.print(chkFromdiv.size());
		if (SubDivs.size()>0)
		{
		for(int counter=0;counter<SubDivs.size();counter++)
		{
		//System.out.println(SubDivs.get(counter).getText());
		if (SubDivs.get(counter).getText().contains(FormName))
		{
		chkFromdiv.get(counter).click();
		break;
		}
		}
		}
		
		
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
		//driver.findElement(By.xpath("//button[@ng-click='redirectToRequestListPage();']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		Thread.sleep(50000);
		driver.navigate().refresh();
		driver.findElement(By.linkText(Reqname)).click();
		Thread.sleep(50000);
		// code for logout
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
				.click();
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(100000);

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
		driver.get(baseUrl);
		guitils.loginToPortal(userName2, password2, driver);
		guitils.LightiningView(driver);
		
		/*
		driver.findElement(By.xpath("//a[@title='App Launcher']")).click();
		Thread.sleep(50000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(50000);
		driver.findElement(By.linkText("Requests")).click();
		Thread.sleep(50000);
		*/
		
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(300000);
		
	/*	driver.findElement(
				By.xpath("//span[@class='triggerLinkText selectedListView uiOutputText']"))
				.click();*/
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
	/*	Thread.sleep(5000);
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
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);*/
		  
		// driver.findElement(By.linkText("AutoTestTue Jun 21 10:48:47 IST 2016")).click();
		
// Search Trading Partner 
		//
		/*
		driver.findElement(By.id("84:2;a")).sendKeys(Reqname);
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.id("84:2;a"));
		webElement.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
		driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/a"))
				.click();
				*/
//
		// Search the request
		//driver.findElement(By.id("84:2;a")).sendKeys(Reqname);
		//driver.switchTo().defaultContent();
		Thread.sleep(3000);
		WebElement txtSrc=driver.findElement(By.xpath("//input[@placeholder='Search Salesforce']"));
		txtSrc.click();
		txtSrc.sendKeys(Reqname);
		   Thread.sleep(3000);
		   //WebElement webElement = driver.findElement(By.id("754:9;a"));
		   //txtSrc.sendKeys(Keys.TAB);
		  // Thread.sleep(3000);
		   txtSrc.sendKeys(Keys.ENTER);
		   Thread.sleep(3000); 
		   //driver.findElement(By.linkText(Reqname)).click();

		//Till here

		WebElement rateElement = driver.findElement(By.linkText(Reqname));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Related']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//a[contains(@title,'BSE Statement')]")).click();
		driver.findElement(By.partialLinkText("California Transparency")).click();
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

		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);

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
		
		/*
		
		// driver.findElement(By.xpath("//a[@title='Related']")).click();
		driver.findElement(
				By.xpath("//div[@class='full forcePageBlock forceRecordLayout']/section[1]/ul/div[2]/li[1]/div[2]/div/div/a"))
				.click();
		Thread.sleep(8000);

		// driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		// driver.findElement(By.xpath("//div[@title='Submit']")).click();
		driver.findElement(By.linkText("Submit")).click();
				
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@onclick='submitRequest()']"))
				.click();
				
				*/
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
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

		// login by requester
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		/*
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(5000);
		*/
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(2000);
		
		// driver.navigate().refresh();

		//driver.findElement(By.xpath("//a[contains(.,'Workflows')]")).click();
		//Thread.sleep(280000);
		// click on all option
		// code for scroll
		// code for click req.
		// click on all option
		
		
		/*
		//New
		
		//Thread.sleep(2000);
		//driver.findElement(By.linkText("Trading Partner Groups")).click();
		Thread.sleep(2000);
		// Search Trading Partner 
				driver.findElement(By.id("84:2;a")).sendKeys(Reqname);
				Thread.sleep(3000);
				WebElement webElement1 = driver.findElement(By.id("84:2;a"));
				webElement1.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				webElement1.sendKeys(Keys.ENTER);
				Thread.sleep(3000);	
				driver.findElement(By.linkText(Reqname)).click();
				Thread.sleep(2000);
		
		//Till here
		*/
		
		// Search the request
				//driver.findElement(By.id("84:2;a")).sendKeys(Reqname);
				//driver.switchTo().defaultContent();
				Thread.sleep(10000);
				txtSrc=driver.findElement(By.xpath("//input[@placeholder='Search Salesforce']"));
				txtSrc.click();
				txtSrc.sendKeys(Reqname);
				   Thread.sleep(3000);
				   //WebElement webElement = driver.findElement(By.id("754:9;a"));
				   //txtSrc.sendKeys(Keys.TAB);
				  // Thread.sleep(3000);
				   txtSrc.sendKeys(Keys.ENTER);
				   Thread.sleep(3000); 
				   //driver.findElement(By.linkText(Reqname)).click();

				//Till here

				rateElement = driver.findElement(By.linkText(Reqname));
				  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		
		
		
		//System.out.println(Reqname);
		//WebElement rateElement1 = driver.findElement(By.linkText("Reqname"));
		 // ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement1);
		
		//driver.findElement(By.linkText("AutoTestThu Sep 15 15:18:24 IST 2016")).click();
	
		//System.out.println("Test 3");
		Thread.sleep(5000);
		// Approve request
		// driver.findElement(By.xpath("//span[@class='forceIconDeprecated forceIcon']")).click();
		String cssSelectorOfSameElements = "[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']";

		List<WebElement> a = driver.findElements(By
				.cssSelector(cssSelectorOfSameElements));
		a.get(0).click();
		//System.out.println("Test 4");
		// a.get(1).click();
		// a.get(2).click();

		/*
		 * driver.findElement(By.linkText("Show more actions for this record"))
		 * .click();
		 */
		Thread.sleep(8000);

		driver.findElement(By.linkText("Approve")).click();
		Thread.sleep(2000);

		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		
		frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		driver.findElement(
				By.xpath("//textarea[@id='txt_Comment']"))
				.sendKeys("test comment");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='btn_Save']"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Assert.assertTrue(
				driver.findElement(By.xpath("//span[contains(.,'Approved')]"))
						.isDisplayed(), "Status is not getting Changed");
		
		//String txt= "";
		//driver.getPageSource().contains(txt);
		
			
			
			
		
		}
		

	}

