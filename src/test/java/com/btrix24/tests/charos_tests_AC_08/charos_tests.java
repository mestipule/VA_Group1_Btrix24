package com.btrix24.tests.charos_tests_AC_08;

import com.btrix24.Base.TestBase;
import com.btrix24.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class charos_tests  extends TestBase {

    /*
   User should be able to click on the Topic icon
  to see the Message Topic text box displays
  on top of the message box.
     */

    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void TopicIcon() throws InterruptedException {
        test = report.createTest("Btrix24 Upload File Icon Functionality");
        test.info("Opening Browser");
        loginPage = new LoginPage();
        test.info("Username input");
        loginPage.username.sendKeys("helpdesk1@cybertekschool.com");
        test.info("Password input");
        loginPage.password.sendKeys("UserUser");
        test.info("Logging in");
        loginPage.login.click();
        WebElement message = driver.findElement(By.id("feed-add-post-form-tab-message"));
        message.click();
        WebElement topicIcon = driver.findElement(By.id("lhe_button_title_blogPostForm"));
        topicIcon.click();
        Thread.sleep(3000);
        WebElement topicmessage = driver.findElement(By.xpath("//div[@class='feed-add-post-title']/input[@id='POST_TITLE']"));
        wait.until(ExpectedConditions.visibilityOf(topicmessage));
        topicmessage.getAttribute("placeholder");
        Assert.assertEquals(topicmessage.getAttribute("placeholder"), "Topic");


    }
}