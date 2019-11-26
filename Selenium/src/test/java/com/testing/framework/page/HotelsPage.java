package com.testing.framework.page;

import com.testing.framework.model.ResidenceTerm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HotelsPage extends AbstractPage {

    @FindBy (xpath = "//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/div[8]/a")
    private WebElement searchButton;
    @FindBy (xpath = "/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[2]/span")
    private WebElement openHotelButton;
    @FindBy (xpath = "//*[@id=\"hc_f_id_checkin_1\"]")
    private WebElement dayOfComingInSelector;
    @FindBy (xpath = "//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select")
    private WebElement monthOfComingInSelector;
    @FindBy (xpath = "//*[@id=\"hc_f_id_checkout_1\"]")
    private WebElement dayOfComingOutSelector;
    @FindBy (xpath = "//*[@id=\"HC_DateSelection_checkout_1\"]/div[2]/label/select")
    private WebElement monthOfComingOutSelector;

    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HotelsPage openPage() {
        return this;
    }

    public HotelPage chooseDates(ResidenceTerm dates) {
        Select dayOfComingIn = new Select(dayOfComingInSelector);
        Select monthOfComingIn = new Select(monthOfComingInSelector);
        Select dayOfComingOut = new Select(dayOfComingOutSelector);
        Select monthOfComingOut = new Select(monthOfComingOutSelector);
        dayOfComingIn.selectByVisibleText(dates.getDayOfComingIn());
        monthOfComingIn.selectByVisibleText(dates.getMonthOfComingIn());
        monthOfComingOut.selectByVisibleText(dates.getMonthOfComingOut());
        dayOfComingOut.selectByVisibleText(dates.getDayOfComingOut());
        searchButton.click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        openHotelButton.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new HotelPage(webDriver);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }


}
