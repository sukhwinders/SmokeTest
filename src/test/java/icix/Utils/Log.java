package icix.Utils;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class Log 
{

	private static Logger Log = Logger.getLogger(Log.class.getSimpleName());
	
	
	public static void info(String message)
	{
		Log.info(message);
		
	}
	
	public static void warn(String message)
	{
		Log.warn(message);
		
	}
}
