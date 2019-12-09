package com.testing.framework.service;

import com.testing.framework.model.ResidenceTerm;

public class ResidenceTermCreator {
    public static final String DAY_OF_CHECKIN = "testdata.residenceData.dayOfComingIn";
    public static final String MONTH_OF_CHECKIN = "testdata.residenceData.monthOfComingIn";
    public static final String DAY_OF_CHECKOUT  = "testdata.residenceData.dayOfComingOut";
    public static final String MONTH_OF_CHECKOUT  = "testdata.residenceData.monthOfComingOut";

    public static ResidenceTerm datesOfResidence() {
        return new ResidenceTerm(
                TestDataReader.getTestData(DAY_OF_CHECKIN),
                TestDataReader.getTestData(MONTH_OF_CHECKIN),
                TestDataReader.getTestData(DAY_OF_CHECKOUT),
                TestDataReader.getTestData(MONTH_OF_CHECKOUT)
        );
    }
}
