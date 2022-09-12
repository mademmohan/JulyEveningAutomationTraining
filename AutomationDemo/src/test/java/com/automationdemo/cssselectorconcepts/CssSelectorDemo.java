package com.automationdemo.cssselectorconcepts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectorDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.cssSelector("input[name*='username']")).sendKeys("Admin");

		driver.findElement(By.cssSelector("input[type$='password']")).sendKeys("admin123");

		driver.findElement(By.cssSelector("button[class^='oxd-button']")).click();
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
