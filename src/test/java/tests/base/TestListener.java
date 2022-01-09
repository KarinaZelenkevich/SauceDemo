package tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        System.out.printf("Test started: %s \n", result.getName());
        AllureUtils.takeScreenshot(driver);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.printf("Test success: %s \n", result.getName());
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        System.out.printf("Test failed: %s \n", result.getName());
        AllureUtils.takeScreenshot(driver);
    }

    public void onStart(ITestContext context) {
        //
    }
}
