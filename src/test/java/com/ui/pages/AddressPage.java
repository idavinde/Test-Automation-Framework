package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.request.model.AddNewAddress;
import com.utility.BrowserUtility;
import com.utility.FakeDataGenerator;

public class AddressPage extends BrowserUtility {
	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");

	private static final By POST_CODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILE_NUMBER_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By OTHER_INFORMATION_TEXTBOX_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By ADDRESS_HEADING_LOCATOR=By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);

	}

	public String saveAddress(AddNewAddress addNewAddress) {

		enterText(COMPANY_TEXTBOX_LOCATOR, addNewAddress.company());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, addNewAddress.address1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, addNewAddress.address2());
		enterText(CITY_TEXTBOX_LOCATOR, addNewAddress.city());
		selectDropdownByValue(STATE_DROPDOWN_LOCATOR, addNewAddress.state());
		enterText(POST_CODE_TEXTBOX_LOCATOR, addNewAddress.postcode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, addNewAddress.phone());
		enterText(MOBILE_NUMBER_TEXTBOX_LOCATOR, addNewAddress.phone_mobile());
		enterText(OTHER_INFORMATION_TEXTBOX_LOCATOR, addNewAddress.other());
		clear(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, addNewAddress.alias());
		clickOn(SAVE_ADDRESS_LOCATOR);
		String addressHeading = getText(ADDRESS_HEADING_LOCATOR);
		return addressHeading;
		
		
	}

}
