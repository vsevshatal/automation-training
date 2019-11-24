package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ServicePage extends AbstractPage{
    public ServicePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public ServicePage openPage() {
        return this;
    }

    public ServiceHotelPage getHotel() {
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(2));
        webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/a")).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/form/div[1]/h2")).click();
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[6]/div[3]/div[1]/div/div[2]/div[2]/div[3]/div/div/div[2]/div[2]/div/div/a")).click();
        return new ServiceHotelPage(webDriver);
    }
}
