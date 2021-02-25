package com.framework.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.base.Base;
import com.framework.pages.HomePage;
import com.framework.pages.forms.FormPage;
import com.framework.utils.ReadExcelFile;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class FormPageTest extends Base {

    static HomePage homePage;
    static FormPage formPage;

    @BeforeMethod
    @Parameters({"URL", "browserName"})
    public void setUp(String url, String browserName) {

        driverInitialization(url, browserName);
        homePage = new HomePage();
        formPage = homePage.clickOnForm();
        formPage.clickPracticeFormLink();
    }

    @DataProvider()
    public Iterator<Object[]> getData() {
        ArrayList<Object[]> arrayList = new ReadExcelFile().readDataFromExcel();
        return arrayList.iterator();
    }

    @Test(dataProvider = "getData", priority = 1, enabled = false)
    @SneakyThrows
    public void verifyForm(String firstName, String lastName, String email, String gender, String mobileNumber) {
        //System.out.print(firstName+" "+lastName+" "+email+" "+gender+" "+mobileNumber);

        formPage.enterFirstName(firstName);
        formPage.enterLastName(lastName);
        formPage.enterEmail(email);
        formPage.selectGender(gender);
        Thread.sleep(2000);
        formPage.enterMobileNumber(mobileNumber);
        Thread.sleep(2000);
        formPage.clickOnSubmit();
        Thread.sleep(1000);

        //TODO
        // assert the value entered for each field after clicking on submission, here in this case a new pop up will be
        // displayed, so you been to fetch the details from it and assert it with the data entered. But in the realtime
        // you may only get the confirmation message either you have to verify that or else you need to verify the data
        // stored in the database using JDBC driver or any other utility which you are familiar with for DB communication.

    }

    @Test(priority = 2)
    @SneakyThrows
    public void test() {
        formPage.selectGender("Male");
        Thread.sleep(1000);
      /*  boolean boo1 = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']")).isEnabled();
        boolean boo2 = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']")).isSelected();
        boolean boo3 = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']")).isDisplayed();*/
        //System.out.println(formPage.isGenderChecked("Male"));
       /* System.out.println(boo1);
        System.out.println(boo2);
        System.out.println(boo3);*/

        Assert.assertTrue(formPage.isGenderChecked("Male"));
        Thread.sleep(2000);
        formPage.selectGender("Other");
        Thread.sleep(2000);

    }

}
