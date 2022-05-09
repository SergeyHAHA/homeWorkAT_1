package com.google;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSettings {

    WebDriver chromeDriver;

    @BeforeEach
    public void befor(){
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        chromeDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(40));
    }

    @AfterEach
    public void after(){
        chromeDriver.quit();
    }

}
