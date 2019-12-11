package com.testing.framework.test;

import com.testing.framework.model.ResidenceTerm;
import com.testing.framework.model.SearchQuery;
import com.testing.framework.page.*;
import com.testing.framework.service.ResidenceTermCreator;
import com.testing.framework.service.SearchQueryCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SearchTests extends CommonCondition{

    @Test
    public void goToBookingServiceTest() {
        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        String savedHotelName = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .chooseDates(dates);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String resultingHotelName = new ServicePage(driver)
                .getHotel(savedHotelName);
        Assert.assertTrue(resultingHotelName.toLowerCase().contains(savedHotelName.toLowerCase()));
    }

    @Test
    public void searchByHotOfferingsTest() {
        String hotOfferingHotel = new HomePage(driver)
                .openPage()
                .goToHotOfferings()
                .chooseHotOfferingHotel()
                .openBooking();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        String resultingHotelName = new ServicePage(driver)
                .getHotel(hotOfferingHotel);
        System.out.println(hotOfferingHotel);
        System.out.println(resultingHotelName);
        Assert.assertTrue(resultingHotelName.toLowerCase().contains(hotOfferingHotel.toLowerCase()));
    }

    @Test
    public void searchByCountryTest() {
        String city = new HomePage(driver)
                .openPage()
                .searchByCountry();
        String cityHotel = new HotelsPage(driver)
                .chooseCityAndHotel();
        Assert.assertTrue(cityHotel.contains(city));
    }

    @Test
    public void serviceTest() {
        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        String service = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .compare(dates)
                .chooseService();
        String resultingService = new ServicePage(driver)
                .getHotelService();
        Assert.assertTrue(resultingService.equals(service));
    }
}
