package config;

/**
 * The Interface App1Config.
 */
public interface App1Config {

	/**
	 * Platform.
	 *
	 * @return the string
	 */
	String platform();

	/**
	 * Appium url.
	 *
	 * @return the string
	 */
	String appiumUrl();

	/**
	 * Ios device name.
	 *
	 * @return the string
	 */
	String iosDeviceName();

	/**
	 * Android device name.
	 *
	 * @return the string
	 */
	String androidDeviceName();

	/**
	 * Android app.
	 *
	 * @return the string
	 */
	String androidApp();

	/**
	 * Ios app.
	 *
	 * @return the string
	 */
	String iosApp();
	
	/**
	 * Appium port.
	 *
	 * @return the int
	 */
	int appiumPort();
}
