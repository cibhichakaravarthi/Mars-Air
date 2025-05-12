package util;

import manager.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

    private WebDriver driver;
    private WebDriverWait wait;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
    }

    // Set value in a field
    public void setElementValue(By locator, String value) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(value);
        } catch (StaleElementReferenceException e) {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(value);
        }
    }

    // Click on an element
    public void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (StaleElementReferenceException e) {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }
    }

    // Click on an element using JavaScript
    public void clickWithJavaScript(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (StaleElementReferenceException e) {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }

    // Find and return the WebElement
    public WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (StaleElementReferenceException e) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
    }

    // Get the text of an element
    public String getElementText(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText().trim();
        } catch (StaleElementReferenceException e) {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText().trim();
        }
    }

    // Get the current URL of the page
    public String getCurrentlyUrl() {
        return driver.getCurrentUrl();
    }

    // Check if an element is displayed
    public boolean hasElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Compare field name with expected value
    public boolean isFieldName(By locator, String fieldName) {
        return getElementText(locator).equals(fieldName);
    }

    // Wait for an element to be visible
    public void waitForElement(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Element not visible in the given time: " + locator);
        }
    }

}
