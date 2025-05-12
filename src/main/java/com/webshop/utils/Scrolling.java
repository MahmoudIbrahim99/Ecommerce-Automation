package com.webshop.utils;

import org.openqa.selenium.*;
import static com.webshop.utils.ElementActions.findElement;

public class Scrolling {
    public Scrolling() {
    }  //To Prevent Creating Object From This Class

    //Scroll to element
    public static void scrollToElement(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", findElement(driver, locator));
//      js.executeScript("arguments[0].scrollIntoView(true);", findElement(driver, locator));
    }
}
