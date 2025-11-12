package com.ui.dataproviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.utility.FakeDataGenerator;

public class AddNewAddressDataProvider {
			
	@DataProvider(name="AddNewAddressDataProvider")
	public Iterator<Object[]> addNewAddressDataProvider(){
		
		List<Object[]> data = new ArrayList<>();
	    data.add(new Object[]{ FakeDataGenerator.generateDataForAddress() });
	    return data.iterator();
	}
}
