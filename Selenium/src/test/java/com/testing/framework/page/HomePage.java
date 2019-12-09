package com.testing.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.roomguru.ru/";

//    @FindBy(xpath = "/html/body/div[5]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/a[@href='Place/Vilnius.htm']")
    @FindBy (xpath = "//*[@href=\"/Place/Vilnius.htm\"]")
    private WebElement popularDestination;

    @FindBy (xpath = "//*[@id=\"hc_evt_settings_buttons\"]/ul/li[3]/a")
    private WebElement hotOfferings;
    @FindBy (xpath = "//*[@href=\"/Countries\"]")
    private WebElement countries;
    @FindBy (xpath = "//*[@href=\"/Place/Australia.htm\"]")
    private WebElement country;



    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public HotelsPage goToTheHotelsTab() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        popularDestination.click();
        return new HotelsPage(webDriver);
    }

    public HotelsPage goToHotOfferings() {
        hotOfferings.click();
        return new HotelsPage(webDriver);
    }

    public String searchByCountry() {
        countries.click();
        String countryName = country.getText();
        country.click();
        return countryName;
    }
}
