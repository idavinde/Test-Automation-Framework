package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constant.Browser;
import com.constant.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); // To Call the Parent Class Constructor
		goToWebSite(JSONUtility.readJSON(Env.QA).getUrl());
		maximizeWindow();
	}

	public HomePage(WebDriver driver) {
		super(driver); // To Call the Parent Class Constructor
		goToWebSite(JSONUtility.readJSON(Env.QA).getUrl());
		maximizeWindow();
	}

	public LoginPage goToLoginPage() { // Page Functions
		logger.info("Trying to performing click to  go in sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);

		return new LoginPage(getDriver());
	}

	public void quitBrowser() {
		getDriver().quit();

	}

}
