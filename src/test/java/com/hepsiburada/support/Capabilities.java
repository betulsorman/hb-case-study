package com.hepsiburada.support;

import com.hepsiburada.utils.LoggerUtils;
import com.hepsiburada.utils.PropertiesUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Capabilities {

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertiesUtils().getProps();

        try {
            LoggerUtils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", params.getPlatformName());
            caps.setCapability("udid", params.getUDID());
            caps.setCapability("deviceName", params.getDeviceName());

            switch (params.getPlatformName()) {
                case "Android":
                    caps.setCapability("automationName", props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    caps.setCapability("autoGrantPermissions", true);
                    caps.setCapability("autoAcceptAlerts", true);
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "hepsiburada-5-31-0.apk";
                    LoggerUtils.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    break;
                case "iOS":
                    //iOS Case
                    break;
            }
            return caps;
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtils.log().fatal("Failed to load capabilities. ABORT!!" + e);
            throw e;
        }
    }
}
