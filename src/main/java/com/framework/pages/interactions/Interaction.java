package com.framework.pages.interactions;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Interaction extends Base {


    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/ul[1]/li[1]/span[1]")
    WebElement sortableLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/ul[1]/li[2]/span[1]")
    WebElement selectableLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/ul[1]/li[3]/span[1]")
    WebElement resizableLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/ul[1]/li[4]/span[1]")
    WebElement droppableLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/ul[1]/li[5]/span[1]")
    WebElement draggableLink;

}
