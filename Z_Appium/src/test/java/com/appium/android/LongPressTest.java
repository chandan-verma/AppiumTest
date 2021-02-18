package com.appium.android;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.appium.page.android.AndroidViewPage;
import com.relevantcodes.extentreports.LogStatus;

import reporting.ExtentTestManager;
import setup.BaseClass;

/**
 * The Class LongPressTest.
 * 
 * @author chandan.verma
 */
public class LongPressTest extends BaseClass {
	static Logger logger = Logger.getLogger(LongPressTest.class);

	/**
	 * Android long press test.
	 */
	@Test
	public void androidLongPressTest() {
		logger.info("Long press test for android");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Long press test for android");
		
		AndroidViewPage androidViewPage = androidHomePage.clickOnViewsOption().clickOnExpandableListsOption()
				.clickOnCustomAdapterOption().longPressOnPeopleName();

		Assert.assertTrue(androidViewPage.isListDisplayed());
	}
}