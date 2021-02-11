package com.framework.pages.elements;

import com.framework.base.Base;
import com.framework.pages.HomePage;
import com.framework.pages.elements.ElementsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox extends Base {

    HomePage homePage = new HomePage();
    ElementsPage elementsPage = new ElementsPage();

    @FindBy(xpath = "//input[@id='userName']")
    WebElement fName;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement emailID;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement curAddress;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    WebElement perAddress;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement saveButton;

    public TextBox() {
        PageFactory.initElements(driver, this);
    }

    public void fillTextBox(String fullName, String email, String currentAddress, String permanentAddress){

        fName.sendKeys(fullName);
        emailID.sendKeys(email);
        curAddress.sendKeys(currentAddress);
        perAddress.sendKeys(permanentAddress);
        saveButton.click();

    }

}