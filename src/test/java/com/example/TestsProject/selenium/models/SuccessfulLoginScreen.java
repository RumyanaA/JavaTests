package com.example.TestsProject.selenium.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulLoginScreen {
    private final WebDriver driver;
    @FindBy(xpath = "//*[@id=\"loop-container\"]/div/article/div[1]/h1")
    private WebElement title;
    @FindBy(id= "error")
    private WebElement errorMessage;

    public SuccessfulLoginScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return title.getText();
    }

    public String getErrorMessage(){
        System.out.println(errorMessage.getText());
        return errorMessage.getText();
    }


}
