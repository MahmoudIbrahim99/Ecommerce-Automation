package com.webshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private Waits() {
    }    //To Prevent Creating Object From This Class

    //Present - Visible - Clickable

    //Wait the element to be present
    public static WebElement WaitForPresent(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Wait the element to be visible
    public static void WaitForVisible(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(WaitForPresent(driver, locator)));
    }

    //Wait the element to be invisible
    public static void WaitForInvisible(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //Wait the element to be clickable
    public static void WaitForClickable(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Wait For URL To Be Present
    public static void waitForURL(WebDriver driver, String expectedURL) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(expectedURL));
    }

    //Wait For Text To Be Present in Element
    public static void waitForTextToBePresent(WebDriver driver, By locator, String name) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, name));
    }

}
