package manager;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static long defaultTimeout = 10;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup(); // Automatically sets up the ChromeDriver binary
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWait(long defaultTimeout) {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        }
        return wait;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        }
        return wait;
    }

    public static void endSession() {
        if (driver != null) {
            driver.quit();
            wait = null;
            driver = null;
        }
    }
}
