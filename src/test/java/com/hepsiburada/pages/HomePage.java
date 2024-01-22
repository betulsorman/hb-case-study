package com.hepsiburada.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    private WebElement searchBox;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.pozitron.hepsiburada:id/search_suggestion'][1]")
    private WebElement firstSearchedElement;

    public HomePage() {
    }

    public void dismissOnboardingToolTip() {
        click(searchBox);
    }

    public void enterProduct(String product) {
        click(searchBox);
        sendKeys(searchBox, product);
        clickFirstSearchedElement();
    }

    public void clickFirstSearchedElement() {
        click(firstSearchedElement);
    }

}
