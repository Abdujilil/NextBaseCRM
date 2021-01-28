package com.NextBaseCRM.Tests;

import com.NextBaseCRM.Pages.LoginPage;
import com.NextBaseCRM.utility.BrowserUtils;
import com.NextBaseCRM.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RandomTest extends TestBase {

    private static WebDriver driver = Driver.get();


    public void logOut() {
        WebElement userNameDropdown = driver.findElement(By.xpath("//div[@onclick='showUserMenu()']"));
        userNameDropdown.click();
        BrowserUtils.sleep(3);
        WebElement logOutButton = driver.findElement(By.xpath("//div[@class='menu-popup-items']/a[3]"));
        logOutButton.click();
//        BrowserUtils.sleep(3);
    }

    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsHelpDesk();
        BrowserUtils.sleep(5);
        logOut();

    }

}
