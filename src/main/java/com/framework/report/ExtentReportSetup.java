package com.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.utils.TestUtils;

public class ExtentReportSetup {

    public static ExtentReports setUpExtentReport() {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")
                + "/ExtentReports/testReport" + TestUtils.getDateFormat() + ".html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Extent Test Report");
        sparkReporter.config().setReportName("Automation Test Report");
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }

}
