package com.automationdemo.javademo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDemo {
	
	public static void checkSelection_Reuse(String radiotype) { // hondaradio
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://courses.letskodeit.com/practice");
		
		// In selenium driver.findElemetns will find more than one element
		
		List<WebElement> allcheckbox_buttons=driver.findElements(By.xpath("//legend[text()='Checkbox Example']/parent::fieldset/label/input[@type='checkbox']"));
		
		for(WebElement checkboxbutton:allcheckbox_buttons) {
			
			if(checkboxbutton.getAttribute("value").equalsIgnoreCase(radiotype)) {  //F  True
				checkboxbutton.click();  // true area  happy click on that radio button
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		checkSelection_Reuse("honda");
		
	}
	

}
