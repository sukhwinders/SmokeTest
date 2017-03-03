package icix.Utils;
import org.testng.Reporter;
import icix.Utils.Log;

public class ConsoleLog {

  public static void info(String message) {
    Log.info(message);
    Reporter.log(message);
    System.out.println(message);
  }

  public static void warn(String message) {
    Log.info(message);
    Reporter.log(message);
    System.out.println(message);
  }
}
