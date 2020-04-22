package com.btrix24.tests.akif_tests;

import com.btrix24.Base.TestBase;
import com.btrix24.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TaskTabTest extends TestBase {

    //TODO 1. User should be able to click on "High Priority"
    //        checkbox to set the current task to a top priority task.

    @Test
    public void test1() throws InterruptedException {

        test = report.createTest("Verify High Priority checkbox selected");

        String username = ConfigurationReader.getProperty("helpdesk1_username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        // Click on "Task" button
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement taskButton = driver.findElement(By.xpath("//*[@id='feed-add-post-form-tab-tasks']/span"));
        taskButton.click();

        // Click on "High Priority" checkbox under "Task"
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement highPriority = driver.findElement(By.xpath("//*[@id='tasks-task-priority-cb']"));
        highPriority.click();
        // Verify High Priority checkbox selected
        Assert.assertTrue(highPriority.isSelected());
    }

    //TODO 2. User should be able to click on Visual Editor and see
    //        the editor text-bar displays on top of the message box.

    @Test
    public void test2() throws InterruptedException {

        test = report.createTest("Verify editor text-bar displays on top of the message box");

        String username = ConfigurationReader.getProperty("helpdesk1_username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        // Click on "Task" button
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement taskButton = driver.findElement(By.xpath("//*[@id='feed-add-post-form-tab-tasks']/span"));
        taskButton.click();

        // Click Visual Editor button
        WebElement visualEditor = driver.findElement(By.xpath("//*[@id='lhe_button_editor_task-form-lifefeed_task_form']"));
        visualEditor.click();

        // Verify editor text-bar displays on top of the message box.
        WebElement editorTextBar = driver.findElement(By.xpath("//*[@id='bx-html-editor-tlbr-lifefeed_task_form']"));
        assertTrue(editorTextBar.isDisplayed());
    }
}