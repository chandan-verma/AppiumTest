package common;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import setup.Setup;


/**
 * The Class Wrapper.
 * 
 * @author chandan.verma
 */
public class Wrapper extends Setup {

	private Actions actions = null ;
	private TouchAction<?> touchActions = null ;


	/**
	 * Gets the text of element.
	 *
	 * @param element the element
	 * @return the text of element
	 */
	public  String getTextOfElement(WebElement element) {
		return visibilityOfElement(element).getText();
	}

	/**
	 * Gets the text of all element.
	 *
	 * @param locator the locator
	 * @return the text of all element
	 */
	public List<String> getTextOfAllElement(By locator) {
		return getAllElement(locator).stream().map(e -> e.getText())
				.collect(Collectors.toList());
	}
	
	/**
	 * Gets the text of all element.
	 *
	 * @param locator the locator
	 * @param attributeValue the attribute value
	 * @return the text of all element
	 */
	public List<String> getTextOfAllElement(By locator, int attributeValue) {
		return getAllElement(locator)
				.stream().filter(h->h.getSize().height==attributeValue).map(e->e.getText()).collect(Collectors.toList());
	}
	
	/**
	 * Gets the all element.
	 *
	 * @param locator the locator
	 * @return the all element
	 */
	public List<WebElement> getAllElement(By locator) {
		return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * Gets the text of all elements.
	 *
	 * @param locator the locator
	 * @param attributeValue the attribute value
	 * @return the text of all elements
	 */
	public List<String> getTextOfAllElements(By locator, int attributeValue) {
		return driver.findElements(locator)
				.stream().filter(h->h.getSize().height==attributeValue).map(e->e.getText()).collect(Collectors.toList());
	}
	
	
	/**
	 * Gets the text of all elements.
	 *
	 * @param attributeValue the attribute value
	 * @param locator the locator
	 * @return the text of all elements
	 */
	public List<String> getTextOfAllElements( int attributeValue,WebElement... locator) {
		return getWait().until(ExpectedConditions.visibilityOfAllElements(locator[0]))
				.stream().filter(h->h.getSize().height==attributeValue).map(e->e.getText()).collect(Collectors.toList());
	}
	
	/**
	 * Visibility of element.
	 *
	 * @param element the element
	 * @return the web element
	 */
	public WebElement visibilityOfElement(WebElement element) {
		return getWait().until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Checks if is element displayed.
	 *
	 * @param element the element
	 * @return true, if is element displayed
	 */
	public boolean isElementDisplayed(WebElement element) {
		return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}
	
	/**
	 * Visibility of element.
	 *
	 * @param locator the locator
	 * @return true, if successful
	 */
	public boolean visibilityOfElement(String locator) {
		return getAndroidDriver().findElementByAndroidUIAutomator(locator).isDisplayed();
	}
	
	
	/**
	 * Visibility of element.
	 *
	 * @param element the element
	 * @return the web element
	 */
	public WebElement visibilityOfElement(By element) {
		return getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	/**
	 * Visibility of element.
	 *
	 * @param element the element
	 * @param childLocator the child locator
	 * @return the web element
	 */
	public WebElement visibilityOfElement(WebElement element, By childLocator) {
		return getWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, childLocator));
	}
	
	/**
	 * Click on element.
	 *
	 * @param element the element
	 */
	public void clickOnElement(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element)).click();
	}
	
	/**
	 * Tap on element.
	 *
	 * @param element the element
	 */
	public void tapOnElement(WebElement element) {
		getTouchActionObject().tap(tapOptions().withElement(element(element))).perform();
	}
	
	/**
	 * Invisibility of element.
	 *
	 * @param element the element
	 * @return true, if successful
	 */
	public boolean invisibilityOfElement(WebElement element) {
		return getWait().until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * Switch to alert.
	 *
	 * @return the alert
	 */
	public Alert switchToAlert() {
		return getWait().until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * Click on back button.
	 */
	public void clickOnBackButton() {
		driver.navigate().back();
	}
	
	/**
	 * Gets the actions object.
	 *
	 * @return the actions object
	 */
	public Actions getActionsObject() {
		if(actions==null) {
		return new Actions(getAndroidDriver());
		}
		return actions;
	}
	
	/**
	 * Gets the touch action object.
	 *
	 * @return the touch action object
	 */
	public TouchAction<?> getTouchActionObject() {
		if(touchActions==null)
		return new TouchAction(getAndroidDriver());
		return touchActions;
	}
	
	/**
	 * Gets the android driver.
	 *
	 * @return the android driver
	 */
	public AndroidDriver<?> getAndroidDriver() {
		return (AndroidDriver<?>)driver;
	}
	
	public IOSDriver<?> getIosDriver() {
		return (IOSDriver<?>)driver;
	}
	/**
	 * Find by ui automator.
	 *
	 * @param locator the locator
	 * @return the android element
	 */
	public AndroidElement findByUiAutomator(String locator) {
		return (AndroidElement) getAndroidDriver().findElementByAndroidUIAutomator(locator);
	}
	
	/**
	 * Long press.
	 *
	 * @param element the element
	 */
	public void longPress(WebElement element, int sec) {
		getTouchActionObject().longPress(longPressOptions()
				.withElement(element(element)).withDuration(Duration.ofSeconds(sec))).release().perform();
	}
	
	/**
	 * Scroll to view.
	 *
	 * @param locator the locator
	 * @return the android element
	 */
	public AndroidElement scrollToView(String locator) {
		return (AndroidElement)getAndroidDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+locator+");");
	}
	
	/**
	 * Drag and drop.
	 *
	 * @param source the source
	 * @param destination the destination
	 */
	public void dragAndDrop(WebElement source, WebElement destination) {
		getTouchActionObject().longPress(longPressOptions()
				.withElement(element(source))).moveTo(element(destination)).release().perform();
	}
}
