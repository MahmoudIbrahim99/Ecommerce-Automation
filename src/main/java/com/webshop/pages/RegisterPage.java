package com.webshop.pages;

import com.webshop.utils.BrowserActions;
import com.webshop.utils.ElementActions;
import com.webshop.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    //Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Variables
    String expectedUrl = "https://automationteststore.com/index.php?rt=account/success";  //Home URL
    String expectedErrorMessage = "Error: You must agree to the Privacy Policy!";

    //Locators
    private final By firstName = By.id("AccountFrm_firstname");
    private final By lastName = By.id("AccountFrm_lastname");
    private final By email = By.id("AccountFrm_email");
    private final By address = By.id("AccountFrm_address_1");
    private final By city = By.id("AccountFrm_city");
    private final By zipCode = By.id("AccountFrm_postcode");
    private final By stateDropDown = By.id("AccountFrm_zone_id");
    private final By countryDropDown = By.name("country_id");
    private final By loginName = By.id("AccountFrm_loginname");
    private final By password = By.id("AccountFrm_password");
    private final By confirmPassword = By.id("AccountFrm_confirm");
    private final By policyCheck = By.id("AccountFrm_agree");
    private final By registerButton = By.cssSelector("button[type='submit'][title='Continue']");


    //Actions
    public void Register(String firstname, String lastname, String emailValue, String addressValue, String cityName, String zipCodeValue, String countryName, String stateName, String loginNameValue, String pass, String confirmPass) {
        goToLogin();   //click on login/register button
        new LoginPage(driver).clickOnContinueButton(); //click on continue-button
        ElementActions.sendData(driver, firstName, firstname);   //enter first-name
        ElementActions.sendData(driver, lastName, lastname);     //enter last-name
        ElementActions.sendData(driver, email, emailValue);      //enter email
        ElementActions.sendData(driver, address, addressValue);  //enter address
        ElementActions.sendData(driver, city, cityName);         //enter city
        ElementActions.sendData(driver, zipCode, zipCodeValue);  //enter zip-code
        selectByVisibleText(countryDropDown, countryName);       //select country
        selectByVisibleText(stateDropDown, stateName);           //select state
        ElementActions.sendData(driver, loginName, loginNameValue);    //enter login-name
        ElementActions.sendData(driver, password, pass);               //enter password
        ElementActions.sendData(driver, confirmPassword, confirmPass); //enter confirm-password
        ElementActions.click(driver, policyCheck);                     //click on policy
        ElementActions.click(driver, registerButton);                  //click on register-button
    }
    public void clickOnRegisterButtonFail(){
        goToLogin();   //click on login/register button
        new LoginPage(driver).clickOnContinueButton(); //click on continue-button
        ElementActions.click(driver,registerButton);   //click on register-button
    }
    public String getErrorMessage(){
        String errorMsg = (String) js.executeScript("return document.querySelector('.alert-error').childNodes[2].nodeValue.trim();");
        System.out.println(errorMsg);
        return errorMsg;
    }

    //Validation
    public boolean verifySuccessfulRegister(){
        Waits.waitForURL(driver, expectedUrl);
        return BrowserActions.getCurrentUrl(driver).equals(expectedUrl);  //true , false
    }
    public boolean verifyFailRegister(){
        return getErrorMessage().equals(expectedErrorMessage);  //true , false
    }

}
