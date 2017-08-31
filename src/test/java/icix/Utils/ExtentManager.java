package icix.Utils;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.sun.jna.platform.unix.X11.Display;

public class ExtentManager {
	 static ExtentReports extent;
	 public static String OsName=System.getProperty("os.name").toLowerCase();	
	 
	    //final static String filePath = System.getProperty("user.dir")+"\\ExecutionReports\\HtmlReport\\TestReport.html";
	    //final static String configFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.xml";
	    
	    static String filePath = null;
	    static String configFilePath = null;
	    
	    public synchronized static ExtentReports getReporter() {
	    	
	    	if (OsName.contains("mac"))
	    	{
	    		filePath = System.getProperty("user.dir")+"/ExecutionReports/HtmlReport/TestReport.html";
	    		configFilePath = System.getProperty("user.dir")+"/src/main/resources/config.xml";
	    	}
	    	else if(OsName.contains("win"))
	    	{
	    		filePath = System.getProperty("user.dir")+"\\ExecutionReports\\HtmlReport\\TestReport.html";
	    		configFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.xml";	    		
	    	}
	    	
	        if (extent == null) {
	            //extent = new ExtentReports(filePath, false, DisplayOrder.NEWEST_FIRST);
	            extent = new ExtentReports(filePath, true, DisplayOrder.NEWEST_FIRST);
	            extent.loadConfig(new File(configFilePath));
	        }
	        
	        return extent;
	    }
}
