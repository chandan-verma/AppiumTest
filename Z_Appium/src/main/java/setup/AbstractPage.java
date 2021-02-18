package setup;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class AbstractPage<T extends AbstractPage<T>> extends Setup{
	
	public final AppiumDriver<?> driver;

	protected AbstractPage(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

}
