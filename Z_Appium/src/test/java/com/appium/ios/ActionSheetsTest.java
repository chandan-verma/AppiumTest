package com.appium.ios;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.appium.page.ios.ActionSheetsPage;
import com.relevantcodes.extentreports.LogStatus;

import reporting.ExtentTestManager;
import setup.BaseClass;

/**
 * The Class ActionSheetsTest.
 * 
 * @author chandan.verma
 */
public class ActionSheetsTest extends BaseClass {
	static Logger logger = Logger.getLogger(ActionSheetsTest.class);

	/**
	 * Verify ok button functionality test.
	 */
	@Test
	public void verifyOkButtonFunctionalityTest() {
		logger.info("Verify ok button functioonality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify ok button functionality");
		
		ActionSheetsPage actionSheetsPage = iosHomePage
				.clickOnActionSheets()
				.clickOnOkAndCancelButton()
				.clickOnOkButton();
		assertTrue(actionSheetsPage.invisibilityOfOkButton());
	}

	/**
	 * Verify cancel button functionality test.
	 */
	@Test
	public void verifyCancelButtonFunctionalityTest() {
		logger.info("Verify cancel button functioonality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify cancel button functionality");
		
		ActionSheetsPage actionSheetsPage = iosHomePage.clickOnActionSheets().clickOnOkAndCancelButton()
				.clickOnCancelButton();
		assertTrue(actionSheetsPage.invisibilityOfCancelButton());

	}

	/**
	 * Verify destructive choice button functionality test.
	 */
	@Test
	public void verifyDestructiveChoiceButtonFunctionalityTest() {
		logger.info("Verify destructive choice button functionality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify destructive choice button functionality");
		
		ActionSheetsPage actionSheetsPage = iosHomePage.clickOnActionSheets().clickOnOtherButton()
				.clickOnDestructiveChoiceActionButton();
		assertTrue(actionSheetsPage.invisibilityOfDestructiveChoiceActionButton());

	}

	/**
	 * Verify safe choice button functionality test.
	 */
	@Test
	public void verifySafeChoiceButtonFunctionalityTest() {
		logger.info("Verify safe choice button functionality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify safe choice button functionality");
		
		ActionSheetsPage actionSheetsPage = iosHomePage.clickOnActionSheets().clickOnOtherButton()
				.clickOnSafeChoiceActionButton();
		assertTrue(actionSheetsPage.invisibilityOfSafeChoiceActionButton());

	}
}