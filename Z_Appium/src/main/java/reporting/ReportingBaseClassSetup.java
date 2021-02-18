package reporting;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setup.Setup;

/**
 * The Class ReportingBaseClassSetup.
 *
 * @author Chandan Verma
 */
public abstract class ReportingBaseClassSetup {

	/** The test. */
	ExtentTest test;

	/**
	 * Before method.
	 *
	 * @param method the method
	 */
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		ExtentTestManager.startTest(method.getName());
	}

	/**
	 * After method.
	 *
	 * @param result the result
	 */
	@AfterMethod(alwaysRun = true)
	protected void afterMethod(ITestResult result) {
		switch (result.getStatus()) {
		case ITestResult.FAILURE:
			ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
			File screenShotPath = ((TakesScreenshot) Setup.driver).getScreenshotAs(OutputType.FILE);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Snapshot below: "
					+ ExtentTestManager.getTest().addScreenCapture(screenShotPath.getAbsolutePath()));
			break;
		case ITestResult.SKIP:
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
			break;
		default:
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
			break;
		}
		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
		ExtentManager.getReporter().flush();
	}
}
