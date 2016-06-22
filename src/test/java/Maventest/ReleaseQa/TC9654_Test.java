package Maventest.ReleaseQa;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9654_Test {
	WebDriver driver;
	String baseUrl;
	Date d = new Date(System.currentTimeMillis());
	String Product = "TestProduct" + d;
	String randomNumbers = RandomStringUtils.randomNumeric(8);
	String UPCproduct = "1111" + randomNumbers;
	String firstwindow;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String userName2 = guitils.getUserName("ResponderUsername");
	String password2 = guitils.getPassword("RequestorPassword");
	String strTPName = guitils.getPassword("product_partner");

	@Test
	public void publicProduct() throws Exception {

		// Login to the salesforce
		guitils.loginToPortal(userName2, password2, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(4000);
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(By.xpath("//a[contains(text(),'ICIX Products')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));

		driver.findElement(By.id("txtIdValue0")).clear();
		driver.findElement(By.id("txtIdValue0")).sendKeys(UPCproduct);
		Thread.sleep(9000);
		driver.findElement(By.id("btnProductSearch")).click();
		driver.findElement(By.id("btnCreateProduct")).click();
		driver.findElement(By.xpath("//input[@id='ProductName']")).sendKeys(
				Product);

		driver.findElement(
				By.xpath("//button[contains(@ng-click,'vm.AddNewProduct()')]"))
				.click();
		driver.findElement(
				By.xpath("//input[@id='txt_UPProductRelationship_Name']"))
				.sendKeys(Product);
		/*
		 * driver.findElement(By.xpath("//input[@id='txt_UPTardingPartner_Name']"
		 * )).sendKeys(strTPName); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//h3[@class='ng-binding']")).click();
		 */
		new Select(driver.findElement(By.id("ddl_UPRelationship_Type")))
				.selectByVisibleText("Buy");
		String strTypeDrp = "//select[@id='ddl_UPRelationship_Status']";

		if (System.getProperty("os.name").toLowerCase().contains("win")) {

			driver.switchTo().activeElement()
					.equals(driver.findElement(By.xpath(strTypeDrp)));
			driver.findElement(By.xpath(strTypeDrp)).sendKeys(Keys.ARROW_DOWN);

		} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			driver.switchTo().activeElement()
					.equals(driver.findElement(By.xpath(strTypeDrp)));
			driver.findElement(By.xpath(strTypeDrp)).sendKeys(
					Keys.chord(Keys.ARROW_DOWN));
		}

		driver.findElement(By.id("btn_UPRelationship_Next")).click();
		driver.findElement(By.id("rdPermissionOption1")).click();
		driver.findElement(By.xpath("//fieldset/div/label[2]")).click();
		driver.findElement(By.id("btn_UPRelationshipPermission_Save")).click();
		driver.findElement(
				By.xpath("//message-dialog/div[2]/div/div/div[3]/button"))
				.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
					.sendKeys(Keys.CONTROL + "t");

		} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
					.sendKeys(Keys.COMMAND + "t");
		}
		driver.get(baseUrl);
		// Login to the salesforce
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		Thread.sleep(3000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'ICIX Products')]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("txtIdValue0")).clear();
		driver.findElement(By.id("txtIdValue0")).sendKeys(UPCproduct);
		Thread.sleep(5000);
		driver.findElement(By.id("btnProductSearch")).click();
		Thread.sleep(8000);
		Assert.assertTrue(
				driver.findElement(
						By.xpath("//button[contains(.,'Connect to Product')]"))
						.isDisplayed(), "product is not avilable");

	}

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

}
