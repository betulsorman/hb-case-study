package com.hepsiburada.pages;

import com.hepsiburada.contants.Constants;
import com.hepsiburada.utils.LocalStorageUtils;
import com.hepsiburada.utils.TextUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage {

    // Product details

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvProductName")
    private WebElement productTitleText;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvPrice")
    private WebElement productPriceText;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvMerchantName")
    private WebElement productMerchantNameText;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/product_detail_add_to_cart_text")
    private WebElement addToCartButton;


    // Product added to cart

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/productSuccesTxt")
    private WebElement addedToCartSuccessText;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/goBasketTxt")
    private WebElement navigateToCartButton;


    // Reviews

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvAllReviews")
    private WebElement allReviewsText;


    // Product comparison

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/iconGroupLl")
    private WebElement compareProductsButton;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/compareStatusTV")
    private WebElement addedToComparisonListSuccessText;



    public ProductDetailsPage() {
    }


    public void validateProductDetails(String product) {
        String productTitle = getText(productTitleText, "Product title: ");
        String productPrice = getText(productPriceText, "Product price: ");
        String bottomCartText = getText(addToCartButton, "Add to cart button text:");

        // Validate product details data
        Assert.assertTrue(productTitle.toLowerCase().contains(product.toLowerCase()));
        Assert.assertFalse(productPrice.isEmpty());
        Assert.assertTrue(
                bottomCartText.equalsIgnoreCase(Constants.PRE_ORDER_TEXT) ||
                        bottomCartText.equalsIgnoreCase(Constants.ADD_TO_CART)
        );

    }

    public void clickAddToCart() {
        click(addToCartButton, "Add to cart button clicked");
    }


    public void validateAddedToCartSuccess() {
        String addedToCartSuccess = getText(addedToCartSuccessText, "Added to cart success: ");
        Assert.assertEquals(Constants.PRODUCT_IN_CART_MESSAGE, addedToCartSuccess);
    }

    public void clickNavigateToCart() {
        click(navigateToCartButton, "Navigate to cart button clicked");
    }


    public void clickCompareProducts() {
        click(compareProductsButton, "Compare products button clicked");
    }

    public void validateProductAddedToComparisonList() {
        String addToComparisonListSuccess = getText(addedToComparisonListSuccessText, "Added to comparison list success: ");
        Assert.assertEquals(Constants.COMPARISON_LIST_SUCCESS_MESSAGE, addToComparisonListSuccess);
    }

    public void clickAllReviews() {
        // Store number of reviews in product page to compare with reviews page
        String numberOfReviewsText = getText(allReviewsText, "Number of reviews: ");
        LocalStorageUtils.setItem(LocalStorageUtils.CURRENT_PRODUCT_NUMBER_OF_REVIEWS_KEY, TextUtils.getNumberOfReviews(numberOfReviewsText));

        click(allReviewsText, "All reviews text clicked");
    }

    public void clickMerchant() {

        // Scroll until merchant container visible
        scrollToElement("text", Constants.MERCHANT_FOLLOW_TEXT);

        // Store merchant name in product page to compare with merchant page
        String merchantName = getText(productMerchantNameText, "Product merchant name: ");
        LocalStorageUtils.setItem(LocalStorageUtils.CURRENT_PRODUCT_MERCHANT_NAME_KEY, merchantName);

        // Hepsiburada merchant text is not clickable
        if (!merchantName.equalsIgnoreCase(Constants.MERCHANT_HEPSIBURADA)) {
            click(productMerchantNameText, "Merchant name clicked");
        }
    }
}
