package com.webshop.tests;

import com.github.javafaker.Faker;
import com.webshop.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = "Smouha";
    String city = "Alex";
    String zipCode = "020";
    String country = "Egypt";
    String state = "Aswan";
    String loginName = faker.regexify("[a-zA-Z0-9]{8,12}");
    String password = faker.number().digits(4);
    String confirmPassword = password;


    @Test
    public void validRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register(
                firstName, lastName, email, address, city, zipCode,
                country, state, loginName, password, confirmPassword
        );
        Assert.assertTrue(registerPage.verifySuccessfulRegister(),"Failed Register");
    }

    @Test
    public void invalidRegister() {
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.clickOnRegisterButtonFail();
        Assert.assertTrue(registerpage.verifyFailRegister(),"don't match");
    }
}
