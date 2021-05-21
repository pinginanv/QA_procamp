package com.povzhyk.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;


    @FindBy(xpath = "//h1")
    protected WebElement header;



    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(this.driver, 20);
        shortWait = new WebDriverWait(this.driver, 3);

    }


    public String getHeaderText(){
        return header.getText();
    }









}
