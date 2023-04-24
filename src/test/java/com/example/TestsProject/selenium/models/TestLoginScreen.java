package com.example.TestsProject.selenium.models;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLoginScreen {
    private final WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id="submit")
    private WebElement submitButton;

    public TestLoginScreen(WebDriver driver) {
        this.driver = driver;
        driver.get("https://practicetestautomation.com/practice-test-login/");
       PageFactory.initElements(driver, this);
    }
    public SuccessfulLoginScreen login(String username, String pass) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(pass);
        submitButton.click();
        return new SuccessfulLoginScreen(driver);
    }
}
