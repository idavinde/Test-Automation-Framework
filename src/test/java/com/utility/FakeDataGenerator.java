package com.utility;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.ui.request.model.AddNewAddress;

public class FakeDataGenerator {
	private static Faker faker = new Faker(new Locale("en-US"));
	private static final Random random = new Random(); 
	private FakeDataGenerator() {
		
	}
	public static AddNewAddress generateDataForAddress() {
		
		String company = faker.company().name();
		String address1 = faker.address().buildingNumber();
		String address2 = faker.address().streetAddress();
		String city = faker.address().city();
		String state = String.valueOf(random.nextInt(52)+1);
		String postcode = faker.number().digits(5);
		String phone = faker.number().digits(10);
		String phone_mobile = faker.phoneNumber().cellPhone();
		String other = faker.lorem().sentence(5);
		String alias = faker.name().firstName();
		
		
		AddNewAddress addNewAddress = new AddNewAddress(company, address1,
				address2, city, state, postcode, phone, phone_mobile, other, alias);
		
		return addNewAddress;
		
	}
}
