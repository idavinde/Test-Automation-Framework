package com.ui.test.dataprovider;

import static com.constant.Browser.*;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.ui.test.TestBase;

public class LoginTestCSVDataProvider extends TestBase {
	HomePage homePage;
	
	
	
	
	@Test(description="Verify if the valid user is able to login into the application", groups= {"e2e","dataprovider"}
	      , dataProviderClass= com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider" )
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Dav Raj");
	}
	
	@AfterMethod 
	public void tearDown() {
	    if (homePage != null) {
	        homePage.quitBrowser();  // close browser after each iteration
	    }
}
	
}
