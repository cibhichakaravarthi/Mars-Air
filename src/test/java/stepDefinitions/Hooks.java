package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import manager.DriverFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("BEFORE ALL EXECUTIONS: maximize the browser windows");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }
    
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Running Test Case: " + scenario.getName());
    }
    
    public static String takeScreenShot(String scenario) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destinationFile = new File("C:\\Users\\cibhi\\eclipse-workspace\\Marsair1\\screenshots\\" + scenario + ".png");
        try {
            FileUtils.copyFile(scrFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String path = "<img src= " + destinationFile.getAbsolutePath() + " width = 200px height=200px />";

        Reporter.log(path);
        return destinationFile.getAbsolutePath();
    }

    @After
    public void tearDown() {
        System.out.println("AFTER ALL EXECUTIONS: close the browser window");
        DriverFactory.endSession();
    }

}