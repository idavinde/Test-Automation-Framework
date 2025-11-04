package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	
	public static Iterator<User> loadCSV(String pathOfCSVFile)  {
		
		InputStream  is= Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr);
		
		
		CsvToBean<User> csvToBean = new CsvToBeanBuilder(csvReader)
				.withType(User.class)
				.withIgnoreEmptyLine(true)
				.build();
		List<User> userList = csvToBean.parse();
		return userList.iterator();
	}
}
