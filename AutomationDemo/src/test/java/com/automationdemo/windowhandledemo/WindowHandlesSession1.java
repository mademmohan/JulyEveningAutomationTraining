package com.automationdemo.windowhandledemo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesSession1 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String parent_window=driver.getWindowHandle();
		
		
		WebElement inputtext_box=driver.findElement(By.xpath("//input[@class='whTextBox']"));
		
		inputtext_box.sendKeys("MR Training");
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> allwindows=driver.getWindowHandles();
		
		 Iterator<String> itr = allwindows.iterator();
		 
		 while(itr.hasNext()) {  // this hasNext will return true or false, if next ele is available it will return true
			 driver.switchTo().window(itr.next());
			 
			 if(driver.getCurrentUrl().equals("https://www.hyrtutorials.com/p/basic-controls.html")) {
				 driver.manage().window().maximize();
				String new_windowtext= driver.findElement(By.xpath("//h1[@class='post-title entry-title']")).getText();
				System.out.println("New Window Text is ::"+new_windowtext);
			 }
		 }
		 
		 driver.switchTo().window(parent_window);
		 
		 inputtext_box.clear();
		 inputtext_box.sendKeys("JSN Institute");
		 
		 
	}

}
