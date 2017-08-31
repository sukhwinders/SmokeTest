package icix.Start;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;

import icix.Urls.Urls;
import icix.Utils.Log;
import icix.Utils.WaitTool;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;

public class Start{
	
	public static WebDriver driver;
	//public static PhantomJSDriver driver;
	
	public static WebDriver getDriverInstance() {
	    return driver;
	  }
	
	protected static void InitilizeBrowser()
	{
		//ChromeDriverManager.getInstance().setup();
	    //driver = new ChromeDriver();
		//driver = new HtmlUnitDriver();
	    
		//DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
	    //driver = new PhantomJSDriver(capabilities);
		
		PhantomJsDriverManager.getInstance().setup();
		driver = new PhantomJSDriver();
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    //driver.navigate().to(Urls.baseUrl);
	    driver.get(Urls.baseUrl);
	}
	
	
	
	/*
	public static void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	}*/
}
