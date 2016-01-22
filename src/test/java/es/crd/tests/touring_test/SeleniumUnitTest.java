package es.crd.tests.touring_test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumUnitTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumUnitTest.class);
	private WebDriverWait wait = new WebDriverWait(driver, 20);
	Actions actions = new Actions(driver);
	private static FirefoxDriver driver;
	private WebElement element;
	private long timer;
	private long elapsedTime;

	private WebElement waitAndGetResultElement(By by) {
		try {
			element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		} catch (NotFoundException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
		return element;
	}

	@BeforeClass
	public static void openBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(Constants.TOURING_ULR);
	}

	@Test
	public void quickQuoteTest() {
		// ========== Step 1: Age test==========
		timer = System.currentTimeMillis();

		element = driver.findElement(By.name(Constants.NAME_AGE));
		element.sendKeys(Constants.STEP_1_EXPECTED_AGE);
		element.sendKeys(Keys.ENTER);

		element = waitAndGetResultElement(By.xpath(Constants.XPATH_AGE + Constants.XPATH_GENERIC));
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_1_EXPECTED_AGE,
				element.getText());
		assertEquals(Constants.STEP_1_EXPECTED_AGE, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Age test took {} ms to complete ===", elapsedTime);
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
