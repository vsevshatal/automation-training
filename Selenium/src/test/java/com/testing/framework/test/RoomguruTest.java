package com.testing.framework.test;

import com.testing.framework.model.ResidenceTerm;
import com.testing.framework.model.SearchQuery;
import com.testing.framework.page.*;
import com.testing.framework.service.ResidenceTermCreator;
import com.testing.framework.service.SearchQueryCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RoomguruTest extends CommonCondition{

    @Test
    public void bookingTest() {
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
    public void hotOffering() {
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
    public void searchByCountry() {
        String city = new HomePage(driver)
                .openPage()
                .searchByCountry();
        String cityHotel = new HotelsPage(driver)
                .chooseCityAndHotel();
        Assert.assertTrue(cityHotel.contains(city));
    }

    @Test
    public void wrongDatesTest() {
        ResidenceTerm dates = ResidenceTermCreator.wrongDates();
        String error = new HomePage(driver)
                .openPage()
                .chooseWrongDates(dates);
        Assert.assertTrue(error.equals("Пожалуйста, убедитесь, что даты Заезда и Отъезда в будущем."));
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

    @Test
    public void checkQuery() {
        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        SearchQuery searchQuery = SearchQueryCreator.hotelName();
        boolean service = new HomePage(driver)
                .openPage()
                .enterDates(dates, searchQuery)
                .isRightQuery();
        Assert.assertTrue(service);
    }

    @Test
    public void checkLanguage() {
        String engWords = new HomePage(driver)
                .openPage()
                .checkLanguage();
        Assert.assertTrue(engWords.contains("The best hotel deals from around the world. It's our guarantee!"));
    }

    @Test
    public void wrongName() {
        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        SearchQuery searchQuery = SearchQueryCreator.wrongSearchQuery();
        String error = new HomePage(driver)
                .enterWrongName(dates, searchQuery);
        Assert.assertTrue(error.contains("Извините, по вашему запросу ничего не найдено."));
    }

    @Test
    public void categoryTest() {
        String category = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .chooseCategory();
        String resultCategory = new HotelPage(driver)
                .checkServiceCategory();
        Assert.assertTrue(resultCategory.contains(category));
    }

    @Test
    public void locationTest() {
        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        SearchQuery searchQuery = SearchQueryCreator.cityName();
        String location = new HomePage(driver)
                .findHotel(dates, searchQuery)
                .checkCity();
        Assert.assertTrue(searchQuery.getSearchQuery().contains(location));
    }

}
