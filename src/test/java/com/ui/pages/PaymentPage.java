package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {
	private static final By PAYMENT_BY_WIRE_BUTTON_LOCATOR= By.xpath("//a[@class=\"bankwire\"]");
	private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR= By.xpath("//button[contains(@class, \"button btn\")]");
	private static final By ALERT_SUCCESS_MESSAGE_LOCATOR =By.xpath("//p[@class=\"alert alert-success\"]");
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String makePaymentByWire() {
		
		clickOn(PAYMENT_BY_WIRE_BUTTON_LOCATOR);
		clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
		return getText(ALERT_SUCCESS_MESSAGE_LOCATOR);
		
	}

}
