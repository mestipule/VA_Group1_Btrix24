package com.btrix24.tests.tests_MSH_US_09;

import com.btrix24.Base.TestBase;
import com.btrix24.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SearchFiltersTests extends TestBase {
    String username = ConfigurationReader.getProperty("helpdesk1_username");
    String password = ConfigurationReader.getProperty("password");
    String workFilter = "work";
    String favoritesFilter = "favorites";
    String myActivityFilter = "my";
    String announcementsFilter = "important";
    String workflowsFilter = "bizproc";

    @Test
    public void filtersTest() {
        test = report.createTest("Btrrix-24 -> Default Searches Test");
        test.info("Opening Btrix and logging in...");
        loginPage.login(username, password);
        test.info("Testing search Filter \"Work\"");
        assertEquals(filterSearch(workFilter), "Work");
        clearFilter();
        test.info("Testing search Filter \"Favorites\"");
        assertEquals(filterSearch(favoritesFilter), "Favorites");
        clearFilter();
        test.info("Testing search Filter \"My Activity\"");
        assertEquals(filterSearch(myActivityFilter), "My Activity");
        clearFilter();
        test.info("Testing search Filter \"Announcements\"");
        assertEquals(filterSearch(announcementsFilter), "Announcements");
        clearFilter();
        test.info("Testing search Filter \"Workflows\"");
        assertEquals(filterSearch(workflowsFilter), "Workflows");
        clearFilter();


    }

    public String filterSearch(String filterName) {
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        // Click search box...
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='LIVEFEED_search']"));
        searchBox.click();
        // Select the given filter...
        WebElement searchFilter = driver.findElement(By.xpath(
                "//div[@class='main-ui-filter-sidebar-item'][@data-id='"+filterName+"']"));
        searchFilter.click();
        // Get text of the selected filter and return for assertion...
        WebElement selectedFilter = driver.findElement(By.xpath("//div/div/div[@class='main-ui-square-item']"));
        String selectedFilterText = selectedFilter.getText();

        return selectedFilterText;
    }

    public void clearFilter(){
        WebElement clearFilter = driver.findElement(By.xpath("//div/span[@class='main-ui-item-icon main-ui-delete']"));
        clearFilter.click();
    }
}
