package test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RoomguruTest {
    private WebDriver webDriver;
    Roomguru testcase;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.roomguru.ru/");
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
//        webDriver.quit();
//        webDriver = null;
    }

    @Test
    public void testOfPage() {
        try {
            Roomguru test = new Roomguru(webDriver)
                    .openPopularDestination()
                    .chooseDates();
            ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            test = new Roomguru(webDriver)
                    .openWebsite();
            tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(2));
            test = new Roomguru(webDriver)
                    .goToPages();
            tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(3));
            String finalTest = new Roomguru(webDriver)
                    .getFinalData();
            Assert.assertTrue(finalTest.contains("Отель Comfort Hotel LT - Rock 'n' Roll Vilnius"));
        } catch (NoSuchElementException e) {
            System.out.println("Fall");
            webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }


    @Test
    public void otherTest() {
        RoomguruOther test = new RoomguruOther(webDriver)
                .enterCityName()
                .chooseOtherDate();
    }

    @Test
    public void bookingTest() {
        String test = new HomePage(webDriver)
                .openPage()
                .goToTheHotelsTab()
                .chooseDates()
                .openBooking()
                .getHotel()
                .getHotelName();
        Assert.assertTrue(test.contains("Отель Comfort Hotel LT - Rock 'n' Roll Vilnius"));
    }

//    @Test
//    public void testPage() {
//        testcase = new Roomguru(webDriver);
//        String t = testcase.everything();
//        System.out.println(t);
//        boolean b;
//        if (t.equals("Отель Comfort Hotel LT - Rock 'n' Roll Vilnius"))
//            System.out.println("TRUE!!!");
//    }
}
