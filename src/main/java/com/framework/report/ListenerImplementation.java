package com.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.base.Base;
import com.framework.utils.TestUtils;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ListenerImplementation extends Base implements ITestListener {

    static ExtentTest extentTest;
    static ExtentReports extentReports;

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(getMethodName(result));
        extentTest.info("Test Case " + getMethodName(result) + " execution started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.pass("Test Case " + getMethodName(result) + " is passed.");
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.fail("Test Case " + getMethodName(result) + " is failed.");
        extentTest.info("Error stack: " + result.getThrowable());

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcPath = screenshot.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/ExtentReports/screenshots/test"
                + TestUtils.getDateFormat() + ".jpg";

        File destPath = new File(dest);
        FileUtils.copyFile(srcPath, destPath);

        extentTest.addScreenCaptureFromPath(dest);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.skip("Test Case" + getMethodName(result) + " is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        extentTest.fail("Test Case" + getMethodName(result) + " is timed out..");
        extentTest.info("Error Stack: " + result.getThrowable());

    }

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentReportSetup.setUpExtentReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        //extentReports.flush();
    }

    public static String getMethodName(ITestResult result) {
        //System.out.println(result.getMethod().getMethodName());
        //System.out.println(result.getMethod().getConstructorOrMethod().getName());
        return result.getMethod().getMethodName();
    }
}
