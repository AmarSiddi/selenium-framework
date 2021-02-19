package com.framework.tests;

import com.framework.base.Base;
import com.framework.pages.HomePage;
import com.framework.pages.elements.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ElementsTestUtils extends Base {

    HomePage homePage;
    ElementsPage elementsPage;
    TextBoxPage textBoxPage;
    CheckBoxPage checkBoxPage;
    ButtonsPage buttonsPage;
    LinksPage linksPAge;

    @BeforeMethod
    @Parameters("URL")
    public void setup(String url) {
        driverInitialization(url);
        homePage = new HomePage();
        elementsPage = homePage.clickOnElementsPage();
    }

    @Test(priority = 1, enabled = false)
    public void textBox() {
        textBoxPage = elementsPage.clickTextBox();
        textBoxPage.fillTextBox(prop.getProperty("fullName"), prop.getProperty("email"),
                prop.getProperty("curAddress"), prop.getProperty("perAddress"));
        String verifySavedFullName = driver.findElement(By.xpath("//p[@id='name']")).getText();
        Assert.assertEquals(verifySavedFullName.substring(5), prop.getProperty("fullName"));
    }

    @Test(priority = 2, enabled = false)
    public void checkBox() throws InterruptedException {
        checkBoxPage = elementsPage.clickCheckBox();

        checkBoxPage.expandHome();
        checkBoxPage.expandDesktop();
        checkBoxPage.checkNotesBox();
        checkBoxPage.checkCommandsBox();

        //TODO Learn how to handle checkbox without type="checkbox"
        //Thread.sleep(5000);

        //unCheck the selected boxes
        checkBoxPage.unCheckCommandsBox();
        Thread.sleep(5000);
        checkBoxPage.unCheckNotesBox();
        Thread.sleep(5000);

        //collapseHierarchy
        checkBoxPage.collapseDesktop();
        Thread.sleep(5000);
        checkBoxPage.collapseHome();

    }

    @Test(priority = 3, enabled = false)
    public void verifyButtons() throws InterruptedException {
        buttonsPage = elementsPage.clickButton();
        buttonsPage.performDoubleClickButton();
        buttonsPage.performRightClickButton();
        buttonsPage.performDynamicClickButton();
    }

    @Test(priority = 4, enabled = true)
    public void verifyNewTab(){
        linksPAge = elementsPage.clickLinks();
        String oldTab = driver.getWindowHandle();
        linksPAge.clickOnHomeLink();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());;
    }

}
