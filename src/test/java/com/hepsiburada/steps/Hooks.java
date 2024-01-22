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

/*        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
                + params.getDeviceName());

        new ServerManager().startServer();
        new DriverManager().initializeDriver();*/
        new ScreenRecordingUtils().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = new Driver().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        new ScreenRecordingUtils().stopRecording(scenario.getName());
/*        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }*/
    }
}
