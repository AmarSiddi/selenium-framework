package com.framework.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class Driver {

    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driver) {
        dr.set(driver);
    }

    public static void unload() {
        dr.remove();
    }

    public static WebDriver initDriver(String url, String browserName) {
        if (Objects.isNull(driver)) {

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                setDriver(driver);
            }
            if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                setDriver(driver);
            }
            getDriver().get(url);
        }

        return getDriver();
    }

    public static void quitDriver() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }


}
