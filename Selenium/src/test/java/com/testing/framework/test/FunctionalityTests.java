package com.testing.framework.test;

import com.testing.framework.model.ResidenceTerm;
import com.testing.framework.model.SearchQuery;
import com.testing.framework.page.HomePage;
import com.testing.framework.page.HotelPage;
import com.testing.framework.service.ResidenceTermCreator;
import com.testing.framework.service.SearchQueryCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalityTests extends CommonCondition {

    @Test
    public void checkQueryTest() {
        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        SearchQuery searchQuery = SearchQueryCreator.hotelName();
        boolean service = new HomePage(driver)
                .openPage()
                .enterDates(dates, searchQuery)
                .isRightQuery();
        Assert.assertTrue(service);
    }

    @Test
    public void checkLanguageTest() {
        String engWords = new HomePage(driver)
                .openPage()
                .checkLanguage();
        Assert.assertTrue(engWords.contains("The best hotel deals from around the world. It's our guarantee!"));
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
    public void wrongNameTest() {
        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        SearchQuery searchQuery = SearchQueryCreator.wrongSearchQuery();
        String error = new HomePage(driver)
                .enterWrongName(dates, searchQuery);
        Assert.assertTrue(error.contains("Извините, по вашему запросу ничего не найдено."));
    }

    @Test
    public void checkCategoryTest() {
        String category = new HomePage(driver)
                .openPage()
                .goToTheHotelsTab()
                .chooseCategory();
        String resultCategory = new HotelPage(driver)
                .checkServiceCategory();
        Assert.assertTrue(resultCategory.contains(category));
    }

    @Test
    public void checkLocationTest() {
        ResidenceTerm dates = ResidenceTermCreator.datesOfResidence();
        SearchQuery searchQuery = SearchQueryCreator.cityName();
        String location = new HomePage(driver)
                .findHotel(dates, searchQuery)
                .checkCity();
        Assert.assertTrue(searchQuery.getSearchQuery().contains(location));
    }
}
