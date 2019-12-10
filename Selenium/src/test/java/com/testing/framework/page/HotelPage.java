package com.testing.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HotelPage extends AbstractPage {

//    @FindBy (xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div[3]/div[2]/div/section[1]/div[2]/div/div[4]/div/div[1]/div/div[3]/div[5]/div/div/div/button")
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[3]/div/div/div[2]/div/section[1]/div[2]/div/div[4]/div/div[1]/div/div[3]/div[5]/div/div/div/button")
    private WebElement openBookingService;
    @FindBy (xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div[3]/section/div/div/h1")
    private WebElement hotelName;
    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div[3]/div/div[4]/section[2]/div[2]/div/div[2]/div[2]/div[3]/div/label")
    private WebElement service;


    public HotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HotelPage openPage() {
        return this;
    }


    public String openBooking() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sourceHotelName = hotelName.getText();
        openBookingService.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Open booking service page");
        return sourceHotelName;
    }

    public String chooseService() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String serviceName = "";
        try {
             serviceName = service.getText();
        } catch (NoSuchElementException exc) {
            driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div/div[4]/div[2]/div/section[1]/div[2]/div/div[2]/div[2]/div[3]/div/label")).getText();
        }
        try {
            openBookingService.click();
        } catch (NoSuchElementException exc) {
            driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div/div[4]/section[2]/div[2]/div/div[4]/div/div[1]/div/div[3]/div[5]/div/div/div/button")).click();
        }
        logger.info("Get service name");
        return serviceName;
    }

    public boolean isRightQuery() {
        logger.info("Getting name info");
        return hotelName.getText().contains("Hotel");
    }

    public String checkServiceCategory() {
        String category = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div/div[4]/section[3]/div/div/div/div[4]/p")).getText();
        logger.info("Checking service");
        return category;
    }
}
