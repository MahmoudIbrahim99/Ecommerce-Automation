package com.webshop.tests;

import com.webshop.pages.LoginPage;
import com.webshop.pages.OrderHistoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OrderHistoryTest extends BaseTest{

    //Variables
    List<String> productsToAdd = List.of("Skinsheen Bronzer Stick", "Benefit Bella Bamba","Flash Bronzer Body Gel","Brunette expressions Conditioner");
    List<String> orderProducts;

    @Test(dependsOnMethods = {"com.webshop.tests.CheckOutTest.confirmOrder","com.webshop.tests.HomeTest.addProduct" })
    public void OrderHistoryProducts(){
        new LoginPage(driver).logIn("khaled77", "1234");
        orderProducts = new OrderHistoryPage(driver).goToOrderHistory().clickOnView().getOrderProducts();  //get products in order page
        //Validate that product added to the order history
        Assert.assertEquals(orderProducts, productsToAdd, "Product in order doesn't match");
    }
}
