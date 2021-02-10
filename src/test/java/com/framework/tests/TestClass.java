package com.framework.tests;

import com.framework.base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass extends Base {

    public TestClass() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driverInitialization();
    }

    @Test
    public void test() {
        Assert.assertEquals("ToolsQA",driver.getTitle());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
