package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RoomguruOther {
    private WebDriver webDriver;
    public RoomguruOther(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public RoomguruOther enterCityName() {
        webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div[1]/div/div[1]/div/form/fieldset/div[1]/input")).sendKeys("Вильнюс");
        Select dayOfComingIn = new Select(webDriver.findElement(By.xpath("//*[@id=\"hc_f_id_checkin_1\"]")));
        Select monthOfComingIn = new Select(webDriver.findElement(By.xpath("//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select")));
        Select dayOfComingOut = new Select(webDriver.findElement(By.xpath("//*[@id=\"hc_f_id_checkout_1\"]")));
        Select monthOfComingOut = new Select(webDriver.findElement(By.xpath("//*[@id=\"HC_DateSelection_checkout_1\"]/div[2]/label/select")));
        dayOfComingIn.selectByVisibleText("10");
        monthOfComingIn.selectByVisibleText("Декабрь 2019");
        monthOfComingOut.selectByVisibleText("Декабрь 2019");
        dayOfComingOut.selectByVisibleText("Ср 11");
        webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div[1]/div/div[1]/div/form/fieldset/div[9]/a")).click();
        webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/h3/a")).click();
        return this;
    }

    public RoomguruOther chooseOtherDate() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div/div/div[1]/div/div[2]/div[2]/div[2]/span")).click();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        return this;
    }

}
