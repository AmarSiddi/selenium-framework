package com.framework.utils;

import com.framework.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils extends Base {

    JavascriptExecutor js;

    public Utils() {
        js = (JavascriptExecutor) driver;
    }

    public void presenceOfElement(By element) {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated((element)));

    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollByCoordinates(String x, String y) {
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

}
