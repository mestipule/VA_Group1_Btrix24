package com.btrix24.tests.test_MSH_AC_9;

import com.btrix24.Base.TestBase;
import com.btrix24.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RecordVideoTest extends TestBase {

    String username = ConfigurationReader.getProperty("helpdesk1_username");
    String password = ConfigurationReader.getProperty("password");
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        wait = new WebDriverWait(driver, 7);
    }

    @Test
    public void filtersTest() throws InterruptedException {
        test = report.createTest("Btrix-24 Record Video - Test");
        test.info("Opening browser and logging in to Btrix-24 website");
        loginPage.login(username, password);
        test.info("Locating and clicking on message box");
        WebElement messageBox = driver.findElement(By.id("microoPostFormLHE_blogPostForm_inner"));
        wait.until(ExpectedConditions.elementToBeClickable(messageBox));
        messageBox.click();
        test.info("Locating and clicking on 'Record Video' button");
        WebElement recordVideoBtn = driver.findElement(By.xpath("//div[@id='post-buttons-bottom']/span[7]"));
        wait.until(ExpectedConditions.elementToBeClickable(recordVideoBtn));
        recordVideoBtn.click();
        test.info("Locating and clicking 'Allow' button in popup message");
        WebElement allowBtn = driver.findElement(By.xpath("//div[@id='bx-popup-videomessage-popup']/div[3]/span[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(allowBtn));
        allowBtn.click();

        test.info("Note: Website is not allowed to access camera and microphone");

        test.info("Locating error message and verifying the message");
        WebElement errorMessage = driver.findElement(By.id("popup-window-content-bx-popup-videomessage-popup"));

        String actual = errorMessage.getText();
        String expected = "Expected conditions: Video recording";
        test.info(expected + "  ==>  Actual: " +actual);
        // Verify the error message...
        assertEquals(actual, expected);
    }
}
