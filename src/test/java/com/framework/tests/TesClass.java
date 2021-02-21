package com.framework.tests;

import com.framework.base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TesClass extends Base {

    @BeforeMethod
    @Parameters("URL")
    public void setup(String url) {
        System.out.println(prop.getProperty("browserName"));
        driverInitialization(url);
    }

    @Test
    public void test() {
        Assert.assertEquals("ToolsQA",driver.getTitle());
    }

}
