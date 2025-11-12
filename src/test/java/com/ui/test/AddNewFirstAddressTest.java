package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.request.model.AddNewAddress;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	
	@BeforeMethod(description = "Valid First Time user logs into the application")
	public void setup() {

		myAccountPage = homePage.goToLoginPage().doLoginWith("febetix752@erynka.com", "password");
	}

	@Test (description= "Verify if the user is able to add new address for the first time" , groups= {"e2e","smoke","sanity"} ,
			dataProviderClass = com.ui.dataproviders.AddNewAddressDataProvider.class , dataProvider="AddNewAddressDataProvider")
	public void addNewAddress(AddNewAddress addNewAddress) {
		String  addressAlias = myAccountPage.goToAddAddressPage().saveAddress(addNewAddress);
		Assert.assertEquals(addressAlias, addNewAddress.alias().toUpperCase());
	}
}
