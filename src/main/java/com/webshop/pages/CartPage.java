package com.webshop.pages;

import com.webshop.utils.ElementActions;
import com.webshop.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage{
    //Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Locators
//    private final By cartItemName = By.cssSelector(".align_left a");
    private final By cartItemName = By.xpath("//tr /td[@class='align_center'][1]/following-sibling::td[1]/a");
    private final By CheckButton = By.id("cart_checkout1");

    //Actions
    //Return Products names in cart page
    public List<String> getCartProducts() {
        Waits.WaitForVisible(driver,cartItemName);
        List<WebElement> cartItems = ElementActions.findElements(driver,cartItemName);
        return cartItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void ClickOnCheckButton(){
        ElementActions.click(driver,CheckButton);
    }
}
