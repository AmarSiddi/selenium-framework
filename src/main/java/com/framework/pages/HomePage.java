package com.framework.pages;

import com.framework.base.Base;
import com.framework.pages.elements.ElementsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]")
    WebElement elementsPage;

    @FindBy(xpath = "//*[text()='Forms']")
    WebElement formsPage;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]")
    WebElement alertFrameWindowsPage;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public ElementsPage clickElementsPage(){
        elementsPage.click();
        return new ElementsPage();
    }






}
