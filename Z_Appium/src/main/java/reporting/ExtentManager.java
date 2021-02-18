package reporting;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * The Class ExtentManager.
 *
 * @author Chandan Verma
 */
public class ExtentManager {

	/** The extent. */
	static ExtentReports extent;

	/** The Constant filePath. */
	final static String filePath = "./test-output/html/Extent.html";

	/**
	 * Gets the reporter.
	 *
	 * @return the reporter
	 */
	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			extent = new ExtentReports(filePath, true);
		}
		return extent;
	}
}
