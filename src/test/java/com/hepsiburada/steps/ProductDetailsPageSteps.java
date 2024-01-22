package com.hepsiburada.steps;

import com.hepsiburada.pages.ProductDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProductDetailsPageSteps {

    private final ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Then("User validates product details page with product {string}")
    public void validateProductDetails(String product) {
        productDetailsPage.validateProductDetails(product);
    }

    @When("User clicks add to cart")
    public void clickAddToCart() {
        productDetailsPage.clickAddToCart();
    }

    @Then("User validates product added to cart successfully")
    public void validateAddedToCart() {
        productDetailsPage.validateAddedToCartSuccess();
    }

    @When("User clicks navigate to cart")
    public void clickNavigateToCart() {
        productDetailsPage.clickNavigateToCart();
    }


    @When("User clicks compare products")
    public void clickCompareProducts() {
        productDetailsPage.clickCompareProducts();
    }

    @Then("User validates product added to comparison list successfully")
    public void validateProductAddedToComparisonList() {
        productDetailsPage.validateProductAddedToComparisonList();
    }

    @When("User clicks all reviews")
    public void clickAllReviews() {
        productDetailsPage.clickAllReviews();
    }

    @When("User clicks merchant")
    public void clickMerchant() {
        productDetailsPage.clickMerchant();
    }


}



