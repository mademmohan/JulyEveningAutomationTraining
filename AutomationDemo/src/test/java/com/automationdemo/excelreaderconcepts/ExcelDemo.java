package com.automationdemo.excelreaderconcepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	
	public static void main(String[] args) throws IOException {
		
		File f= new File("C:\\Users\\gurum\\Desktop\\OrangHRMData.xlsx");
		
		FileInputStream fi= new FileInputStream(f);
		
		// Above line will connect to file not opened any file
		
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		
		// Above line will interact workbook of above file
		
		XSSFSheet sh= wb.getSheet("OrangeLogin");
		
		// Above line will interact with sheet
		
		
		int row=sh.getLastRowNum();
		 String username_data= sh.getRow(2).getCell(0).getStringCellValue();
		 
		 
		 String password_data= sh.getRow(2).getCell(1).getStringCellValue();
		 
		 
		 System.out.println(username_data);
		 
		 System.out.println(password_data);
		
		
		
	}

}
