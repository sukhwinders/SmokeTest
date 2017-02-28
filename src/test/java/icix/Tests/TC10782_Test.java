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

//Create Product With Universal Id

public class TC10782_Test extends TestBase {
	Product objProduct = new Product();
	LoginOut objLoginOut = new LoginOut();
	
	@Test
	public void TestProductSearchByUniID (Method method) throws Exception{
		Log.info("Test Case Name is: "+method.getName());
		ConsoleLog.info("Test Case Name is: "+method.getName());
		
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		objProduct.ProductSearchByUniID(ProductTestData.selectTP_TC10781, ProductTestData.univeralID_TC10782, ProductTestData.ProductName_TC10781,
				ProductTestData.id_TC10781, ProductTestData.idtxt_TC10781, ProductTestData.Description_TC10781, ProductTestData.TradingpRel_TC10781);
		
	}

}

