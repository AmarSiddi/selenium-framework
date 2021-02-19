package com.framework.pages.elements;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends Base {

    @FindBy(css = "#simpleLink")
    WebElement homeLink;

    @FindBy(xpath = "//a[@id='created']")
    WebElement createdLink;

    @FindBy(xpath = "//a[@id='no-content']")
    WebElement noContentLink;

    @FindBy(xpath = "//a[@id='bad-request']")
    WebElement badRequestLink;

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnHomeLink() {
        homeLink.click();
    }

    //TODO learn how to handle the API request using Web Driver
    public void getCreatedAPIResponse(){

    }

    public void getNoContentLinkResponse(){

    }

    public void getBadRequestResponse(){

    }



}
