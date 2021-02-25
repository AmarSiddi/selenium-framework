package com.framework.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class ExtentReportTest {
    static ExtentReports reports;
    static ExtentSparkReporter sparkReporter;

    @BeforeTest
    public void test(){
        reports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("index.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Extent Report");
        reports.attachReporter(sparkReporter);
    }

    @org.testng.annotations.Test(priority = 1)
    public void test2(){

        ExtentTest extentTest = reports.createTest("Practice Form Test")
                .assignCategory("user")
                .assignAuthor("human")
                .assignDevice("chrome");
        extentTest.warning("Gender has been selected.");
        extentTest.pass("Form has been submitted.");
    }

    @Test(priority = 2, enabled = true)
    public void test3(){
        ExtentTest extentTest = reports.createTest("New Form Test")
                .assignCategory("non-user")
                .assignAuthor("non-human")
                .assignDevice("firefox");
        extentTest.pass("Form has been submitted.");
        extentTest.info("This has been selected.");
        extentTest.fail("Form has been submitted.");
    }

    @AfterTest
    public void teardown(){
        reports.flush();
    }

}
