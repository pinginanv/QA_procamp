package com.povzhyk.listeners;

import com.povzhyk.constants.EndPoints;
import com.povzhyk.driver.WebDriverHolder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MyListener implements ITestListener  {
    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()){
            File screenshot = ((TakesScreenshot) WebDriverHolder.getDriver()).getScreenshotAs(OutputType.FILE);
            File dest = new File(EndPoints.SCREENSHOT_FOLDER,
                    iTestResult.getName() + "_" + new Date().getTime() + ".png");
            try {
                FileUtils.copyFile(screenshot,dest);
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("Test: " + iTestResult.getName() + " is Finished.");
        }

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
