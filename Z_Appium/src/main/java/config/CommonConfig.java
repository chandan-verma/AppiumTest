package config;

/**
 * The Class CommonConfig.
 */
public class CommonConfig {

	/** The app 1 config. */
	private final App1Config app1Config;

	/**
	 * Instantiates a new common config.
	 *
	 * @param config the config
	 */
	public CommonConfig(App1Config config) {
		this.app1Config = config;
	}

	/**
	 * Gets the app config.
	 *
	 * @return the app config
	 */
	public App1Config getAppConfig() {
		return app1Config;
	}
}
