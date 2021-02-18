package setup;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.LogLevel;

import config.App1Config;
import config.CommonConfig;
import config.ConfigHandler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import reporting.ReportingBaseClassSetup;
import utility.SoftAssertion;

/**
 * The Class Setup.
 */
public class Setup extends ReportingBaseClassSetup {

	/** The driver. */
	public static AppiumDriver<?> driver;

	/** The common configuration. */
	private static CommonConfig commonConfig = null;

	/** The android platform. */
	protected final String androidPlatform = "android";

	/** The ios platform. */
	protected final String iosPlatform = "ios";

	private URL url = null;

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public AppiumDriver<?> getDriver() {
		//if(driver==null) {
		try {
			url = new URL(getProperty().appiumUrl());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if (getPlatform().equalsIgnoreCase(androidPlatform))
			driver = new AndroidDriver<AndroidElement>(url, getCapabilities());
		if (getPlatform().equalsIgnoreCase(iosPlatform))
			driver = new IOSDriver<IOSElement>(url, getCapabilities());
		//}
		return driver;
	}
 
	public String getPlatform() {
		return getProperty().platform();
	}
	
	public DesiredCapabilities getCapabilities() {
		if (getPlatform().equalsIgnoreCase(androidPlatform))
			return capabilitiesForAndroid();
		if (getPlatform().equalsIgnoreCase(iosPlatform))
			return capabilitiesForIos();
		return null;
	}
	/**
	 * Capabilities for ios.
	 *
	 * @return the desired capabilities
	 */
	public DesiredCapabilities capabilitiesForIos() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getProperty().iosDeviceName());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(MobileCapabilityType.APP, getProperty().iosApp());
		return capabilities;
	}

	/**
	 * Root path.
	 *
	 * @return the string
	 */
	public String rootPath() {
		return System.getProperty("user.dir");
	}

	/**
	 * Capabilities for android.
	 *
	 * @return the desired capabilities
	 */
	public DesiredCapabilities capabilitiesForAndroid() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getProperty().androidDeviceName());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		capabilities.setCapability(MobileCapabilityType.APP, rootPath() + getProperty().androidApp());
		return capabilities;
	}

	/**
	 * Gets the wait.
	 *
	 * @return the wait
	 */
	public WebDriverWait getWait() {
		return new WebDriverWait(driver, 10);
	}

	/**
	 * Setup.
	 */
	@BeforeSuite
	public void setup() {
		commonConfig = ConfigHandler.buildConfig("config.app1.properties");
	}

	/**
	 * Gets the property.
	 *
	 * @return the property
	 */
	public App1Config getProperty() {
		return commonConfig.getAppConfig();
	}

	/**
	 * Assert all.
	 */
	@AfterMethod
	public void assertAll() {
		SoftAssertion.getSoftAssertion().assertAll();
	}

	/**
	 * Load logger file.
	 */
	@BeforeSuite(alwaysRun = true)
	public void loadLoggerFile() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
		DOMConfigurator.configure("resource/logger.xml");
	}
	AppiumDriverLocalService appiumDriverLocalService ;
	
	public void startAppium() {
		if(!isAppiumServerRunning(getProperty().appiumPort())) {
			AppiumServiceBuilder builder;
			builder = new AppiumServiceBuilder();
			builder.usingPort(getProperty().appiumPort());
			builder.withAppiumJS(new File("/usr/local/bin/appium"));
			builder.withCapabilities(getCapabilities());
			builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			builder.withArgument(GeneralServerFlag.LOG_LEVEL, LogLevel.ERROR.name());
			appiumDriverLocalService = AppiumDriverLocalService.buildService(builder);
			appiumDriverLocalService.start();
		}
	}
	
	public void stopAppium() {
		appiumDriverLocalService.stop();
	}
	
	public boolean isAppiumServerRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			 serverSocket = new ServerSocket(port);
			 serverSocket.close();
		} catch (IOException e) {
			isServerRunning=true;
			e.printStackTrace();
		}
		finally {
			serverSocket = null;
		}
		
		return isServerRunning;
	}
}
