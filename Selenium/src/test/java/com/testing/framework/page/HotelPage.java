package com.testing.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HotelPage extends AbstractPage {

//    @FindBy (xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div[3]/div[2]/div/section[1]/div[2]/div/div[4]/div/div[1]/div/div[3]/div[5]/div/div/div/button")
    @FindBy (xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div[3]/div[2]/div/section[1]/div[2]/div/div[4]/div/div[1]/div/div[3]/div[5]/div/div/div/button")
    private WebElement openBookingService;
    @FindBy (xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div[3]/section/div/div/h1")
    private WebElement hotelName;


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
        return sourceHotelName;
    }
}
