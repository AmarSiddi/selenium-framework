package com.framework.pages.elements;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends Base {

    @FindBy(xpath = "//li[@class='rct-node rct-node-parent rct-node-collapsed']/span[1]/button[1]/*[1]")
    WebElement homeExpand;

    //@FindBy(xpath = "//li[@class='rct-node rct-node-parent rct-node-expanded']/span[1]/button[1]/*[1]")

    @FindBy(xpath = "//label[@for='tree-node-home']/span[1]/*[1]")
    WebElement homeCheckBox;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[1]/span[1]/button[1]/*[1]")
    WebElement desktopExpand;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")
    WebElement notesCheck;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[1]/ol[1]/li[2]/span[1]/label[1]/span[1]/*[1]")
    WebElement commandsCheck;

    @FindBy(xpath = "//span[contains(text(),'Desktop')]")
    WebElement desktopText;

    @FindBy(xpath = "//span[contains(text(),'Notes')]")
    WebElement notesText;

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    public void expandHome() {
        try {
            homeExpand.click();
        } catch (Exception e) {
            homeExpand.click();
        }
    }

    public void expandDesktop() {
        try {
            desktopExpand.click();
        } catch (Exception e) {
            desktopExpand.click();
        }
    }

    public void collapseHome() {
        //if (desktopText.isDisplayed())
            homeExpand.click();
    }


    public void collapseDesktop() {
        //if (notesText.isDisplayed())
            desktopExpand.click();
    }

    public void checkNotesBox() {
        if (!notesCheck.isSelected())
            notesCheck.click();
    }

    public void unCheckNotesBox() {
        System.out.println("Print2 : "+!notesCheck.isSelected());
        //if (notesCheck.isSelected())
            notesCheck.click();
    }

    public void checkCommandsBox() {
        if (!commandsCheck.isSelected())
            commandsCheck.click();
    }

    public void unCheckCommandsBox() {

        System.out.println("Print2 : "+!commandsCheck.isSelected());
        //if (commandsCheck.isSelected())
            commandsCheck.click();
    }
}
