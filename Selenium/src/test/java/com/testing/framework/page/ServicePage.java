package com.testing.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ServicePage extends AbstractPage {

    @FindBy (xpath = "/html/body/div[1]/div[3]/a")
    private WebElement continueToSite;

    @FindBy (xpath = "//*[@id=\"hotel_370185\"]/a/img")
    private WebElement hotelName;

    public ServicePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public ServicePage openPage() {
        return this;
    }

    public ServiceHotelPage getHotel() {
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(2));
        continueToSite.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        hotelName.click();
        return new ServiceHotelPage(webDriver);
    }
}
