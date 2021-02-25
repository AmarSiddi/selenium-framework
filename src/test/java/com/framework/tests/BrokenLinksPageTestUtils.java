package com.framework.tests;

import com.framework.base.Base;
import com.framework.pages.HomePage;
import com.framework.pages.elements.BrokenLinksPage;
import com.framework.pages.elements.ElementsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrokenLinksPageTestUtils extends Base {
    HomePage homePage;
    BrokenLinksPage brokenLinksPage;
    ElementsPage elementsPage;

    @BeforeMethod
    @Parameters({"URL","browserName"})
    public void setUp(String url, String browserName) {
        driverInitialization(url, browserName);
        homePage = new HomePage();
        elementsPage = homePage.clickOnElementsPage();
        brokenLinksPage = elementsPage.brokenLinks();
    }

    @Test(priority = 1, enabled = false)
    public void verifyBrokenImages() {
        Assert.assertTrue(brokenLinksPage.getAllBrokenImages());
        //This should be handled in the real time projects
        //Assert.assertFalse(brokenLinksPage.getAllBrokenImage(););
    }

    @Test(priority = 2, enabled = true)
    public void verifyBrokenLinks() {
        Assert.assertTrue(brokenLinksPage.getAllBrokenLinks());
    }
}
