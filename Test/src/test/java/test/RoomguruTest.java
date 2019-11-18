package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.Roomguru;

public class RoomguruTest {
    private WebDriver driver;
    Roomguru testcase;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://www.roomguru.ru/");
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void testOfPage() {
        String test = new Roomguru(driver)
                .openPopularDestination()
                .enterData();
        Assert.assertTrue(test.contains("Отель Comfort Hotel LT - Rock 'n' Roll Vilnius"));
    }

    @Test
    public void testPage() {
        testcase = new Roomguru(driver);
        String t = testcase.enterData();
        System.out.println(t);
        boolean b;
        if (t.equals("Отель Comfort Hotel LT - Rock 'n' Roll Vilnius"))
            System.out.println("TRUE!!!");
    }
}
