package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constant.Size;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	private SearchResultPage searchResultPage;
	private static final String SEARCH_TERM= "Printed Summer dress";
	@BeforeMethod(description="User logs into the application and searches for a product")
	public void setup() {
		
		searchResultPage = homePage.goToLoginPage().doLoginWith("febetix752@erynka.com", "password")
		.searchForAProduct(SEARCH_TERM);
	}
	
	@Test(description="Verify if the logged in user is able to buy a dress", groups = {"e2e", "smoke", "sanity"})
	public void checkoutTest() {
		String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(Size.M).changeColour().addProductToCart()
		.proceedToCheckOut().goToConfirmAddressPage().goToShipmentPage().goToPaymentPage()
		.makePaymentByWire();
		
		
		Assert.assertTrue(result.contains("complete"));
		
		
	}
}
