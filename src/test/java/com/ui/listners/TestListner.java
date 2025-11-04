package com.ui.listners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListner implements ITestListener{
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	
	@Override
	public void onTestStart(ITestResult result) {
			logger.info(result.getMethod().getMethodName());
			logger.info(result.getMethod().getDescription());
			logger.info(Arrays.toString(result.getMethod().getGroups()));
			ExtentReportUtility.creatExtentTest(result.getMethod().getMethodName());
			
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+" "+ "PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" "+ "PASSED");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+" "+ "FAILED");
		logger.info(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" "+ "FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		
		Object testclass = result.getInstance();
		
		BrowserUtility browserUtility =((TestBase)testclass).getInstance();
		logger.info("Capturing Screenshot for the failed tests");
		
		String screenshotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		logger.info("Attaching Screenshot to the HTML File");
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+" "+ "SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" "+ "SKIPPED");
	}
	
	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReportUtility.setUpSparkReporter("/report.html");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReportUtility.flushReport();
	}
	
	
}
