import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonModule extends AutomationScriptForAmazon {
	
	
	public static void OpenAmazon() throws IOException{
				
		//Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
		//Launch the Amazon application
		driver.get("https://www.amazon.com/");
		

	}

}
