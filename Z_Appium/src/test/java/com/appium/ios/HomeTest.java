package com.appium.ios;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import common.Constant;
import common.Wrapper;
import reporting.ExtentTestManager;
import setup.BaseClass;

/**
 * The Class HomeTest.
 * 
 * @author chandan.verma
 */
public class HomeTest extends BaseClass {
	static Logger logger = Logger.getLogger(HomeTest.class);

	/**
	 * Verify home control availability test.
	 */
	@Test
	public void verifyHomeControlAvailabilityTest() {
		logger.info("Verify home control availablity");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify home control availablity");
		
		assertEquals(iosHomePage.getUiCatalogTitleText(), Constant.uiCatalog);
		iosHomePage.verifyAllOption(iosHomePage.getTextOfAllOptions(), Constant.options);
		iosHomePage.verifyAllOption(iosHomePage.getTextOfAllSubOptions(), Constant.subOptions);
	}

	/**
	 * Verify action sheets tab functionality test.
	 */
	@Test
	public void verifyActionSheetsTabFunctionalityTest() {
		logger.info("Verify action sheet functionality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify action sheet functionality");
		
		String actionSheetsPageTitle = iosHomePage.clickOnActionSheets().getPageTitle();
		assertEquals(actionSheetsPageTitle, Constant.actionSheets);

	}

	/**
	 * Verify alert views tab functionality test.
	 */
	@Test
	public void verifyAlertViewsTabFunctionalityTest() {
		logger.info("Verify alert views tab functionality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify alert views tab functionality");
		
		String alertViewsPageTitle = iosHomePage.clickOnAlertViews().getPageTitle();
		assertEquals(alertViewsPageTitle, Constant.alertViews);

	}

	/**
	 * Verify back button functionality test.
	 */
	@Test
	public void verifyBackButtonFunctionalityTest() {
		logger.info("Verify back button functionality");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify back button functionality");
		
		String actionSheetsPageTitle = iosHomePage.clickOnActionSheets().getPageTitle();
		assertEquals(actionSheetsPageTitle, Constant.actionSheets);
		new Wrapper().clickOnBackButton();
		assertEquals(iosHomePage.getUiCatalogTitleText(), Constant.uiCatalog);
	}
}