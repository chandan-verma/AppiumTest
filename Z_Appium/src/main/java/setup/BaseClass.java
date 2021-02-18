package setup;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import com.appium.page.android.AndroidHomePage;
import com.appium.page.ios.HomePage;
import com.relevantcodes.extentreports.LogStatus;

import reporting.ExtentTestManager;

/**
 * The Class BaseClass.
 * 
 * @author chandan.verma
 */
public class BaseClass extends Setup {

	/** The home page. */
	public HomePage iosHomePage;
	
	/** The touch and hold page. */
	public AndroidHomePage androidHomePage;
	
	static Logger logger = Logger.getLogger(BaseClass.class);


	/**
	 * Inits the home page.
	 */
	@BeforeClass
	public void initHomePage() {
		logger.info("Initialized the home page object");
		//ExtentTestManager.getTest().log(LogStatus.INFO, "Initialized the home page object");

		if(getPlatform().equalsIgnoreCase(iosPlatform))
			iosHomePage = new HomePage(getDriver());

		if(getPlatform().equalsIgnoreCase(androidPlatform))
			androidHomePage = new AndroidHomePage(getDriver());
	}
}