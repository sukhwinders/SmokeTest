package icix.Utils;

import icix.TestData.LoginOutTestData;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({ icix.Utils.ScreenShotOnFailure.class})
public class TestBase {
	
	protected static String Requestor = "Requestor";
	protected static String Responder = "Responder";
	protected static String Laboratory = "Laboratory";
	
	@BeforeSuite
	 public void initialiseLogFile(){
	  
	  DOMConfigurator.configure("src\\main\\resources\\log4j\\log4j.xml"); 
	 }
	
	@BeforeTest
	public void initialiseParameters(ITestContext context) throws Exception
	
	{
		LoginOutTestData.initialiseLoginParameters(context);
	}
	@BeforeClass
	public void beforeClass() {
		Common.Init();	
	}


	@AfterClass
	public void close(){
		Common.LogoutUser();
		Common.closeBrowser();
	}
	
}
