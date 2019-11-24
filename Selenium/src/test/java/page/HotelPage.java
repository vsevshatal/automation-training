package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HotelPage extends AbstractPage {

    public HotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HotelPage openPage() {
        return this;
    }

    public ServicePage openBooking() {
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div/div[4]/div[2]/div/section[1]/div[2]/div/div[4]/div/div[1]/div/div[2]/div[5]/div/div/div/button")).click();
        return new ServicePage(webDriver);
    }
}
