package com.framework.pages.elements;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/******
 * link to the problem: https://www.techlistic.com/p/demo-selenium-practice.html
 *
 * Assignment 1: Verify that there are only 4 structure values present.
 Read the 'Structure' column and find out the total number of structures present.
 Read the value of 'Total' column and match with the previous step.
 Solution Hint:
 Use list to store the structure values.
 Find the length of the list  and match with the expected value.
 * Assignment 2: Read All the Values from the table row-wise and print them all
 Solution Hint:
 Use for loop to read all the values of the table.
 * Assignment 3: Verify that Burj Khalifa has a height of 829m (similar for other structures)
 *
 * Assignment 4: Verify that 6th row (Last Row) has only two columns.
 *******/

public class WebTables extends Base {


    @FindBy(xpath = "//table[@class='tsc_table_s13']/tbody/tr/th[1]")
    List<WebElement> tableBodyHeadersList;

    @FindBy(xpath = "//table[@class='tsc_table_s13']/tbody/tr/td")
    List<WebElement> tableBodyValuesList;

    @FindBy(xpath = "//table[@class='tsc_table_s13']/tfoot/tr[1]/td")
    WebElement tableFooterValue;

    @FindBy(xpath = "//table[@class='tsc_table_s13']/thead/tr/th")
    WebElement tableRowHeaders;

    @FindBy(xpath = "//table[@class='tsc_table_s13']/tbody[1]/tr[1]/td[3]")
    WebElement burjKhalifaHeight;

    @FindBy(xpath = "//table[@class='tsc_table_s13']/tfoot/tr[1]")
    WebElement tableFoot;


    public WebTables() {
        PageFactory.initElements(driver, this);
    }

    public int getTableBodyHeadersCount() {
        return tableBodyHeadersList.size();

        /*tableBodyHeadersList.forEach((temp) -> {
            System.out.println(temp.getText());
        });
        System.out.println(tableBodyHeadersList.size());
        for (WebElement temp : tableBodyHeadersList) {
            System.out.println(temp.getText());
        }*/
    }

    public int getTotalValueFromFooter() {
        return Integer.parseInt(tableFooterValue.getText().substring(0, 1));
    }

    public String getBurjKhalifaHeight() {
        return burjKhalifaHeight.getText();
    }

    public void getTableBodyValues() {

        ArrayList<String> alist = new ArrayList<String>();
        for (WebElement element : tableBodyValuesList) {
            alist.add(element.getText());
            String value = element.getText();
            if (value.equals("")) {
                System.out.println();
                //System.out.println("Found1" +element.getText().getClass());
            }else{
                System.out.print(value+" ");
            }
        }

        /*System.out.println();
        System.out.println("Different ways to print ArrayList as follows: ");
        System.out.println(Arrays.toString(alist.toArray()));
        System.out.println(Arrays.toString(alist.toArray()).replaceAll("[\\[\\]]", ""));
        alist.stream().forEach(System.out::println);
        System.out.println(alist.stream().map(Object::toString).collect(Collectors.joining("\n")));*/

    }

    //TODO Learn how to traverse complete table and selenium whole column section
    public void getColumsInLastRow(){

    }
}
