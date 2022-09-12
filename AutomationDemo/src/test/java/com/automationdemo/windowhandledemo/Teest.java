package com.automationdemo.windowhandledemo;

public class Teest {
	
	  
	
	
	public static void main(String[] args) {
		
	 String str= "welcome to india";
	 
	   String [] words=str.split(" ");
	   
	   String reverse = "";
	   
	   String reverseword="";
	   
	   for(int i=0;i<words.length;i++) {
		   
		   String word= words[i];
		   
		   for(int j= word.length()-1;j>=0;j--) {
			   reverse= reverse+word.charAt(j);
			 }
		    reverseword= reverseword+reverse+" ";
	   }
	
	     System.out.println(reverseword);
	  

	}

}
