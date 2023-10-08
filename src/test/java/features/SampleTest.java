package features;


import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.GoogleHomePage;
import pages.ResultsPage;
import pages.WikipiediPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SampleTest extends BaseTest {

    private GoogleHomePage googleHomePage;


    @BeforeAll
    public void setUp() {
        setupDriver();
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.load();
    }

    @Test
    @Description("Simple test from youtube")
    public void searchSampleTest() {
        googleHomePage.clickOnAcceptCookies();
        ResultsPage resultsPage = googleHomePage.search("automatizacion");
        WikipiediPage wikipiediPage = resultsPage.clickOnWikipediaPage();
        wikipiediPage.assertYear("270 a. C");
    }

    @AfterAll
    public void tearDown() {
        driver.close();
    }
}
