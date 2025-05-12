package com.webshop.tests;

import com.webshop.data.LoginExcelReader;
import com.webshop.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {


    @DataProvider(name = "loginData")
    public Object[][] userLoginData() throws IOException {
        LoginExcelReader excelReader = new LoginExcelReader();
        return excelReader.getExcelData();
    }
    @Test(dataProvider = "loginData")
    public void validLogin(String userName , String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userName, password);
        Assert.assertTrue(loginPage.verifySuccessfulLogin(), "Failed Register");
    }

    @Test
    public void inValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(" ", " ");
        Assert.assertTrue(loginPage.verifyFailLogin(), "don't match");
    }

}
