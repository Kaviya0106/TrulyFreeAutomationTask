package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// WaitUtil class is used to handle explicit waits for web elements
public class WaitUtil {

    // WebDriver instance used to interact with the browser
    private final WebDriver driver;

    // WebDriverWait object used to apply wait conditions on elements
    private final WebDriverWait wait;

    // Constructor used to initialize WebDriver and wait timeout
    public WaitUtil(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // Waits until the element becomes visible on the web page
    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Waits until the element becomes Clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Waits until the current URL contains the given text
    public boolean waitForUrlContains(String urlPart) {
        return wait.until(ExpectedConditions.urlContains(urlPart));
    }

    // Checks whether the element is visible on the page
    public boolean isVisible(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Performs click action after waiting for the element to be clickable
    public void click(By locator) {
        waitForClickable(locator).click();
    }

    // Enters text into the input field after waiting for the element to be visible
    public void type(By locator, String value) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(value);
    }

    // Safely clicks the element without failing the test if the element is not present
    public void safeClick(By locator) {
        try {
            click(locator);
        } catch (Exception ignored) {
            // Optional element is not present in this flow
        }
    }

    // Returns the WebDriver instance used in the framework
    public WebDriver getDriver() {
        return driver;
    }
}