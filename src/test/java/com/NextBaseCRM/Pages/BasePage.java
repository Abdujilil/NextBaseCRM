package com.NextBaseCRM.Pages;


import com.NextBaseCRM.utility.BrowserUtils;
import com.NextBaseCRM.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver = Driver.get();

    public void clockIn() {

        WebElement timeClock = driver.findElement(By.cssSelector("#timeman-status"));
        timeClock.click();

        WebElement clockInButton = driver.findElement(By.xpath("//span[contains(@class,'button-accept')]/span"));
        clockInButton.click();

    }

    public WebElement locateClockOutButton() {
       return driver.findElement(By.xpath("//span[.='Clock Out']"));
    }

    public boolean verifyClockedIn() {
        return driver.findElement(By.xpath("//span[@id='timeman-status']")).getText().equals("WORKING");
    }

    public void addEvent() {

        WebElement timeClockButton = driver.findElement(By.cssSelector("#timeman-status"));

        try {
            driver.findElement(By.xpath("//div[@id='timeman_main']")).isDisplayed();
        } catch (NoSuchElementException e) {
            timeClockButton.click();
        }

        WebElement startTime = driver.findElement(By.xpath("//input[contains(@class,'start-time')]"));
        startTime.click();

        WebElement amPm = driver.findElement(By.xpath("//span[@class='bxc-am-pm']"));

        if (amPm.getText().equals("AM")) {
            amPm.click();
        }

        WebElement hours = driver.findElement(By.xpath("(//input[@class='bxc-cus-sel'])[1]"));
        BrowserUtils.doubleClick(hours);
        hours.sendKeys("5");

        WebElement minutes = driver.findElement(By.xpath("(//input[@class='bxc-cus-sel'])[2]"));
        BrowserUtils.doubleClick(minutes);
        minutes.sendKeys("00");

        WebElement selectButton = driver.findElement(By.xpath("//span[.='Select']"));
        selectButton.click();

        BrowserUtils.waitUntilPresent(hours);

        if (amPm.getText().equals("AM")) {
            amPm.click();
        }

        BrowserUtils.doubleClick(hours);
        hours.sendKeys("5");
        BrowserUtils.doubleClick(minutes);
        minutes.sendKeys("30");
        selectButton.click();

        WebElement eventName = driver.findElement(By.xpath("//input[@class='tm-popup-event-form-textbox_am_pm']"));
        eventName.sendKeys("group meeting");

        WebElement addButton = driver.findElement(By.cssSelector(".tm-popup-event-form-submit"));
        addButton.click();

    }

    public WebElement newestEvent() {
        return driver.findElement(By.xpath("//div[@class='tm-popup-event-list']/*[last()]"));
    }

    public void logout() {
        WebElement userBlock = driver.findElement(By.xpath("//div[@id='user-block']"));
        userBlock.click();

        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutButton.click();
    }
}
