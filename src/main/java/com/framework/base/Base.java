package com.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties prop;

    public Base() {
        prop = new Properties();
        try {
            FileInputStream propFileName = new FileInputStream("src/main/java/com/framework/config/config.properties");
            prop.load(propFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void driverInitialization(String url) {

       String browserName = prop.getProperty("browserName");

        switch (browserName) {
            case "chrome":

                System.out.println("Chrome driver has been initialised");

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        System.out.println("URL fetched : "+prop.getProperty("url"));

        //driver.get(prop.getProperty("url"));
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
