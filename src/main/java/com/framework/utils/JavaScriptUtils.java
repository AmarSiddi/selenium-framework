package com.framework.utils;

import com.framework.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptUtils extends Base {

    JavascriptExecutor js;

    public JavaScriptUtils() {
        js = (JavascriptExecutor) driver;
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollByCoordinates(String x, String y) {
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

}
