package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Roomguru {
    private WebDriver webDriver;
    private By searchBox = By.xpath("//*[@id=\"hc_f_id_where_1\"]");
    private By searchVariant = By.xpath("//*[@id=\"ui-id-12\"]/a");
    private By popularDestination = By.xpath("//*[@id=\"hc_r_content\"]/div[2]/div[3]/div/div/div[3]/div/a");
    private By hotel = By.xpath("//*[@id=\"hc_popularHotels\"]/div/div[2]/div[1]/div/div/h3/a");
    //*[@id="hc_popularHotels"]/div/div[2]/div[1]/div/div/h3/a
    public Roomguru(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public Roomguru openPopularDestination() {
        webDriver.findElement(popularDestination).click();
        return this;
    }
    public String enterData() {
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
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div/div[4]/div[2]/div/section[1]/div[2]/div/div[4]/div/div[1]/div/div[2]/div[5]/div/div/div/button")).click();
        tabs = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(2));
        webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/a")).click();
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[1]/h3/a/span[1]")).click();
        tabs = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(3));
//        webDriver.close();
//        webDriver.switchTo().window(tabs.get(0));
//        webDriver.findElement(By.xpath("//*[@id=\"hc_hotelPageSearch\"]/div/div[2]/form/fieldset/div[8]/a")).click();
        return webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[4]/div[1]/h2")).getText();
    }
}
