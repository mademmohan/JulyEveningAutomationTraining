package com.automationdemo.sreenshotdemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotDemo {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String exp_url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

		String actual_url = driver.getCurrentUrl();

		String projectLocation = System.getProperty("user.dir"); // path of project location

		if (exp_url.equalsIgnoreCase(actual_url)) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File dest = new File(projectLocation + "\\ScreenShotPath\\Homepage.jpg");

			FileUtils.copyFile(src, dest);

		}

		else {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File dest = new File(projectLocation + "\\ScreenShotPath\\FailedHome.jpg");

			FileUtils.copyFile(src, dest);
		}
	}

}
