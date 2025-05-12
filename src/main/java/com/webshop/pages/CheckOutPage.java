package com.webshop.pages;

import com.webshop.utils.ElementActions;
import com.webshop.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CheckOutPage extends BasePage {
    //Constructor
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    //Variables
    String expectedConfirmMessage = "Your Order Has Been Processed!";
    String confirmMsg;

    //Locator
    private final By CheckOutItemName = By.cssSelector(".align_left a");
    private final By confirmOrderButton = By.id("checkout_btn");
    private final By loader = By.cssSelector("div.wait");
    private final By confirmMessage = By.cssSelector(".maintext");

    //Actions
    //Return Products names in check-out page
    public List<String> getCheckOutProducts() {
        Waits.WaitForVisible(driver, CheckOutItemName);
        List<WebElement> CheckOutItems = ElementActions.findElements(driver, CheckOutItemName);
        return CheckOutItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public String getConfirmMessage() {
        Waits.WaitForVisible(driver,loader);
        Waits.WaitForInvisible(driver,loader);
        confirmMsg = ElementActions.findElement(driver,confirmMessage).getText();
        //confirmMsg = (String) js.executeScript( "return document.querySelector('span.maintext').textContent.trim();");
        return confirmMsg;
    }
    public void clickToConfirmOrder() {
        ElementActions.click(driver,confirmOrderButton);
    }

    //Validation
   /* //Validate that products in (check-out page) match products in (cart page)
    public void validateCheckOutItems(){
        List<String> checkOutProducts = getCheckOutProducts();
        System.out.println("checkOutProducts " + checkOutProducts);
        List<String> cartProducts = new CartPage(driver).getCartProducts();
        System.out.println("cartProducts " + cartProducts);
        Assert.assertEquals(checkOutProducts,cartProducts,"Product in cart doesn't match");
    }*/



    public boolean verifySuccessfulCheckedOut() {
        return getConfirmMessage().equalsIgnoreCase(expectedConfirmMessage);  //true , false
    }
}
