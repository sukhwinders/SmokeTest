package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ModuleLocatorRepository.RequestRepo;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import ModuleLocatorRepository.*;

public class Data_loading {

	String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	String DATE_FORMAT_DATE = "yyyy-MM-dd";
	String DATE_FORMAT_TODAY_DATE = "M/d/yyyy";
	String DATE_FORMAT_TODAY_DATE_TIME = "M/dd/yyyy hh:mm a";
	String DATE_FORMAT_TODAY_DATE_TIME2 = "M/d/yyyy hh:mm a";
	
	//For 2Actorworkflow
	
	RequestRepo ObjReq=new RequestRepo(); // to access the request module locators
	
	String userName1 = getUserName("RequestorUsername");
	String password1 = getPassword("RequestorPassword");
	String Responder = getDATA("TPResponder");
	String userName2 = getUserName("ResponderUsername");
	String password2 = getPassword("RequestorPassword");
	String comment = getDATA("Comments");
	
	// Till here
	
	//For FormBuilder
	
	FormBuilderRepo ObjForm=new FormBuilderRepo();
		
	//Till here
	
	@SuppressWarnings("unused")
	private WebDriver driver;

	public void GeneralUtils(WebDriver driver) {
		this.driver = driver;
	}

	public String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
		// qa
	}

	@SuppressWarnings("unused")
	public Date nowSFDCformat() throws Exception {
		DateFormat formatter = null;
		Date convertedDate = null;
		String currentDate = now().substring(0, 10);
		String convertedDate2;
		// String currentDate = "2015-02-19 12:00:00";

		// Calendar cal = Calendar.getInstance();
		// formatter = new SimpleDateFormat(DATE_FORMAT_NOW);
		formatter = new SimpleDateFormat(DATE_FORMAT_DATE);

		// formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		convertedDate = formatter.parse(currentDate);
		// System.out.println(convertedDate);
		return convertedDate;
	}

	public Date tomorrowSFDCformat() throws Exception {
		DateFormat formatter = null;
		Date convertedDate = null;

		formatter = new SimpleDateFormat(DATE_FORMAT_DATE);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String tommorrow = (String) (formatter.format(cal.getTime()));
		convertedDate = formatter.parse(tommorrow);
		// System.out.println(convertedDate);
		return convertedDate;
	}
	
	public WebDriver openBrowser(WebDriver driver1)
	  {  
	  String baseUrl = "https://login.salesforce.com";
	   //driver = new FirefoxDriver();
	   //System.setProperty("webdriver.chrome.driver", "/Users/gurpinder.singh/Downloads/chromedriver");
	   ChromeDriverManager.getInstance().setup();
	   driver1 = new ChromeDriver();  
	   driver1.manage().window().maximize();
	   
	   driver1.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	   driver1.navigate().to(baseUrl);
	   return driver1;
	   
	  }

	public Date todayPlusNumberOfDaysSFDCformat(int numberOfDays)
			throws Exception {
		DateFormat formatter = null;
		Date convertedDate = null;

		formatter = new SimpleDateFormat(DATE_FORMAT_DATE);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, numberOfDays); // number of days to add
		String tommorrow = (String) (formatter.format(cal.getTime()));
		convertedDate = formatter.parse(tommorrow);
		return convertedDate;
	}

	public String today_date() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE);
		return sdf.format(cal.getTime());
	}

	public String today_date_time() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE_TIME);
		return sdf.format(cal.getTime());
	}

	public Date today_date_time2() throws ParseException {
		// Calendar cal = Calendar.getInstance();
		// Date currentDate = cal.getTime();
		Date curDate = new Date();
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE_TIME2,
				Locale.US);
		String currentDateTimeStr = sdf.format(curDate);
		Date currentDateTime = sdf.parse(currentDateTimeStr);

		return currentDateTime;
	}

	public String getTestRunStartTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH.mm");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());

		return dateTime;
	}

	public String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH.mm");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());

		return dateTime;

	}

	public String getUserName(String username) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(username);
	}

	public String getDATA(String Data) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(Data);
	}

	public String getPassword(String password) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(password);
	}

	public static String getProjectDirectory() {
		String projectDir = System.getProperty("user.dir")
				+ "/src/test/java/ConfigData/";
		// if (projectDir.contains("/AutomationSalesforce/"))
		// {
		// projectDir = projectDir + "src/test/java/Config/";
		// }
		// System.out.println("Using base directory as: " + projectDir);
		return projectDir;
	}

	// Added By sdei for fetching relationship type and status
	public String getRelationshipType(String Rtype) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(Rtype);
	}

	// Added By sdei for fetching relationship type and status
	public String getRelationshipStatus(String Rstatus) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			// / input = new
			// FileInputStream("/Users/jeff.radom/git/AutomationForSalesforce/AutomationforSalesforce/src/test/java/config/config.properties");
			input = new FileInputStream(getProjectDirectory()
					+ "Config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(Rstatus);
	}

	public String generaterandomupc() {
		// randomNumbers = RandomStringUtils.randomNumeric(8);
		// UPCproduct = "1111" + randomNumbers;
		return "1111" + RandomStringUtils.randomNumeric(8);
	}

	public void LightiningView(WebDriver driver) throws InterruptedException {
			  if (driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() > 0) {

			   driver.findElement(By.id("userNavLabel")).click();
			   driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"))
			     .click();
			   
			   Thread.sleep(5000);
			   driver.findElement(By.cssSelector("div[class='slds-icon-waffle']"))
			     .click();
			  } else  {
			   Thread.sleep(5000);
			   driver.findElement(By.cssSelector("div[class='slds-icon-waffle']"))
			     .click();
			  
			  }
			 }

	public void loginToPortal(String uname, String pwd, WebDriver driver)
			throws InterruptedException {
		
		String baseUrl =  "https://login.salesforce.com";
		driver.get(baseUrl);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();

	}
	public void logoutFromPortal(WebDriver driver)
	{
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
		.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.linkText("Log Out")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//// Added by Sukhwinder on 25th Oct 2016
	
	public void SendRequest() throws InterruptedException
	{
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]")).click();
		driver.findElement(By.xpath(ObjReq.lnkRequest)).click();
		Thread.sleep(5000);		
		
		//driver.findElement(By.xpath("//div[contains(@title,'New')]")).click();
		//driver.findElement(By.xpath("//a[contains(@title,'New')]")).click();
		driver.findElement(By.xpath(ObjReq.btnNew)).click();
		//driver.findElement(By.xpath("//a[contains(.,'New')]/following::div[1]")).click();
		
		/*
		WebElement frame=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		*/
				
		//List<WebElement> frame1=driver.findElements(By.tagName("iframe"));
		List<WebElement> frame1=driver.findElements(By.tagName(ObjReq.FrameTag));
		System.out.println(frame1.size());
		driver.switchTo().frame(frame1.get(1));
		Thread.sleep(5000);
		
		driver.findElement(By.id(ObjReq.txtReqName)).clear();
		driver.findElement(By.id(ObjReq.txtReqName)).sendKeys(ObjReq.Reqname);
		driver.findElement(By.id(ObjReq.drpTpName)).clear();
		driver.findElement(By.id(ObjReq.drpTpName)).sendKeys(Responder);
		driver.findElement(By.cssSelector(ObjReq.TpCssSelector)).click();

		driver.findElement(By.cssSelector(ObjReq.TpCssSelector1)).click();
		driver.findElement(By.xpath(ObjReq.TemplateName)).click();
		Thread.sleep(2000);
				
		WebElement MainDiv=driver.findElement(By.xpath(ObjReq.MainDivForForm));
		List<WebElement> SubDivs=MainDiv.findElements(By.xpath(ObjReq.InnerDivForForm));
		List<WebElement> chkFromdiv=MainDiv.findElements(By.xpath(ObjReq.chkForm));
		
		if (SubDivs.size()>0)
		{
			for(int counter=0;counter<SubDivs.size();counter++)
			{
				//System.out.println(SubDivs.get(counter).getText());
				if (SubDivs.get(counter).getText().contains(ObjForm.container_Name))
				{
					chkFromdiv.get(counter).click();
					break;
				}
			}
		}		
		
		driver.findElement(By.cssSelector(ObjReq.btnFormPopCssSelector1))
				.click();
		driver.findElement(By.xpath(ObjReq.btnOnPop)).click();
		
		Thread.sleep(4000);
		driver.findElement(By.id(ObjReq.txtDate)).click();
		WebElement tblDate=driver.findElement(By.xpath(ObjReq.tblMonth));
		
		List<WebElement> tblTds=tblDate.findElements(By.tagName(ObjReq.tblElementByTag));
		
		tblTds.get(25).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("html/body/div[5]/div/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[6]/span")).click();
		
		driver.findElement(By.id(ObjReq.txtComments)).sendKeys(ObjReq.SendReqComments);
		Thread.sleep(2000);

		driver.findElement(By.xpath(ObjReq.btnSend)).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(ObjReq.btnClose)).click();
		Thread.sleep(30000);
		driver.navigate().refresh();
		driver.findElement(By.linkText(ObjReq.Reqname)).click();
		Thread.sleep(50000);
	}
	
	public void SearchRequest(String Reqname) throws InterruptedException
	{
		driver.findElement(By.xpath(ObjReq.lnkRequest)).click();
		Thread.sleep(350000);
		//Thread.sleep(3000);
		
		WebElement txtSrc=driver.findElement(By.xpath(ObjReq.txtGlobalSrc));
		txtSrc.click();
		txtSrc.sendKeys(Reqname);
		   Thread.sleep(3000);
		   txtSrc.sendKeys(Keys.ENTER);
		   Thread.sleep(3000);   		

		WebElement rateElement = driver.findElement(By.linkText(Reqname));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
	}
	
	public void FillFormAndSubmitRequest() throws InterruptedException
	{
		Thread.sleep(4000);
		SearchRequest(ObjReq.Reqname);
		Thread.sleep(4000);
		driver.findElement(By.xpath(ObjReq.lnkRelated)).click();
		Thread.sleep(4000);
		
		driver.findElement(By.partialLinkText(ObjReq.PartialContainer)).click();
		Thread.sleep(5000);
		// Click on open form button
		//driver.findElement(By.cssSelector("[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']")).click();
		//driver.findElement(By.xpath("//span[@title='Show more actions for this record']")).click();
		//driver.findElement(By.xpath("//a[@class='menuTrigger'][@tabindex='0']")).click();
		
		List<WebElement> ar = driver.findElements(By.xpath(ObjReq.ArrowForMenu));
		
		//System.out.print(ar.size());
		
		Thread.sleep(2000);
		if(ar.size()>1)
		{
			ar.get(1).click();
		}
		else
		{
			ar.get(0).click();
		}		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(ObjReq.OpenFormOption)).click();		
		
		WebElement frame=driver.findElement(By.tagName(ObjReq.FrameTag));
		driver.switchTo().frame(frame);
		Thread.sleep(5000);	
		
		/*

		List<WebElement> RdoNo = driver.findElements(By.xpath(".//label[starts-with(@for,'No')]"));

		RdoNo.get(0).click();

		driver.findElement(By.xpath("//label[contains(.,'Signature')]/following::input[1]")).sendKeys(comment);
		*/
		
		driver.findElement(By.xpath(ObjReq.txtForRespAns)).sendKeys(ObjReq.ResponderComments);
				
		Thread.sleep(3000);
		driver.findElement(By.xpath(ObjReq.btnFormSubmit)).click();
		Thread.sleep(80000);
	}
	
	public void ApproveRequest() throws InterruptedException
	{
		driver.findElement(By.xpath(ObjReq.lnkWorkflows)).click();
				
		Thread.sleep(320000);
		//Thread.sleep(5000);
		WebElement txtSrc=driver.findElement(By.xpath(ObjReq.txtGlobalSrc));
		txtSrc.click();
		txtSrc.sendKeys(ObjReq.Reqname);
		Thread.sleep(3000);
		txtSrc.sendKeys(Keys.ENTER);
		Thread.sleep(3000); 
		
		WebElement rateElement = driver.findElement(By.linkText(ObjReq.Reqname));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(ObjReq.lnkRelated)).click();
		Thread.sleep(4000);
		 
		driver.findElement(By.partialLinkText(ObjReq.PartialReq)).click();
		Thread.sleep(4000);
		//String cssSelectorOfSameElements = "[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']";

		List<WebElement> a = driver.findElements(By.cssSelector(ObjReq.cssSelectorOfSameElements));
		//System.out.println(a.size());	
		Thread.sleep(2000);
		if(a.size()>1)
		{
			a.get(1).click();
		}
		else
		{
			a.get(0).click();
		}		
		
		Thread.sleep(6000);

		driver.findElement(By.linkText(ObjReq.lnkApprove)).click();
		Thread.sleep(2000);
	
		WebElement frame=driver.findElement(By.tagName(ObjReq.FrameTag));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(ObjReq.txtAreaForAppRej)).sendKeys(ObjReq.ApproveComments);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ObjReq.btnSaveAppRej)).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.navigate().refresh();	
		Thread.sleep(20000);
		
	}
	
	public void RejectRequest() throws InterruptedException
	{
		driver.findElement(By.xpath(ObjReq.lnkWorkflows)).click();
				
		Thread.sleep(320000);
		WebElement txtSrc=driver.findElement(By.xpath(ObjReq.txtGlobalSrc));
		txtSrc.click();
		txtSrc.sendKeys(ObjReq.Reqname);
		Thread.sleep(3000);
		txtSrc.sendKeys(Keys.ENTER);
		Thread.sleep(3000); 
		
		WebElement rateElement = driver.findElement(By.linkText(ObjReq.Reqname));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(ObjReq.lnkRelated)).click();
		Thread.sleep(4000);
		 
		driver.findElement(By.partialLinkText(ObjReq.PartialReq)).click();
		Thread.sleep(3000);
		//String cssSelectorOfSameElements = "[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']";

		//List<WebElement> a = driver.findElements(By.cssSelector(cssSelectorOfSameElements));
		//a.get(0).click();
		List<WebElement> ar = driver.findElements(By.xpath(ObjReq.ArrowForMenu));
		
		//System.out.print(ar.size());
		Thread.sleep(2000);
		if(ar.size()>1)
		{
			ar.get(1).click();
		}
		else
		{
			ar.get(0).click();
		}	
		
		Thread.sleep(6000);

		driver.findElement(By.linkText(ObjReq.lnkReject)).click();
		Thread.sleep(2000);
	
		WebElement frame=driver.findElement(By.tagName(ObjReq.FrameTag));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//textarea[@id='txt_Comment']")).sendKeys("test comment");
		driver.findElement(By.xpath(ObjReq.txtRejectComments)).sendKeys(ObjReq.RejectComments);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ObjReq.btnSubmit)).click();
		Thread.sleep(5000);
	}
	
	public WebDriver VerifyWorkFlowAndReqSts() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.navigate().refresh();	
		Thread.sleep(20000);
		
		driver.findElement(By.xpath(ObjReq.lnkRequest)).click();
		Thread.sleep(350000);
		
		WebElement txtSrc=driver.findElement(By.xpath(ObjReq.txtGlobalSrc));
		txtSrc.click();
		txtSrc.sendKeys(ObjReq.Reqname);
		   Thread.sleep(3000);
		   txtSrc.sendKeys(Keys.ENTER);
		   Thread.sleep(3000);   		

		WebElement rateElement = driver.findElement(By.linkText(ObjReq.Reqname));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		  
		Thread.sleep(4000);
		driver.findElement(By.xpath(ObjReq.lnkRelated)).click();
		Thread.sleep(4000);
		 
		driver.findElement(By.partialLinkText(ObjReq.PartialReq)).click();
		Thread.sleep(3000);
		return driver;
	}
	
	//// till here
	
	
