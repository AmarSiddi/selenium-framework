package com.framework.pages.elements;

import com.framework.base.Base;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinks extends Base {



    public BrokenLinks(){
        PageFactory.initElements(driver, this);
    }

    //TODO these below logic can be added to the Utils
    //TODO develop a logic to fetch all broken links in a website
    public void getAllBrokenLinks(){

    }

    //TODO develop a logic to find all broken images in a website
    public void getAllBrokenImage(){

    }
}
