package com.testing.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver webDriver;


    private DriverSingleton() {

    }

    public static WebDriver getWebDriver() {
        if (null == webDriver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    webDriver.manage().window().maximize();
                }
            }
        }
        return webDriver;
    }


}
