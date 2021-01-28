package com.NextBaseCRM.Tests;

import com.NextBaseCRM.Pages.LoginPage;

import com.NextBaseCRM.utility.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase { // User Story 1

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsHR();

        BrowserUtils.sleep(1);

        Assert.assertEquals(driver.getCurrentUrl(),loginPage.expectedURL,"Verify the URL is correct");

    }

    @Test
    public void rememberMeButton() {

        LoginPage loginPage = new LoginPage();

        Assert.assertFalse(loginPage.rememberMeCheckBox.isSelected(),"Verify checkbox is not selected");

        loginPage.rememberMeCheckBox.click();

        Assert.assertTrue(loginPage.rememberMeCheckBox.isSelected(),"Verify checkbox is selected");

    }

    @Test
    public void accessForgetPassword() {

        LoginPage loginPage = new LoginPage();

        loginPage.forgotYouPassword.click();

        Assert.assertEquals(driver.getTitle(),"Get Password","Verify the loaded page is correct");

    }


}
