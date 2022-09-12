package com.automationdemo.testngconcepts;

public class Test {
	
	
	public static  void launchApp() {
		System.out.println("Appliacation Launcehd");
	}
	
	
	public static void loginApp() {
		System.out.println("Successfully Logged into applicaiton");
	}
	
	public static void deleteUser() {
		System.out.println("Deleted User");
	}
	
	public static void logOff() {
		System.out.println("LogOff Successfully");
	}
	
	public static void closeBrowser() {
		System.out.println("Closed Browser");
	}
	
	// If I want to run all methods we create object
	
	public static void main(String[] args) {
		// className reference= new Classname();
		
		/*
		 * Test application= new Test();
		 * 
		 * application.launchApp(); application.loginApp(); application.deleteUser();
		 * application.logOff(); application.closeBrowser();
		 * 
		 * 
		 */
		
		launchApp();
		loginApp();
		deleteUser();
		logOff();
		closeBrowser();
		
	}

}
