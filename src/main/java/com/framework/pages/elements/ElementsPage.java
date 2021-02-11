package com.framework.pages.elements;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends Base {

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

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/span[1]")
    WebElement links;

    @FindBy(xpath = "//span[contains(text(),'Broken Links - Images')]")
    WebElement brokenLinks;

    @FindBy(xpath = "//span[contains(text(),'Upload and Download')]")
    WebElement uploadDownload;

    @FindBy(xpath = "//span[contains(text(),'Upload and Download')]")
    WebElement dynamicProperty;

    public ElementsPage(){
        PageFactory.initElements(driver, this);
    }

    public TextBox clickTextBox(){
        textBox.click();
        return new TextBox();
    }

    public CheckBox clickCheckBox() {
        CheckBox.click();
        return new CheckBox();
    }
}
