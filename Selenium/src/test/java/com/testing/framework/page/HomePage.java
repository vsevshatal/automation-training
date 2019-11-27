package com.testing.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.roomguru.ru/";
    @FindBy(xpath = "//*[@id=\"hc_r_content\"]/div[2]/div[3]/div/div/div[1]/div/a")
    private WebElement popularDestination;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div[2]/div[2]/div[4]/div/div/div[1]/div[2]/div[1]/div/h3/a")
    private WebElement trendingHotel;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HomePage openPage() {
        webDriver.manage().window().maximize();
        webDriver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    public HotelsPage goToTheHotelsTab() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        popularDestination.click();
        return new HotelsPage(webDriver);
    }

    public HotelPage openTrendingHotel() {
        trendingHotel.click();
        return new HotelPage(webDriver);
    }
}
