package com.testing.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ServicePage extends AbstractPage {

    @FindBy (xpath = "/html/body/div[1]/div[3]/a")
    private WebElement continueToSite;

    @FindBy (xpath = "/html/body/div[4]/main/div[4]/div[1]/div[1]/div/div[1]/h1")
    private WebElement hotelName;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[5]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[3]/div[4]")
    private WebElement hotelService;

    public ServicePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public ServicePage openPage() {
        return this;
    }

    public String getHotel(String receiveHotelName) {
//        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
//        webDriver.switchTo().window(tabs.get(1));
//        continueToSite.click();
        try {
            logger.info("Loading...");
            Thread.sleep(10000);
        } catch (InterruptedException exc) {

        }
        if (getCurrentUrl().contains("hotels.com")) {
            logger.info("Get hotel name");
            return hotelName.getText();
        }
        else {
            logger.info("Get hotel name");
            return driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[1]/div[1]/div[1]/h3/a/span[1]")).getText();
        }

    }


    public String getHotelService() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[1]/div[1]/div[1]/h3/a/span[1]")).click();
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(3));
        logger.info("Check if hotel has service");
        return hotelService.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
