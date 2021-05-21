package com.povzhyk.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.povzhyk.driver.WebDriverHolder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import java.util.Base64;

import java.io.File;
import java.io.IOException;

public class MNExtentReportListener extends ExtentITestListenerClassAdapter {

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        ExtentTest test = ExtentTestManager.getTest(result);


        try {

            File file = getScreenShot(result);
            test.addScreenCaptureFromBase64String(
                    Base64
                            .getEncoder()
                            .encodeToString(
                                    FileUtils.readFileToByteArray(file)),
                    "Failed test image"
            );
            file.delete();
        }catch (IOException e){
            e.printStackTrace();
        }



    }

    private File getScreenShot(ITestResult iTestResult){
        File fileForCopy = new File(iTestResult.getName() + ".jpg");
        File screenShotFile = ((TakesScreenshot) WebDriverHolder.getDriver()).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShotFile,fileForCopy);
        }catch (IOException e){
            e.printStackTrace();
        }
        return fileForCopy;
    }
}
