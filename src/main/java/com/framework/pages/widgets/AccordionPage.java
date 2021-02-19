package com.framework.pages.widgets;

import com.framework.base.Base;
import com.framework.utils.JavaScriptUtils;
import com.framework.utils.TestUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class AccordionPage extends Base {

    @FindBy(xpath = "//div [@id ='accordianContainer']/div/div/div[@class='card-header']")
    WebElement allAccordionList;

    @FindBy(xpath = "//div [@id ='accordianContainer']/div/div[1]")
    WebElement firstAccordion;

    @FindBy(xpath = "//div [text() ='What is Lorem Ipsum?']/../div/div/p")
    WebElement firstAccordionContent;

    @FindBy(xpath = "//div [@id ='accordianContainer']/div/div[2]")
    //@FindBy(name = "Where does it come from?")
    WebElement secondAccordion;

    @FindBy(xpath = "//div [text() ='Where does it come from?']/parent::*/div/div")
    WebElement secondAccordionContent;

    @FindBy(xpath = "//div [@id ='accordianContainer']/div/div[3]")
    //@FindBy(name = "Why do we use it?")
    WebElement thirdAccordion;

    @FindBy(xpath = "//div [text() ='Why do we use it?']/parent::*/div/div/p")
    WebElement thirdAccordionContent;

    TestUtils testUtils;

    public AccordionPage() {
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils();
    }


    public ArrayList<String> getAllAccordions() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement element : driver.findElements(By.xpath("//div [@id ='accordianContainer']" +
                "/div/div/div[@class='card-header']")))
            arrayList.add(element.getText());
        return arrayList;
    }


    public String getFirstAccordionContent() {
        testUtils.moveToElementClick(firstAccordion);
        return firstAccordionContent.getText();
    }

    public String getSecondAccordionContent() {
        testUtils.moveToElementClick(secondAccordion);
        return secondAccordionContent.getText();
    }

    public String getThirdAccordionContent() {
        testUtils.moveToElementClick(thirdAccordion);
        return thirdAccordionContent.getText();
    }

}