////Added by Sukhwinder on 1st Nov 2016
	
	//Create Container
	public void CreateContaniner() throws InterruptedException
	{
		driver.findElement(By.xpath(ObjForm.lnkFormList)).click();
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		
		WebElement btnBlock = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(By.id(ObjForm.ButtonsBlock)));
		
		WebElement we3= driver.findElement(By.xpath(ObjForm.btnBtn1));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", we3);
		
		Thread.sleep(10000);
		driver.findElement(By.xpath(ObjForm.txtContainerName)).click();
		driver.findElement(By.xpath(ObjForm.txtContainerName)).sendKeys(ObjForm.container_Name);
		//driver.findElement(By.id(ObjForm.txtContainerName)).sendKeys(ObjForm.container_Name);
		
		new Select(driver.findElement(By.id(ObjForm.drpContainerConType))).selectByVisibleText("Single Form");
		new Select(driver.findElement(By.id(ObjForm.drpContainerType))).selectByVisibleText("Form");
		
		driver.findElement(By.id(ObjForm.chkFormType)).click();
	
		driver.findElement(By.id(ObjForm.btnCreateCon)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(ObjForm.btnSaveCon)).click();
		Thread.sleep(3000);
	}
	
	//Create Layout
	public void CreateLayout() throws InterruptedException
	{		
		driver.findElement(By.id(ObjForm.TabLayout)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(ObjForm.txtLayoutName)).clear();
		Thread.sleep(3000);
		driver.findElement(By.id(ObjForm.txtLayoutName)).sendKeys(ObjForm.Layout_Name);
		Thread.sleep(2000);
		
		new Select(driver.findElement(By.id(ObjForm.LayoutType))).selectByVisibleText("desktop");
		Thread.sleep(3000);
		driver.findElement(By.id(ObjForm.btnCreateLayout)).click();
		Thread.sleep(6000);
		driver.findElement(By.id(ObjForm.btnSaveLayout)).click();
		Thread.sleep(5000);
	}
	
	// Add Tab
	public void AddTab() throws InterruptedException
	{
		
		driver.findElement(By.id(ObjForm.tabTabs)).click();
		Thread.sleep(6000);
		driver.findElement(By.id(ObjForm.btnCreateTab)).click();
		Thread.sleep(6000);
		WebElement tblTabs=driver.findElement(By.xpath(ObjForm.tbllist));
		
		List<WebElement> tblRows=tblTabs.findElements(By.tagName(ObjForm.tblElement));
		
		//System.out.println(tblRows.size());
		
		List<WebElement> trTxt=tblRows.get(1).findElements(By.xpath(ObjForm.txtName));
		//System.out.println(trTxt.size());
		trTxt.get(0).sendKeys(ObjForm.Tab_Name);
		Thread.sleep(1000);
		driver.findElement(By.id(ObjForm.btnSaveTab)).click();
		Thread.sleep(6000);
		
	}
	
	public void AddSection() throws InterruptedException
	{
		driver.findElement(By.id(ObjForm.btnSelectTab)).click();
		Thread.sleep(6000);
		
		//Script for Sections template
		driver.findElement(By.id(ObjForm.tabSection)).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(ObjForm.btnAddSection)).click();
		Thread.sleep(3000);
		
		WebElement tblTabs=driver.findElement(By.xpath(ObjForm.tbllist));
		
		List<WebElement> tblRows=tblTabs.findElements(By.tagName(ObjForm.tblElement));		
		
		List<WebElement> trTxt=tblRows.get(0).findElements(By.xpath(ObjForm.txtName));
		trTxt.get(0).sendKeys(ObjForm.Section_Name);
		
		for (int counter=1;counter<=4;counter++)
		{
			driver.switchTo().activeElement().sendKeys(Keys.TAB);
			Thread.sleep(500);
		}	
		
		driver.switchTo().activeElement().sendKeys("Row");
		
		WebElement we2 = driver.findElement(By.xpath(ObjForm.btnSaveSection));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", we2);
		Thread.sleep(6000);
		driver.findElement(By.xpath(ObjForm.btnSelectSection)).click();
		Thread.sleep(6000);
		
	}
	
	public void AddLinkedQuestion() throws InterruptedException
	{
		// Script for Linked in Questions
		driver.findElement(By.id(ObjForm.tabQst)).click();
		Thread.sleep(3000);	
		
		driver.findElement(By.id(ObjForm.txtQstName)).sendKeys(ObjForm.QuestionName);
		Thread.sleep(500);
		driver.findElement(By.xpath(ObjForm.txtAreaAns)).sendKeys(ObjForm.AnswerName);
		
		WebElement we1 = driver.findElement(By.id(ObjForm.btnAddQst));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", we1);
		Thread.sleep(6000);
		driver.findElement(By.id(ObjForm.btnSaveAll)).click();
		Thread.sleep(6000);
		driver.findElement(By.id(ObjForm.btnPublish)).click();
		Thread.sleep(6000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	public void InitilizeBrowser()
	  {  
	  String baseUrl = "https://login.salesforce.com";
	   //driver = new FirefoxDriver();
	   //System.setProperty("webdriver.chrome.driver", "/Users/gurpinder.singh/Downloads/chromedriver");
	   ChromeDriverManager.getInstance().setup();
	   driver = new ChromeDriver();  
	   driver.manage().window().maximize();
	   
	   driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	   driver.navigate().to(baseUrl);
	   //return driver1;
	   
	  }
	
	public void loginToSalesForce(String uname, String pwd) throws InterruptedException {
		
		String baseUrl =  "https://login.salesforce.com";
		driver.get(baseUrl);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);

	}
	
	public void SalesForceLightiningView() throws InterruptedException {
		
		System.out.println(driver);
		  if (driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() > 0) {

		   driver.findElement(By.id("userNavLabel")).click();
		   driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"))
		     .click();
		   
		   Thread.sleep(5000);
		   driver.findElement(By.cssSelector("div[class='slds-icon-waffle']"))
		     .click();
		  } else  {
		   Thread.sleep(5000);
		   driver.findElement(By.cssSelector("div[class='slds-icon-waffle']"))
		     .click();
		  
		  }
		  
		  Thread.sleep(5000);
		 }
	
	public void logoutSalesForce()
	{
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
		.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.linkText("Log Out")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
