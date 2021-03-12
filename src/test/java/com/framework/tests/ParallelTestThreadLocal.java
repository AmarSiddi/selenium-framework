package com.framework.tests;

import com.framework.utils.Driver;
import lombok.SneakyThrows;
import org.testng.annotations.*;

public class ParallelTestThreadLocal {


    @BeforeMethod
    @Parameters({"URL", "browserName"})
    @SneakyThrows
    public void before(String url, String browserName) {
        Thread.sleep(1000);
        Driver.setDriver(Driver.initDriver(url, browserName));
    }

    @Test(priority = 1, groups = "one")
    public void one() {
        //Driver.getDriver().findElement(By.name("q")).sendKeys("Send");
        Driver.getDriver().getTitle();
        System.out.println("one Thread: " + Thread.currentThread().getId());
    }

    @Test(priority = 2, enabled = true, dependsOnGroups = {"one"})
    public void two() {
        //Driver.getDriver().findElement(By.name("q")).sendKeys("Send");
        Driver.getDriver().getTitle();
        System.out.println("two Thread: " + Thread.currentThread().getId());
    }

    @Test(enabled = true)
    public void three() {
        //Driver.getDriver().findElement(By.name("q")).sendKeys("Send");
        Driver.getDriver().getTitle();
        System.out.println("three Thread: " + Thread.currentThread().getId());

    }

    @AfterMethod
    public void tearDown() {
        if (Driver.getDriver() != null) {
            System.out.println("After Method: " + Driver.getDriver());
            //Driver.getDriver().quit();
        }
    }

    @AfterTest
    public void endTest(){
        Driver.getDriver().close();
    }

    @AfterSuite
    @SneakyThrows
    public void endSuite() {
        if (Driver.getDriver() != null) {
            System.out.println("***********  After Test: " + Driver.getDriver()+"***************");
            Thread.sleep(2000);
            Driver.getDriver().quit();
            Driver.unload();
        } else {
            Driver.unload();
            System.out.println("********** ThreadLocal has been removed.************");
        }

    }
}