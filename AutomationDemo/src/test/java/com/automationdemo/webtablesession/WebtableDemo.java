package com.automationdemo.webtablesession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtableDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://courses.letskodeit.com/practice");
		
		List<WebElement> table_headers=driver.findElements(By.xpath("//tbody/tr[1]/th"));
		
		//list data wil be printed using for each loop
		
		for(WebElement table_header:table_headers) {
			System.out.print(table_header.getText()+" ");
		}
		
		// If i want to entire data from given table
		
		System.out.println("Printing entire table data");
		
		List<WebElement> entire_table=driver.findElements(By.xpath("//tbody/tr"));
		
		for(WebElement each_row:entire_table) {
			System.out.println(each_row.getText()+" ");
		}
		
		Thread.sleep(2000);
		
		driver.close();		
	}

}
