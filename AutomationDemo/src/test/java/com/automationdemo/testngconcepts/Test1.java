package com.automationdemo.testngconcepts;

public class Test1 {
	
	
	@org.testng.annotations.Test(priority =  1)
	public static  void launchApp() {
		System.out.println("Appliacation Launcehd");
	}
	
	@org.testng.annotations.Test(priority = 2)
	public static void loginApp() {
		System.out.println("Successfully Logged into applicaiton");
	}
	
	@org.testng.annotations.Test(priority = 3, enabled =  false)
	public static void deleteUser() {
		System.out.println("Deleted User");
	}
	
	@org.testng.annotations.Test(priority = 4)
	public static void logOff() {
		System.out.println("LogOff Successfully");
	}
	
	@org.testng.annotations.Test(priority = 5)
	public static void closeBrowser() {
		System.out.println("Closed Browser");
	}

}
