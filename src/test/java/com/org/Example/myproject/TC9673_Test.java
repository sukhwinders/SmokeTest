package com.org.Example.myproject;

import java.util.Date;
import java.util.List;
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

//import com.utils.Data_loading;

public class TC9673_Test {
	WebDriver driver;
	String baseUrl = "https://login.salesforce.com";
	Date d = new Date(System.currentTimeMillis());
	String Reqname = "AutoTest" + d;
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String Product = guitils.getDATA("Product_Name");
	String Comments = guitils.getDATA("Comment");

	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	String FormName="BSE Statement";

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
		/*baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);*/
	}

	
	 @AfterClass 
	 public void afterClass() 
	 
	 { 
		 driver.quit(); 
		}
	 

	// ** This test will create a new product in the specific org ID**//
	@Test
	public void productTwoactor_workflow() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.xpath("//a[contains(.,'Requests')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='topRightHeaderRegion']/div/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//div[contains(@title,'New')]")).click();
		//driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		WebElement frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		driver.findElement(By.id("requestName")).clear();
		driver.findElement(By.id("requestName")).sendKeys(Reqname);

		driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/label[2]/span[1]")).click();
		driver.findElement(By.xpath("//input[@id='productDropDown1']")).clear();
		driver.findElement(By.xpath("//input[@id='productDropDown1']"))
				.sendKeys(Product);
		//driver.findElement(By.cssSelector("h3.ng-binding")).click();
		driver.findElement(By.xpath("//a[contains(.,'Test Pr002')]")).click();
		

		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--neutral"))
				.click();
		driver.findElement(
				By.xpath("//a[contains(@ng-click,'populateDocTemplate(d.name);')]"))
				.click();
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//div[5]/div/div/div/div/label/span")).click();
		
		
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
		
		
		
/*		List<WebElement> checklist = driver.findElements(By.xpath("//input[@class='slds-checkbox']"));
 * 
		if(checklist.size()>0)
		checklist.get(0).click();*/
		
		
		driver.findElement(
				By.cssSelector("div.slds-modal__footer.slds-modal__footer--directional > button.slds-button.slds-button--brand"))
				.click();
		driver.findElement(By.xpath("//button[3]")).click();

		Thread.sleep(4000);
		driver.findElement(By.id("dueDate")).click();
		driver.findElement(By.xpath("html/body/div[5]/div/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[6]/span")).click();
/*		driver.findElement(By.xpath("//div[2]/button")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[contains(.,'12')]")).click();
		driver.findElement(
				By.cssSelector("button.slds-button.slds-button--neutral"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//button[@ng-click='CancelAttachDialog()']")).click();*/
		
		  driver.findElement(By.id("comments")).sendKeys("Test");
		
		

		driver.findElement(By.xpath("//button[contains(.,'Send')]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//button[@ng-click='redirectToRequestListPage();']"))
				.click();
		driver.navigate().refresh();
		Thread.sleep(5000);
		//driver.findElement(By.linkText(Reqname)).click();
		Thread.sleep(6000);

		
	/******** New Tab ***********/
		
		/*if (System.getProperty("os.name").toLowerCase().contains("win")) {
			driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
					.sendKeys(Keys.CONTROL + "t");

		} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
					.sendKeys(Keys.COMMAND + "t");
		}*/
		driver.get(baseUrl);
		guitils.loginToPortal(userName2, password2, driver);
		guitils.LightiningView(driver);
		Thread.sleep(3000);
		//driver.findElement(By.linkText("ICIX")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Requests')]")).click();
		driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		Thread.sleep(300000);

		//driver.findElement(By.xpath("//span[@class='triggerLinkText selectedListView uiOutputText']")).click();
		//Thread.sleep(2000);
		/*
		 * driver.findElement(By.xpath("//input[@placeholder='Find list']"))
		 * .sendKeys("All"); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@placeholder='Find list']"))
		 * .click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@placeholder='Find list']"))
		 * .click(); Thread.sleep(7000);
		 * driver.findElement(By.xpath("//a[contains(@role,'option')]"
		 * )).click();
		 */
		//driver.findElement(By.xpath("html/body/div[5]/div[3]/div[2]/div/div[1]/div/div/div/div/div[1]/div/ul/li[1]/a")).click();

		//Thread.sleep(7000);
		/*while (true) {
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
*/
		//driver.findElement(By.linkText(Reqname)).click();
		
		
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

	}

}
