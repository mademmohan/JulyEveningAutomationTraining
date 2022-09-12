package com.automationdemo.testngconcepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMAssertionDemo {

	public WebDriver driver;

	// Note: If we define any thing at class level we can use it any where in that
	// class directly

	@DataProvider(name= "Empdata")
	public Object[][] getExceldata() throws IOException {

		File f = new File("C:\\Users\\gurum\\Desktop\\OrangHRMData.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook book = WorkbookFactory.create(fi);

		Sheet sh = book.getSheet("EmployeeData");

		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

		for (int i = 0; i < sh.getLastRowNum(); i++) { // this will replicate for rowss

			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) { // this will replicate for columns

				data[i][j] = sh.getRow(i + 1).getCell(j).toString();

			}
		}

		return data;

	}

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		// This two line wil initailize empty browser

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Note: Basically if we define any thing at method level we can use it specific
	// to method,
	// But if we define at class level we can use it any where

	@BeforeMethod
	public void orangeHRMLogin() throws InterruptedException {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String expected_url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

		String actual_url = driver.getCurrentUrl();

		// Now my requirement if both are same pass else fail

		// By hard assertion I'm going to use

		//Assert.assertEquals(actual_url, expected_url);

		// THis line of statement will say if both are equal my test else fail

		Thread.sleep(4000);

	}

	@Test(dataProvider = "Empdata")
	public void addEmployee(String empfName, String empMname, String empLname, String empid) throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

		String section_title = driver.findElement(By.xpath("(//h6)[2]")).getText();

		String expected_title = "Add Employee";

		Assert.assertEquals(section_title, expected_title);

		Thread.sleep(4000);

		driver.findElement(By.name("firstName")).sendKeys(empfName);

		driver.findElement(By.name("middleName")).sendKeys(empMname);

		driver.findElement(By.name("lastName")).sendKeys(empLname);
		
		driver.findElement(By.xpath("//div/label[.='Employee Id']/../following::div[1]/input")).sendKeys(empid);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000);

	}

	@AfterMethod
	public void logOff() {

		driver.findElement(By.xpath("//span[contains(@class,'userdropdown')]")).click();

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		String expected_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String actual_url = driver.getCurrentUrl();

		Assert.assertEquals(actual_url, expected_url);

	}

	@AfterClass
	public void tearDown() {

		driver.close();
	}

}
