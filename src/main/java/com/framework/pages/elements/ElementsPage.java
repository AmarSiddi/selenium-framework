package com.framework.pages.elements;

import com.framework.base.Base;
import com.framework.utils.JavaScriptUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends Base {

    JavaScriptUtils javaScriptUtils;

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
        javaScriptUtils = new JavaScriptUtils();
    }

    public TextBoxPage clickTextBox(){
        textBox.click();
        return new TextBoxPage();
    }

    public CheckBoxPage clickCheckBox() {
        CheckBox.click();
        return new CheckBoxPage();
    }

    public ButtonsPage clickButton() {
        buttons.click();
        return new ButtonsPage();
    }

    public LinksPage clickLinks() {
        javaScriptUtils.scrollToElement(links);
        links.click();
        return new LinksPage();
    }

    public BrokenLinksPage brokenLinks() {
        javaScriptUtils.scrollToElement(brokenLinks);
        brokenLinks.click();
        return new BrokenLinksPage();
    }

}
