package com.testing.framework.test;

import com.testing.framework.model.ResidenceTerm;
import com.testing.framework.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.testing.framework.utils.StringUtils.WEBSITE_URL;

public class RoomguruTest {
    private WebDriver webDriver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.get(WEBSITE_URL);
//        webDriver = DriverSingleton.getWebDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
//        webDriver.quit();
//        webDriver = null;
    }

    @Test
    public void bookingTest() {
        ResidenceTerm dates = new ResidenceTerm("10", "Декабрь 2019", "Ср 11", "Декабрь 2019");
        String resultingHotelName = new HomePage(webDriver)
                .openPage()
                .goToTheHotelsTab()
                .chooseDates(dates)
                .openBooking()
                .getHotel()
                .getHotelName();
        Assert.assertTrue(resultingHotelName.contains("Отель Comfort Hotel LT - Rock 'n' Roll Vilnius"));
    }

}
