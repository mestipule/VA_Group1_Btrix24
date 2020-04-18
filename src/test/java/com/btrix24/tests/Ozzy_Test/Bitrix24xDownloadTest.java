package com.btrix24.tests.Ozzy_Test;

import com.btrix24.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bitrix24xDownloadTest extends TestBase {
    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, 8);
    }
    @Test
    public void download() throws InterruptedException {
        driver.get("https://login2.nextbasecrm.com");
        WebElement UN = driver.findElement(By.name("USER_LOGIN"));
        UN.sendKeys("helpdesk1@cybertekschool.com");
        WebElement PW = driver.findElement(By.name("USER_PASSWORD"));
        PW.sendKeys("UserUser" + Keys.ENTER);
        WebElement More = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        wait.until(ExpectedConditions.elementToBeClickable(More));
        More.click();
        WebElement File = driver.findElement(By.xpath("//span[.='File']"));
        wait.until(ExpectedConditions.elementToBeClickable(File));
        File.click();
        WebElement Office365Download = driver.findElement(By.xpath("//span[.='Office 365']"));
        wait.until(ExpectedConditions.elementToBeClickable(Office365Download));
        Office365Download.click();
        WebElement Office365PopUP= driver.findElement(By.xpath("//span[@title='Office 365']"));
        wait.until(ExpectedConditions.elementToBeClickable(Office365Download));
        Office365PopUP.click();
        Thread.sleep(2000);
        WebElement Office365PopUPVerify = driver.findElement(By.xpath("//span[.='Select document']"));
        Assert.assertEquals(Office365PopUPVerify.getText(),"SELECT DOCUMENT");
    }

}
