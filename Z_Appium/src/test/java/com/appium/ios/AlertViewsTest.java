package com.appium.ios;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.appium.page.ios.AlertViewsPage;
import com.relevantcodes.extentreports.LogStatus;

import reporting.ExtentTestManager;
import setup.BaseClass;

/**
 * The Class AlertViewsTest.
 * 
 * @author chandan.verma
 */
public class AlertViewsTest extends BaseClass {
	static Logger logger = Logger.getLogger(AlertViewsTest.class);

	/**
	 * Verify simple alert view test.
	 */
	@Test
	public void verifySimpleAlertViewTest() {
		logger.info("Verify simple alert functionality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify simple alert functionality");
		
		AlertViewsPage alertViewsPage = iosHomePage.clickOnAlertViews().clickOnSimpleAlertButton();

		assertTrue(alertViewsPage.visibilityOfSimpleShortText());
		assertTrue(alertViewsPage.visibilityOfSimpleLongText());
		assertTrue(alertViewsPage.visibilityOfSimpleOkButton());

		assertEquals(alertViewsPage.getAlertText(),
				"A Short Title Is Best\nA message should be a short, complete sentence.");
		alertViewsPage.acceptAlert();
	}

	/**
	 * Verify ok and cancel alert view test.
	 */
	@Test
	public void verifyOkAndCancelAlertViewTest() {
		logger.info("Verify ok and cancel alert functionality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify ok and cancel alert functionality");
		
		AlertViewsPage alertViewsPage = iosHomePage.clickOnAlertViews().clickOnOkAndCancelAlertButton();

		assertEquals(alertViewsPage.getAlertText(),
				"A Short Title Is Best\nA message should be a short, complete sentence.");
		alertViewsPage.acceptAlert().clickOnOkAndCancelAlertButton().dismissAlert();
	}

	/**
	 * Verify other alert view test.
	 */
	@Test
	public void verifyOtherAlertViewTest() {
		logger.info("Verify other alert functionality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify other alert functionality");
		
		AlertViewsPage alertViewsPage = iosHomePage.clickOnAlertViews().clickOnOtherAlertButton();

		assertEquals(alertViewsPage.getAlertText(),
				"A Short Title Is Best\nA message should be a short, complete sentence.");
		alertViewsPage.acceptAlert().clickOnOtherAlertButton().dismissAlert();
	}
}