package com.automationdemo.syncronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicityWaitDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.findElement(By.id("btn2")).click();
		
		//now implimenting explicity wait condition
		
		
		WebDriverWait wait= new WebDriverWait(driver, 15);
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@id='txt2'])[1]"))));   // Only applicable 11 sec of specific webElement
		
		driver.findElement(By.xpath("//h3/input[@type='text' and @id='txt2']")).sendKeys("JSN Training");

	}
}
