package com.btrix24.tests.akif_tests;

import com.btrix24.Base.TestBase;
import com.btrix24.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AddUserEmail extends TestBase {


//TODO  1.User should be able to add users selecting contact lists from "Employees and departments".
    @Test
    public void test1() throws InterruptedException {
        String username = ConfigurationReader.getProperty("helpdesk1_username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        // Click on Message tab under "Active Stream"
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement messageTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageTab.click();

        // Click in the "To" box "Add more" element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement addMore = driver.findElement(By.linkText("Add more"));
        addMore.click();

        // Click on "Employees and departments" element
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement employeesAndDepartments = driver.findElement(By.xpath("//*[@class='bx-finder-box-tabs']/a[contains(text(),'Employees and departments')]"));
        employeesAndDepartments.click();  //

        // Randomly select users from contact lists.
        WebElement boxArea2 = driver.findElement(By.xpath("//*[@id=\"bx-lm-category-relation-129\"]"));
        List<WebElement> l3 = boxArea2.findElements(By.xpath("//*[@id='bx-lm-category-relation-129']/a/div/div[contains(text(),'.com')]"));

        for (int i = 0; i < l3.size(); i++) {
            Random r = new Random();
            l3.get(r.nextInt(2)).click();
        }

        // Verify n the "To" box displays with user e-mails.
        WebElement l2 = driver.findElement(By.xpath("//*[@id='feed-add-post-destination-item']/span/span[contains(text(),'.com')]"));
        Assert.assertTrue(l2.isDisplayed());
    }

    // ToDo: 2.User should be able to add users selecting contact lists from "Recent".
    @Test
    public void test2() throws InterruptedException {
        String username = ConfigurationReader.getProperty("helpdesk1_username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        // Click on Message tab under "Active Stream"
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement messageTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageTab.click();

        // Click in the "To" box "Add more" element
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement addMore = driver.findElement(By.linkText("Add more"));
        addMore.click();

        // Select users from contact lists.
        WebElement user1 = driver.findElement(By.linkText("helpdesk7@cybertekschool.com"));
        user1.click();
        WebElement user2 = driver.findElement(By.linkText("helpdesk1@cybertekschool.com"));
        user2.click();

        // Verify in the "To" box displays with added user e-mails.
        WebElement actualUser1 =driver.findElement(By.xpath("//*[@id='feed-add-post-destination-item']/span[2]/span[1]"));
        Assert.assertEquals(actualUser1.getText(), "helpdesk7@cybertekschool.com");

        WebElement actualUser2 = driver.findElement(By.xpath("//*[@id='feed-add-post-destination-item']/span[3]/span[1]"));
        Assert.assertEquals(actualUser2.getText(),"helpdesk1@cybertekschool.com");
    }
}
