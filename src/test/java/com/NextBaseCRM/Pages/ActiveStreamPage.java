package com.NextBaseCRM.Pages;


import com.NextBaseCRM.utility.BrowserUtils;
import com.NextBaseCRM.utility.DataUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ActiveStreamPage extends BasePage{

    public void switchToIframe() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public void enterRandomMessage() {
        WebElement messageContent = driver.findElement(By.xpath("/html/body"));
        messageContent.sendKeys(DataUtils.generateRandomMessage());
    }

    public void enterMessage(String message) {
        WebElement messageContent = driver.findElement(By.xpath("/html/body"));
        BrowserUtils.waitUntilPresent(messageContent);
        messageContent.sendKeys(message);
    }

    public void clickMessageTab() {
        WebElement messageTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageTab.click();
    }

    public void clickOnTab(String tabName) {
        String xpath = String.format("//span[@id='feed-add-post-form-tab-%s']",tabName.toLowerCase());
        WebElement tab = driver.findElement(By.xpath(xpath));
        BrowserUtils.waitUntilClickable(tab);
        tab.click();
    }

    public void clickSend() {
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        BrowserUtils.waitUntilClickable(sendButton);
        sendButton.click();
    }

    public void clickCancel() {
        WebElement cancelButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']"));
        cancelButton.click();
    }

    public void clickLink() {
        WebElement link = driver.findElement(By.xpath("//span[@title='Link']"));
        link.click();
    }

    public void clickSaveLink() {
        WebElement saveLinkButton = driver.findElement(By.xpath("//input[@id='undefined']"));
        saveLinkButton.click();
    }

    public WebElement findMessageBlockWithTest(String message) {

        String xpath = String.format("//div[.='%s']/../../..",message);
        return driver.findElement(By.xpath(xpath));

    }

    public String getUsername() {
        return driver.findElement(By.xpath("//span[@id='user-name']")).getText();
    }

    public void enterLinkInfo(String linkText, String linkURL) {

        WebElement linkTextBox = driver.findElement(By.xpath("//input[@placeholder='Link text']"));
        linkTextBox.sendKeys(linkText);

        WebElement linkURLBox = driver.findElement(By.xpath("//input[@placeholder='Link URL']"));
        linkURLBox.sendKeys(linkURL);

    }

    public WebElement findAnchorTagInMessage() {
        return driver.findElement(By.tagName("a"));
    }

}
