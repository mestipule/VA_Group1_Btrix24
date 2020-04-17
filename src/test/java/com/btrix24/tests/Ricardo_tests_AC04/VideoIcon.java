package com.btrix24.tests.Ricardo_tests_AC04;

import com.btrix24.Base.TestBase;
import com.btrix24.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VideoIcon extends TestBase {
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
       // driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);

    }
    //user should be able to insert videos by clicking on the video icon and entering video URL

    @Test
    public void VideoIconTest() throws InterruptedException {
        test = report.createTest("Btrix24 Upload File Icon Functionality");
        test.info("Opening Browser");
        loginPage = new LoginPage();
        test.info("Username input");
        loginPage.username.sendKeys("helpdesk1@cybertekschool.com");
        test.info("Password input");
        loginPage.password.sendKeys("UserUser");
        test.info("Logging in");
        loginPage.login.click();

        WebElement company = driver.findElement(By.linkText("Company"));
        company.click();
       // System.out.println("Company click");
       // wait.until(ExpectedConditions.elementToBeClickable(video));

        WebElement video=driver.findElement(By.linkText("Video"));
        wait.until(ExpectedConditions.elementToBeClickable(video));
        video.click();

        WebElement Download=driver.findElement(By.linkText("Download"));

        wait.until(ExpectedConditions.elementToBeClickable(Download));
      Download.click();
      //by clicking on the video icon and entering video URL

    }
}