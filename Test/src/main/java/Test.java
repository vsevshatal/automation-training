import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test {
    private WebDriver webDriver;
    public void initDriver() throws MalformedURLException {
        webDriver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void launch() {
        webDriver.get("https://roomguru.ru");
    }
    public void shutDown() {
        webDriver.close();
        webDriver.quit();
    }
    public void start() {
        Roomguru roomguru = new Roomguru(webDriver);
        roomguru.enterData();
        roomguru.clickMainPage();
        roomguru.enterWrongData();
    }

    public static void main(String[] args) throws MalformedURLException {
        Test test = new Test();
        test.initDriver();
        test.launch();
        test.start();
    }
}

