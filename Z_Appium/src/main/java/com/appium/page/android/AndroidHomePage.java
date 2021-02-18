package com.appium.page.android;

import org.openqa.selenium.WebElement;

import common.Wrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import setup.AbstractPage;

/**
 * The Class AndroidHomePage.
 * 
 * @author chandan.verma
 */
public class AndroidHomePage extends AbstractPage<AndroidHomePage> {

	/** The wrapper. */
	private Wrapper wrapper = new Wrapper();

	/**
	 * Instantiates a new android home page.
	 *
	 * @param driver the driver
	 */
	public AndroidHomePage(AppiumDriver<?> driver) {
		super(driver);
	}

	/** The views option. */
	@AndroidFindBy(accessibility = "Views")
	private WebElement viewsOption;

	/**
	 * Click on views option.
	 *
	 * @return the android view page
	 */
	public AndroidViewPage clickOnViewsOption() {
		wrapper.clickOnElement(viewsOption);
		return new AndroidViewPage(driver);
	}
}