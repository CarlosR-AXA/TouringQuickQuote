package es.crd.tests.touring_test;

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
	
	public WebElement waitAndGetResultElement(By by, WebDriver driver) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		try {
			element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		} catch (NotFoundException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
		return element;
	}
}
