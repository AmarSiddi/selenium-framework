package com.framework.pages.elements;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buttons extends Base {

    Actions actions;

    @FindBy(xpath = "//button[@id='doubleClickBtn']")
    WebElement doubleClickButton;

    @FindBy(xpath = "//button[@id='rightClickBtn']")
    WebElement rightClickButton;

    @FindBy(xpath = "//*[text()='Click Me']")
    WebElement dynamicClickButton;

    public Buttons(){
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    public void performDoubleClickButton() {
        actions.doubleClick(doubleClickButton).build().perform();
    }

    public void performRightClickButton() {
        actions.contextClick(rightClickButton).build().perform();
    }

    public void performDynamicClickButton(){
        actions.moveToElement(dynamicClickButton)
                .build()
                .perform();
    }
}
