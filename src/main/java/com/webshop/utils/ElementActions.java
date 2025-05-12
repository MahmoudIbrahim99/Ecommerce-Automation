package com.webshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementActions {
    private ElementActions() {
    }    //To Prevent Creating Object From This Class


    //Find Element
    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
    //Find Elements
    public static List<WebElement> findElements(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }

    //Send Keys
    public static void sendData(WebDriver driver, By locator, String data) {
        Waits.WaitForVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(data);
    }

    //Click
    public static void click(WebDriver driver, By locator) {
        Waits.WaitForClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).click();
    }

    //Get Text
    public static String getText(WebDriver driver, By locator) {
        Waits.WaitForVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return findElement(driver, locator).getText();
    }

}
