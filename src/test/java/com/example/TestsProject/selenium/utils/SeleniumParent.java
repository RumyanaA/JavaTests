package com.example.TestsProject.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumParent {

    private static ChromeDriver driver;

    @BeforeClass
    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    @AfterClass
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();

        }
    }
}
