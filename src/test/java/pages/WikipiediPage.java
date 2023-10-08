package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipiediPage extends BasePage{


    private By subTitles = By.cssSelector("h3");
    private By firstHistoryParagraph = By.xpath("//*[@id=\"Historia_temprana\"]/ancestor::h3//following-sibling::p[1]");

    public WikipiediPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage load() {
        return null;
    }


    public WikipiediPage assertYear(String year)
    {
        String paragraphContent = driver.findElement(firstHistoryParagraph).getText();
        Assertions.assertTrue(paragraphContent.contains(year));
        return this;
    }
}