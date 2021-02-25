package com.framework.tests;

import com.framework.base.Base;
import com.framework.pages.HomePage;
import com.framework.pages.alertframewindows.AlertFrameWindowsPage;
import lombok.SneakyThrows;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AlertFrameWinTests extends Base {

    static AlertFrameWinTests afw;
    static HomePage homePage;
    static AlertFrameWindowsPage alertFrameWindowsPage;
    static Actions actions;
    static SoftAssert softAssert;
    static Alert alert;
    static String URL = "https://demoqa.com/register";
    String browserName = "chrome";

    public AlertFrameWinTests() {
        driverInitialization(URL,browserName);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        homePage = new HomePage();
    }

    public static void main(String[] args) {

        afw = new AlertFrameWinTests();
        alertFrameWindowsPage = homePage.clickOnAlertFrameWindows();
        handleAlerts();
        driver.quit();
    }

    @SneakyThrows
    public static void handleAlerts() {
        alertFrameWindowsPage.clickOnAlerts();

        findByXPATH("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/button[1]").click();
        driver.switchTo().alert().accept();

        findByXPATH("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/button[1]").click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        //Thread.sleep(7000);
        driver.switchTo().alert().accept();

        findByXPATH("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/button[1]").click();
        driver.switchTo().alert().dismiss();

        findByXPATH("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[2]/button[1]").click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();

    }

    public static void handleIFrames() {

    }

    public static WebElement findByXPATH(String XPATH) {
        return driver.findElement(By.xpath(XPATH));
    }

    public static WebElement findByCSSSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

}
