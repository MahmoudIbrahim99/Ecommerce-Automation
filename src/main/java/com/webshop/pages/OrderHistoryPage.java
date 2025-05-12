package com.webshop.pages;

import com.webshop.utils.ElementActions;
import com.webshop.utils.Scrolling;
import com.webshop.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class OrderHistoryPage extends BasePage{
    //Constructor
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }


    //Variables


    //Locators
    private final By viewBtn = By.id("button_edit");
    private final By orderItemName = By.xpath("//tr /td[contains(@class,'align_left')][1]/a");
    private final By orderItemContainer = By.cssSelector(".invoice_products");


    //Actions
    public OrderHistoryPage clickOnView(){
        ElementActions.click(driver,viewBtn);
        return new OrderHistoryPage(driver);
    }

    //Return Products names in order-history page
    public List<String> getOrderProducts() {
        Waits.WaitForVisible(driver,orderItemName);
        Scrolling.scrollToElement(driver,orderItemContainer);
        List<WebElement> orderItems = ElementActions.findElements(driver,orderItemName);
        return orderItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    //Validation
}
