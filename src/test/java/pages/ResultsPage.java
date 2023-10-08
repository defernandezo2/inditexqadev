package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ResultsPage extends BasePage {

    private String path = "/search?q=";
    private String searchText;

    private By searchElements=By.id("search");

    private By searchResultTitles= By.cssSelector("h3");

    public ResultsPage(WebDriver driver, String searchText) {
        super(driver);
        this.searchText = searchText;
    }

    @Override
    public ResultsPage load() {
        driver.get(baseUrl + path + searchText);
        return this;
    }

    public WikipiediPage clickOnWikipediaPage() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultTitles));
        List<WebElement> titles = driver.findElements(searchResultTitles);
        Optional<WebElement> wikipediaLink = titles.stream().filter(element -> element.getText().contains("Wikipedia")).findFirst();
        wikipediaLink.orElseThrow(NoSuchElementException::new).click();
        return new WikipiediPage(driver);
    }

}
