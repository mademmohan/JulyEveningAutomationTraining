package com.automationdemo.windowhandledemo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesSession {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.naukri.com/");

		String parent_window = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[text()='Register now']")).click();

		Set<String> allwindows = driver.getWindowHandles();

		// By using for-each loop we are handling windows in selenium

		for (String window : allwindows) {// 2

			driver.switchTo().window(window); // When driver will switch to required window the

			if (driver.getCurrentUrl()
					.equalsIgnoreCase("https://www.naukri.com/registration/createAccount?othersrcp=22536")) { // False,
																												// True

				driver.findElement(By.xpath("(//input)[1]")).sendKeys("MR Training");

			}
			
			driver.switchTo().window(parent_window);
			
			
			driver.findElement(By.xpath("//div[text()='Login']")).click();
			
			
			Thread.sleep(2000);
			
			driver.quit();

		}

	}

}
