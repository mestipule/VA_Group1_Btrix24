package com.btrix24.tests.test_MSH_AC_9;

import com.btrix24.Base.TestBase;
import com.btrix24.utilities.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class RecordVideoTest extends TestBase {

    String username = ConfigurationReader.getProperty("helpdesk1_username");
    String password = ConfigurationReader.getProperty("password");

    @Test
    public void filtersTest() throws InterruptedException {
        loginPage.login(username, password);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement messageBox = driver.findElement(By.id("microoPostFormLHE_blogPostForm_inner"));
        messageBox.click();
        WebElement recordVideoBtn = driver.findElement(By.xpath(
                "//span[@id='bx-b-mention-blogPostForm']/following-sibling::*[2][text()='Record Video']"));
        recordVideoBtn.click();
        WebElement allowBtn = driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-blue']"));
        allowBtn.click();
        WebElement errorMessage = driver.findElement(By.id("popup-window-content-bx-popup-videomessage-popup"));

        String actualMessage = errorMessage.getText();
        String expectedMessage = "Cannot access your camera and microphone.";

        assertEquals(actualMessage, expectedMessage);
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);

    }
}