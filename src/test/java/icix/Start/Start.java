package icix.Start;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import icix.Urls.Urls;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Start{
	
	public static WebDriver driver;
	
	public static WebDriver getDriverInstance() {
	    return driver;
	  }
	
	protected static void InitilizeBrowser()
	{
		ChromeDriverManager.getInstance().setup();
	    driver = new ChromeDriver();  
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    //driver.navigate().to(Urls.baseUrl);
	    driver.get(Urls.baseUrl);
	}
}
