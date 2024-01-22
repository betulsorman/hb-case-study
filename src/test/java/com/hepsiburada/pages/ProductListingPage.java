package com.hepsiburada.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ProductListingPage extends BasePage {

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/productBoxView")
    private WebElement productListElement;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvProductName")
    private WebElement productTitleElement;


    public ProductListingPage() {
    }

    public void clickFirstProduct() {
        click(productListElement);
    }

    public void validateProductListing(String product) {
        String productTitle = getText(productTitleElement, "Product title: ");
        Assert.assertTrue(productTitle.toLowerCase().contains(product));
    }

}
