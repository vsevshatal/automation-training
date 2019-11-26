package com.testing.framework.model;

public class ResidenceTerm {
    private String dayOfComingIn ;
    private String monthOfComingIn;
    private String dayOfComingOut;
    private String monthOfComingOut;

    public ResidenceTerm(String dayOfComingIn, String monthOfComingIn, String dayOfComingOut, String monthOfComingOut) {
        this.dayOfComingIn = dayOfComingIn;
        this.monthOfComingIn = monthOfComingIn;
        this.dayOfComingOut = dayOfComingOut;
        this.monthOfComingOut = monthOfComingOut;
    }

    public String getDayOfComingIn() {
        return dayOfComingIn;
    }

    public void setDayOfComingIn(String dayOfComingIn) {
        this.dayOfComingIn = dayOfComingIn;
    }

    public String getMonthOfComingIn() {
        return monthOfComingIn;
    }

    public void setMonthOfComingIn(String monthOfComingIn) {
        this.monthOfComingIn = monthOfComingIn;
    }

    public String getDayOfComingOut() {
        return dayOfComingOut;
    }

    public void setDayOfComingOut(String dayOfComingOut) {
        this.dayOfComingOut = dayOfComingOut;
    }

    public String getMonthOfComingOut() {
        return monthOfComingOut;
    }

    public void setMonthOfComingOut(String monthOfComingOut) {
        this.monthOfComingOut = monthOfComingOut;
    }


}
