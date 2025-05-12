package com.webshop.tests;

import com.webshop.pages.CheckOutPage;
import com.webshop.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {


    @Test(dependsOnMethods = {"com.webshop.tests.HomeTest.addProduct"})
    public void confirmOrder() {
        new LoginPage(driver).logIn("khaled77", "1234");
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.goToCheckOut().clickToConfirmOrder();

        Assert.assertTrue(checkOutPage.verifySuccessfulCheckedOut());
    }
}
