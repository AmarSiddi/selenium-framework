package com.framework.utils;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestUtils extends Base {

    Actions actions;

    public TestUtils() {
        actions = new Actions(driver);
    }

    public void moveToElementClick(WebElement element) {
        actions.moveToElement(element).click(element).build().perform();
    }


}
