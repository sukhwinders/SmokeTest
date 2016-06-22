package Maventest.ReleaseQa;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TC9883_Test {
	String firstwindow;
	WebDriver driver;
	String baseUrl;

	Date d = new Date(System.currentTimeMillis());
	String container_Name = "Testcontainer" + d;
	String Layout_Name = "Testlayout" + d;
	String Tab_Name = "Testtab" + d;
	String Section_Name = "Testsection" + d;
	String QuestionText = "TestQ" + d;
	String FName;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	String Answertype = guitils.getDATA("AnswerType");

	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() throws Exception {
		// driver.findElement(By.id("j_id0:form:buttonPreview")).click();
		// Thread.sleep(9000);
		// driver.findElement(By.id("j_id0:form:buttonPublish")).click();
		// Thread.sleep(6000);
		// driver.quit();
	}

	@Test
	public void Copy_form() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(3000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'FormList')]")).click();
		driver.switchTo().frame(0);
		FName = driver
				.findElement(
						By.xpath(".//*[@id='j_id0:form:dataPageBlock:j_id39:3:j_id69']"))
				.getText();
		driver.findElement(
				By.xpath("//input[@id='j_id0:form:dataPageBlock:j_id39:0:j_id69']"))
				.click();
		String str = driver.findElement(
				By.id("j_id0:form:dataPageBlock:j_id39:3:j_id69")).getText();
		if (str.contains(FName))

		{
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}

}
