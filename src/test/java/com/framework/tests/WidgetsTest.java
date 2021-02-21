package com.framework.tests;

import com.framework.base.Base;
import com.framework.pages.HomePage;
import com.framework.pages.widgets.Widgets;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WidgetsTest extends Base {

    static WidgetsTest widgetsTest;
    static HomePage homePage;
    static Widgets widgets;
    static Actions actions;
    static SoftAssert softAssert;
    static String URL = "https://demoqa.com/register";

    public WidgetsTest() {
        driverInitialization(URL);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        homePage = new HomePage();
    }

    public static void main(String[] args) {
        widgetsTest = new WidgetsTest();
        widgets = homePage.clickOnWidgets();
        //widgetsTest.autoComplete();
        //widgetsTest.selectDate();
        widgetsTest.slideBar();

        driver.quit();
    }


    @lombok.SneakyThrows
    public void autoComplete() {
        widgets.clickOnAutoComplete();
        findByXPATH("//div [@class = 'auto-complete__value-container auto-complete__" +
                "value-container--is-multi css-1hwfws3']").click();
        findByXPATH("//input[@id='autoCompleteMultipleInput']").sendKeys("White");
        //Thread.sleep(2000);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        //Thread.sleep(1000);
        String expected = driver.findElement(By.xpath("//div[text()='White']")).getText();
        System.out.println(expected);
        softAssert.assertEquals("White", expected);

    }

    @lombok.SneakyThrows
    public void selectDate() {
        widgets.clickOnDatePicker();
        findByXPATH("//input[@id='datePickerMonthYearInput']").click();

        String sendMonth = "March";
        String month = sendMonth.toLowerCase().substring(0, 1).toUpperCase() + sendMonth.substring(1);

        int sendYear = 1901;
        String year = String.valueOf(sendYear);

        String dateString = "5";
        int date = Integer.parseInt(dateString);

        if (date == 1) dateString = date + "st";
        if (date == 2) dateString = date + "nd";
        if (date == 3) dateString = date + "rd";
        else dateString = date + "th";

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Integer.parseInt(year), Calendar.MARCH, date);
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        String day = format.format(calendar.getTime());

        Thread.sleep(1000);
        selectDropDown("//select[@class='react-datepicker__month-select']", 2);
        Thread.sleep(1000);
        selectDropDown("//select[@class='react-datepicker__year-select']", year);
        Thread.sleep(1000);
        findByXPATH("//div[@aria-label='Choose " + day + ", " + month + " " + dateString + ", " + year + "']").click();
        Thread.sleep(1000);

    }

    public void slideBar() {
        widgets.clickOnSlider();
        WebElement slider = findByCSSSelector("div.body-height:nth-child(2) div.container.playgound-body " +
                "div.row div.col-12.mt-4.col-md-6:nth-child(2) form:nth-child(1) div.form-group.row div.col-9" +
                " span.range-slider__wrap > input.range-slider.range-slider--primary");

        Dimension sliderSize = slider.getSize();
        int sliderWidth = sliderSize.getWidth();
        System.out.println(sliderWidth);
        int xCoord = slider.getLocation().getX();
        System.out.println(xCoord);

        actions.dragAndDropBy(slider,sliderWidth/2,0).build().perform();
        //actions.clickAndHold(slider).moveByOffset(  150, 0).build().perform();

        String sliderValue = findByXPATH("//input[@id='sliderValue']").getAttribute("value");
        //int value = Integer.parseInt(sliderValue);
        System.out.println(sliderValue);
        //Assert.assertEquals(value, 50);
    }

    public static WebElement findByXPATH(String XPATH) {
        return driver.findElement(By.xpath(XPATH));
    }

    public static WebElement findByCSSSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public static void selectDropDown(String XPATH, String value) {
        Select select = new Select(driver.findElement(By.xpath(XPATH)));
        try {
            select.selectByValue(value);
        } catch (Exception e) {
            select.selectByVisibleText(value);
            e.printStackTrace();
        }
    }

    public static void selectDropDown(String XPATH, int index) {
        Select select = new Select(driver.findElement(By.xpath(XPATH)));
        select.selectByIndex(index);
    }
}
