package com.testing.framework.page;

import com.testing.framework.model.ResidenceTerm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class HotelPage extends AbstractPage {

    @FindBy (xpath = "//*[@id=\"hc_f_id_checkin_2\"]")
    private WebElement dayOfComingInSelector;
    @FindBy (xpath = "//*[@id=\"HC_DateSelection_checkin_2\"]/div[2]/label/select")
    private WebElement monthOfComingInSelector;
    @FindBy (xpath = "//*[@id=\"hc_f_id_checkout_2\"]")
    private WebElement dayOfComingOutSelector;
    @FindBy (xpath = "//*[@id=\"HC_DateSelection_checkout_2\"]/div[2]/label/select")
    private WebElement monthOfComingOutSelector;
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div[3]/div/div[4]/div[2]/div/section[1]/div[2]/div/div[4]/div/div[1]/div/div[2]/div[5]/div/div/div/button")
    private WebElement openBookingService;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/div[2]/div/div/div[2]/form/fieldset/div[8]/a")
    private WebElement enterDatesButton;

    public HotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HotelPage openPage() {
        return this;
    }

    public ServicePage openBooking() {
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        openBookingService.click();
        return new ServicePage(webDriver);
    }

    public HotelsPage enterDates(ResidenceTerm dates) {
        Select dayOfComingIn = new Select(dayOfComingInSelector);
        Select monthOfComingIn = new Select(monthOfComingInSelector);
        Select dayOfComingOut = new Select(dayOfComingOutSelector);
        Select monthOfComingOut = new Select(monthOfComingOutSelector);
        dayOfComingIn.selectByVisibleText(dates.getDayOfComingIn());
        monthOfComingIn.selectByVisibleText(dates.getMonthOfComingIn());
        monthOfComingOut.selectByVisibleText(dates.getMonthOfComingOut());
        dayOfComingOut.selectByVisibleText(dates.getDayOfComingOut());
        enterDatesButton.click();
        return new HotelsPage(webDriver);
    }
}
