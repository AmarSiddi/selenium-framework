package com.framework.tests;

import com.framework.base.Base;
import com.framework.utils.Driver;
import lombok.SneakyThrows;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.annotations.Test;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class TestClass extends Base {

    String URL;

    @BeforeMethod(enabled = true)
    @Parameters({"URL", "browserName"})
    @SneakyThrows
    public void setup(String url, String browserName) {
        Thread.sleep(1000);
        Driver.setDriver(Driver.initDriver(url, browserName));
    }

    @Test(priority = 1)
    public void firstTest() {
        Driver.getDriver().getTitle();
        System.out.println("First Test Thread: " + Thread.currentThread().getId());
        //driver.navigate().refresh();
    }

    @Test(priority = 2, enabled = true)
    public void secondTest() {
        Driver.getDriver().getWindowHandle();
        System.out.println("Second Test Thread: " + Thread.currentThread().getId());
        //driver.navigate().refresh();
    }

    @Test(priority = 3, enabled = false)
    public void thirdTest() {
        Driver.getDriver();
        throw new NoSuchElementException();
    }

    @Test(priority = 4, enabled = false)
    @SneakyThrows
    public void fourthTest() {
        Driver.getDriver();
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

    //@AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println(Driver.getDriver());
        Driver.getDriver().close();
    }
}