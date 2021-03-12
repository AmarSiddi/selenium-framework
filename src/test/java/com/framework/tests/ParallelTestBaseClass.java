package com.framework.tests;

import com.framework.base.Base;
import com.framework.utils.Driver;
import lombok.SneakyThrows;
import org.testng.annotations.*;

public class ParallelTestBaseClass {


    @BeforeMethod
    @Parameters({"URL", "browserName"})
    @SneakyThrows
    public void startMethod(String url, String browserName) {
        Thread.sleep(1000);

        /**Using a Base class Web Driver doesn't help to achieve the parallel test execution.
         *
         * answer can be found here :
         * https://stackoverflow.com/questions/35287122/testng-close-browsers-after-parallel-test-execution
         *
         * https://stackoverflow.com/questions/59827491/parallel-execution-of-test-throws-exception-when-parallel-is-set-to-true-on-data
         */
        //driverInitialization(url, browserName);
        Driver.setDriver(Driver.initDriver(url, browserName));
/*        System.out.println("startMethod Thread: " + Thread.currentThread().getId()
                + " " + "startMethod Session ID: " + Driver.getDriver().getWindowHandle());*/
    }

    @Test(priority = 1)
    public void login() {
/*        System.out.println("login Thread: " + Thread.currentThread().getId()
                + " " + "login Session ID: " + Driver.getDriver().getWindowHandle());*/
    }

    @Test(priority = 2)
    public void verifyTitle() {
        /*System.out.println("verifyTitle Thread: " + Thread.currentThread().getId()
                + " " + "verifyTitle Session ID: " + Driver.getDriver().getWindowHandle());*/
    }

    @Test(priority = 3)
    public void verifyUser() {
        //System.out.println("verifyUser Thread: " + Thread.currentThread().getId());
    }

    @Test(priority = 4)
    public void logout() {
        System.out.println("logout Thread: " + Thread.currentThread().getId());
    }

    @AfterMethod
    @SneakyThrows
    public void endMethod() {
        if (Driver.getDriver() != null) {
            System.out.println("Window: "+Driver.getDriver().getWindowHandle()+""+Thread.currentThread().getId());
            Thread.sleep(1000);
            Driver.getDriver().quit();
            /*System.out.println("Printing**********  Thread: " + Thread.currentThread().getId());
            Driver.getDriver().quit();
            Driver.unload();
            System.out.println("success**********");*/
        }
        //Driver.getDriver().quit();
        Driver.unload();
    }

}
