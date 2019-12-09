package com.testing.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ServiceHotelPage extends AbstractPage {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[5]/div[1]/div[1]/div[3]/div[1]/h2")
    private WebElement hotelName;

    public ServiceHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public ServiceHotelPage openPage() {
        return this;
    }

    public String getHotelName() {
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(3));
        return hotelName.getText();
    }
}
