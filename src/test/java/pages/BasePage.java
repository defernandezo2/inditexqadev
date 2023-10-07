package pages;


import configurations.Configurations;
import org.openqa.selenium.WebDriver;

/**
 * Class is created to gather all the global configurations for the pages, so far they only have the Base url to use
 */
public abstract class BasePage {
    protected String baseUrl = Configurations.getInstance().getProperty("TEST_TARGET_URL");

    WebDriver driver;

    public abstract BasePage load();

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }
}
