package com.appium.page.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Wrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import setup.AbstractPage;

/**
 * The Class AlertViewsPage.
 * 
 * @author chandan.verma
 */
public class AlertViewsPage extends AbstractPage<AlertViewsPage> {

	/** The wrapper. */
	private Wrapper wrapper = new Wrapper();

	/**
	 * Instantiates a new alert views page.
	 *
	 * @param driver the driver
	 */
	public AlertViewsPage(AppiumDriver<?> driver) {
		super(driver);
	}

	/** The simple button. */
	@iOSXCUITFindBy(accessibility = "Simple")
	private WebElement simpleButton;

	/** The ok and cancel button. */
	@iOSXCUITFindBy(accessibility = "Okay / Cancel")
	private WebElement okAndCancelButton;

	/** The other button. */
	@iOSXCUITFindBy(accessibility = "Other")
	private WebElement otherButton;

	/** The simple alert view. */
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='A Short Title Is Best']")
	private WebElement simpleAlertView;

	/** The alert view page title. */
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	private WebElement alertViewPageTitle;

	/** The simple short text by. */
	private By simpleShortTextBy = By.xpath("//XCUIElementTypeStaticText[@name='A Short Title Is Best']");
	
	/** The simple long text by. */
	private By simpleLongTextBy = By
			.xpath("//XCUIElementTypeStaticText[@name='A message should be a short, complete sentence.']");
	
	/** The simple ok button by. */
	private By simpleOkButtonBy = By.xpath("//XCUIElementTypeButton[@name='OK']");

	/**
	 * Gets the page title.
	 *
	 * @return the page title
	 */
	public String getPageTitle() {
		return wrapper.getTextOfElement(alertViewPageTitle);
	}

	/**
	 * Click on simple alert button.
	 *
	 * @return the alert views page
	 */
	public AlertViewsPage clickOnSimpleAlertButton() {
		wrapper.clickOnElement(simpleButton);
		return this;
	}

	/**
	 * Click on ok and cancel alert button.
	 *
	 * @return the alert views page
	 */
	public AlertViewsPage clickOnOkAndCancelAlertButton() {
		wrapper.clickOnElement(okAndCancelButton);
		return this;
	}

	/**
	 * Click on other alert button.
	 *
	 * @return the alert views page
	 */
	public AlertViewsPage clickOnOtherAlertButton() {
		wrapper.clickOnElement(otherButton);
		return this;
	}

	/**
	 * Visibility of simple short text.
	 *
	 * @return true, if successful
	 */
	public boolean visibilityOfSimpleShortText() {
		return wrapper.visibilityOfElement(simpleAlertView, simpleShortTextBy).isDisplayed();
	}

	/**
	 * Visibility of simple long text.
	 *
	 * @return true, if successful
	 */
	public boolean visibilityOfSimpleLongText() {
		return wrapper.visibilityOfElement(simpleAlertView, simpleLongTextBy).isDisplayed();
	}

	/**
	 * Visibility of simple ok button.
	 *
	 * @return true, if successful
	 */
	public boolean visibilityOfSimpleOkButton() {
		return wrapper.visibilityOfElement(simpleAlertView, simpleOkButtonBy).isDisplayed();
	}

	/**
	 * Gets the alert text.
	 *
	 * @return the alert text
	 */
	public String getAlertText() {
		return wrapper.switchToAlert().getText();
	}

	/**
	 * Accept alert.
	 *
	 * @return the alert views page
	 */
	public AlertViewsPage acceptAlert() {
		wrapper.switchToAlert().accept();
		return this;
	}

	/**
	 * Dismiss alert.
	 *
	 * @return the alert views page
	 */
	public AlertViewsPage dismissAlert() {
		wrapper.switchToAlert().dismiss();
		return this;
	}
}
