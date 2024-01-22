package com.hepsiburada.runners;

import com.hepsiburada.support.Driver;
import com.hepsiburada.support.GlobalParams;
import com.hepsiburada.utils.AppiumServerUtils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "summary"
        }
        ,features = {"src/test/java/com/hepsiburada/features"}
        ,glue = {"com.hepsiburada.steps"}
        ,snippets = CAMELCASE
        ,dryRun=false
        ,monochrome=true

)

public class TestRunner {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        new AppiumServerUtils().startServer();
        new Driver().initializeDriver();
    }

    @AfterClass
    public static void quit(){
        Driver driver = new Driver();
        if(driver.getDriver() != null){
            driver.getDriver().quit();
            driver.setDriver(null);
        }
        AppiumServerUtils appiumServerUtils = new AppiumServerUtils();
        if(appiumServerUtils.getServer() != null){
            appiumServerUtils.getServer().stop();
        }
    }
}
