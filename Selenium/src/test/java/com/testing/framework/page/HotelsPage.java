package com.testing.framework.page;

import com.testing.framework.model.ResidenceTerm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelsPage extends AbstractPage {

    @FindBy (xpath = "/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div/div/div[1]/div/div[1]/div[1]/div/div/h3")
    private WebElement saveHotelName;
    @FindBy (xpath = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/div[8]/a")
    private WebElement searchButton;
    @FindBy (xpath = "/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/a/div/div[2]/div[2]/button")
    private WebElement openHotelButton;
    @FindBy (xpath = "//*[@id=\"hc_f_id_checkin_1\"]")
    private WebElement dayOfComingInSelector;
    @FindBy (xpath = "//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select")
    private WebElement monthOfComingInSelector;
    @FindBy (xpath = "//*[@id=\"hc_f_id_checkout_1\"]")
    private WebElement dayOfComingOutSelector;
    @FindBy (xpath = "//*[@id=\"HC_DateSelection_checkout_1\"]/div[2]/label/select")
    private WebElement monthOfComingOutSelector;
    @FindBy (xpath = "/html/body/div[5]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/h3/a")
    private WebElement hotOfferingHotel;
    @FindBy (xpath = "//*[@href=\"/Place/Sydney.htm\"]")
    private WebElement city;
    @FindBy (xpath = "//*[@id=\"hc_popularHotels\"]/div/div[2]/div[1]/div/div/h3/a")
    private WebElement cityHotel;
    @FindBy (xpath = "/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[2]/span")
    private WebElement compareButton;
    @FindBy (xpath = "/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[7]/div[3]/ul/li[1]/div[1]/div/div/label")
    private WebElement category;
    @FindBy (xpath = "/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[7]/div[1]/div[1]")
    private WebElement categoryMenu;

    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HotelsPage openPage() {
        logger.info("Hotels page opened");
        return this;
    }

    public String chooseDates(ResidenceTerm dates) {
        Select dayOfComingIn = new Select(dayOfComingInSelector);
        Select monthOfComingIn = new Select(monthOfComingInSelector);
        Select dayOfComingOut = new Select(dayOfComingOutSelector);
        Select monthOfComingOut = new Select(monthOfComingOutSelector);
        dayOfComingIn.selectByValue(dates.getDayOfComingIn());
        monthOfComingIn.selectByValue(dates.getMonthOfComingIn());
        monthOfComingOut.selectByValue(dates.getMonthOfComingOut());
        dayOfComingOut.selectByValue(dates.getDayOfComingOut());
        searchButton.click();
        sourceHotelName = saveHotelName.getText();
        openHotelButton.click();
        logger.info(sourceHotelName);
        return sourceHotelName;
    }

    public HotelPage chooseHotOfferingHotel() {
        hotOfferingHotel.click();
        logger.info("Chosen hot offering");
        return new HotelPage(driver);
    }

    public String chooseCityAndHotel() {
        city.click();
        cityHotel.click();
        logger.info("Get city");
        return driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/p[1]")).getText();
    }

    public HotelPage compare(ResidenceTerm dates) {
        new Select(dayOfComingInSelector).selectByValue(dates.getDayOfComingIn());
        new Select(monthOfComingInSelector).selectByValue(dates.getMonthOfComingIn());
        new Select(dayOfComingOutSelector).selectByValue(dates.getDayOfComingOut());
        new Select(monthOfComingOutSelector).selectByValue(dates.getMonthOfComingOut());
        searchButton.click();
        compareButton.click();
        logger.info("Open hotel");
        return new HotelPage(driver);
    }

    public String chooseCategory() {
        categoryMenu.click();
        category.click();
        logger.info("Get category");
        compareButton.click();
        logger.info("Open hotel");
        return category.getText();
    }

    public String checkCity() {
        logger.info("Get city location");
        return driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div/div/div[1]/div/div[1]/div[1]/div/div/div[2]/span[1]")).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


}
