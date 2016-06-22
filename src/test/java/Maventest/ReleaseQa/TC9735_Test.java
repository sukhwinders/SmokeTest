package Maventest.ReleaseQa;

import java.util.Date;
import java.util.List;
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

public class TC9735_Test {
	WebDriver driver;
	String baseUrl;
	Date d = new Date(System.currentTimeMillis());
	String Reqname = "AutoTest" + d;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String Product = guitils.getDATA("Product_Name");
	String Comment = guitils.getDATA("Comment");

	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	String firstwindow;

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

	// ** This test will create a new product in the specific org ID**//
	@Test
	public void productTwoactor_workflow() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Requests")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='topRightHeaderRegion']/div/div/ul/li[1]/a"))
				.click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		Thread.sleep(2000);
		driver.findElement(By.id("requestName")).clear();
		driver.findElement(By.id("requestName")).sendKeys(Reqname);

		driver.findElement(
				By.xpath("html/body/div[3]/div/div/div/div/label[2]/span[1]"))
				.click();
		driver.findElement(By.xpath("//input[@id='productDropDown1']")).clear();
		driver.findElement(By.xpath("//input[@id='productDropDown1']"))
				.sendKeys(Product);
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
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--neutral"))
				.click();
		driver.findElement(
				By.xpath("//button[@ng-click='CancelAttachDialog()']")).click();

		driver.findElement(By.id("comments")).sendKeys("Test");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(.,'Send')]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//button[@ng-click='redirectToRequestListPage();']"))
				.click();
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.linkText(Reqname)).click();
		Thread.sleep(6000);
		// logout responder
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
				.click();
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(5000);

		guitils.loginToPortal(userName2, password2, driver);
		guitils.LightiningView(driver);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.linkText("Requests")).click();

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
		driver.findElement(By.linkText(Reqname)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Related']")).click();

		driver.findElement(
				By.xpath("//a[contains(@title,'California Transparency of Supply Chain Act')]"))
				.click();
		driver.findElement(By.xpath("//div[@title='Open Form']")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));

		
		List<WebElement> RdoNo = driver.findElements(By
				.xpath(".//label[starts-with(@for,'No')]"));

		RdoNo.get(0).click();
		
		driver.findElement(By.xpath("//input[@id='QuestionSignature']"))
				.sendKeys(Comment);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@ng-click='vm.onSubmit(vm)']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//div[@class='full forcePageBlock forceRecordLayout']/section[1]/ul/div[2]/li[1]/div[2]/div/div/a"))
				.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@title='Submit']")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.xpath("//button[@onclick='submitRequest()']"))
				.click();
		Thread.sleep(10000);
		// logout responder
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
				.click();
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(5000);

		
		// login by requester
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(5000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(.,'Workflows')]")).click();
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
		driver.findElement(By.linkText(Reqname)).click();
		// driver.findElement(By.linkText("AutoTestTue Jun 21 16:33:22 IST 2016")).click();

		String cssSelectorOfSameElements = "[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']";

		List<WebElement> a = driver.findElements(By
				.cssSelector(cssSelectorOfSameElements));
		a.get(0).click();
		// a.get(1).click();
		// a.get(2).click();

		driver.findElement(By.linkText("Approve")).click();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(
				By.xpath("//textarea[@name='j_id0:j_id40:commentBlock:j_id44']"))
				.sendKeys("Test comment");
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
