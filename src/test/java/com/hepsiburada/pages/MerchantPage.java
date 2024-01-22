package com.hepsiburada.pages;

import com.hepsiburada.contants.Constants;
import com.hepsiburada.utils.LocalStorageUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class MerchantPage extends BasePage {


    @AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[1]")
    private WebElement merchantNamePageText;


    public MerchantPage() {
    }


    public void validateMerchantPageOpened() {
        String expectedMerchantName = LocalStorageUtils.getItem(LocalStorageUtils.CURRENT_PRODUCT_MERCHANT_NAME_KEY);

        // Hepsiburada has not merchant page
        if (!expectedMerchantName.equalsIgnoreCase(Constants.MERCHANT_HEPSIBURADA)) {
            String merchantPageName = getText(merchantNamePageText, "Merchant name: ");
            Assert.assertEquals(expectedMerchantName, merchantPageName);
        }
    }
}
