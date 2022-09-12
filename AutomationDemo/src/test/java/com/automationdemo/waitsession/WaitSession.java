package com.automationdemo.waitsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitSession {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://letcode.in/waits");
		
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
		
		//After clicking on this button selenium won't wait for 20 sec like finding elements it will
		//immediatly trying to for element,
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		
		Alert untill=wait.until(ExpectedConditions.alertIsPresent());
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(untill.getText());

		untill.accept();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
