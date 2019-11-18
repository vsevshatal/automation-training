package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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


//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown(){
//        driver.quit();
//        driver = null;
//    }
    @Test
    public void testPage() {
        testcase = new Roomguru(driver);
        testcase.enterData();
    }
}
