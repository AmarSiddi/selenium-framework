package com.framework.pages.alertframewindows;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowsPage extends Base {

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/span[1]")
    WebElement browserWindows;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/span[1]")
    WebElement alerts;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[3]/span[1]")
    WebElement frames;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[4]/span[1]")
    WebElement nestedFrames;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[5]/span[1]")
    WebElement modalDialogs;

    public AlertFrameWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnBrowserWindows(){

    }

    public void clickOnAlerts(){
        alerts.click();
    }

    public void clickOnFrames(){
        frames.click();
    }

    public void clickOnNestedFrames(){
        nestedFrames.click();
    }

    public void clickOnModalDialogs(){
        modalDialogs.click();
    }
}
