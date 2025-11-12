package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {
	
	private static final By EMAIL_TEXT_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_LOCATOR = By.id("passwd");
	private static final By SUBMIT_LOGIN_BUTTON = By.id("SubmitLogin");
	private static final By ERROR_MESSAGE_LOCATOR= By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		
		enterText(EMAIL_TEXT_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_LOCATOR, password);
		clickOn(SUBMIT_LOGIN_BUTTON);
		
		return new MyAccountPage(getDriver());
		
	}
	
	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
		
		enterText(EMAIL_TEXT_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_LOCATOR, password);
		clickOn(SUBMIT_LOGIN_BUTTON);
		
		return new LoginPage(getDriver());
	}
	
	public String getErrorMessage() {
		
		return getText(ERROR_MESSAGE_LOCATOR);
	}

}
