package com.framework.pages.forms;

import com.framework.base.Base;
import com.framework.utils.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends Base {

    //@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/span[1]")
    @FindBy(xpath = "//span[text()='Practice Form']")
    WebElement practiceFormLink;

    //@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[2]/input[1]")
    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement email;

    //@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/label[1]")
    @FindBy(xpath = "//input[@name='gender' and @value='Male']//following::label[1]")
    WebElement male;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement female;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement other;

    @FindBy(id = "userNumber")
    WebElement mobileNumber;

    @FindBy(css = "#hobbies-checkbox-1")
    WebElement sports;

    @FindBy(css = "#hobbies-checkbox-2")
    WebElement reading;

    @FindBy(css = "#hobbies-checkbox-3")
    WebElement music;

    //TODO
    @FindBy(xpath = "")
    WebElement selectCity;

    //TODO
    @FindBy(xpath = "")
    WebElement selectState;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submit;


    JavaScriptUtils javaScriptUtils;
    public FormPage() {
        PageFactory.initElements(driver, this);
        javaScriptUtils = new JavaScriptUtils();
    }

    public void clickPracticeFormLink() {
        practiceFormLink.click();
    }

    public void enterFirstName(String fName) {
        firstName.clear();
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastName.clear();
        lastName.sendKeys(lName);
    }

    public void enterEmail(String emailAddress) {
        email.clear();
        email.sendKeys(emailAddress);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) male.click();
        if (gender.equalsIgnoreCase("Female")) female.click();
        if (gender.equalsIgnoreCase("Other")) other.click();
    }

    public boolean isGenderChecked(String gender){
        if (gender.equalsIgnoreCase("Male"))
            return driver.findElement(By.xpath("//input[@name='gender' and @value='Male']")).isSelected();
        if (gender.equalsIgnoreCase("Female"))
            return driver.findElement(By.xpath("//input[@name='gender' and @value='Female']")).isSelected();
        if (gender.equalsIgnoreCase("Other"))
            return driver.findElement(By.xpath("//input[@name='gender' and @value='Other']")).isSelected();
        else return false;
    }


    public void enterMobileNumber(String phoneNumber) {
        mobileNumber.clear();
        mobileNumber.sendKeys(phoneNumber);
    }

    public void clickOnSubmit(){
        javaScriptUtils.scrollToElement(submit);
        submit.click();
    }

}
