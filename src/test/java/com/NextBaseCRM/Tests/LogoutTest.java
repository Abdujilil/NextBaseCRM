package com.NextBaseCRM.Tests;

import com.NextBaseCRM.Pages.ActiveStreamPage;
import com.NextBaseCRM.Pages.LoginPage;
import com.NextBaseCRM.utility.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {  // User Story 14

    @Test
    public void logout() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsHelpDesk();

        ActiveStreamPage activeStreamPage = new ActiveStreamPage();

        activeStreamPage.logout();

        BrowserUtils.sleep(1);

        Assert.assertEquals(driver.getTitle(),"Authorization");

    }

}
