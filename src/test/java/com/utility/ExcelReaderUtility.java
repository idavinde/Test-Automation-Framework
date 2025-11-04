package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User> readExcelFile(String excelFilePath)  {
	
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(excelFilePath);
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		List<User> userList = null;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user ;
		
		try {
			xssfWorkbook = new XSSFWorkbook(inputStream);
			xssfSheet=xssfWorkbook.getSheet("LoginTestData");
			
			userList = new ArrayList<User>();
			
			
			rowIterator = xssfSheet.iterator();
			
			rowIterator.next();
			
			while(rowIterator.hasNext()) {
				
				 row = rowIterator.next();
				
				 emailAddressCell = row.getCell(0);
				 passwordCell = row.getCell(1);
				
				 user = new User(emailAddressCell.toString(),passwordCell.toString());
				
				userList.add(user);
			}
			
			xssfWorkbook.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return userList.iterator();
		
		
	}
}
