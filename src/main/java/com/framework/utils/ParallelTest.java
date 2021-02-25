package com.framework.utils;

import org.openqa.selenium.chrome.ChromeDriver;

public class ParallelTest {

    public static void main(String[] args) {

    }

    public void test(){
        ThreadLocal<ChromeDriver> threadLocal = new ThreadLocal<>();
        threadLocal.get();
    }
}
