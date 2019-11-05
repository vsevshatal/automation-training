import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Roomguru {
    private WebDriver webDriver;
    private By searchBox = By.xpath("//*[@id=\"hc_f_id_where_1\"]");
    //*[@id="HC_DateSelection_checkin_1"]/div[2]/label/select
    public Roomguru(final WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
    public void enterData() {
        webDriver.findElement(searchBox).clear();
        webDriver.findElement(searchBox).sendKeys("Минск");
        Select dayOfComingIn = new Select(webDriver.findElement(By.xpath("//*[@id=\"hc_f_id_checkin_1\"]")));
        Select monthOfComingIn = new Select(webDriver.findElement(By.xpath("//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select")));
        Select dayOfComingOut = new Select(webDriver.findElement(By.xpath("//*[@id=\"hc_f_id_checkout_1\"]")));
        Select monthOfComingOut = new Select(webDriver.findElement(By.xpath("//*[@id=\"HC_DateSelection_checkout_1\"]/div[2]/label/select")));
        dayOfComingIn.selectByVisibleText("7");
        monthOfComingIn.selectByVisibleText("Ноябрь 2019");
        monthOfComingOut.selectByVisibleText("Декабрь 2019");
        dayOfComingOut.selectByVisibleText("Вс 1");
        webDriver.findElement(By.xpath("//*[@id=\"hc_searchBox\"]/div/form/fieldset/div[9]/a")).click();
    }
    public void enterWrongData() {
        webDriver.findElement(searchBox).sendKeys("Минск");
        Select dayOfComingIn = new Select(webDriver.findElement(By.xpath("//*[@id=\"hc_f_id_checkin_1\"]")));
        Select monthOfComingIn = new Select(webDriver.findElement(By.xpath("//*[@id=\"HC_DateSelection_checkin_1\"]/div[2]/label/select")));
        Select dayOfComingOut = new Select(webDriver.findElement(By.xpath("//*[@id=\"hc_f_id_checkout_1\"]")));
        Select monthOfComingOut = new Select(webDriver.findElement(By.xpath("//*[@id=\"HC_DateSelection_checkout_1\"]/div[2]/label/select")));
        dayOfComingIn.selectByVisibleText("Чт 7");
        monthOfComingIn.selectByVisibleText("Ноябрь 2019");
        monthOfComingOut.selectByVisibleText("Ноябрь 2019");
        dayOfComingOut.selectByVisibleText("Ср 6");
        webDriver.findElement(By.xpath("//*[@id=\"hc_searchBox\"]/div/form/fieldset/div[9]/a")).click();
    }
    public void clickMainPage() {
        webDriver.findElement(By.xpath("//*[@id=\"hc_r_hd\"]/a")).click();
    }
}
