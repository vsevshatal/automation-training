package com.testing.framework.service;

import com.testing.framework.model.SearchQuery;

public class SearchQueryCreator {
    private static final String HOTEL_NAME = "testdata.searchdata.hotelName";
    private static final String CITY_NAME = "testdata.searchdata.cityName";
    private static final String SEARCH_QUERY = "testdata.searchdata.wrongQuery";

    public static SearchQuery hotelName() {
        return new SearchQuery(
                TestDataReader.getTestData(HOTEL_NAME)
        );
    }

    public static SearchQuery cityName() {
        return new SearchQuery(
                TestDataReader.getTestData(CITY_NAME)
        );
    }

    public static SearchQuery wrongSearchQuery() {
        return new SearchQuery(
                TestDataReader.getTestData(SEARCH_QUERY)
        );
    }
}
