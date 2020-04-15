package com.btrix24.tests.tests_MSH_US_09;

import com.btrix24.Base.TestBase;
import com.btrix24.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class SearchFiltersTests extends TestBase {
    String username;
    String password;

    @Test
    public void filtersTest(){
        username = ConfigurationReader.getProperty("helpdesk1_username");
        password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

}
