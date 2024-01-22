package com.hepsiburada.steps;

import com.hepsiburada.pages.BasePage;
import com.hepsiburada.support.Driver;
import com.hepsiburada.utils.ScreenRecordingUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        BasePage basePage = new BasePage();
        basePage.closeApp();
        basePage.launchApp();

        new ScreenRecordingUtils().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = new Driver().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        new ScreenRecordingUtils().stopRecording(scenario.getName());
    }
}
