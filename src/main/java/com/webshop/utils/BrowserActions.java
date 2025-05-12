package com.webshop.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {
    }//To Prevent Creating Object From This Class

    //Navigate To URL
    public static void GetUrl(WebDriver driver, String url) {
        driver.get(url);
    }
    //Navigate To URL
    public static void navigateToUrl(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    //Get Current URL
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    //Get Page Title
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    //Refresh Page
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

}
