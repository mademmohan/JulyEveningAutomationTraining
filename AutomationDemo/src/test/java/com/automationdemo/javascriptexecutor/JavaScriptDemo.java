package com.automationdemo.javascriptexecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://courses.letskodeit.com/practice");
		
		WebElement textbox=driver.findElement(By.xpath("//input[@name='enter-name']"));
		
		WebElement alert_botton=driver.findElement(By.id("alertbtn"));
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].value='JSN Training';", textbox);
		
		js.executeScript("arguments[0].click();", alert_botton);
		
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
		
		WebElement mouseOver_btn=driver.findElement(By.id("mousehover"));
		
		js.executeScript("arguments[0].scrollIntoView();", mouseOver_btn);
		
		Thread.sleep(2000);
		
		WebElement headerpage=driver.findElement(By.xpath("//h1[.='Practice Page']"));
		
		js.executeScript("arguments[0].scrollIntoView();", headerpage);
	}

}
