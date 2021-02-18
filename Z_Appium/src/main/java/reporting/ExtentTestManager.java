package reporting;

import java.util.HashMap;
import java.util.Map;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * The Class ExtentTestManager.
 *
 * @author Chandan Verma
 */

public class ExtentTestManager {

	/** The extent test map. */
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	/** The extent. */
	static ExtentReports extent = ExtentManager.getReporter();

	/**
	 * Gets the test.
	 *
	 * @return the test
	 */
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	/**
	 * End test.
	 */
	public static synchronized void endTest() {
		extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
	}

	/**
	 * Start test.
	 *
	 * @param testName the test name
	 * @return the extent test
	 */
	public static synchronized ExtentTest startTest(String testName) {
		return startTest(testName, "");

	}

	/**
	 * Start test.
	 *
	 * @param testName the test name
	 * @param desc     the desc
	 * @return the extent test
	 */
	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.startTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}
