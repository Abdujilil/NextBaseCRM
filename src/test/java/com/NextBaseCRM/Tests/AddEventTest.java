package com.NextBaseCRM.Tests;

import com.NextBaseCRM.Pages.ActiveStreamPage;
import com.NextBaseCRM.Pages.LoginPage;


import com.NextBaseCRM.utility.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEventTest extends TestBase {

    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsHelpDesk();

        ActiveStreamPage activeStreamPage = new ActiveStreamPage();

        if (!activeStreamPage.verifyClockedIn()) {
            activeStreamPage.clockIn();
        }

        activeStreamPage.addEvent();

        BrowserUtils.sleep(1);

        Assert.assertEquals(activeStreamPage.newestEvent().getText(),"05:00 pm-05:30 pm\n" + "group meeting");



    }
}
