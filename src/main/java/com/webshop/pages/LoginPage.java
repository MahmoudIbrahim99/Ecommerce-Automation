package com.webshop.pages;

import com.webshop.utils.BrowserActions;
import com.webshop.utils.ElementActions;
import com.webshop.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Variables
    String expectedUrl = "https://automationteststore.com/index.php?rt=account/account";  //Home URL
    String expectedErrorMessage = "Error: Incorrect login or password provided.";

    //Locators
    private final By userField = By.id("loginFrm_loginname");
    private final By passwordField = By.id("loginFrm_password");
    private final By loginButton = By.cssSelector("button[type='submit'][title='Login']");
    private final By continueButton = By.cssSelector("button[title='Continue']");

    //Actions
    public void logIn(String username, String password) {
        goToLogin();
        ElementActions.sendData(driver, userField, username);
        ElementActions.sendData(driver, passwordField, password);
        ElementActions.click(driver, loginButton);
    }

    public String getErrorMessage() {
        String errorMsg = (String) js.executeScript("return document.querySelector('.alert-error').childNodes[2].nodeValue.trim();");
        System.out.println(errorMsg);
        return errorMsg;
    }

    public void clickOnContinueButton(){
        ElementActions.click(driver,continueButton);
    }

    //Validation
    public boolean verifySuccessfulLogin(){
        Waits.waitForURL(driver, expectedUrl);
        return BrowserActions.getCurrentUrl(driver).equals(expectedUrl);  //true , false
    }
    public boolean verifyFailLogin(){
        return getErrorMessage().equals(expectedErrorMessage);  //true , false
    }



}
