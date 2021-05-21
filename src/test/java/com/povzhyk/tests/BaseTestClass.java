package com.povzhyk.tests;

import com.povzhyk.configuration.Configurator;
import com.povzhyk.configuration.models.Configuration;
import com.povzhyk.constants.EndPoints;
import com.povzhyk.driver.WebDriverHolder;
import com.povzhyk.listeners.MNExtentReportListener;
import com.povzhyk.listeners.MyListener;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import java.io.File;
import java.io.IOException;


@Listeners({MNExtentReportListener.class,MyListener.class, HTMLReporter.class})
public class BaseTestClass {
    protected WebDriver driver = null;
    protected Configuration configuration = null;

    @BeforeSuite
    public void beforeSuite() throws IOException {

        reCreateScreenshotFolder();
        driver = WebDriverHolder.getDriver();

        configuration = Configurator.readResourseConfigFromYaml("qa.yaml");
        System.out.println(configuration.getUser());
        EndPoints.BASE_URL = configuration.getHost();
    }





    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void goToUrl() {
        goToUrl(EndPoints.BASE_URL);
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public void reCreateScreenshotFolder() throws IOException{
        File schreenshotFolder = new File(EndPoints.SCREENSHOT_FOLDER);
        if (schreenshotFolder.exists()){
            FileUtils.forceDelete(schreenshotFolder);
        }
        FileUtils.forceMkdir(schreenshotFolder);
    }

    public Configuration getConfiguration(){
        return configuration;
    }

}
