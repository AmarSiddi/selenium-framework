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

public class ElementsTest extends Base {

    HomePage homePage;
    ElementsPage elementsPage;
    TextBox textBox;
    CheckBox checkBox;
    Buttons buttons;
    Links links;

    @BeforeMethod
    @Parameters("URL")
    public void setup(String url) {
        driverInitialization(url);
        homePage = new HomePage();
        elementsPage = homePage.clickElementsPage();
    }

    @Test(priority = 1, enabled = false)
    public void textBox() {
        textBox = elementsPage.clickTextBox();
        textBox.fillTextBox(prop.getProperty("fullName"), prop.getProperty("email"),
                prop.getProperty("curAddress"), prop.getProperty("perAddress"));
        String verifySavedFullName = driver.findElement(By.xpath("//p[@id='name']")).getText();
        Assert.assertEquals(verifySavedFullName.substring(5), prop.getProperty("fullName"));
    }

    @Test(priority = 2, enabled = false)
    public void checkBox() throws InterruptedException {
        checkBox = elementsPage.clickCheckBox();

        checkBox.expandHome();
        checkBox.expandDesktop();
        checkBox.checkNotesBox();
        checkBox.checkCommandsBox();

        //TODO Learn how to handle checkbox without type="checkbox"
        //Thread.sleep(5000);

        //unCheck the selected boxes
        checkBox.unCheckCommandsBox();
        Thread.sleep(5000);
        checkBox.unCheckNotesBox();
        Thread.sleep(5000);

        //collapseHierarchy
        checkBox.collapseDesktop();
        Thread.sleep(5000);
        checkBox.collapseHome();

    }

    @Test(priority = 3, enabled = false)
    public void verifyButtons() throws InterruptedException {
        buttons = elementsPage.clickButton();
        buttons.performDoubleClickButton();
        buttons.performRightClickButton();
        buttons.performDynamicClickButton();
    }

    @Test(priority = 4, enabled = true)
    public void verifyNewTab(){
        links = elementsPage.clickLinks();
        String oldTab = driver.getWindowHandle();
        links.clickOnHomeLink();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());;
    }

}
