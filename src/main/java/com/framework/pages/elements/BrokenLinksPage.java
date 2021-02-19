package com.framework.pages.elements;

import com.framework.base.Base;
import com.framework.utils.LinksImagesUtils;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinksPage extends Base {

    LinksImagesUtils linksImages;

    public BrokenLinksPage() {
        PageFactory.initElements(driver, this);
        linksImages = new LinksImagesUtils();
    }

    public boolean getAllBrokenLinks() {
        return !linksImages.getAllBrokenLinks().isEmpty();
    }

    public boolean getAllBrokenImages() {
        return !linksImages.getAllBrokenImages().isEmpty();
    }
}