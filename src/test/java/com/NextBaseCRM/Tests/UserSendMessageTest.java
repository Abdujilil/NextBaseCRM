package com.NextBaseCRM.Tests;

import com.NextBaseCRM.Pages.ActiveStreamPage;
import com.NextBaseCRM.Pages.LoginPage;
import com.NextBaseCRM.utility.BrowserUtils;
import com.NextBaseCRM.utility.ConfigurationReader;
import com.NextBaseCRM.utility.DataUtils;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserSendMessageTest extends TestBase { // User Story 2

    @Test
    public void sendMessage() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsHelpDesk();

        ActiveStreamPage activeStreamPage = new ActiveStreamPage();

        activeStreamPage.clickOnTab("message");

        activeStreamPage.switchToIframe();

        BrowserUtils.sleep(1);

        String message = DataUtils.generateRandomMessage();

        activeStreamPage.enterMessage(message);

        activeStreamPage.switchToParentFrame();

        BrowserUtils.sleep(1);

        activeStreamPage.clickSend();

        BrowserUtils.sleep(2);

        String expectedSender = ConfigurationReader.get("helpdesk_username");

        String actualResult = activeStreamPage.findMessageBlockWithTest(message).getText();

        Assert.assertTrue(actualResult.contains(message));

        Assert.assertTrue(actualResult.contains(expectedSender));

    }

    @Test
    public void cancelMessage() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsHelpDesk();

        ActiveStreamPage activeStreamPage = new ActiveStreamPage();

        activeStreamPage.clickOnTab("message");

        activeStreamPage.switchToIframe();

        BrowserUtils.sleep(1);

        String message = DataUtils.generateRandomMessage();

        activeStreamPage.enterMessage(message);

        activeStreamPage.switchToParentFrame();

        BrowserUtils.sleep(1);

        activeStreamPage.clickCancel();

        boolean cancelled = false;

        try {
            activeStreamPage.findMessageBlockWithTest(message);
        } catch (NoSuchElementException e) {
            cancelled = true;
        }

        Assert.assertTrue(cancelled);
    }

    @Test
    public void attachLink() throws InterruptedException {
        //2.3 Verify users can attach link by clicking on the link icon.
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsHelpDesk();

        ActiveStreamPage activeStreamPage = new ActiveStreamPage();

        activeStreamPage.clickOnTab("message");

        activeStreamPage.clickLink();

        activeStreamPage.enterLinkInfo("Google","https://www.google.com");

        activeStreamPage.clickSaveLink();

        activeStreamPage.switchToIframe();

        BrowserUtils.sleep(1);

        Assert.assertEquals(activeStreamPage.findAnchorTagInMessage().getTagName(),"a","Verify it is an anchor tag");


    }


}
