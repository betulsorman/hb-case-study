package com.hepsiburada.pages;

import com.hepsiburada.contants.Constants;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='continue_step_btn']")
    private WebElement completeShoppingButton;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='onboarding_item_list']")
    private WebElement cartListContainer;


    public CartPage() {
    }


    public void validateProductInMyCart() {
        // Check cart is not empty and "Alışverişi tamamla" button is available

        String completeShoppingButtonText = getText(completeShoppingButton, "Complete shopping button text: ");
        Assert.assertTrue(cartListContainer.isDisplayed());
        Assert.assertEquals(Constants.COMPLETE_SHOPPING, completeShoppingButtonText);
    }
}
