package com.hepsiburada.support;

import com.hepsiburada.utils.AppiumServerUtils;
import com.hepsiburada.utils.LoggerUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class Driver {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();

        if(driver == null){
            try{
                LoggerUtils.log().info("initializing Appium driver");
                switch(params.getPlatformName()){
                    case "Android":
                        driver = new AndroidDriver(new AppiumServerUtils().getServer().getUrl(), new Capabilities().getCaps());
                        break;
                    case "iOS":
                        //iOS Case
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
                LoggerUtils.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                LoggerUtils.log().fatal("Driver initialization failure. ABORT !!!!" + e);
                throw e;
            }
        }

    }

}
