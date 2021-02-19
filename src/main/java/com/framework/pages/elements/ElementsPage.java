package com.framework.pages.elements;

import com.framework.base.Base;
import com.framework.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends Base {

    Utils utils;

    @FindBy(xpath = "//span[contains(text(),'Text Box')]")
    WebElement textBox;

    @FindBy(xpath = "//span[contains(text(),'Check Box')]")
    WebElement CheckBox;

    @FindBy(xpath = "//span[contains(text(),'Text Box')]")
    WebElement radioButton;

    @FindBy(xpath = "//span[contains(text(),'Web Tables')]")
    WebElement webTables;

    @FindBy(xpath = "//span[contains(text(),'Buttons')]")
    WebElement buttons;

    @FindBy(xpath = "//span[text()='Links']")
    WebElement links;

    @FindBy(xpath = "//span[contains(text(),'Broken Links - Images')]")
    WebElement brokenLinks;

    @FindBy(xpath = "//span[contains(text(),'Upload and Download')]")
    WebElement uploadDownload;

    @FindBy(xpath = "//span[contains(text(),'Upload and Download')]")
    WebElement dynamicProperty;

    public ElementsPage(){
        PageFactory.initElements(driver, this);
        utils = new Utils();
    }

    public TextBox clickTextBox(){
        textBox.click();
        return new TextBox();
    }

    public CheckBox clickCheckBox() {
        CheckBox.click();
        return new CheckBox();
    }

    public Buttons clickButton() {
        buttons.click();
        return new Buttons();
    }

    public Links clickLinks() {
        utils.scrollToElement(links);
        links.click();
        return new Links();
    }

}
