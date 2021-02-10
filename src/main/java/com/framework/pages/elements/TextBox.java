package com.framework.pages;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox extends Base {

    ElementsPage elementsPage = new ElementsPage();

    @FindBy(xpath = "//input[@id='userName']")
    WebElement fullName;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement email;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement currentAddress;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    WebElement permanentAddress;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement textBoxSaveButton;


    WebElement CheckBox;
    WebElement radioButton;
    WebElement webTables;
    WebElement buttons;
    WebElement links;
    WebElement brokenLinks;
    WebElement uploadDownload;
    WebElement dynamicProperty;


    public TextBox() {
        PageFactory.initElements(driver, this);
    }


}