package com.NextBaseCRM.Pages;


import com.NextBaseCRM.utility.ConfigurationReader;

import com.NextBaseCRM.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    WebDriver driver = Driver.get();

    public static final String url = "https://login2.nextbasecrm.com/";
    public String expectedURL = url;



    public WebElement usernameTextBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
    public WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
    public WebElement rememberMeCheckBox = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));
    public WebElement loginButton = driver.findElement(By.cssSelector(".login-btn"));
    public WebElement forgotYouPassword = driver.findElement(By.xpath("//a[.='Forgot your password?']"));



    public void loginAsHelpDesk() {

        usernameTextBox.sendKeys(ConfigurationReader.get("helpdesk_username"));
        passwordTextBox.sendKeys(ConfigurationReader.get("helpdesk_password"));
        loginButton.click();

    }

    public void loginAsHR() {

        usernameTextBox.sendKeys(ConfigurationReader.get("hr_username"));
        passwordTextBox.sendKeys(ConfigurationReader.get("hr_password"));
        loginButton.click();

    }

    public void loginAsMarketing() {

        usernameTextBox.sendKeys(ConfigurationReader.get("marketing_username"));
        passwordTextBox.sendKeys(ConfigurationReader.get("marketing_password"));
        loginButton.click();

    }

}
