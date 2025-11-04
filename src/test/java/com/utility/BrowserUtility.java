package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constant.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {

		super();
		this.driver.set(driver);
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for " + browserName);

		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
		}

		else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
		}

		else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
		}

		else {
			logger.error("Invalid Browser Name... Please select Chrome or Edge or Firefox");
			System.err.println("Invalid Browser Name... Please select Chrome or Edge or Firefox Browser ");
		}

	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);

		if (browserName == Browser.CHROME) {

			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}

			else {
				driver.set(new ChromeDriver());
			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));

			}

			else {
				driver.set(new EdgeDriver());
			}
		}

		else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver.set(new FirefoxDriver(options));
			}

			else {

				driver.set(new FirefoxDriver());
			}
		}

		else {
			logger.error("Invalid Browser Name... Please select Chrome or Edge or Firefox");
			System.err.println("Invalid Browser Name... Please select Chrome or Edge or Firefox Browser ");
		}

	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void goToWebSite(String url) {

		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {

		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {

		logger.info("Finding Element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and performing click ");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now enter text " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getText(By locator) {
		logger.info("Finding Element with the locator " + locator);

		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and returning the value  " + element.getText());
		return element.getText();
	}

	public String takeScreenShot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);

		String path =  "./screenshots/" + name + " _ " + timeStamp + ".png";

		File screenschotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenschotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;
	}

}
