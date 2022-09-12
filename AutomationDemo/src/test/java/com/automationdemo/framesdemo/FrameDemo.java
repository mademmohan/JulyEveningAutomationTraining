package com.automationdemo.framesdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameDemo {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		//ChromeDriver driver1= new ChromeDriver();// This is not recommended because it is class it doesn't contians to 
		  //funtions to test application
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement demo_frame =driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(demo_frame);
		
		WebElement draggable =driver.findElement(By.id("draggable"));
		
		WebElement droppable =driver.findElement(By.id("droppable"));
		
		Actions action= new Actions(driver);
		
		action.dragAndDrop(draggable, droppable).perform();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[.='Draggable']")).click();
		
	}

}
