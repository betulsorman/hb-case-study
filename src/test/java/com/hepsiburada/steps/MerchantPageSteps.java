package com.hepsiburada.steps;

import com.hepsiburada.pages.MerchantPage;
import io.cucumber.java.en.When;


public class MerchantPageSteps {

    private final MerchantPage merchantPage = new MerchantPage();

    @When("User validates merchant page opened with correct merchant name")
    public void validateMerchantPageOpened() {
        merchantPage.validateMerchantPageOpened();
    }

}



