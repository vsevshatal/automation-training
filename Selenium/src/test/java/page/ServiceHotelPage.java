package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ServiceHotelPage extends AbstractPage{
    public ServiceHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public ServiceHotelPage openPage() {
        return this;
    }

    public String getHotelName() {
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(3));
        return webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[3]/div[1]/h2")).getText();
    }
}
