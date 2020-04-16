package com.btrix24.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.btrix24.pages.LoginPage;
import com.btrix24.utilities.BrowserUtils;
import com.btrix24.utilities.ConfigurationReader;
import com.btrix24.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected WebDriverWait wait;

    protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;


    @BeforeSuite
    public void setUpSuite() {

        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Bitrix Automated Tests");
        report.attachReporter(htmlReporter);

        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
    }


    @BeforeMethod
    public void startUp(){

        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage = new LoginPage();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void tearDownSuite() {
        report.flush();
    }

    @AfterMethod
    public void closeOut(ITestResult iTestResult) throws IOException {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            // tell extent report that the test failed
            test.fail(iTestResult.getName());

            // take screen shot of the screen and save location
            String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());
            // show path to screenshot
            test.addScreenCaptureFromPath(screenshot);
        }
        Driver.closeDriver();
    }

}
