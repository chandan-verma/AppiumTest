package com.appium.android;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.appium.page.android.AndroidViewPage;
import com.relevantcodes.extentreports.LogStatus;

import reporting.ExtentTestManager;
import setup.BaseClass;
import utility.SoftAssertion;

/**
 * The Class DragAndDropTest.
 * 
 * @author chandan.verma
 */
public class DragAndDropTest extends BaseClass {
	static Logger logger = Logger.getLogger(DragAndDropTest.class);
	/**
	 * Android long press test.
	 */
	@Test
	public void androidDragAndDropTest() {
		logger.info("Drag and drop test for android");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Drag and drop test for android");
		
		AndroidViewPage androidViewPage = androidHomePage.clickOnViewsOption().clickOnDragAndDropOption()
				.redDotDragAndDrop();

		SoftAssertion.assertTrue(androidViewPage.isDragAndDropConfirmationTextDisplayed());
	}
}