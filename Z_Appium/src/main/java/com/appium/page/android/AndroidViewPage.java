package com.appium.page.android;

import org.openqa.selenium.WebElement;

import common.Wrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import setup.AbstractPage;

/**
 * The Class AndroidViewPage.
 * 
 * @author chandan.verma
 */
public class AndroidViewPage extends AbstractPage<AndroidViewPage> {

	/** The wrapper. */
	private Wrapper wrapper = new Wrapper();

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	public AndroidViewPage(AppiumDriver<?> driver) {
		super(driver);
	}

	/** The expandable lists option. */
	@AndroidFindBy(accessibility = "Expandable Lists")
	private WebElement expandableListsOption;

	/** The drag and drop option. */
	@AndroidFindBy(accessibility = "Drag and Drop")
	private WebElement dragAndDropOption;

	/** The custom adapter. */
	@AndroidFindBy(accessibility = "1. Custom Adapter")
	private WebElement customAdapter;

	/** The people names. */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
	private WebElement peopleNames;

	/** The locator for list. */
	private String locatorForList = "text(\"Sample action\")";

	/** The locator for scroll bars. */
	private String locatorForScrollBars = "text(\"ScrollBars\")";

	/** The red source dot. */
	@AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
	private WebElement redSourceDot;

	/** The red destination dot. */
	@AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_2")
	private WebElement redDestinationDot;

	/** The drag and drop confirmation text. */
	@AndroidFindBy(id = "io.appium.android.apis:id/drag_text")
	private WebElement dragAndDropConfirmationText;

	/**
	 * Click on expandable lists option.
	 *
	 * @return the android view page
	 */
	public AndroidViewPage clickOnExpandableListsOption() {
		wrapper.clickOnElement(expandableListsOption);
		return this;
	}

	/**
	 * Click on custom adapter option.
	 *
	 * @return the android view page
	 */
	public AndroidViewPage clickOnCustomAdapterOption() {
		wrapper.tapOnElement(customAdapter);
		return this;
	}

	/**
	 * Long press on people name.
	 *
	 * @return the android view page
	 */
	public AndroidViewPage longPressOnPeopleName() {
		wrapper.longPress(peopleNames,2);
		return this;
	}

	/**
	 * Checks if is list displayed.
	 *
	 * @return true, if is list displayed
	 */
	public boolean isListDisplayed() {
		return wrapper.findByUiAutomator(locatorForList).isDisplayed();
	}

	/**
	 * Scroll to scroll bars.
	 *
	 * @return the android view page
	 */
	public AndroidViewPage scrollToScrollBars() {
		wrapper.scrollToView(locatorForScrollBars);
		return this;
	}

	/**
	 * Checks if is scroll bars displayed.
	 *
	 * @return true, if is scroll bars displayed
	 */
	public boolean isScrollBarsDisplayed() {
		return wrapper.visibilityOfElement(locatorForScrollBars);
	}

	/**
	 * Checks if is drag and drop confirmation text displayed.
	 *
	 * @return true, if is drag and drop confirmation text displayed
	 */
	public boolean isDragAndDropConfirmationTextDisplayed() {
		return wrapper.isElementDisplayed(dragAndDropConfirmationText);
	}

	/**
	 * Click on drag and drop option.
	 *
	 * @return the android view page
	 */
	public AndroidViewPage clickOnDragAndDropOption() {
		wrapper.clickOnElement(dragAndDropOption);
		return this;
	}

	/**
	 * Red dot drag and drop.
	 *
	 * @return the android view page
	 */
	public AndroidViewPage redDotDragAndDrop() {
		wrapper.dragAndDrop(redSourceDot, redDestinationDot);
		return this;
	}
}
