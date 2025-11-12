package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constant.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {

	private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
	private static final By COLOUR_TO_PICK_LOCATOR = By.id("color_14");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//a[@title=\"Proceed to checkout\"]");

	public ProductDetailPage(WebDriver driver) {

		super(driver);
	}

	public ProductDetailPage changeSize(Size size) {

		selectDropdownByVisibleText(SIZE_DROP_DOWN_LOCATOR, size.toString());
		return new ProductDetailPage(getDriver());
	}

	public ProductDetailPage changeColour() {

		clickOn(COLOUR_TO_PICK_LOCATOR);
		return new ProductDetailPage(getDriver());
	}

	public ProductDetailPage addProductToCart() {

		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		
		return new ProductDetailPage(getDriver());
	}

	public ShoppingCartPage proceedToCheckOut() {

		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		
		return new ShoppingCartPage(getDriver());
	}

}
