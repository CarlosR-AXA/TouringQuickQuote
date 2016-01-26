package es.crd.tests.touring;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestUtils.class);

	/**
	 * Wait for an element to be visible.
	 *
	 * @param by
	 *            The location of the element you want to wait.
	 * @param driver
	 *            The WebDriver of the test.
	 * @return A visible element ready to be worked with.
	 */
	public WebElement waitVisibilityOf(final By by, final WebDriver driver) {
		WebElement element = null;
		final WebDriverWait wait = new WebDriverWait(driver, 60);

		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (final NotFoundException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
		return element;
	}

	/**
	 * Wait for an element to be available to click or send keys.
	 *
	 * @param myElement
	 *            The element you want to wait.
	 * @param driver
	 *            The WebDriver of the test.
	 * @return An available element ready to be worked with.
	 */
	public WebElement waitAvailabilityOf(final WebElement myElement, final WebDriver driver) {
		WebElement element = null;
		final WebDriverWait wait = new WebDriverWait(driver, 60);

		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(myElement));
		} catch (final NotFoundException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
		return element;
	}
}