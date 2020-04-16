package com.btrix24.Base;

import com.btrix24.pages.LoginPage;
import com.btrix24.utilities.ConfigurationReader;
import com.btrix24.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void startUp(){
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage = new LoginPage();

    }

    @AfterMethod
    public void closeOut(){
        Driver.closeDriver();
    }

}
