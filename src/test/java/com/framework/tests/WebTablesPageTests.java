package com.framework.tests;

import com.framework.base.Base;
import com.framework.pages.elements.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTablesPageTests extends Base {

    WebTablesPage webTablesPage;

    @BeforeMethod
    @Parameters("URL")
    public void setup(String url){
        driverInitialization(url);
        webTablesPage = new WebTablesPage();
    }

    @Test(priority = 1, enabled = false)
    public void verifyTableBodyHeaders(){
        Assert.assertEquals(webTablesPage.getTableBodyHeadersCount(), webTablesPage.getTotalValueFromFooter());
    }

    @Test(priority = 2, enabled = false)
    public void verifyBurjKhalifaHeight(){
        Assert.assertEquals("829m", webTablesPage.getBurjKhalifaHeight());
    }

    @Test(priority = 3)
    public void verifyTableBodyData(){
        webTablesPage.getTableBodyValues();
    }

}
