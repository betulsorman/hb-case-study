package com.hepsiburada.steps;

import com.hepsiburada.pages.HomePage;
import io.cucumber.java.en.When;


public class HomePageSteps {

    private final HomePage homePage = new HomePage();

    @When("dismiss onboarding tool tip")
    public void dismissOnboardingToolTip() {
        homePage.dismissOnboardingToolTip();
    }

    @When("search {string} product")
    public void searchKeyword(String product) {
        homePage.enterProduct(product);
    }
}



