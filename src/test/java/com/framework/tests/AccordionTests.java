package com.framework.tests;

import com.framework.base.Base;
import com.framework.pages.HomePage;
import com.framework.pages.widgets.AccordionPage;
import com.framework.pages.widgets.Widgets;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccordionTests extends Base {

    HomePage homePage;
    Widgets widgets;
    AccordionPage accordionPage;

    @BeforeMethod
    @Parameters({"URL", "browserName"})
    public void setUp(String url, String browserName) {
        driverInitialization(url, browserName);
        homePage = new HomePage();
        widgets = homePage.clickOnWidgets();
        accordionPage = widgets.clickOnAccordion();
    }

    @Test(priority = 1, enabled = true)
    public void verifyAccordions() {
        Assert.assertEquals("What is Lorem Ipsum?", accordionPage.getAllAccordions().get(0));
        Assert.assertEquals("Where does it come from?", accordionPage.getAllAccordions().get(1));
        Assert.assertEquals("Why do we use it?", accordionPage.getAllAccordions().get(2));
        //System.out.println(accordionPage.getAllAccordions());
    }

    @Test(priority = 2)
    public void verifyFirstAccordionContent() {
        Assert.assertTrue(!accordionPage.getFirstAccordionContent().isEmpty());

    }

    @Test(priority = 3)
    public void verifySecondAccordionContent() {
        Assert.assertTrue(!accordionPage.getSecondAccordionContent().isEmpty());
    }

    @Test(priority = 4)
    public void verifyThirdAccordionContent() {
        Assert.assertTrue(!accordionPage.getThirdAccordionContent().isEmpty());

    }

}
