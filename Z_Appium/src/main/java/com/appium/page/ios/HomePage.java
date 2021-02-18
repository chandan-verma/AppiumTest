package com.appium.page.ios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import common.Wrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import setup.AbstractPage;

/**
 * The Class HomePage.
 * 
 * @author chandan.verma
 */
public class HomePage extends AbstractPage<HomePage> {

	/** The wrapper. */
	private Wrapper wrapper = new Wrapper();

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	public HomePage(AppiumDriver<?> driver) {
		super(driver);
	}

	/** The Buttons. */
	@iOSXCUITFindBy(id = "Buttons")
	private WebElement Buttons;

	/** The ui catalog title. */
	@iOSXCUITFindBy(xpath = ".//XCUIElementTypeStaticText[@name='UICatalog']")
	private WebElement uiCatalogTitle;

	/** The action sheets. */
	@iOSXCUITFindBy(accessibility = "Action Sheets")
	private WebElement actionSheets;

	/** The alert views. */
	@iOSXCUITFindBy(accessibility = "Alert Views")
	private WebElement alertViews;

	/** The option list. */
	By optionList = By.xpath("//XCUIElementTypeStaticText");

	/**
	 * Gets the ui catalog title text.
	 *
	 * @return the ui catalog title text
	 */
	public String getUiCatalogTitleText() {
		return wrapper.getTextOfElement(uiCatalogTitle);
	}

	/**
	 * Gets the text of all options.
	 *
	 * @return the text of all options
	 */
	public List<String> getTextOfAllOptions() {
		return wrapper.getTextOfAllElements(optionList, 20);
	}

	/**
	 * Gets the text of all sub options.
	 *
	 * @return the text of all sub options
	 */
	public List<String> getTextOfAllSubOptions() {
		return wrapper.getTextOfAllElements(optionList, 14);
	}

	/**
	 * Click on action sheets.
	 *
	 * @return the action sheets page
	 */
	public ActionSheetsPage clickOnActionSheets() {
		wrapper.clickOnElement(actionSheets);
		return new ActionSheetsPage(driver);
	}

	/**
	 * Click on alert views.
	 *
	 * @return the alert views page
	 */
	public AlertViewsPage clickOnAlertViews() {
		wrapper.clickOnElement(alertViews);
		return new AlertViewsPage(driver);
	}
	
	
	/**
	 * Verify all option.
	 *
	 * @param actualList the actual list
	 * @param expectedList the expected list
	 */
	public void verifyAllOption(List<String> actualList, List<String> expectedList)
	{
		for (String expected : expectedList) {
			Assert.assertEquals(expected, actualList.get(expectedList.indexOf(expected)));
		}
	}
}
