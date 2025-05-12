package com.webshop.pages;

import com.webshop.utils.ElementActions;
import com.webshop.utils.Scrolling;
import com.webshop.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    //Locators
    private final By homeButton = By.cssSelector(".menu_home");
    private final By loginButton = By.id("customer_menu_top");
    private final By cartContainerToHover = By.cssSelector("div.block_7 li.dropdown");
    private final By cartButton = By.cssSelector("a[title = 'View Cart']");
    private final By accountToHover = By.cssSelector("div.topnavbar a.menu_account");
    private final By logOutButton = By.cssSelector("div.topnavbar a.menu_logout");
    private final By checkOutButton = By.cssSelector("div.topnavbar a.menu_checkout");
    private final By yourOrderButton = By.cssSelector("div.topnavbar a.menu_order");

    public void goToLogin() {
        ElementActions.click(driver, loginButton);
    }

    public HomePage goToHome() {
        ElementActions.click(driver, homeButton);
        return new HomePage(driver);
    }

    public CartPage goToCart() {
        Waits.WaitForVisible(driver, cartContainerToHover);
        Scrolling.scrollToElement(driver, cartContainerToHover);
        actions.moveToElement(driver.findElement(cartContainerToHover)).perform();
        ElementActions.click(driver, cartButton);
        return new CartPage(driver);
    }

    public CheckOutPage goToCheckOut() {
        ElementActions.click(driver,checkOutButton);
        return new CheckOutPage(driver);
    }

    public void goLogOut() {
        Waits.WaitForVisible(driver, accountToHover);
        Scrolling.scrollToElement(driver, accountToHover);
        actions.moveToElement(driver.findElement(accountToHover)).perform();
        ElementActions.click(driver, logOutButton);
    }

    public OrderHistoryPage goToOrderHistory() {
        Waits.WaitForVisible(driver, accountToHover);
        Scrolling.scrollToElement(driver, accountToHover);
        actions.moveToElement(driver.findElement(accountToHover)).perform();
        ElementActions.click(driver, yourOrderButton);
        return new OrderHistoryPage(driver);
    }

    public void selectByVisibleText(By locator, String text) {
        Waits.WaitForVisible(driver, locator);
        Waits.waitForTextToBePresent(driver, locator, text);
        Select select = new Select(ElementActions.findElement(driver, locator));
        select.selectByVisibleText(text);
    }

}
