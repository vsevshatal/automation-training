package com.testing.framework.page;

import com.testing.framework.model.ResidenceTerm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy (xpath = "//*[@id=\"hc_f_id_checkin_1\"]")
    private WebElement dayOfComingInSelector;
    @FindBy (xpath = "//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select")
    private WebElement monthOfComingInSelector;
    @FindBy (xpath = "//*[@id=\"hc_f_id_checkout_1\"]")
    private WebElement dayOfComingOutSelector;
    @FindBy (xpath = "//*[@id=\"HC_DateSelection_checkout_1\"]/div[2]/label/select")
    private WebElement monthOfComingOutSelector;
    @FindBy (xpath = "/html/body/div[5]/div[1]/div[2]/div[1]/div/div[1]/div/form/fieldset/div[9]/a")
    private WebElement searchButton;
    @FindBy (xpath = "//*[@id=\"hc_searchBox\"]/div/form/fieldset/p/em")
    private WebElement warningField;
    @FindBy (xpath = "//*[@id=\"hc_f_id_where_1\"]")
    private WebElement searchField;
    @FindBy (xpath = "/html/body/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/h3/a")
    private WebElement openHotel;
    @FindBy (xpath = "//*[@id=\"hc_evt_settings_buttons\"]/ul/li[1]/a")
    private WebElement languageChooser;
    @FindBy (xpath = "//*[@id=\"hc_evt_settings_language\"]/div[2]/div[2]/ul[1]/li[1]/a")
    private WebElement language;
    @FindBy (xpath = "/html/body/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/h3/a")
    private WebElement exactLocation;
    @FindBy (xpath = "/html/body/div[5]/div[1]/div[2]/div[1]/div/h1")
    private WebElement engTextElement;



    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Page opened");
        return this;
    }

    public HotelsPage goToTheHotelsTab() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        popularDestination.click();
        return new HotelsPage(driver);
    }

    public HotelsPage goToHotOfferings() {
        hotOfferings.click();
        return new HotelsPage(driver);
    }

    public String searchByCountry() {
        countries.click();
        String countryName = country.getText();
        country.click();
        logger.info("Searching by country");
        return countryName;
    }

    public String chooseWrongDates(ResidenceTerm dates) {
        new Select(dayOfComingInSelector).selectByValue(dates.getDayOfComingIn());
        new Select(monthOfComingInSelector).selectByValue(dates.getMonthOfComingIn());
        new Select(dayOfComingOutSelector).selectByValue(dates.getDayOfComingOut());
        new Select(monthOfComingOutSelector).selectByValue(dates.getMonthOfComingOut());
        searchButton.click();
        logger.info("Wrong dates chosen");
        return warningField.getText();
    }

    public HotelPage enterDates(ResidenceTerm dates) {
        searchField.sendKeys("Hotel");
        new Select(dayOfComingInSelector).selectByValue(dates.getDayOfComingIn());
        new Select(monthOfComingInSelector).selectByValue(dates.getMonthOfComingIn());
        new Select(dayOfComingOutSelector).selectByValue(dates.getDayOfComingOut());
        new Select(monthOfComingOutSelector).selectByValue(dates.getMonthOfComingOut());
        searchButton.click();
        logger.info("Search started");
        openHotel.click();
        return new HotelPage(driver);
    }

    public String checkLanguage() {
        languageChooser.click();
        language.click();
        String engText = engTextElement.getText();
        logger.info("Language set to English");
        return engText;
    }

    public String enterWrongName(ResidenceTerm dates) {
        searchField.sendKeys("111111111111111111111111111111");
        new Select(dayOfComingInSelector).selectByValue(dates.getDayOfComingIn());
        new Select(monthOfComingInSelector).selectByValue(dates.getMonthOfComingIn());
        new Select(dayOfComingOutSelector).selectByValue(dates.getDayOfComingOut());
        new Select(monthOfComingOutSelector).selectByValue(dates.getMonthOfComingOut());
        searchButton.click();
        logger.info("Wrong info entered");
        return driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[1]/h1")).getText();
    }

    public HotelsPage findHotel(ResidenceTerm dates) {
        searchField.sendKeys("Вильнюс");
        new Select(dayOfComingInSelector).selectByValue(dates.getDayOfComingIn());
        new Select(monthOfComingInSelector).selectByValue(dates.getMonthOfComingIn());
        new Select(dayOfComingOutSelector).selectByValue(dates.getDayOfComingOut());
        new Select(monthOfComingOutSelector).selectByValue(dates.getMonthOfComingOut());
        searchButton.click();
        logger.info("Finding hotel in certain city");
        exactLocation.click();
        logger.info("Check location");
        return new HotelsPage(driver);
    }

}
