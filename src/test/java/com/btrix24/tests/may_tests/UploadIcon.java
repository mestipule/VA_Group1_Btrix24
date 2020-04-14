package com.btrix24.tests.may_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class UploadIcon {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void uploadFileIconTest() {

        WebElement username = driver.findElement(By.xpath("//input[@class='login-inp']"));
        username.sendKeys("helpdesk1@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");

        WebElement loginIcon = driver.findElement(By.xpath("//input[@type='submit']"));
        loginIcon.click();

        Actions actions = new Actions(driver);

        WebElement moreIcon = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreIcon.click();

        WebElement fileIcon = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][1]"));
        fileIcon.click();


        System.out.println("login successfully");
    }
}
