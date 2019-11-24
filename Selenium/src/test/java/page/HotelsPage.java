package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HotelsPage extends AbstractPage {



    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public HotelsPage openPage() {
        return this;
    }

    public HotelPage chooseDates() {
        Select dayOfComingIn = new Select(webDriver.findElement(By.xpath("//*[@id=\"hc_f_id_checkin_1\"]")));
        Select monthOfComingIn = new Select(webDriver.findElement(By.xpath("//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select")));
        Select dayOfComingOut = new Select(webDriver.findElement(By.xpath("//*[@id=\"hc_f_id_checkout_1\"]")));
        Select monthOfComingOut = new Select(webDriver.findElement(By.xpath("//*[@id=\"HC_DateSelection_checkout_1\"]/div[2]/label/select")));
        dayOfComingIn.selectByVisibleText("10");
        monthOfComingIn.selectByVisibleText("Декабрь 2019");
        monthOfComingOut.selectByVisibleText("Декабрь 2019");
        dayOfComingOut.selectByVisibleText("Ср 11");
        webDriver.findElement(By.xpath("//*[@id=\"hc_findAHotel\"]/div/div[2]/form/fieldset/div[8]/a")).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[2]/span")).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return new HotelPage(webDriver);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }


}
