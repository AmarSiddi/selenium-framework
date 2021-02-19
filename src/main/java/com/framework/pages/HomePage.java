package com.framework.pages;

import com.framework.base.Base;
import com.framework.pages.elements.ElementsPage;
import com.framework.pages.interactions.Interaction;
import com.framework.pages.widgets.Widgets;
import com.framework.utils.JavaScriptUtils;
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

    @FindBy(xpath = "//div [text() ='Widgets']")
    WebElement widgetsLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/span[1]/div[1]/div[2]/div[2]/svg[1]/g[1]/path[2]")
    WebElement interactionLink;


    JavaScriptUtils javaScriptUtils;
    public HomePage() {
        PageFactory.initElements(driver, this);
        javaScriptUtils = new JavaScriptUtils();
    }

    public ElementsPage clickOnElementsPage() {
        elementsPage.click();
        return new ElementsPage();
    }

    public Widgets clickOnWidgets(){
        javaScriptUtils.scrollToElement(widgetsLink);
        widgetsLink.click();
        return new Widgets();
    }

    public Interaction clickOnInteraction(){
        javaScriptUtils.scrollToElement(interactionLink);
        interactionLink.click();
        return new Interaction();
    }

}
