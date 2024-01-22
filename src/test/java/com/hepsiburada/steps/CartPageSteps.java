package com.hepsiburada.steps;

import com.hepsiburada.pages.CartPage;
import io.cucumber.java.en.Then;


public class CartPageSteps {

    private final CartPage cartPage = new CartPage();

    @Then("User validates product is in my cart")
    public void validateProductInMyCart() {
        cartPage.validateProductInMyCart();
    }

}



