package com.webshop.tests;


import com.webshop.pages.HomePage;
import com.webshop.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

    //Variables
    List<String> productsToAdd = List.of("Skinsheen Bronzer Stick", "Benefit Bella Bamba","Flash Bronzer Body Gel","Brunette expressions Conditioner");
    List<String> cartProducts;

    @Test
    public void addProduct(){
        new LoginPage(driver).logIn("khaled77", "1234");
        cartProducts = new HomePage(driver).goToHome().clickToAddProduct(productsToAdd).goToCart().getCartProducts();  //get products in cart page
        //Validate that product added to the cart
        Assert.assertEquals(cartProducts, productsToAdd, "Product in cart doesn't match");
    }
}


