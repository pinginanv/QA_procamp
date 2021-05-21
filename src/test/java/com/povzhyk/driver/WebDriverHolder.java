package com.povzhyk.driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverHolder {
    private Map<Long,WebDriver> driverMap = new HashMap<Long, WebDriver>();
    private static WebDriverHolder instance = null;

    public static WebDriverHolder getInstance(){
        if (instance == null){
            instance = new WebDriverHolder();
        }
        return instance;
    }

    private WebDriverHolder() {
        WebDriver driver = WebDriverFactory.initDriver();
        Long threadId = Thread.currentThread().getId();
        driverMap.put(threadId,driver);
    }

    public static WebDriver getDriver(){
        Long threadId = Thread.currentThread().getId();
        return getInstance().driverMap.get(threadId);
    }

    public static JavascriptExecutor getJSExecuter(){
        return (JavascriptExecutor) getDriver();
    }
}
