package com.povzhyk.driver;

import com.povzhyk.constants.BrowserName;
import com.povzhyk.constants.EndPoints;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    public static WebDriver initDriver(BrowserName browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                Map<String,Object> preferences= new HashMap<String,Object>();
                preferences.put("profile.default_content_settings.popups", 0);
                preferences.put("download.default_directory",
                        new File(EndPoints.DOWNLOAD_FOLDER).getAbsolutePath());
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs",preferences);
                driver = new ChromeDriver(options);
                break;

        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initDriver(){
        String browserName = System.getProperty("browserName", "chrome");
        return initDriver(BrowserName.valueOf(browserName.toUpperCase()));
    }




}
