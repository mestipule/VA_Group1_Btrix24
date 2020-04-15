package com.btrix24.tests.akif_tests;

import com.btrix24.Base.TestBase;
import com.btrix24.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AddUsersTests extends TestBase {

    @Test
    public void filtersTest() throws InterruptedException {
        String username = ConfigurationReader.getProperty("helpdesk1_username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        loginPage.message.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.allEmployees));
        loginPage.allEmployees.click();






    }
}
