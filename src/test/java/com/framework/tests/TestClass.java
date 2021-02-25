package com.framework.tests;

import com.framework.base.Base;
import lombok.SneakyThrows;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class TestClass extends Base {

    @BeforeMethod
    @Parameters({"URL", "browserName"})
    public void setup(String url, String browserName) {
        driverInitialization(url, browserName);
    }

    @Test(priority = 1)
    @Parameters({"URL", "browserName"})
    public void firstTest(String url, String browserName) {
        //driverInitialization(url,browserName);
        System.out.println("First Test");
        //driver.navigate().refresh();
    }

    @Test(priority = 2)
    @Parameters({"URL", "browserName"})
    public void secondTest(String url, String browserName) {
        //driverInitialization(url,browserName);
        System.out.println("Second Test");
        //driver.navigate().refresh();

    }

    @Test(priority = 3, enabled = false)
    public void thirdTest() {
        throw new NoSuchElementException();
    }

    @Test(priority = 4, enabled = false)
    @SneakyThrows
    public void fourthTest() {
        throw new TimeoutException();
    }

    @Test(priority = 5, enabled = false)
    public void fifthTest() {
        System.out.println("Fourth Test");
    }

    @Test(priority = 6, enabled = false)
    public void sixthTest() {
        throw new SkipException("Test skipped");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}