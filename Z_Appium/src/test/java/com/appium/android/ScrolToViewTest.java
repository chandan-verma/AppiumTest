package com.appium.android;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.appium.page.android.AndroidViewPage;
import com.relevantcodes.extentreports.LogStatus;

import reporting.ExtentTestManager;
import setup.BaseClass;

/**
 * The Class ScrolToViewTest.
 * 
 * @author chandan.verma
 */
public class ScrolToViewTest extends BaseClass {
	static Logger logger = Logger.getLogger(ScrolToViewTest.class);

	/**
	 * Android scroll to view test.
	 */
	@Test
	public void androidScrollToViewTest() {
		logger.info("Scroll to view test");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Scroll to view test");
		
		AndroidViewPage androidViewPage = androidHomePage.clickOnViewsOption()
		.scrollToScrollBars();
		
		Assert.assertTrue(androidViewPage.isScrollBarsDisplayed());
	}
}