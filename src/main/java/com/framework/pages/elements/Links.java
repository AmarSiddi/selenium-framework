package com.framework.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Links {

    @FindBy(xpath = "//button[@id='doubleClickBtn']")
    WebElement doubleClickButton;

    @FindBy(xpath = "//button[@id='rightClickBtn']")
    WebElement rightClickButton;

    @FindBy(xpath = "//*[text()='Click Me']")
    WebElement dynamicClickButton;
}
