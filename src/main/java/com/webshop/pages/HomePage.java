package com.webshop.pages;

import com.webshop.utils.ElementActions;
import com.webshop.utils.Scrolling;
import com.webshop.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Variables

    //Locators
    private final By productContainer = By.cssSelector("div.thumbnails div.col-md-3");
    private final By productName = By.cssSelector("a.prdocutname");
    private final By AddToCartButton = By.cssSelector("a[title='Add to Cart']");


    //Actions
    public HomePage clickToAddProduct(List<String> productNames) {
        Waits.WaitForVisible(driver, productContainer);  // find product container
        Scrolling.scrollToElement(driver, productContainer);
        List<WebElement> products = ElementActions.findElements(driver,productContainer);
        for (String nameOfProduct : productNames) {
            WebElement product = products.stream()     // return the product which match with name in the list
                    .filter(s -> s.findElement(productName).getText().equalsIgnoreCase(nameOfProduct)).findFirst().orElse(null);
            if (product != null) {
                product.findElement(AddToCartButton).click();   //click on add-button
            } else {
                System.out.println("Product is not available");
            }
        }
        return this;
    }

    //Validation
}
