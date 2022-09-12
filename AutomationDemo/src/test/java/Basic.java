import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); // This will approach automatically check and download
		
		//System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe"); //104  if your chorme will update
		// you need suitable .exe file of browser
		
		//above syntax of code automatically download requied .exe browser file
		WebDriver driver = new ChromeDriver();

		driver.get("http://google.com");
		
		//By copy required dependencies I'm getting all into my 
	}

}
