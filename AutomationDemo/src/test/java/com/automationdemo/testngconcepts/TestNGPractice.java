package com.automationdemo.testngconcepts;

import org.testng.annotations.Test;

public class TestNGPractice {

	
	@Test(invocationCount =  10)
	public void m1() {
		System.out.println("m1 method in TestNG");
	}  // if we provide invocation count 10 then that method will execute 10  times
}

/*
 * O/P: m1 method in TestNG m1 method in TestNG m1 method in TestNG m1 method in
 * TestNG m1 method in TestNG m1 method in TestNG m1 method in TestNG m1 method
 * in TestNG m1 method in TestNG m1 method in TestNG
 */

// I want to execute this method for 10times 
