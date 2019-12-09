package com.testing.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicePage extends AbstractPage {

    @FindBy (xpath = "/html/body/div[1]/div[3]/a")
    private WebElement continueToSite;

    @FindBy (xpath = "/html/body/div[4]/main/div[4]/div[1]/div[1]/div/div[1]/h1")
    private WebElement hotelName;

    public ServicePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
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
            Thread.sleep(10000);
        } catch (InterruptedException exc) {

        }
        if (getCurrentUrl().contains("hotels.com")) {
            return hotelName.getText();
        }
        else {
            return webDriver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[1]/div[1]/div[1]/h3/a/span[1]")).getText();
        }
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

}
