package es.crd.tests.touring_test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumUnitTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumUnitTest.class);
	private static FirefoxDriver driver = null;
	private WebElement element = null;
	private long timer = 0L;
	private long elapsedTime = 0L;
	private TestUtils utils = new TestUtils();
	

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

		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_AGE + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_1_EXPECTED_AGE,
				element.getText());
		assertEquals(Constants.STEP_1_EXPECTED_AGE, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Age test took {} ms to complete ===", elapsedTime);

		// ========== Step 2: BM Test==========
		timer = System.currentTimeMillis();

		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_BUTTON), driver);
		while (element.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_BM + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_2_EXPECTED_BM,
				element.getText());
		assertEquals(Constants.STEP_2_EXPECTED_BM, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== BM test took {} ms to complete ===", elapsedTime);

		// ========== Step 3: Postal code Test==========
		timer = System.currentTimeMillis();

		element = utils.waitAndGetResultElement(By.name(Constants.NAME_POSTAL_CODE), driver);
		element.sendKeys(Constants.STEP_3_EXPECTED_POSTAL_CODE);
		element.sendKeys(Keys.ENTER);

		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_POSTAL_CODE + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_3_EXPECTED_POSTAL_CODE,
				element.getText());
		assertEquals(Constants.STEP_3_EXPECTED_POSTAL_CODE, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Postal code test took {} ms to complete ===", elapsedTime);

		// ========== Step 4: Brand Test==========
		timer = System.currentTimeMillis();

		element = utils.waitAndGetResultElement(By.className(Constants.CLASS_ALL_BRANDS), driver);
		while (element.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}

		element = utils.waitAndGetResultElement(By.className(Constants.CLASS_TACK), driver);
		while (element.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}

		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_BRAND + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_4_EXPECTED_BRAND,
				element.getText());
		assertEquals(Constants.STEP_4_EXPECTED_BRAND, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Brand test took {} ms to complete ===", elapsedTime);

		// ========== Step 5: Price test==========
		timer = System.currentTimeMillis();

		element = driver.findElement(By.name(Constants.NAME_PRICE));
		element.sendKeys(Constants.STEP_5_EXPECTED_PRICE);
		element.sendKeys(Keys.ENTER);

		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_PRICE + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_5_EXPECTED_PRICE,
				element.getText());
		assertEquals(Constants.STEP_5_EXPECTED_PRICE, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Price test took {} ms to complete ===", elapsedTime);

		// ========== Step 6: KM Test==========
		timer = System.currentTimeMillis();

		element = utils.waitAndGetResultElement(By.name(Constants.NAME_KM), driver);
		while (element.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_KM + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_6_EXPECTED_KM,
				element.getText());
		assertEquals(Constants.STEP_6_EXPECTED_KM, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== KM test took {} ms to complete ===", elapsedTime);

		// ========== Step 7: Email test==========
		timer = System.currentTimeMillis();

		element = driver.findElement(By.name(Constants.NAME_EMAIL));
		element.sendKeys(Constants.STEP_7_MAIL);

		element = utils.waitAndGetResultElement(By.className(Constants.CLASS_EMAIL), driver);
		while (element.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}

		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_RC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_7_EXPECTED_MIN,
				element.getText());
		assertEquals(Constants.STEP_7_EXPECTED_MIN, element.getText());
		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_RCPO), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_7_EXPECTED_MED,
				element.getText());
		assertEquals(Constants.STEP_7_EXPECTED_MED, element.getText());
		element = utils.waitAndGetResultElement(By.xpath(Constants.XPATH_RCFO), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_7_EXPECTED_MAX,
				element.getText());
		assertEquals(Constants.STEP_7_EXPECTED_MAX, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Email and assurance price test took {} ms to complete ===", elapsedTime);
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
