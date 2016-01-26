package es.crd.tests.touring;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTestNg {

	private static FirefoxDriver driver = null;
	private WebElement element = null;
	private WebElement availableElement = null;
	private final TestUtils utils = new TestUtils();

	/**
	 * Opens a new browser instance (Firefox in our case) to the page we want to
	 * test.
	 */
	@BeforeClass
	public static void openBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(Constants.TOURING_ULR);
	}

	@Test(description = "Tests the age field")
	public void ageTest() {
		element = driver.findElement(By.name(Constants.NAME_AGE));
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.sendKeys(Constants.STEP_1_EXPECTED_AGE);
		availableElement.sendKeys(Keys.RETURN);

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_AGE + Constants.XPATH_GENERIC), driver);

		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_1_EXPECTED_AGE,
				element.getText()));
		Assert.assertEquals(Constants.STEP_1_EXPECTED_AGE, element.getText());
	}

	@Test(description = "Tests the bonus-malus button", dependsOnMethods = { "ageTest" })
	public void bmTest() {
		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_BUTTON), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_BM + Constants.XPATH_GENERIC), driver);
		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_2_EXPECTED_BM,
				element.getText()));
		Assert.assertEquals(Constants.STEP_2_EXPECTED_BM, element.getText());
	}

	@Test(description = "Tests the postal code", dependsOnMethods = { "bmTest" })
	public void postalTest() {
		element = utils.waitVisibilityOf(By.name(Constants.NAME_POSTAL_CODE), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.sendKeys(Constants.STEP_3_EXPECTED_POSTAL_CODE);
		availableElement.sendKeys(Keys.RETURN);
		
		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_POSTAL_CODE + Constants.XPATH_GENERIC), driver);
		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_3_EXPECTED_POSTAL_CODE,
				element.getText()));
		Assert.assertEquals(Constants.STEP_3_EXPECTED_POSTAL_CODE, element.getText());
	}

	@Test(description = "Tests the brand selector", dependsOnMethods = { "postalTest" })
	public void brandTest() {
		element = utils.waitVisibilityOf(By.className(Constants.CLASS_ALL_BRANDS), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.className(Constants.CLASS_TACK), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_BRAND + Constants.XPATH_GENERIC), driver);
		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_4_EXPECTED_BRAND,
				element.getText()));
		Assert.assertEquals(Constants.STEP_4_EXPECTED_BRAND, element.getText());
	}

	@Test(description = "Tests the price field", dependsOnMethods = { "brandTest" })
	public void priceTest() {
		element = utils.waitVisibilityOf(By.name(Constants.NAME_PRICE), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.sendKeys(Constants.STEP_5_EXPECTED_PRICE);
		availableElement.sendKeys(Keys.RETURN);

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_PRICE + Constants.XPATH_GENERIC), driver);
		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_5_EXPECTED_PRICE,
				element.getText()));
		Assert.assertEquals(Constants.STEP_5_EXPECTED_PRICE, element.getText());
	}

	@Test(description = "Tests the kilometer selector", dependsOnMethods = { "priceTest" })
	public void kmTest() {
		element = utils.waitVisibilityOf(By.name(Constants.NAME_KM), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_KM + Constants.XPATH_GENERIC), driver);
		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_6_EXPECTED_KM,
				element.getText()));
		Assert.assertEquals(Constants.STEP_6_EXPECTED_KM, element.getText());
	}

	@Test(description = "Tests the email field and the result page", dependsOnMethods = { "kmTest" })
	public void emailTest() {
		element = driver.findElement(By.name(Constants.NAME_EMAIL));
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.sendKeys(Constants.STEP_7_MAIL);

		element = utils.waitVisibilityOf(By.className(Constants.CLASS_EMAIL), driver);
		availableElement = utils.waitAvailabilityOf(element, driver);
		availableElement.click();

		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_RC), driver);
		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_7_EXPECTED_MIN,
				element.getText()));
		Assert.assertEquals(Constants.STEP_7_EXPECTED_MIN, element.getText());
		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_RCPO), driver);
		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_7_EXPECTED_MED,
				element.getText()));
		Assert.assertEquals(Constants.STEP_7_EXPECTED_MED, element.getText());
		element = utils.waitVisibilityOf(By.xpath(Constants.XPATH_RCFO), driver);
		Reporter.log(String.format("The expected result is \"%s\" and we got \"%s\".", Constants.STEP_7_EXPECTED_MAX,
				element.getText()));
		Assert.assertEquals(Constants.STEP_7_EXPECTED_MAX, element.getText());
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}
