package com.testing.framework.test;

import com.testing.framework.model.ResidenceTerm;
import com.testing.framework.page.HomePage;
import com.testing.framework.page.HotelsPage;
import com.testing.framework.page.ServicePage;
import com.testing.framework.service.ResidenceTermCreator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RoomguruTest extends CommonCondition{
    private WebDriver webDriver;
//    @BeforeMethod(alwaysRun = true)
//    public void browserSetup() {
//        webDriver = new ChromeDriver();
//        webDriver.get(WEBSITE_URL);
//    }
//
//
//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown(){
//
//    }

    @Test
    public void bookingTest() {

        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        String savedHotelName = new HomePage(webDriver)
                .openPage()
                .goToTheHotelsTab()
                .chooseDates(dates);
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        String resultingHotelName = new ServicePage(webDriver)
                .getHotel(savedHotelName);
        Assert.assertTrue(resultingHotelName.toLowerCase().contains(savedHotelName.toLowerCase()));
    }

    @Test
    public void hotOffering() {
        String hotOfferingHotel = new HomePage(webDriver)
                .goToHotOfferings()
                .chooseHotOfferingHotel()
                .openBooking();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(2));
        String resultingHotelName = new ServicePage(webDriver)
                .getHotel(hotOfferingHotel);
        System.out.println(hotOfferingHotel);
        System.out.println(resultingHotelName);
        Assert.assertTrue(resultingHotelName.toLowerCase().contains(hotOfferingHotel.toLowerCase()));
    }

    @Test
    public void searchByCountry() {
        String city = new HomePage(webDriver)
                .searchByCountry();
        String cityHotel = new HotelsPage(webDriver)
                .chooseCityAndHotel();
        Assert.assertTrue(cityHotel.contains(city));
    }
}
