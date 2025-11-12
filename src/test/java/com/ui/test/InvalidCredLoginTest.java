package com.ui.test;

import static com.constant.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listners.TestListner.class)
public class InvalidCredLoginTest extends TestBase {

	private static final String INVALID_EMAIL_ADDRESS="jdasd@gmail.com";
	private static final String INVALID_PASSWORD="Qweerty";
	@Test(description = "Verify if the proprer error message shown  for the user when they enter invalid credentials", groups = { "e2e",
			"smoke" })
	public void loginTest() {

		 assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage(), "Authentication failed.");

	}

	

}
