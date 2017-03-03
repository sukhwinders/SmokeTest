package icix.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTool {

	public static WebElement waitForElementPresentAndDisplay(WebDriver driver,final By by,int timeOutInSeconds) {
		WebElement element = null;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			Log.warn("element is not present and displayed");
		}
		return element;
	}
	
	public static List<WebElement> waitForElementsPresentAndDisplay(WebDriver driver,final By by,int timeOutInSeconds) throws Exception {
		List<WebElement> element = null;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			//throw new Exception(by.toString()+ "element is not present and displayed");
		}
		return element;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver,final By by,int timeOutInSeconds) throws Exception {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(by));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			throw new Exception(by.toString()+ "element is not present and displayed");
		}
	}
	
	public static void waitForPageLoadToComplete(WebDriver driver, int timeOutInSeconds){
		try{
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver newDriver) {
	                return ((JavascriptExecutor)newDriver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	    wait.until(pageLoadCondition);
	    //Log.info("Waiting for Page to load completely");
		}
		catch(Exception e){
			System.out.println("not able to load page and exception is thrown "+e.getMessage());
		}
	}

	public static boolean isElementPresentAndDisplay(WebDriver driver, By by) {
		try {			
			if(driver.findElement(by).isDisplayed())
				return true;
			else 
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void waitForElementToBeClickable(WebDriver driver,
			WebElement element, int timeOutInSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(element));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
		} catch (Exception e) {
			Log.warn(element.toString()+ "element is not present and displayed");
		}
		
	}
	
	public static Boolean waitForElementsToBeInvisible(WebDriver driver,final By by,int timeOutInSeconds) throws Exception {
		Boolean isTrue=false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			isTrue = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
			return isTrue; // return the element
		} catch (Exception e) {
			//throw new Exception(by.toString()+ "element is not present and displayed");
		}
		return isTrue;
	}
	
}
