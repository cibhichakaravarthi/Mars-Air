package util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import stepDefinitions.Hooks;
import manager.DriverFactory;

public class MyListener implements ITestListener {

    ExtentTest Test;
    
    public static ExtentReports getExtentReport() {
        String reportPath = "C:\\Users\\cibhi\\eclipse-workspace\\Marsair1\\report\\TestReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Mars Air Test Report");
        reporter.config().setDocumentTitle("Test Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Cibhi");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");

        return extent;
    }
    ExtentReports report=getExtentReport();


    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        Test = report.createTest(testName).assignAuthor("Cibhi").assignCategory("AutomationTesting").assignDevice("Windows");
        Test.log(Status.INFO, testName + " execution started");
    }



    public static String takeScreenShot(String testName) {
        WebDriver driver = DriverFactory.getDriver();

        // Ensure driver is not null
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null. Cannot take screenshot.");
        }

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "C:\\Users\\cibhi\\eclipse-workspace\\Marsair1\\report\\screenshots\\" + testName + ".png";

        try {
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }


    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        Test.log(Status.FAIL, testName + " got failed");
        Test.log(Status.INFO, result.getThrowable());
        String screenshotPath = Hooks.takeScreenShot(testName);
        try {
            Test.addScreenCaptureFromPath(screenshotPath); // Add screenshot to Extent Report
        } catch (Exception e) {
            throw new RuntimeException("Failed to attach screenshot to report", e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        Test.log(Status.SKIP, testName + " Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    @Override
    public void onStart(ITestContext context) {
        // Not implemented
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
        File eReportFile = new File("C:\\Users\\cibhi\\eclipse-workspace\\Marsair1\\report\\TestReport.html");
        try {
            Desktop.getDesktop().browse(eReportFile.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
