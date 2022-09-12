package com.automationdemo.javademo;

public class Test {

	// Here in methods also we can write business logics

	public static void addition() { // inside method we can't
		// Here we are going to write business logics
		int a = 10;
		int b = 200;
		int c;
		c = a + b;
		System.out.println(c); // Here my values are constant, we can't change

	}// If there is no static then that method is non-static method
		/// if there is static keyword then it is static method

	public static void subtraction(int a, int b) {  // values may vary
		int c = a - b;
		System.out.println("Subtraction of two numbers ::" + c);

	}

	public static void main(String[] args) {
		// here we create object or we can write business logics

		// clasname ref= new classname();
		addition(); // In this method values are constant
		subtraction(10000, 1249);
                        // one time we created method and that method we used multiple times based on paramters
		
		// If methods are static we don't required to create object we can call directly

	}

}
