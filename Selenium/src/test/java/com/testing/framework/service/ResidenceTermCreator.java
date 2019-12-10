package com.testing.framework.service;

import com.testing.framework.model.ResidenceTerm;

public class ResidenceTermCreator {
    public static final String DAY_OF_CHECKIN = "testdata.residenceData.dayOfComingIn";
    public static final String MONTH_OF_CHECKIN = "testdata.residenceData.monthOfComingIn";
    public static final String DAY_OF_CHECKOUT  = "testdata.residenceData.dayOfComingOut";
    public static final String MONTH_OF_CHECKOUT  = "testdata.residenceData.monthOfComingOut";
    public static final String WRONG_DAY_OF_CHECKIN = "testdata.wrongData.dayOfComingIn";
    public static final String WRONG_MONTH_OF_CHECKIN = "testdata.wrongData.monthOfComingIn";
    public static final String WRONG_DAY_OF_CHECKOUT  = "testdata.wrongData.dayOfComingOut";
    public static final String WRONG_MONTH_OF_CHECKOUT  = "testdata.wrongData.monthOfComingOut";


    public static ResidenceTerm datesOfResidence() {
        return new ResidenceTerm(
                TestDataReader.getTestData(DAY_OF_CHECKIN),
                TestDataReader.getTestData(MONTH_OF_CHECKIN),
                TestDataReader.getTestData(DAY_OF_CHECKOUT),
                TestDataReader.getTestData(MONTH_OF_CHECKOUT)
        );
    }

    public static ResidenceTerm wrongDates() {
        return new ResidenceTerm(
                TestDataReader.getTestData(WRONG_DAY_OF_CHECKIN),
                TestDataReader.getTestData(WRONG_MONTH_OF_CHECKIN),
                TestDataReader.getTestData(WRONG_DAY_OF_CHECKOUT),
                TestDataReader.getTestData(WRONG_MONTH_OF_CHECKOUT)
        );
    }
}
