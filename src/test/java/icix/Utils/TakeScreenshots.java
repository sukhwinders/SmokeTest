package icix.Utils;

import icix.Start.Start;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TakeScreenshots {

	private static String destDir  = null;
	private static String destFile = null;
	public static  String baseScreenShotsFolder=null; 


	public static void takescreenshotOnSuccess() {
		WebDriver driver = Start.getDriverInstance();
		// if there is no folder created, then create one
		if (destDir == null) {
			destDir = createScreenshotFolder()+ "/Passed";
		}

		destFile = createFileName(driver);
		captureScreenshot(driver, destDir, destFile);
		System.out.println("Screenshot captured");
	}

	public static void captureScreenshot(WebDriver driver, String screenshotFolder, String fileName) {
		File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tempFile, new File(screenshotFolder + "/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String createFileName(WebDriver driver) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		String pageTitle = driver.getTitle();
		String newPageTitle = pageTitle.replaceAll("[\\/:*?\"<>|]", "_");
		String destFile = newPageTitle + "_" + dateFormat.format(new Date()) + ".png";
		return destFile;
	}

	// Jagdeep.kaur: create a base folder for each execution
	public static String createScreenshotFolder() {


		if(baseScreenShotsFolder==null){
			baseScreenShotsFolder = "target/screenshots/";
			SimpleDateFormat sdfmth = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			Calendar cal = Calendar.getInstance();
			baseScreenShotsFolder = baseScreenShotsFolder + "/" + sdfmth.format(cal.getTime())+"/";
			new File(baseScreenShotsFolder).mkdirs();
			return baseScreenShotsFolder;
		}
		else
			return baseScreenShotsFolder;

	}
	public static void resetScreenshotFolder() {
		destDir = null;
	}
}