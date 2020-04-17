package com.btrix24.tests.may_tests;

import com.btrix24.Base.TestBase;
import com.btrix24.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadIcon extends TestBase {
    LoginPage loginPage;
    WebDriverWait wait;
//
    @BeforeMethod
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://login2.nextbasecrm.com/");
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void uploadFileIconTest() {

        test = report.createTest("Btrix24 Upload File Icon Functionality");
        test.info("Opening Browser");
        loginPage = new LoginPage();
        test.info("Username input");
        loginPage.username.sendKeys("helpdesk1@cybertekschool.com");
        test.info("Password input");
        loginPage.password.sendKeys("UserUser");
        test.info("Logging in");
        loginPage.login.click();

        test.info("Finding More Button");
        WebElement moreIcon = driver.findElement(By.id("feed-add-post-form-link-more"));
        wait.until(ExpectedConditions.elementToBeClickable(moreIcon));
        moreIcon.click();
        test.info("File option found");
        WebElement fileIcon = driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][1]"));
        fileIcon.click();

        test.info("Checking Document Upload Functionality");
        WebElement documentUpload = driver.findElement(By.xpath("//span[@data-bx-doc-handler='gdrive']/span[@class='wd-fa-add-file-light-title-text'][1]"));
        documentUpload.click();

        WebElement boxElement = driver.findElement(By.xpath("//a/span[@title='Box']"));
        boxElement.click();
        System.out.println(boxElement.getText() + "clicked");

        WebElement dropBox = driver.findElement(By.xpath("//a/span[@title='Dropbox']"));
        dropBox.click();
        System.out.println(dropBox.getText() + "clicked");

        WebElement googleDrive = driver.findElement(By.xpath("//a/span[@title='Google Drive']"));
        googleDrive.click();
        System.out.println(googleDrive.getText() + "clicked");

        WebElement office365 = driver.findElement(By.xpath("//a/span[@title='Office 365']"));
        office365.click();
        System.out.println(office365.getText() + "clicked");

        WebElement oneDrive = driver.findElement(By.xpath("//a/span[@title='OneDrive']"));
        oneDrive.click();
        System.out.println(oneDrive.getText() + "clicked");

        WebElement yandex = driver.findElement(By.xpath("//a/span[@title='Yandex.Disk']"));
        yandex.click();
        System.out.println(yandex.getText() + "clicked");

    }
}
