package com.hepsiburada.steps;

import com.hepsiburada.pages.ProductListingPage;
import io.cucumber.java.en.When;


public class ProductListingPageSteps {

    private final ProductListingPage productListingPage = new ProductListingPage();

    @When("validate product list has product {string}")
    public void validateProductListPage(String product) {
        productListingPage.validateProductListing(product);
    }

    @When("click first product")
    public void clickFirstProduct() {
        productListingPage.clickFirstProduct();
    }
}



