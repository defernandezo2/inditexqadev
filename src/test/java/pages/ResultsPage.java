package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ResultsPage extends BasePage {

    private String path = "/search?q=";
    private String searchText;

    private By searchElements=By.id("search");

    public ResultsPage(WebDriver driver, String searchText) {
        super(driver);
        this.searchText = searchText;
    }

    @Override
    public BasePage load() {
        driver.get(baseUrl + path + searchText);
        return this;
    }

    public WikipiediPage clickOnWikipediaPage() {
        List<WebElement> titles = searchElements.findElements((SearchContext) By.cssSelector("h3"));
        Optional<WebElement> wikipediaLink = titles.stream().filter(element -> element.getText().contains("wikipedia")).findFirst();
        wikipediaLink.orElseThrow(NoSuchElementException::new).click();
        return new WikipiediPage(driver);
    }

}
