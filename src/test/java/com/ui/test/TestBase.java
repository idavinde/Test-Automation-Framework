package com.ui.test;

import com.constant.Browser;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	protected Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest ;
	
	
	@Parameters({"browser","isLambdaTest", "isHeadless"})
	@BeforeMethod(description = "Load the homepage of the website")
	public void setup(
			@Optional("chrome")String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadless,ITestResult result) {
		
		logger.info("Load the HomePage of Website");
		
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;

		if (isLambdaTest) {

			lambdaDriver = LambdaTestUtility.intializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {

		return homePage;
	}
	
	@AfterMethod
	public void tearDown() {

		if (isLambdaTest) {

			LambdaTestUtility.quitSession();
		}

		else {

			homePage.quitBrowser();
		}
	}
}
