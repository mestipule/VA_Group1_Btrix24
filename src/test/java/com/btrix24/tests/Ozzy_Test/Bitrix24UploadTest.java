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

public class Bitrix24UploadTest extends TestBase {

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, 8);
    }

    @Test
    public void BitrixUPLOADtest() throws InterruptedException {

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


        WebElement upload = driver.findElement(By.name("bxu_files[]"));
        upload.sendKeys("C:\\Users\\15713\\Desktop\\TempTEST\\TestFILE.txt");

        WebElement uploadedFile = driver.findElement(By.xpath("//span[@class='files-text']"));
        Assert.assertEquals(uploadedFile.getText(),"TestFILE.txt");

        Thread.sleep(2000);
        WebElement  xout = driver.findElement(By.xpath("//span[@class='del-but']"));
        xout.click();
    }
}
