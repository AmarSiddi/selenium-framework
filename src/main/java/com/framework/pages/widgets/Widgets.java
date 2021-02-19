package com.framework.pages.widgets;

import com.framework.base.Base;
import com.framework.utils.JavaScriptUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Widgets extends Base {

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[1]/span[1]")
    WebElement accordionLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]")
    WebElement autoCompleteLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[3]/span[1]")
    WebElement datePicker;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]/span[1]")
    WebElement sliderLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[5]/span[1]")
    WebElement progressBar;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[6]/span[1]")
    WebElement tabsLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[7]/span[1]")
    WebElement toolTipsLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[8]/span[1]")
    WebElement menuLink;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[9]/span[1]")
    WebElement selectMenuLink;

    JavaScriptUtils javaScriptUtils;

    public Widgets() {
        PageFactory.initElements(driver, this);
        javaScriptUtils = new JavaScriptUtils();
    }

    public AccordionPage clickOnAccordion() {
        accordionLink.click();
        return new AccordionPage();
    }

    public AutoCompletePage clickOnAutoComplete() {
        javaScriptUtils.scrollToElement(autoCompleteLink);
        autoCompleteLink.click();
        return new AutoCompletePage();
    }

    public DatePickerPage clickOnDatePicker() {
        javaScriptUtils.scrollToElement(datePicker);
        datePicker.click();
        return new DatePickerPage();
    }

    public MenuPage clickOnMenuLink() {
        javaScriptUtils.scrollToElement(menuLink);
        menuLink.click();
        return new MenuPage();
    }

    public ProgressBarPage clickOnProgressBar() {
        javaScriptUtils.scrollToElement(progressBar);
        progressBar.click();
        return new ProgressBarPage();
    }

    public SliderPage clickOnSlider() {
        javaScriptUtils.scrollToElement(sliderLink);
        sliderLink.click();
        return new SliderPage();
    }

    public TabsPage clickOnTabs() {
        javaScriptUtils.scrollToElement(tabsLink);
        tabsLink.click();
        return new TabsPage();
    }

    public ToolTipsPage clickOnToolTips() {
        javaScriptUtils.scrollToElement(toolTipsLink);
        toolTipsLink.click();
        return new ToolTipsPage();
    }


}
