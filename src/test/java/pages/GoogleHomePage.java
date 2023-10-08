package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage {

    private By searchField = By.name("q");

    private By contents = By.id("contents");

    private By acceptCookiesButton = By.cssSelector("#L2AGLb");

    private By elementList = By.className("L2AGLb");

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("loading the sample page ")
    public GoogleHomePage load() {
        driver.get(baseUrl);
        return this;
    }

    @Step("Serching the site")
    public ResultsPage search(String input) {
        driver.findElement(searchField).sendKeys(input);
        driver.findElement(searchField).sendKeys(Keys.RETURN);
        return new ResultsPage(driver,input);
    }


    public GoogleHomePage clickOnAcceptCookies() {
        if (driver.findElements(acceptCookiesButton).size() != 0) {
            driver.findElement(acceptCookiesButton).click();
        }
        return this;
    }
}
