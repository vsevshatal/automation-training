package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.roomguru.ru/";
    private By popularDestination = By.xpath("//*[@id=\"hc_r_content\"]/div[2]/div[3]/div/div/div[3]/div/a");


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HomePage openPage() {
        webDriver.navigate().to(HOMEPAGE_URL);
        return this;
    }


    public HotelsPage goToTheHotelsTab() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(popularDestination).click();
        return new HotelsPage(webDriver);
    }
}
