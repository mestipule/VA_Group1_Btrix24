package com.btrix24.pages;

import com.btrix24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        // page object classes needs constructor, here we have to call the pageFactory. initElements
        // from selenium and pass a WebDriver object and this class as param
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // FindBy --> we provide te locator for the WebElement
    @FindBy(xpath="//input[@name='USER_LOGIN']")
    public WebElement username;

    @FindBy(xpath="//input[@name='USER_PASSWORD']")
    public WebElement password;

    @FindBy(className="login-btn")
    public WebElement login;

    @FindBy(className = "errortext")
    public WebElement errorMessage;

    public void login (String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }
}
