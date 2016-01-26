package es.crd.tests.touring;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumUnitTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumUnitTest.class);
	private static FirefoxDriver driver = null;
	private WebElement element = null;
	private WebElement availableElement = null;
	private long timer = 0L;
	private long elapsedTime = 0L;
	private final TestUtils utils = new TestUtils();

	/**
	 * Opens a new browser instance (Firefox in our case) to the page we want to
	 * test.
	 */
	@BeforeClass
	public static void openBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(Constants.TOURING_ULR);
	}

	@Test
	public void step1_ageTest() {
		// ========== Step 1: Age test==========
		timer = System.currentTimeMillis();

		element = driver.findElement(By.name(Constants.NAME_AGE));
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.sendKeys(Constants.STEP_1_EXPECTED_AGE);
		availableElement.sendKeys(Keys.RETURN);

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_AGE + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_1_EXPECTED_AGE, element.getText());
		assertEquals(Constants.STEP_1_EXPECTED_AGE, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Age test took {} ms to complete ===", elapsedTime);
	}

	@Test
	public void step2_bmTest() {
		// ========== Step 2: BM Test==========
		timer = System.currentTimeMillis();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_BUTTON), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_BM + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_2_EXPECTED_BM, element.getText());
		assertEquals(Constants.STEP_2_EXPECTED_BM, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== BM test took {} ms to complete ===", elapsedTime);
	}

	@Test
	public void step3_postalCodeTest() {
		// ========== Step 3: Postal code Test==========
		timer = System.currentTimeMillis();

		element = utils.waitVisibilityOf(By.name(Constants.NAME_POSTAL_CODE), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.sendKeys(Constants.STEP_3_EXPECTED_POSTAL_CODE);
		availableElement.sendKeys(Keys.RETURN);

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_POSTAL_CODE + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_3_EXPECTED_POSTAL_CODE, element.getText());
		assertEquals(Constants.STEP_3_EXPECTED_POSTAL_CODE, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Postal code test took {} ms to complete ===", elapsedTime);
	}

	@Test
	public void step4_brandTest() {
		// ========== Step 4: Brand Test==========
		timer = System.currentTimeMillis();

		element = utils.waitVisibilityOf(By.className(Constants.CLASS_ALL_BRANDS), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.className(Constants.CLASS_TACK), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_BRAND + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_4_EXPECTED_BRAND, element.getText());
		assertEquals(Constants.STEP_4_EXPECTED_BRAND, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Brand test took {} ms to complete ===", elapsedTime);
	}

	@Test
	public void step5_priceTest() {
		// ========== Step 5: Price test==========
		timer = System.currentTimeMillis();

		element = driver.findElement(By.name(Constants.NAME_PRICE));
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.sendKeys(Constants.STEP_5_EXPECTED_PRICE);
		availableElement.sendKeys(Keys.RETURN);

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_PRICE + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_5_EXPECTED_PRICE, element.getText());
		assertEquals(Constants.STEP_5_EXPECTED_PRICE, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Price test took {} ms to complete ===", elapsedTime);
	}

	@Test
	public void step6_kmTest() {
		// ========== Step 6: KM Test==========
		timer = System.currentTimeMillis();

		element = utils.waitVisibilityOf(By.name(Constants.NAME_KM), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_KM + Constants.XPATH_GENERIC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_6_EXPECTED_KM, element.getText());
		assertEquals(Constants.STEP_6_EXPECTED_KM, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== KM test took {} ms to complete ===", elapsedTime);
	}

	@Test
	public void step7_emailResultTest() {
		// ========== Step 7: Email and final result test==========
		timer = System.currentTimeMillis();

		element = driver.findElement(By.name(Constants.NAME_EMAIL));
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.sendKeys(Constants.STEP_7_MAIL);

		element = utils.waitVisibilityOf(By.className(Constants.CLASS_EMAIL), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_RC), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_7_EXPECTED_MIN, element.getText());
		assertEquals(Constants.STEP_7_EXPECTED_MIN, element.getText());
		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_RCPO), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_7_EXPECTED_MED, element.getText());
		assertEquals(Constants.STEP_7_EXPECTED_MED, element.getText());
		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_RCFO), driver);
		LOGGER.info("The expected result is \"{}\" and we got \"{}\".", Constants.STEP_7_EXPECTED_MAX, element.getText());
		assertEquals(Constants.STEP_7_EXPECTED_MAX, element.getText());

		elapsedTime = (System.currentTimeMillis() - timer);
		LOGGER.info("=== Email and assurance price test took {} ms to complete===", elapsedTime);
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
