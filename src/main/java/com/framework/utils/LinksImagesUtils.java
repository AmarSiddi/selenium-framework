package com.framework.utils;

import com.framework.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LinksImagesUtils extends Base {

    public ArrayList<String> getAllLinksFromWebPage() {
        ArrayList<String> al = new ArrayList<>();
        for (WebElement element : driver.findElements(By.tagName("a"))) {
            al.add(element.getAttribute("href"));
        }
        return al;
    }

    public int getLinksCount() {
        return getAllLinksFromWebPage().size();
    }

    public int getBrokenLinkCounts() {
        return getAllBrokenLinks().size();
    }

    @lombok.SneakyThrows
    public ArrayList<String> getAllBrokenLinks() {

        ArrayList<String> links = new ArrayList<>();

        for (String urlString : getAllLinksFromWebPage()) {
            URL url = new URL(urlString);
            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setConnectTimeout(3000);
            openConnection.connect();
            int responseCode = openConnection.getResponseCode();
            if (responseCode == 200)
                System.out.println("Success: " + openConnection.getResponseMessage());
            else if (openConnection.getResponseCode() >= 400)
                links.add(urlString);
            else {
                System.out.println("***************************************************");
                System.out.println("Response Code: " + openConnection.getResponseCode());
                System.out.println("Response Message: " + openConnection.getResponseMessage());
                System.out.println("Request Method: " + openConnection.getRequestMethod());
                System.out.println("Connection Timeout: " + openConnection.getConnectTimeout());
                System.out.println("Error Stream: " + openConnection.getErrorStream());
            }
        }
        return links;
    }

    public int getImageLinksCount() {
        return getAllImagesFromWebPage().size();
    }

    public int getBrokenImageLinksCount() {
        return getAllBrokenImages().size();
    }

    public List<WebElement> getAllImagesFromWebPage() {
        return driver.findElements(By.cssSelector("img"));
    }

    public ArrayList<WebElement> getAllBrokenImages() {
        ArrayList<WebElement> brokenImages = new ArrayList<>();
        for (WebElement element : getAllImagesFromWebPage()) {
            if (element.getAttribute("naturalWidth").equals("0")) {
                brokenImages.add(element);
            }
        }
        return brokenImages;
    }
}
