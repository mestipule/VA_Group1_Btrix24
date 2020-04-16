package com.btrix24.tests.seymanur_tests_AC_07;
import com.btrix24.Base.TestBase;
import com.btrix24.pages.LoginPage;
import com.btrix24.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;
public class VisualEditor extends TestBase {
    LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage = new LoginPage();
    }
    @Test
    public void VisualEditor(){
        loginPage.username.sendKeys(ConfigurationReader.getProperty("helpdesk1_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.login.click();
        /*
            Test Cases:
                1. click on Message tab under Active Stream
                2. click on Visual Editor.
                3. Verify the editor text-bar displays on top of the message box.
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement messageTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageTab.click();
        WebElement visualEditor = driver.findElement(By.xpath("//span[@id='lhe_button_editor_blogPostForm']"));
        visualEditor.click();
        WebElement editorTextBar = driver.findElement(By.id("bx-html-editor-tlbr-idPostFormLHE_blogPostForm"));
        assertTrue(editorTextBar.isDisplayed());
    }
}