package com.hepsiburada.steps;

import com.hepsiburada.pages.ReviewsPage;
import io.cucumber.java.en.Then;


public class ReviewsPageSteps {

    private final ReviewsPage reviewsPage = new ReviewsPage();

    @Then("User validates review list opened")
    public void validateReviewsPageOpened() {
        reviewsPage.validateReviewsPageOpened();
    }

    @Then("Validate number of reviews on product and reviews page match")
    public void validateNumberOfReviewsMatchWithProductDetails() {
        reviewsPage.validateNumberOfReviewsMatchWithProductDetails();
    }

}



