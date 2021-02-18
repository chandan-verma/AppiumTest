package com.appium.page.ios;

import org.openqa.selenium.WebElement;

import common.Wrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import setup.AbstractPage;

/**
 * The Class ActionSheetsPage.
 * 
 * @author chandan.verma
 */
public class ActionSheetsPage extends AbstractPage<ActionSheetsPage> {

	/** The wrapper. */
	private Wrapper wrapper = new Wrapper();

	/**
	 * Instantiates a new action sheets page.
	 *
	 * @param driver the driver
	 */
	public ActionSheetsPage(AppiumDriver<?> driver) {
		super(driver);
		// TODO validation to confirm the page or throw the exception
	}

	/** The Ok and cancel button. */
	@iOSXCUITFindBy(iOSNsPredicate = "label == 'Okay / Cancel'")
	private WebElement OkAndCancelButton;

	/** The other button. */
	@iOSXCUITFindBy(id = "Other")
	private WebElement otherButton;

	/** The action sheets page title. */
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	private WebElement actionSheetsPageTitle;

	/** The ok action button. */
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement okActionButton;

	/** The safe choice action button. */
	@iOSXCUITFindBy(accessibility = "Safe Choice")
	private WebElement safeChoiceActionButton;

	/** The destructive choice action button. */
	@iOSXCUITFindBy(accessibility = "Destructive Choice")
	private WebElement destructiveChoiceActionButton;

	/** The cancel action button. */
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement cancelActionButton;

	/**
	 * Gets the page title.
	 *
	 * @return the page title
	 */
	public String getPageTitle() {
		return wrapper.getTextOfElement(actionSheetsPageTitle);
	}

	/**
	 * Click on ok and cancel button.
	 *
	 * @return the action sheets page
	 */
	public ActionSheetsPage clickOnOkAndCancelButton() {
		wrapper.clickOnElement(OkAndCancelButton);
		return this;
	}

	/**
	 * Click on other button.
	 *
	 * @return the action sheets page
	 */
	public ActionSheetsPage clickOnOtherButton() {
		wrapper.clickOnElement(otherButton);
		return this;
	}

	/**
	 * Click on ok button.
	 *
	 * @return the action sheets page
	 */
	public ActionSheetsPage clickOnOkButton() {
		wrapper.clickOnElement(okActionButton);
		return this;
	}

	/**
	 * Click on cancel button.
	 *
	 * @return the action sheets page
	 */
	public ActionSheetsPage clickOnCancelButton() {
		wrapper.clickOnElement(cancelActionButton);
		return this;
	}

	/**
	 * Invisibility of ok button.
	 *
	 * @return true, if successful
	 */
	public boolean invisibilityOfOkButton() {
		return wrapper.invisibilityOfElement(okActionButton);
	}

	/**
	 * Invisibility of cancel button.
	 *
	 * @return true, if successful
	 */
	public boolean invisibilityOfCancelButton() {
		return wrapper.invisibilityOfElement(cancelActionButton);
	}

	/**
	 * Click on safe choice action button.
	 *
	 * @return the action sheets page
	 */
	public ActionSheetsPage clickOnSafeChoiceActionButton() {
		wrapper.clickOnElement(safeChoiceActionButton);
		return this;
	}

	/**
	 * Click on destructive choice action button.
	 *
	 * @return the action sheets page
	 */
	public ActionSheetsPage clickOnDestructiveChoiceActionButton() {
		wrapper.clickOnElement(destructiveChoiceActionButton);
		return this;
	}

	/**
	 * Invisibility of safe choice action button.
	 *
	 * @return true, if successful
	 */
	public boolean invisibilityOfSafeChoiceActionButton() {
		return wrapper.invisibilityOfElement(safeChoiceActionButton);
	}

	/**
	 * Invisibility of destructive choice action button.
	 *
	 * @return true, if successful
	 */
	public boolean invisibilityOfDestructiveChoiceActionButton() {
		return wrapper.invisibilityOfElement(destructiveChoiceActionButton);
	}
}