package com.automationdemo.syncronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeOutDemo {

	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
		//Now I define load page with in less than 2 seconds
		
		driver.get("https://flipkart.com/");
		
		
		//Note: In pageLoadTimeOut() method, if page is not loaded in specific time it will throw
		  // page load rendering issue
		
		
	}
}
