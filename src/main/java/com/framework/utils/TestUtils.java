package com.framework.utils;

import com.framework.base.Base;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils extends Base {

    Actions actions;

    public void moveToElementClick(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).click(element).build().perform();
    }

    @SneakyThrows
    public static String takeScreenShotAsImage() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcPath = screenshot.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/ExtentReports/screenshots/test-" + getDateFormat() + ".jpg";
        File destPath = new File(dest);
        FileUtils.copyFile(srcPath, destPath);
        return dest;
    }

    @SneakyThrows
    public static void takeScreenShotAsBase64() {

        String srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        File destPath = new File(System.getProperty("user.dir") + "/ExtentReports/" +
                "screenshots/test-" + getDateFormat() + ".jpg");
        FileUtils.copyFile(new File(srcFile), destPath);
    }

    @SneakyThrows
    public static void takeScreenShotAsBytes() {

        byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        File destPath = new File(System.getProperty("user.dir") + "/ExtentReports/" +
                "screenshots/test-" + getDateFormat() + ".jpg");
        FileUtils.copyFile(new File(String.valueOf(srcFile)), destPath);
    }

    public static String getDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date date = new Date();
        return formatter.format(date);
    }

}
