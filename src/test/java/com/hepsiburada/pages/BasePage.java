package com.hepsiburada.pages;

import com.hepsiburada.support.Driver;
import com.hepsiburada.utils.LoggerUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final AppiumDriver driver;
    public static final long WAIT = 10;

    public BasePage() {
        this.driver = new Driver().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(WebElement e, String msg) {
        waitForVisibility(e);
        LoggerUtils.log().info(msg);
        e.click();
    }

    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public String getText(WebElement e, String logMessage) {
        String txt = getAttribute(e, "text");
        LoggerUtils.log().info(logMessage + txt);
        return txt;
    }

    public void closeApp() {
        ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                getCapability("appPackage").toString());
    }

    public void launchApp() {
        ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                getCapability("appPackage").toString());
    }

    public void scrollToElement(String childLocAttr, String childLocValue) {
            waitForVisibility(driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                            + "new UiSelector()." + childLocAttr + "(\"" + childLocValue + "\"));")));
    }
}
