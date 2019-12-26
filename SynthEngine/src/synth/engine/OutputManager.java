// -TODO-
// Add a general logger
// Add a crash logger

package synth.engine;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputManager {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private static String date = simpleDateFormat.format(new Date());
	
	public static void println(String message, OutputType messageType) {
		if (messageType.allow) {			
			System.out.println("[" + date + "] {" + new Exception().getStackTrace()[0].getClassName() + "} (" + messageType.toString() + ") | " + message);
		}
	}
	
	public static void updateDate() {
		date = simpleDateFormat.format(new Date());
	}

}