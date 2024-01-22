package com.hepsiburada.pages;

import com.hepsiburada.contants.Constants;
import com.hepsiburada.utils.LocalStorageUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.hepsiburada.utils.LocalStorageUtils.CURRENT_PRODUCT_NUMBER_OF_REVIEWS_KEY;

public class ReviewsPage extends BasePage {

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvTitle")
    private WebElement titleAllReviewsText;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.TextView[2]")
    private WebElement numberOfReviewsText;


    public ReviewsPage() {
    }


    public void validateReviewsPageOpened() {
        String titleAllReviews = getText(titleAllReviewsText, "Title: ");
        Assert.assertEquals(Constants.ALL_REVIEWS, titleAllReviews);
    }

    public void validateNumberOfReviewsMatchWithProductDetails(){
        // Compare number of product reviews in product details page and reviews page
        String numberOfReviews = getText(numberOfReviewsText, "Total number of reviews: ");
        String expectedNumberOfReviews = LocalStorageUtils.getItem(CURRENT_PRODUCT_NUMBER_OF_REVIEWS_KEY);
        Assert.assertEquals(expectedNumberOfReviews, numberOfReviews);
    }
}
