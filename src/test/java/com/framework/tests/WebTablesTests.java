package com.framework.tests;

import com.framework.base.Base;
import com.framework.pages.elements.WebTables;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTablesTests extends Base {

    WebTables webTables;

    @BeforeMethod
    @Parameters("URL")
    public void setup(String url){
        driverInitialization(url);
        webTables = new WebTables();
    }

    @Test(priority = 1, enabled = false)
    public void verifyTableBodyHeaders(){
        Assert.assertEquals(webTables.getTableBodyHeadersCount(), webTables.getTotalValueFromFooter());
    }

    @Test(priority = 2, enabled = false)
    public void verifyBurjKhalifaHeight(){
        Assert.assertEquals("829m", webTables.getBurjKhalifaHeight());
    }

    @Test(priority = 3)
    public void verifyTableBodyData(){
        webTables.getTableBodyValues();
    }

}
