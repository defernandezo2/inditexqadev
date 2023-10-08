package features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * This class is created to gather all the configuration needed to run the test, like driver and driver properties
 */
public abstract class BaseTest {


    protected WebDriver driver;

    public void setupDriver() {
//        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}
