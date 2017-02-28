package icix.Tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import icix.Modules.LoginOut;
import icix.Modules.Product;
import icix.TestData.LoginOutTestData;
import icix.TestData.ProductTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

//Scenario: Create Product Without Universal Id

public class TC10781_Test extends TestBase{
	
	Product objProduct = new Product();
	LoginOut objLoginOut = new LoginOut();
	
	@Test
	public void TestProductSearchWithoutUID (Method method) throws Exception{
		Log.info("Test Case Name is: "+method.getName());
		ConsoleLog.info("Test Case Name is: "+method.getName());
		
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		objProduct.ProductSearchWithoutUID(ProductTestData.selectTP_TC10781,
				ProductTestData.ProductName_TC10781,ProductTestData.id_TC10781,ProductTestData.idtxt_TC10781
				,ProductTestData.Description_TC10781,ProductTestData.TradingpRel_TC10781);
	}
	
}
