package listeners;

import browserFactory.BrowserFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import helper.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGITestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getInstance();

    ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();


    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        parentTest.set(extentTest);
    }

    public synchronized void onTestSuccess(ITestResult result) {
        parentTest.get().pass("Test Passed");
    }

    public synchronized void onTestFailure(ITestResult result) {
        String screenshot = Utility.captureScreenshotAsBase64(BrowserFactory.getDriver());
        parentTest.get().fail("Test Failed " + result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot, "Screenshot Of Failed Test").build());
    }

    public synchronized void onTestSkipped(ITestResult result) {
        parentTest.get().skip("Test Skipped");
    }


    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }
}
