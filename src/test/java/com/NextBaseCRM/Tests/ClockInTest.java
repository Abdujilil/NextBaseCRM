package com.NextBaseCRM.Tests;

import com.NextBaseCRM.Pages.ActiveStreamPage;
import com.NextBaseCRM.Pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClockInTest extends TestBase { // User Story 5


    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsHelpDesk();

        ActiveStreamPage activeStreamPage = new ActiveStreamPage();

        activeStreamPage.clockIn();

        Assert.assertEquals(activeStreamPage.locateClockOutButton().getText(),"CLOCK OUT");

    }
}
