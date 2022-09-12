package com.automationdemo.testngconcepts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesFiles {

	public static void main(String[] args) throws IOException {
		// How to get project location

		String project_location = System.getProperty("user.dir");

		System.out.println(project_location);

		// In java there is an class which stores are call location

		File file = new File(project_location + "\\TestData.properties");

		// BufferedReader is the class which is used to read data properites files

		BufferedReader reader = new BufferedReader(new FileReader(file));

		Properties pr = new Properties(); // this is the class inside collections which is used to read data

		pr.load(reader); // load entire data and we are going use that data

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		// By using getProperty("propertykey");

		String App_url = pr.getProperty("url"); // url of the application

		String userName = pr.getProperty("username");

		String password = pr.getProperty("password"); // It's going to retive passwrod

		driver.get(App_url);

		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
