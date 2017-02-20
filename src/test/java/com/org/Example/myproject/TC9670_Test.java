package com.org.Example.myproject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Date;




import com.utils.Data_loading_Old;

public class TC9670_Test {
	WebDriver driver;
	String baseUrl;
	Date d = new Date(System.currentTimeMillis());
	String container_Name = "Testcontainer" + d;
	String Layout_Name = "QA_Testlayout" + d;
	String Tab_Name = "Testtab" + d;
	String Section_Name = "Testsection" + d;

	Data_loading_Old guitils = new Data_loading_Old();
	String userName1 = guitils.getUserName("RequestorUsername");
	String password1 = guitils.getPassword("RequestorPassword");
	//String Question_ID = guitils.getDATA("Question_ID");

	@BeforeClass
	public void beforeClass() {
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
	driver.quit();
		//driver.close();
	}

	@Test
	public void createNew_form() throws Exception {

		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		
		guitils.CreateContaniner(driver);
		guitils.CreateLayout(driver);		
		guitils.AddTab(driver);
		guitils.AddSection(driver);
		guitils.AddLinkedQuestion(driver);	

	}
}
