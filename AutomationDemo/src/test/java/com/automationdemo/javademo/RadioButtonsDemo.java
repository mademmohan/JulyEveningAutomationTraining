package com.automationdemo.javademo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonsDemo {
	
	
	  public static void radioSelection() {
	  
	  WebDriverManager.chromedriver().setup();
	  
	  WebDriver driver= new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().deleteAllCookies();
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  driver.get("https://courses.letskodeit.com/practice");
	  
	  // Now my requirement is click on BMW
	  
	  driver.findElement(By.id("benzradio")).click(); }
	   // everytime you are changing business logic
	
	
	public static void radioSelection_Reuse(String radiotype) { // hondaradio
          WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://courses.letskodeit.com/practice");
		
		// In selenium driver.findElemetns will find more than one element
		
		List<WebElement> allradio_buttons=driver.findElements(By.xpath("//input[@type='radio']"));
		
		for(WebElement radiobutton:allradio_buttons) {
			
			if(radiobutton.getAttribute("id").equalsIgnoreCase(radiotype)) {  //F  True
				radiobutton.click();  // true area  happy click on that radio button
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		  radioSelection_Reuse("benzradio");
	}

}
