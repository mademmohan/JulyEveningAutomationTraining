package com.automationdemo.testngconcepts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActionsDemo {
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://the-internet.herokuapp.com/key_presses");
		
		Actions action= new Actions(driver);
		
		//action.sendKeys(Keys.ESCAPE).perform();
		
		action.sendKeys(Keys.chord(Keys.CONTROL, Keys.ESCAPE)).perform();
		
		
	}

}
