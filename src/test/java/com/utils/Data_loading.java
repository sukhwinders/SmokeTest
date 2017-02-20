
package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ModuleLocatorRepository.RequestRepo;
import ModuleLocatorRepository.TPGroupCompRepo;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import ModuleLocatorRepository.*;

public class Data_loading {
	public Date d;
	// for formlist default values to create simple form
	boolean BPform = true; // Best practice form or not?
	int NoOfTabs = 1; // No of Tabs
	int NoOfSections = 1; // No of sections in each tab

	String SecDisplayStyle[]={};//Display style of the Sections Card/Table--------SC

	boolean generateServiceSection = false; // generate Service Section
	int NoOfQuestions = 1; // No of Questions in each Section
	int NoOfLinkedQuest = 0; // No of Linked Questions
	int NoOfReqQuest = 0; // No of Mandatory fields Questions in Total questions 
	int NoOfReadOnlyQuest = 0; // No of Read Only Questions in Total questions 
	String ansType[] = {"text"}; // for different answer type, available types text,checkbox, date, datetime,multi-picklist, number,picklist,long text,upload,search,multi-search,radio,email address
	String picklistVal;  // If answer type is picklist then set values available types boolean,chemicals,countries,currencies,ingredients,microbiological,months
	String MultiPickVal; // If answer type is multi-picklist then set values available types boolean,chemicals,countries,currencies,ingredients,microbiological,months
	String NamenValue[][] = {{}, // add picklist or multi-picklist options -- add name here
			{}}; // // add picklist  or multi-picklist options -- add Value here
	String defaultVal; // Select default value for picklist and multi-picklist
	String dependencyValue ;  // Select dependency value , It should be in NamenValue list
	String newFeature; // it's created for feature purpose, now leave it. 

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
	public static  WebDriver driver;
	@SuppressWarnings("unused")
	//private WebDriver driver;

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
//Edit Sc
	public void LightiningView() throws InterruptedException {
		checkModulesReady(1000);
		if (driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() > 0) {

			driver.findElement(By.id("userNavLabel")).click();
			driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"))
			.click();

			Thread.sleep(5000);
			//waitFor(driver, 5000);
			driver.findElement(By.cssSelector("div[class='slds-icon-waffle']"))
			.click();
		} else  {
			Thread.sleep(5000);
			//waitFor(driver, 5000);

			driver.findElement(By.cssSelector("div[class='slds-icon-waffle']"))
			.click();

		}
	}
	public void SalesForceLightiningView(WebDriver driver) throws InterruptedException {
		 
		  
		  if (driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() > 0) {

		   driver.findElement(By.id("userNavLabel")).click();
		   driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"))
		   .click();

		   Thread.sleep(5000);
		   //waitFor(driver, 5000);

		   driver.findElement(By.cssSelector("div[@class='slds-icon-waffle']"))
		   .click();
		  } else  {
		   Thread.sleep(5000);
		   //waitFor(driver, 5000);

		      Thread.sleep(5000);
		         driver.findElement(By.xpath("//div[@class='slds-icon-waffle_container']")).click();
		         
		  }

		  Thread.sleep(5000);
		  //waitFor(driver, 5000);

		 }
	public void loginToPortal(String uname, String pwd, WebDriver driver)
			throws InterruptedException {

		String baseUrl =  "https://login.salesforce.com";
		//driver.get(baseUrl);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();

	}
	//Edit Sc
	public void logoutFromPortal() 
	{
		//waitFor(driver, 200);
		checkModulesReady(2000);
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
		.click();
		//waitFor(driver, 4000);
		driver.findElement(By.linkText("Log Out")).click();
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
		List<WebElement> frame1=driver.findElements(By.tagName(ObjReq.FrameTag));
		System.out.println(frame1.size());
		
		driver.switchTo().frame(1);
		
		//List<WebElement> frame1=driver.findElements(By.tagName("iframe"));
		/*List<WebElement> frame1=driver.findElements(By.tagName(ObjReq.FrameTag));
		System.out.println(frame1.size());
		int i=frame1.size();//Loop is Here
		if(i==1){
		driver.switchTo().frame(frame1.get(i));
		Thread.sleep(5000);
		}
		else{
			driver.switchTo().frame(0);
			Thread.sleep(5000);
		}*/

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
		SalesForceLightiningView();
		driver.findElement(By.xpath(ObjReq.lnkRequest)).click();
		//Thread.sleep(350000);
		Thread.sleep(3000);

		WebElement txtSrc=driver.findElement(By.xpath(ObjReq.txtGlobalSrc));
		txtSrc.click();
		txtSrc.sendKeys(Reqname);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'Requests')]")).click();
		Thread.sleep(3000);  
		//txtSrc.sendKeys(Keys.ENTER);
		//Thread.sleep(3000);   		

		WebElement rateElement = driver.findElement(By.linkText(Reqname));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
	}

	public void FillFormAndSubmitRequest() throws InterruptedException
	 {
	  Thread.sleep(4000);
	  //SearchRequest(ObjReq.Reqname);
	  SearchRequest("AutoTestFri Feb 10 12:28:03 IST 2017");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(ObjReq.lnkRelated)).click();
	  Thread.sleep(4000);
	 // driver.findElement(By.xpath(ObjReq.lnkDetails)).click();
	 // Thread.sleep(4000);

	  driver.findElement(By.partialLinkText(ObjReq.PartialContainer)).click();
	  Thread.sleep(5000);
	  // Click on open form button
	  //driver.findElement(By.cssSelector("[class='forceIconDeprecated forceIcon'][title='Show more actions for this record']")).click();
	  //driver.findElement(By.xpath("//span[@title='Show more actions for this record']")).click();
	  //driver.findElement(By.xpath("//a[@class='menuTrigger'][@tabindex='0']")).click();
	  //driver.findElement(By.xpath(ObjReq.ArrowForMenu)).click();
	  List<WebElement> ar = driver.findElements(By.xpath(ObjReq.ArrowForMenu));
	 
	  //System.out.print(ar.size());

	  Thread.sleep(3000);
	  if(ar.size()>0)
	  {
	   ar.get(0).click();
	  }
	  else
	  {
	   ar.get(0).click();
	  } 
	  Thread.sleep(3000);
	  driver.findElement(By.cssSelector(ObjReq.OpenFormOption)).click();
	  Thread.sleep(5000); 
	  driver.navigate().refresh();
	  Thread.sleep(5000); 
	  

	  WebElement frame=driver.findElement(By.tagName(ObjReq.FrameTag));
	  driver.switchTo().frame(frame);
	 // driver.findElement(By.id("id=a0n1500000FTBMJAA5"));
	 	  
	  Thread.sleep(4000); 

	  /*

	  List<WebElement> RdoNo = driver.findElements(By.xpath(".//label[starts-with(@for,'No')]"));

	  RdoNo.get(0).click();

	  driver.findElement(By.xpath("//label[contains(.,'Signature')]/following::input[1]")).sendKeys(comment);
	   */
	 
	 	driver.findElement(By.xpath(ObjReq.txtForRespAns)).sendKeys(ObjReq.ResponderComments);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(ObjReq.btnFormClose)).click();
	  driver.findElement(By.xpath(ObjReq.btnYes)).click();
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
	public void CreateContaniner(boolean BPform) throws InterruptedException
	{
		SalesForceLightiningView();
		driver.findElement(By.xpath(ObjForm.lnkFormList)).click();
		Thread.sleep(10000);
		driver.switchTo().frame(0);

		WebElement btnBlock = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.id(ObjForm.ButtonsBlock)));

		do
		{
			//WebElement we3= driver.findElement(By.xpath(ObjForm.btnBtn1));
			//WebElement we3= driver.findElement(By.id(ObjForm.btnBtn1));
			//((JavascriptExecutor)driver).executeScript("arguments[0].click();", we3);
			Thread.sleep(8000);
		}
		while(driver.findElements(By.id(ObjForm.btnBtn2)).size()>0);

		//Thread.sleep(10000);

		driver.findElement(By.xpath(ObjForm.txtContainerName)).click();
		driver.findElement(By.xpath(ObjForm.txtContainerName)).sendKeys(ObjForm.container_Name);
		//driver.findElement(By.id(ObjForm.txtContainerName)).sendKeys(ObjForm.container_Name);

		new Select(driver.findElement(By.id(ObjForm.drpContainerConType))).selectByVisibleText("Single Form");
		new Select(driver.findElement(By.id(ObjForm.drpContainerType))).selectByVisibleText("Form");

		if(BPform==true){
			driver.findElement(By.id(ObjForm.chkFormType)).click();
		}
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


	public void createNewForm(boolean BPform, int NoOfTabs, int NoOfSections, boolean generateServiceSection, 
			int NoOfQuestions, int NoOfLinkedQuest, int NoOfReqQuest, int NoOfReadOnlyQuest, String ansType[], 
			String picklistVal, String MultiPickVal,String NamenValue[][],
			String defaultVal, String dependencyValue, String newFeature) throws InterruptedException {	
		d = new Date(System.currentTimeMillis());
		// Create container
		SalesForceLightiningView();
		Thread.sleep(500);
		FindElement("xpath", ObjForm.lnkFormList).click();
		//driver.findElement(By.xpath(ObjForm.lnkFormList)).click();
		Thread.sleep(5000);
		List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		//System.out.println(frames.size());
		//driver.switchTo().frame(0);
		
		  if(frames.size()==3){
			     driver.switchTo().frame(frames.get(2));
			    }
			    else if(frames.size()==2){
			     driver.switchTo().frame(frames.get(1));
			    }
			    else{
			     driver.switchTo().frame(frames.get(0));
			    }

		WebElement btnBlock = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.elementToBeClickable(By.id(ObjForm.ButtonsBlock)));

		/*do
		{
			WebElement we3= driver.findElement(By.xpath(ObjForm.btnBtn2));
			//WebElement we3= driver.findElement(By.id("buttonsBlock"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", we3);
			Thread.sleep(8000);
		}
		while(driver.findElements(By.id(ObjForm.btnBtn2)).size()>0);*/
		/*
		do{
			WebElement we3= driver.findElement(By.xpath(ObjForm.btnNewForm));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", we3);
		}
		while(driver.findElements(By.xpath(ObjForm.btnNewForm)).size()>0);
		*/
		
		do{
			   //WebElement we3= driver.findElement(By.xpath(ObjForm.btnNewForm));
			   //((JavascriptExecutor)driver).executeScript("arguments[0].click();", we3);
			   WebElement we3= driver.findElement(By.xpath("//form/div[3]/input[1]"));
			   ((JavascriptExecutor)driver).executeScript("arguments[0].click();", we3);
			  }
			  while(driver.findElements(By.xpath(ObjForm.btnNewForm)).size()>0);

		Thread.sleep(5000);//Needed for Container--SC
		

		driver.findElement(By.xpath(ObjForm.txtContainerName)).click();
		driver.findElement(By.xpath(ObjForm.txtContainerName)).sendKeys(ObjForm.container_Name+d);
		//driver.findElement(By.id(ObjForm.txtContainerName)).sendKeys(ObjForm.container_Name);
		new Select(driver.findElement(By.id(ObjForm.drpContainerConType))).selectByVisibleText("Single Form");
		new Select(driver.findElement(By.id(ObjForm.drpContainerType))).selectByVisibleText("Form");

		if(BPform==true){
			driver.findElement(By.id(ObjForm.chkFormType)).click();
		}
		driver.findElement(By.id(ObjForm.btnCreateCon)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(ObjForm.btnSaveCon)).click();
		Thread.sleep(5000); //SC Edited From 3 to 5

		// Create Layout 
		driver.findElement(By.id(ObjForm.TabLayout)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(ObjForm.txtLayoutName)).clear();
		Thread.sleep(3000);
		driver.findElement(By.id(ObjForm.txtLayoutName)).sendKeys(ObjForm.Layout_Name+d);
		Thread.sleep(2000);

		new Select(driver.findElement(By.id(ObjForm.LayoutType))).selectByVisibleText("desktop");
		Thread.sleep(3000);
		driver.findElement(By.id(ObjForm.btnCreateLayout)).click();
		Thread.sleep(6000);
		driver.findElement(By.id(ObjForm.btnSaveLayout)).click();
		Thread.sleep(5000);
		// Add Tab
		for(int t=1; t<=NoOfTabs; t++){
			int tabId=t-1;
			driver.findElement(By.id(ObjForm.tabTabs)).click();
			Thread.sleep(6000);
			driver.findElement(By.id(ObjForm.btnCreateTab)).click();
			Thread.sleep(6000);
			driver.findElement(By.id("j_id0:form:tabBlock:tabSection:tabTable:"+tabId+":j_id47")).sendKeys("QA Test Tab"+t);
			Thread.sleep(1000);
			driver.findElement(By.id(ObjForm.btnSaveTab)).click();
			Thread.sleep(6000);
			driver.findElement(By.id("j_id0:form:tabBlock:tabSection:tabTable:"+tabId+":selectTab")).click();

			// Add sections
			for(int s=1; s<=NoOfSections; s++){	
				int sectionId=s-1;
				//driver.findElement(By.id(ObjForm.btnSelectTab)).click();
				Thread.sleep(6000);
				//Script for Sections template
				driver.findElement(By.id(ObjForm.tabSection)).click();
				Thread.sleep(5000);
				if(generateServiceSection== true){
					driver.findElement(By.id(ObjForm.btnGenerateServiceSection)).click();
					Thread.sleep(6000);
				}
				else{	
					driver.findElement(By.xpath(ObjForm.btnAddSection)).click();
					Thread.sleep(4000); //Edited from 3k to 4K
					driver.findElement(By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"+sectionId+":j_id74")).sendKeys("QA Test Section"+s);
					//id="j_id0:form:sectionBlock:sectionSection:sectionTable:1:j_id74"

					//Below Line Added By SC
					Thread.sleep(3000);


					for (int counter=1;counter<=4;counter++)
					{
						driver.switchTo().activeElement().sendKeys(Keys.TAB);
						Thread.sleep(500);
					}	
					WebElement element=driver.findElement(By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"+sectionId+":j_id89"));
					element.sendKeys("Table");
					/*final ArrayList<String> listDispStyle=new ArrayList<String>();

					for (int i=0;i<=element.size();i++){
						String lstval=SecDisplayStyle.toString();

						if ()
					Select selectvalue=new Select(element);
					selectvalue.selectByVisibleText(SecDisplayStyle.toString());
					}*/
					//	driver.switchTo().activeElement().sendKeys(SecDisplayStyle);//added by SC

					WebElement we2 = driver.findElement(By.xpath(ObjForm.btnSaveSection));
					((JavascriptExecutor)driver).executeScript("arguments[0].click();", we2);
					Thread.sleep(6030);
					driver.findElement(By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:"+sectionId+":selectSection']")).click();
					Thread.sleep(6000);

					// Script for Questions

					driver.findElement(By.id(ObjForm.tabQst)).click();
					Thread.sleep(3000);	

					for(int q=1; q<=NoOfQuestions ; q++){
						boolean flag1 = true;
						boolean flag2 = true;
						int linkedid = q-1;
						driver.findElement(By.id(ObjForm.txtQstName)).sendKeys("QA"+q+d);
						Thread.sleep(500);
						driver.findElement(By.xpath(ObjForm.txtAreaAns)).sendKeys("QA Test Question"+q+d);
						// for Required questions
						if(q<=NoOfReqQuest){
							driver.findElement(By.id(ObjForm.reqQuestion)).click();
						}
						// for Read only Questions
						if(q>NoOfReqQuest && q<=NoOfReadOnlyQuest+NoOfReqQuest) {
							driver.findElement(By.id(ObjForm.readOnlyQuest)).click();
						}
						// for linked questions
						if(q % 2 == 0 && q<=(NoOfLinkedQuest*2)){
							driver.findElement(By.id(ObjForm.linkedLookup)).click();
							Thread.sleep(5000);
							String parentWindowHandler = driver.getWindowHandle();
							for (String handle : driver.getWindowHandles()) {
								driver.switchTo().window(handle);
							}
							driver.switchTo().frame(0);
							driver.findElement(By.id("lksrch")).sendKeys("QA"+linkedid+d);
							Thread.sleep(5000);
							driver.findElement(By.name("go")).click();
							Thread.sleep(5000);
							driver.switchTo().defaultContent();
							driver.switchTo().frame(1);
							driver.findElement(By.linkText("QA"+linkedid+d)).click();
							Thread.sleep(1000);
							driver.switchTo().window(parentWindowHandler);
							driver.switchTo().frame(0);
						}
						// for pick list and multi picklist questions
						if( NoOfQuestions== ansType.length){
							new Select(driver.findElement(By.id(ObjForm.answerType))).selectByVisibleText(ansType[q-1]);
							if(ansType[q-1].contains("picklist") && picklistVal!=null){
								new Select(driver.findElement(By.id(ObjForm.optionListName))).selectByVisibleText(picklistVal);
							}
							if(ansType[q-1].contains("multi-picklist")&& MultiPickVal!=null){
								new Select(driver.findElement(By.id(ObjForm.optionListName))).selectByVisibleText(MultiPickVal);
							}
						}
						else{
							new Select(driver.findElement(By.id(ObjForm.answerType))).selectByVisibleText(ansType[0]);
							if(ansType[0].contains("picklist") && picklistVal!=null){
								new Select(driver.findElement(By.id(ObjForm.optionListName))).selectByVisibleText(picklistVal);
							}
							if(ansType[0].contains("multi-picklist")&& MultiPickVal!=null){
								new Select(driver.findElement(By.id(ObjForm.optionListName))).selectByVisibleText(MultiPickVal);
							}
						}
						// for Dependency value
						if(dependencyValue!=null&& q % 2 == 0){

							if(flag1){
								flag1 = false;
								driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:targetId:theImage")).click();
								Thread.sleep(5000);
								String parentWindowHandler = driver.getWindowHandle();
								for (String handle : driver.getWindowHandles()) {
									driver.switchTo().window(handle);
								}

								driver.findElement(By.id("j_id0:form:block:section:query")).sendKeys("QA"+linkedid+d);
								driver.findElement(By.cssSelector("input.btn[Value='Go']")).click();
								Thread.sleep(5000);
								driver.findElement(By.id("j_id0:form:j_id7:j_id8:j_id9:0:j_id10")).click();

								driver.switchTo().window(parentWindowHandler);
								driver.switchTo().frame(0);
								Thread.sleep(3000);
								new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionDependencyAction"))).selectByVisibleText("Show");
								// add Question button

							}

						}
						// add Question button
						WebElement we1 = driver.findElement(By.id(ObjForm.btnAddQst));
						((JavascriptExecutor)driver).executeScript("arguments[0].click();", we1);

						if(dependencyValue!=null&& q % 2 == 0){
							if(flag2){
								flag2 = false;
								WebElement weSelect =driver.findElement(By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:"+(q-1)+":selectElement"));
								((JavascriptExecutor)driver).executeScript("arguments[0].click();", weSelect);
								Thread.sleep(6000);
								driver.findElement(By.id(ObjForm.txtQstName)).click();
								for (int counter=1;counter<=6;counter++)
								{
									driver.switchTo().activeElement().sendKeys(Keys.TAB);
									Thread.sleep(500);
								}	

								driver.switchTo().activeElement().sendKeys(dependencyValue);
								//Select drpValue=new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:j_id188")));
								//drpValue.selectByValue(dependencyValue);
								// new Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:j_id188"))).selectByVisibleText(dependencyValue);
								driver.findElement(By.id("j_id0:form:newElementWithQuestion:editNewLinkedQuestion")).click();
								Thread.sleep(5000);
								driver.findElement(By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion")).click();
								Thread.sleep(3000);
							}
						}
						Thread.sleep(6000);
						// add picklist or multi picklist values 
						if(NamenValue!=null && NoOfQuestions== ansType.length && (ansType[q-1].contains("picklist") || ansType[q-1].contains("multi-picklist"))){
							WebElement weSelect =driver.findElement(By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:"+(q-1)+":selectElement"));
							((JavascriptExecutor)driver).executeScript("arguments[0].click();", weSelect);
							Thread.sleep(5000);
							for(int c=0; c<NamenValue.length;){
								for(int j=0; j<NamenValue[c].length; j++){
									driver.findElement(By.id("j_id0:form:answerOptionBlock:createAnswerOption")).click();
									Thread.sleep(3000);
									driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+j+":j_id167")).sendKeys(NamenValue[c][j]);
									driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"+j+":j_id171")).sendKeys(NamenValue[c+1][j]);
									// Select default value check box	
									if(defaultVal!=null && defaultVal.equals(NamenValue[c+1][j])){
										Actions act = new Actions(driver);
										act.moveToElement(
												driver.findElement(By.id("j_id0_form_answerOptionBlock_answerOptionSection_answerOptionTable_"+j+"_j_id176_chkbox")))
										.doubleClick().build().perform();
										driver.findElement(
												By.id("j_id0_form_answerOptionBlock_answerOptionSection_answerOptionTable_"+j+"_j_id176"))
										.click();
										driver.findElement(By.id("j_id0:form:answerOptionBlock:answerOptionSection"))
										.click();
									}
								}
								WebElement weSave = driver.findElement(By.id(ObjForm.btnSaveAll));
								((JavascriptExecutor)driver).executeScript("arguments[0].click();", weSave);
								Thread.sleep(5000);
								driver.findElement(By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion")).click();
								Thread.sleep(5000);
								break;
							}
						}


					}

				}
			}
		}
		WebElement we2 = driver.findElement(By.id(ObjForm.btnSaveAll));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", we2);
		Thread.sleep(6000);
		WebElement wePublish = driver.findElement(By.id(ObjForm.btnPublish));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",wePublish);
		Thread.sleep(6000);	
		driver.switchTo().defaultContent();
		Thread.sleep(2000);	
	}

	public void createNewForm() throws InterruptedException{
		//CreateContaniner(BPform);//Added By SC
		//CreateLayout();//Added By SC
		createNewForm(BPform, NoOfTabs, NoOfSections, generateServiceSection, NoOfQuestions, 
				NoOfLinkedQuest, NoOfReqQuest, NoOfReadOnlyQuest, ansType, picklistVal,MultiPickVal,
				NamenValue,defaultVal,dependencyValue, newFeature);
	}

	public void InitilizeBrowser()
	{  
		String baseUrl = "https://login.salesforce.com";
		//driver = new FirefoxDriver();
		// System.setProperty("webdriver.chrome.driver", "D:\\Sujeet\\FinalDevIds\\FinalDevIds\\chromedriver.exe");
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();  
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
		//return driver1;

	}

	//
	public void loginToSalesForce(String uname, String pwd) throws InterruptedException {

		String baseUrl =  "https://login.salesforce.com";
		driver.get(baseUrl);
		//waitFor(driver,300);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		//waitFor(driver,3000);

	}

	//Module Ready  check Edit SC
	public void SalesForceLightiningView() throws InterruptedException {
		/*checkModulesReady(1000);*/
		System.out.println(driver);
		if (driver.findElements(By.xpath("//span[@id='userNavLabel']")).size() > 0) {

			driver.findElement(By.id("userNavLabel")).click();
			driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"))
			.click();

			Thread.sleep(5000);
			//waitFor(driver, 5000);

			driver.findElement(By.cssSelector("div[class='slds-icon-waffle']"))
			.click();
		} else  {
			Thread.sleep(5000);
			//waitFor(driver, 5000);

			driver.findElement(By.xpath("//div[@class='slds-icon-waffle_container']")).click();
		}

		Thread.sleep(5000);
		//waitFor(driver, 5000);

	}

	//Edit Sc
	public void logoutSalesForce()
	{
		checkModulesReady(1000);
		driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]"))
		.click();
			// Thread.sleep(2000);
			//waitFor(driver, 2000);

		
		driver.findElement(By.linkText("Log Out")).click();
		
			//waitFor(driver, 5000);

		}
	public void createTPG(String tpgName, String tpgTags[], String tpgStatus[],String tpgType[]) throws InterruptedException {
		  //LightiningView();
		  SalesForceLightiningView();
		  WebElement tpgWE = driver.findElement(By.xpath(TPGroupCompRepo.tpgTab));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",tpgWE);
		  Thread.sleep(3000);
		  //waitFor(driver, 3000);

		  driver.findElement(By.cssSelector(TPGroupCompRepo.tpgNewBtn)).click(); 
		  Thread.sleep(5000);
		  //driver.switchTo().frame(1);
		  /*
		  List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		  if(frames.size()>1){
		   driver.switchTo().frame(frames.get(1));
		  }
		  else{
		   driver.switchTo().frame(frames.get(0));
		  }*/
		  
		  List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		    if(frames.size()==3){
		     driver.switchTo().frame(frames.get(2));
		    }
		    else if(frames.size()==2){
		     driver.switchTo().frame(frames.get(1));
		    }
		    else{
		     driver.switchTo().frame(frames.get(0));
		    }
		  
		  
		  driver.findElement(By.id(TPGroupCompRepo.tpgName)).sendKeys(tpgName);
		  Thread.sleep(4000); // SC edited from 3 to 4 
		  for(int t=0; t<tpgTags.length; t++){
		   driver.findElement(By.xpath("//span[contains(.,'"+tpgTags[t]+"')]")).click();
		   Thread.sleep(1000);
		  }
		  if(tpgStatus.length>0){
		   driver.findElement(By.xpath(TPGroupCompRepo.statusTab)).click();
		   Thread.sleep(4000);
		   for(int s=0; s<tpgStatus.length; s++){  
		    driver.findElement(By.xpath("//span[contains(.,'"+tpgStatus[s]+"')]")).click();
		    Thread.sleep(1000);  
		   }
		   driver.findElement(By.xpath(TPGroupCompRepo.moveIconRight)).click();
		  }
		  if(tpgType.length>0){
		   driver.findElement(By.xpath(TPGroupCompRepo.typeTab)).click();
		   Thread.sleep(5000);
		   for(int t=0; t<tpgType.length; t++){
		    driver.findElement(By.xpath("//span[contains(.,'"+tpgType[t]+"')]")).click();
		    Thread.sleep(1000);
		   }
		   List<WebElement> ar=driver.findElements(By.xpath(TPGroupCompRepo.moveIconRight));
		   //It is finding 2 elements of same ID
		   //driver.findElement(By.id("icnMoveRight")).click();
		   //clicking the 2nd one
		   ar.get(1).click();
		   Thread.sleep(1000);
		  }

		  driver.findElement(By.xpath(TPGroupCompRepo.tpgSave)).click();
		  /*
		  Thread.sleep(3000);
		  String msg = driver.findElement(By.xpath(TPGroupCompRepo.successMsg)).getText();
			Assert.assertTrue(msg.contains("Trading partner group has been created successfully"));
			Thread.sleep(1000);
			driver.findElement(By
					.cssSelector(TPGroupCompRepo.tpgPopupClose))
					.click();
					
					*/
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			
			
			
			//WebElement rateElement = driver.findElement(By.partialLinkText("VerifySendRequirementMon Feb 13 18:16:18 IST 2017"));
			WebElement rateElement = driver.findElement(By.partialLinkText(tpgName));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		}

		 

	public void createTPGN(String tpgName, String tpgTags[], String tpgStatus[],String tpgType[]) throws InterruptedException {
		  //LightiningView();
		  SalesForceLightiningView();
		  WebElement tpgWE = driver.findElement(By.xpath(TPGroupCompRepo.tpgTab));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",tpgWE);
		  Thread.sleep(4000);
		  //waitFor(driver, 3000);

		  driver.findElement(By.cssSelector(TPGroupCompRepo.tpgNewBtn)).click(); 
		  Thread.sleep(5000);
		  driver.switchTo().frame(1);
		/*  
		  List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		  if(frames.size()>1){
		   driver.switchTo().frame(frames.get(1));
		  }
		  else{
		   driver.switchTo().frame(frames.get(0));
		  }*/
		  Thread.sleep(5000);
		  driver.findElement(By.id(TPGroupCompRepo.tpgName)).sendKeys(tpgName);
		  Thread.sleep(4000); // SC edited from 3 to 4 
		  for(int t=0; t<tpgTags.length; t++){
		   driver.findElement(By.xpath("//span[contains(.,'"+tpgTags[t]+"')]")).click();
		   Thread.sleep(1000);
		  }
		  if(tpgStatus.length>0){
		   driver.findElement(By.xpath(TPGroupCompRepo.statusTab)).click();
		   Thread.sleep(3000);
		   for(int s=0; s<tpgStatus.length; s++){  
		    driver.findElement(By.xpath("//span[contains(.,'"+tpgStatus[s]+"')]")).click();
		    Thread.sleep(3000);  
		   }
		   driver.findElement(By.xpath(TPGroupCompRepo.moveIconRight)).click();
		  }
		  if(tpgType.length>0){
		   driver.findElement(By.xpath(TPGroupCompRepo.typeTab)).click();
		   Thread.sleep(5000);
		   for(int t=0; t<tpgType.length; t++){
		    driver.findElement(By.xpath("//span[contains(.,'"+tpgType[t]+"')]")).click();
		    Thread.sleep(1000);
		   }
		   List<WebElement> ar=driver.findElements(By.xpath(TPGroupCompRepo.moveIconRight));
		   //It is finding 2 elements of same ID
		   //driver.findElement(By.id("icnMoveRight")).click();
		   //clicking the 2nd one
		   ar.get(1).click();
		   Thread.sleep(1000);
		  }

		  driver.findElement(By.xpath(TPGroupCompRepo.tpgSave)).click();
		  Thread.sleep(3000);
		  String msg = driver.findElement(By.xpath(TPGroupCompRepo.successMsg)).getText();
		  Assert.assertTrue(msg.contains("Trading partner group has been created successfully"));
		  Thread.sleep(1000);
		  driver.findElement(By
		    .cssSelector(TPGroupCompRepo.tpgPopupClose))
		  .click();
		  driver.switchTo().defaultContent();
		  Thread.sleep(3000);
		  WebElement rateElement = driver.findElement(By.partialLinkText(tpgName));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		 }
	
	public void editTPG(String editTags[]) throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath(TPGroupCompRepo.editTPG)).click();
		Thread.sleep(5000);
		List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		if(frames.size()>1){
			driver.switchTo().frame(frames.get(1));
		}
		else{
			driver.switchTo().frame(frames.get(0));
		}
		Thread.sleep(3000);
		for(int t=0; t<editTags.length; t++){
			driver.findElement(By.xpath("//span[contains(.,'"+editTags[t]+"')]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(TPGroupCompRepo.tpgSave)).click();
		Thread.sleep(3000);
	/*	String updateMsg = driver.findElement(By.xpath(TPGroupCompRepo.successMsg)).getText();
		//Assert.assertTrue(updateMsg.contains("Trading partner group has been updated successfully"));
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(TPGroupCompRepo.tpgPopupClose)).click();*/
		driver.switchTo().defaultContent();
	 
		Thread.sleep(10000);
	}
	
	
	/*public void editTPG(String editTags[]) throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath(TPGroupCompRepo.editTPG)).click();
		Thread.sleep(5000);
		List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		if(frames.size()>1){
			driver.switchTo().frame(frames.get(1));
		}
		else{
			driver.switchTo().frame(frames.get(0));
		}
		Thread.sleep(3000);
		for(int t=0; t<editTags.length; t++){
			driver.findElement(By.xpath("//span[contains(.,'"+editTags[t]+"')]")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(TPGroupCompRepo.tpgSave)).click();
		Thread.sleep(3000);
		String updateMsg = driver.findElement(By.xpath(TPGroupCompRepo.successMsg)).getText();
		//Assert.assertTrue(updateMsg.contains("Trading partner group has been updated successfully"));
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(TPGroupCompRepo.tpgPopupClose)).click();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
	}*/
	// Set Requirements then save	//Modules Ready Check
	public void SetRequirement(String requestType[], String formNames[],String saveOrSend) throws InterruptedException {

		driver.navigate().refresh();
		 Thread.sleep(10000);

			if(driver.findElements(By.xpath(TPGroupCompRepo.showMoreActionsIcon)).size()>0)
			{
				driver.findElement(By.xpath(TPGroupCompRepo.showMoreActionsIcon)).click();
				Thread.sleep(3000);
			}
			//waitFor(driver, 1000);
			 Thread.sleep(3000);
			driver.findElement(By.xpath(TPGroupCompRepo.setReqBtn)).click();
			Thread.sleep(3000);
			/*driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			Thread.sleep(4000);*/
			List<WebElement> NewRequestFrame=driver.findElements(By.tagName("iframe"));
			System.out.println(NewRequestFrame.size());

			//driver.switchTo().frame(0);
			 List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
			    if(frames.size()==3){
			     driver.switchTo().frame(frames.get(2));
			    }
			    else if(frames.size()==2){
			     driver.switchTo().frame(frames.get(1));
			    }
			    else{
			     driver.switchTo().frame(frames.get(0));
			    }
			
			
			Thread.sleep(4000);
			//driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();

			
			//new Select(driver.findElement(By.id("RequestType0"))).selectByVisibleText("All");
		
			for(int r=1; r<=formNames.length; r++){
				int id=r-1;
				int reqid=r+1;
				if(requestType.length==formNames.length){
					//new Select(driver.findElement(By.id("RequestType"+id+""))).selectByVisibleText(requestType[id]);
					new Select(driver.findElement(By.xpath("//select[contains(@name,'RequestType0')]"))).selectByVisibleText(requestType[id]);
							//select[contains(@name,'RequestType0')]
					
				}
				else{
					new Select(driver.findElement(By.id("RequestType"+id+""))).selectByVisibleText("All");
				}
				Thread.sleep(3000);
				new Select(driver.findElement(By.id("DocType"+id+""))).selectByVisibleText(formNames[id]);
				Thread.sleep(6000);
				
				
				/*
				Actions action = new Actions(driver);
				WebElement we1 = driver.findElement(By.xpath("html/body/form/div["+r+"]/div[4]/section/div/div/slds-datepicker/div/div[1]/div/input"));
				action.moveToElement(we1).moveToElement(driver.findElement(By.xpath("html/body/form/div["+r+"]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[3]/span"))).click().build().perform();
				
				*/
				
				driver.findElement(By.id("0")).click();
				String TblDueDate="//table[@class='datepicker__month']";
				WebElement tblDate=driver.findElement(By.xpath(TblDueDate));
				driver.findElement(By.xpath("//button[@title='Next Month']")).click();
				Thread.sleep(500);
				List<WebElement> tblTds=tblDate.findElements(By.tagName("td"));
				tblTds.get(20).click();
				Thread.sleep(2000);			
			

				Thread.sleep(3000);
				new Select(driver.findElement(By.id("RequirementType"+id+""))).selectByVisibleText("Approval");
				if(r<formNames.length){
					// add new requirement
					driver.findElement(By.xpath("html/body/form/div["+reqid+"]/div[2]/button")).click();
					Thread.sleep(5000);
				}
			}
			driver.findElement(By.id(saveOrSend)).click();
			Thread.sleep(15000);
			/*if(saveOrSend.equals("btnSave")){
			String saveMsg = driver.findElement(By.xpath(TPGroupCompRepo.reqSaveUpdateMsg)).getText();
			Assert.assertTrue(saveMsg.contains("Requirements updated successfully"));
			Thread.sleep(1000);
			}
			if(saveOrSend.equals("btnSend")){
				String sendMsg = driver.findElement(By.cssSelector(TPGroupCompRepo.reqSendMsg)).getText();
				Assert.assertTrue(sendMsg.contains("Request is sent for the following Requirements and Members of the Group"));
			}*/
			driver.findElement(By.cssSelector(TPGroupCompRepo.tpgPopupClose)).click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
		}
	
	public void assertAndDeleteReqs(int assertReqsSize, boolean removeReqs) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(TPGroupCompRepo.tpgRelated)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(TPGroupCompRepo.tpgCompLink)).click();
					
		List<WebElement> listInputs = driver.findElements(By.xpath(TPGroupCompRepo.reqList));
		System.out.println("Requirements Saved " +listInputs.size());
		if(assertReqsSize!=0){
			Assert.assertEquals(listInputs.size(), assertReqsSize);
		}

		// for remove reqs	
		if(removeReqs==true && listInputs.size()>0){
			for(int i=0; i<listInputs.size();i++){
				driver.findElement(By.xpath("//th[@tabindex='-1']//a[contains(text(),'')]")).click();
				//driver.findElement(By.xpath(TPGroupCompRepo.reqList)).click();
				Thread.sleep(5000);
				WebElement element = driver.findElement(By.xpath("//div[@class='active oneContent']"));
				if (element != null) {
					element.findElement(By.xpath(".//div[@title='Delete']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//button[@title='Delete']")).click();
					Thread.sleep(5000);
				}
				else
				{
					throw new NullPointerException();
				}
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	/*public void assertAndDeleteReqs(int assertReqsSize, boolean removeReqs) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(TPGroupCompRepo.tpgRelated)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(TPGroupCompRepo.tpgCompLink)).click();
		List<WebElement> listInputs = driver.findElements(By.xpath(TPGroupCompRepo.reqList));
		System.out.println("Requirements Saved " +listInputs.size());
		if(assertReqsSize!=0){
			Assert.assertEquals(listInputs.size(), assertReqsSize);
		}

		// for remove reqs	
		if(removeReqs=true && listInputs.size()>0){
			for(int i=0; i<listInputs.size();i++){
				driver.findElement(By.xpath(TPGroupCompRepo.reqList)).click();
				Thread.sleep(5000);
				WebElement element = driver.findElement(By.xpath("//div[@class='active oneContent']"));
				if (element != null) {
					element.findElement(By.xpath(".//div[@title='Delete']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//button[@title='Delete']")).click();
					Thread.sleep(5000);
				}
				else
				{
					throw new NullPointerException();
				}
			}
		}
	}*/
	public void searchAnything(String tabName, String searchKeyWord) throws InterruptedException {
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath(TPGroupCompRepo.searchBox));
		webElement.sendKeys(searchKeyWord);
		Thread.sleep(3000);
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		Thread.sleep(8000);
		driver.findElement(By.cssSelector(".buttonLabel")).click();
		Thread.sleep(3000);
		List<WebElement> allTabs = driver.findElements(By.xpath("//div[@id='allItemsList']//li//a"));
		for(WebElement myTab:allTabs){
			if(myTab.getText().equals(tabName)){
				myTab.click();
				break;
			}
		}
		driver.findElement(By.partialLinkText(searchKeyWord)).click();
		Thread.sleep(3000);
	}
	public void assertWFnReqStatus(String wfStatus, String ReqStatus) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(TPGroupCompRepo.wfStatus)).getText(), wfStatus);
		Assert.assertEquals(driver.findElement(By.xpath(TPGroupCompRepo.ReqStatus)).getText(), ReqStatus);
	}
	public void submitRequest() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(.,'Container')]/following::a[1]")).click();
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		List<WebElement> showMore = driver.findElements(By.xpath("//span[@title='Show more actions for this record']"));
		if(showMore.size()==2)
			showMore.get(1).click();
		else
			showMore.get(0).click();
		driver.findElement(By.xpath("//a[@title='Open Form']")).click();
		Thread.sleep(3000);
		List<WebElement> fl= driver.findElements(By.tagName("iframe"));
		System.out.println("No of iframes"+fl.size());
		WebElement frames = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frames);

		/*for(int f=1;f<=NoOfQuestions;f++){
			driver.findElement(By.xpath("//label[contains(.,'"+"QA Test Question"+f+ObjForm.d+"')]/following::input[1]")).sendKeys("QA Submit"+f);
			Thread.sleep(1000);
		}*/
		List<WebElement> allInputs = driver.findElements(By.xpath("//div[@class='slds-form-element__control']//input"));
		for(int f=1; f<=allInputs.size(); f++){
			driver.findElement(By.xpath("(//div[@class='slds-form-element__control']//input)["+f+"]")).sendKeys("QA Submit"+f);
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}
	public void approveOrRejectRequest(String approveOrReject)throws InterruptedException{
		driver.manage().deleteAllCookies();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[@alt='Show more actions for this record']")).click();
		driver.findElement(By.xpath("//a[@title='"+approveOrReject+"']")).click();
		Thread.sleep(8000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Comments ']")).sendKeys("QA Test");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}


	//Rishu added
	public void assertReqWFnStatus(String ReqStatus,String wfStatus) throws InterruptedException {
		Thread.sleep(3000);

		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'"+ReqStatus+"')]")).getText(), ReqStatus);

		Thread.sleep(5000);
		driver.findElement(By.xpath(TPGroupCompRepo.tpgRelated)).click();
		Thread.sleep(7000);
		//driver.findElement(By.xpath("//a[@data='null']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'"+wfStatus+"')]")).getText(), wfStatus);
		Thread.sleep(3000);
	}

	//From Here SC Added
	public static WebElement FindElement(String SourceBy,String controler) {

		WebElement element=null;
		WebDriverWait wait	=new WebDriverWait(driver, 70);					
		//return element;						
		if (SourceBy.equals("id")) {
			element=driver.findElement(By.id(controler));
			WebElement  bvalue=wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			return bvalue;
		}
		else if (SourceBy.equals("xpath")) {
			element=driver.findElement(By.xpath(controler));
			WebElement  bvalue=wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return bvalue;
		}
		else if (SourceBy.equals("cssSelector")) {
			element=driver.findElement(By.cssSelector(controler));
			WebElement  bvalue=wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return bvalue;
		}	
		else if (SourceBy.equals("linkText")) {
			element=driver.findElement(By.linkText(controler));
			WebElement  bvalue=wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return bvalue;

		}try{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return element;	
		}
		catch(org.openqa.selenium.TimeoutException ex){

			//System.out.println(ex.getMessage());
			System.out.println("Element is not Clickable till the estimated time");
		}
		return element;
	}

	//Added by SC
	public void checkModulesReady(int Interval) {

		JavascriptExecutor js = (JavascriptExecutor)driver;

		//Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")){ 
			System.out.println("Loading modules successful.");
			return; 
		} 

		//This loop will rotate for 25 times to check If page Is ready after every 1 second.
		//You can replace your value with 25 If you wants to Increase or decrease wait time.
		for (int i=0; i<25; i++){ 
			try {
				Thread.sleep(Interval);
			}catch (InterruptedException e) {
				e.printStackTrace();
			} 
			//To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")){ 
				break;
			}
		}
	}

	public void NormalReq() throws InterruptedException{
		 SalesForceLightiningView();
		  driver.findElement(By.xpath(ObjReq.lnkRequest)).click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath(ObjReq.btnNew)).click();
		  Thread.sleep(5000);
		  //driver.switchTo().frame(1);
		  
		  List<WebElement> frames =  driver.findElements(By.tagName("iframe"));
		    if(frames.size()==3){
		     driver.switchTo().frame(frames.get(2));
		    }
		    else if(frames.size()==2){
		     driver.switchTo().frame(frames.get(1));
		    }
		    else{
		     driver.switchTo().frame(frames.get(0));
		    }
			
		Thread.sleep(4000);
		 driver.findElement(By.id(ObjReq.txtReqName)).clear();
		  Thread.sleep(200);
		  driver.findElement(By.id(ObjReq.txtReqName)).sendKeys(ObjReq.Reqname);

		  Thread.sleep(5000);

		  driver.findElement(By.id(ObjReq.drpTpName)).clear();
		  Thread.sleep(200);

		  driver.findElement(By.id(ObjReq.drpTpName)).sendKeys(Responder);
		  Thread.sleep(2000);

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
}
