package com.framework.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class Base {

    public static WebDriver driver;
    public static Properties prop;
    public static ExtentReports extentReports;

    public Base() {
        prop = new Properties();
        try {
            FileInputStream propFileName = new FileInputStream("src/main/java/com/framework/config/config.properties");
            prop.load(propFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void driverInitialization(String url, String browserName) {

       //String browserName = prop.getProperty("browserName");

        switch (browserName) {
            case "chrome":

                System.out.println("Chrome driver has been initialised");

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
                options.setProfile(profile);
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(options);
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
                driver = null;
                break;
        }

        //System.out.println("URL fetched : "+prop.getProperty("url"));

        //driver.get(prop.getProperty("url"));
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }

    //@AfterMethod()
    public void tearDown(){
        driver.quit();
    }
}
