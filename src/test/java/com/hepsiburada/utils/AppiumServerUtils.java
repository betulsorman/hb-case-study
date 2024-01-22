package com.hepsiburada.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class AppiumServerUtils {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
        LoggerUtils.log().info("starting appium server");
        AppiumDriverLocalService server = getAppiumServerDefault();
        server.start();
        if(server == null || !server.isRunning()){
            LoggerUtils.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        server.clearOutPutStreams();
        this.server.set(server);
        LoggerUtils.log().info("Appium server started");
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

}
